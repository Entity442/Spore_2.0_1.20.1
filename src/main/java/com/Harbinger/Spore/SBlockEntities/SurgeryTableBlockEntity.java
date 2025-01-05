
package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Recipes.SurgeryRecipe;
import com.Harbinger.Spore.Screens.SurgeryMenu;
import com.Harbinger.Spore.Sitems.Agents.MutationAgents;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SurgeryTableBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(21);
    public final TagKey<Item> stringLikeItem = ItemTags.create(new ResourceLocation("spore:stitches"));
    private int tickCooldown = 0;
    public static final int STRING_SLOT = 16;
    public static final int AGENT_SLOT_1 = 17;
    public static final int AGENT_SLOT_2 = 18;
    public static final int AGENT_SLOT_3 = 19;
    public static final int OUTPUT_SLOT = 20;
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected final ContainerData data;
    public SurgeryTableBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(SblockEntities.SURGERY_TABLE_ENTITY.get(), p_155229_, p_155230_);
        this.data = new SimpleContainerData(20);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("spore.surgery_table_menu");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory inventory, Player player) {
        return new SurgeryMenu(pContainerId, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }
    public void drops() {
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            ItemStack stack = itemHandler.getStackInSlot(i);
            if (!stack.isEmpty()) {
                Containers.dropItemStack(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), stack);
            }
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public Optional<SurgeryRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < 16; i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<SurgeryRecipe> recipe = this.level != null ? this.level.getRecipeManager().getRecipeFor(SurgeryRecipe.SurgeryRecipeType.INSTANCE, inventory, level) : null;
        if (recipe.isPresent()) {
            System.out.println("Found matching recipe: " + recipe.get().getId());
        } else {
            System.out.println("No matching recipe found.");
        }
        return recipe;
    }

    public void consumeItems() {
        Optional<SurgeryRecipe> match = this.getCurrentRecipe();
        match.ifPresent(recipe -> {
            for (int i = 0; i < 16; i++) {
                ItemStack stack = itemHandler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    itemHandler.extractItem(i, 1, false);
                }
            }
            itemHandler.extractItem(STRING_SLOT,1,false);
        });
        if (level != null){
            this.level.playLocalSound(this.getBlockPos(), Ssounds.SURGERY.get(), SoundSource.BLOCKS,1f,1f,true);
        }
    }
    public void assembleWeapon(Player player, ItemStack stack){
        int mutation = 15;
        int[] e = new int[]{AGENT_SLOT_1,AGENT_SLOT_2,AGENT_SLOT_3};
        List<MutationAgents> mutagens = new ArrayList<>();
        for (int i : e){
            ItemStack itemStack = itemHandler.getStackInSlot(i);
            if (itemStack.getItem() instanceof MutationAgents mutationAgents){
                mutagens.add(mutationAgents);
                itemStack.shrink(1);
            }
        }
        if (stack.getItem() instanceof SporeToolsBaseItem item){
            for (MutationAgents mutagen : mutagens){
                mutagen.mutateWeapon(stack);
                mutation = mutation + mutagen.getMutationChance();
            }
            if (Math.random() < (mutation * 0.01)){
                item.setVariant(SporeToolsMutations.byId(player.getRandom().nextInt(SporeToolsMutations.values().length)),stack);
            }
            stack.setDamageValue(player.getRandom().nextInt(stack.getMaxDamage()));
        }
    }

    public boolean canInsertIntoOutputSlot(ItemStack stack) {
        ItemStack outputStack = itemHandler.getStackInSlot(OUTPUT_SLOT);
        return outputStack.isEmpty() ||
                (outputStack.getItem() == stack.getItem() &&
                        outputStack.getCount() + stack.getCount() <= outputStack.getMaxStackSize());
    }
    public void updateOutputSlot() {
        if (itemHandler.getStackInSlot(STRING_SLOT) == ItemStack.EMPTY){
            return;
        }
        Optional<SurgeryRecipe> match = this.getCurrentRecipe();
        if (match.isPresent()){
            ItemStack stack = match.get().getResultItem(null);
            if (canInsertIntoOutputSlot(stack)) {
                itemHandler.insertItem(OUTPUT_SLOT, stack.copy(), false);
            }
        }else {
            this.itemHandler.setStackInSlot(SurgeryTableBlockEntity.OUTPUT_SLOT, ItemStack.EMPTY);
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, SurgeryTableBlockEntity entity) {
        if (entity.tickCooldown > 0) {
            entity.tickCooldown--;
        } else {
            entity.updateOutputSlot();
            entity.tickCooldown = 5;
        }
    }
}
