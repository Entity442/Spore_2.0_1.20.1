
package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Recipes.GraftingRecipe;
import com.Harbinger.Spore.Recipes.SurgeryRecipe;
import com.Harbinger.Spore.Screens.SurgeryMenu;
import com.Harbinger.Spore.Sitems.Agents.MutationAgents;
import com.Harbinger.Spore.Sitems.BaseWeapons.*;
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
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
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

import java.util.*;

public class SurgeryTableBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(25);
    public final TagKey<Item> stringLikeItem = ItemTags.create(new ResourceLocation("spore:stitches"));
    public static final int STRING_SLOT = 16;
    public static final int AGENT_SLOT_1 = 17;
    public static final int AGENT_SLOT_2 = 18;
    public static final int AGENT_SLOT_3 = 19;
    public static final int OUTPUT_SLOT = 20;
    public static final int GRATING_ITEM_ONE = 21;
    public static final int GRATING_INGREDIENT = 22;
    public static final int GRATING_ITEM_TWO = 23;
    public static final int GRATING_OUTPUT = 24;
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    public final ContainerData data;
    public SurgeryTableBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(SblockEntities.SURGERY_TABLE_ENTITY.get(), p_155229_, p_155230_);
        this.data = new SimpleContainerData(25);
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
    public Optional<GraftingRecipe> getCurrentGraftingRecipe() {
        SimpleContainer inventory = new SimpleContainer(25);
        for (int i = GRATING_ITEM_ONE; i < GRATING_ITEM_TWO+1; i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<GraftingRecipe> recipe = this.level != null ? this.level.getRecipeManager().getRecipeFor(GraftingRecipe.GraftingRecipeType.INSTANCE, inventory, level) : null;
        if (recipe.isPresent()) {
            System.out.println("Found matching recipe: " + recipe.get().getId());
        } else {
            System.out.println("No matching recipe found.");
        }
        return recipe;
    }
    public void consumeItemsGrafting() {
        Optional<GraftingRecipe> match = this.getCurrentGraftingRecipe();
        match.ifPresent(recipe -> {
            for (int i = GRATING_ITEM_ONE; i < GRATING_ITEM_TWO+1; i++) {
                ItemStack stack = itemHandler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    itemHandler.extractItem(i, 1, false);
                }
            }
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
        if (stack.getItem() instanceof SporeWeaponData || stack.getItem() instanceof SporeArmorData){
            for (MutationAgents mutagen : mutagens){
                mutagen.mutateWeapon(stack);
                mutation = mutation + mutagen.getMutationChance();
            }
            if (Math.random() < (mutation * 0.01) && stack.getItem() instanceof SporeWeaponData item){
                item.setVariant(SporeToolsMutations.byId(player.getRandom().nextInt(SporeToolsMutations.values().length)),stack);
            }
            if (Math.random() < (mutation * 0.01) && stack.getItem() instanceof SporeArmorData item){
                item.setVariant(SporeArmorMutations.byId(player.getRandom().nextInt(SporeArmorMutations.values().length)),stack);
            }
            stack.setDamageValue(itemHandler.getStackInSlot(AGENT_SLOT_3) == ItemStack.EMPTY ? player.getRandom().nextInt(stack.getMaxDamage()) : 0);
        }
    }

    public void assembleGraft(ItemStack stack){
        ItemStack firstItem = itemHandler.getStackInSlot(GRATING_ITEM_ONE);
        ItemStack secondItem = itemHandler.getStackInSlot(GRATING_ITEM_TWO);
        Map<Enchantment,Integer> enchants = EnchantmentHelper.getEnchantments(firstItem);
        enchants.putAll(EnchantmentHelper.getEnchantments(secondItem));
        if (stack.getItem() instanceof SporeWeaponData weaponData){
            int luck = 0;
            int extra_durability= 0;
            double extra_damage= 0;
            int mutation= 0;
            if (firstItem.getItem() instanceof SporeWeaponData firstWdata && secondItem.getItem() instanceof SporeWeaponData secondWData){
                luck = (firstWdata.getLuck(firstItem) + secondWData.getLuck(secondItem))/2;
                extra_durability = (firstWdata.getMaxAdditionalDurability(firstItem) + secondWData.getMaxAdditionalDurability(secondItem))/2;
                extra_damage = (firstWdata.getAdditionalDamage(firstItem) + secondWData.getAdditionalDamage(secondItem))/2;
                mutation = Math.random() < 0.5f ? firstWdata.getTypeVariant(firstItem) : secondWData.getTypeVariant(secondItem);
            }else {
                if (firstItem.getItem() instanceof SporeWeaponData firstWdata){
                    luck = firstWdata.getLuck(firstItem);
                    extra_durability = firstWdata.getMaxAdditionalDurability(firstItem);
                    extra_damage = firstWdata.getAdditionalDamage(firstItem);
                    mutation =firstWdata.getTypeVariant(firstItem);
                }
                if (secondItem.getItem() instanceof SporeWeaponData secondWData){
                    luck = secondWData.getLuck(secondItem);
                    extra_durability = secondWData.getMaxAdditionalDurability(secondItem);
                    extra_damage = secondWData.getAdditionalDamage(secondItem);
                    mutation =secondWData.getTypeVariant(secondItem);
                }
            }
            weaponData.setLuck(luck,stack);
            weaponData.setMaxAdditionalDurability(extra_durability,stack);
            weaponData.setAdditionalDamage(extra_damage,stack);
            weaponData.setVariant(SporeToolsMutations.byId(mutation),stack);
        }
        if (stack.getItem() instanceof SporeArmorData armorData){
            int luck = 0;
            int extra_durability= 0;
            double extra_protection= 0;
            double agent_toughness= 0;
            int mutation= 0;
            if (firstItem.getItem() instanceof SporeArmorData firstWdata && secondItem.getItem() instanceof SporeArmorData secondWData){
                luck = (firstWdata.getLuck(firstItem) + secondWData.getLuck(secondItem))/2;
                extra_durability = (firstWdata.getMaxAdditionalDurability(firstItem) + secondWData.getMaxAdditionalDurability(secondItem))/2;
                extra_protection = (firstWdata.getAdditionalProtection(firstItem) + secondWData.getAdditionalProtection(secondItem))/2;
                agent_toughness = (firstWdata.getAdditionalToughness(firstItem) + secondWData.getAdditionalToughness(secondItem))/2;
                mutation = Math.random() < 0.5f ? firstWdata.getTypeVariant(firstItem) : secondWData.getTypeVariant(secondItem);
            }else {
                if (firstItem.getItem() instanceof SporeArmorData firstWdata){
                    luck = firstWdata.getLuck(firstItem);
                    extra_durability = firstWdata.getMaxAdditionalDurability(firstItem);
                    extra_protection = firstWdata.getAdditionalProtection(firstItem);
                    agent_toughness = firstWdata.getAdditionalToughness(firstItem);
                    mutation =firstWdata.getTypeVariant(firstItem);
                }
                if (secondItem.getItem() instanceof SporeArmorData secondWData){
                    luck = secondWData.getLuck(secondItem);
                    extra_durability = secondWData.getMaxAdditionalDurability(secondItem);
                    extra_protection = secondWData.getAdditionalProtection(secondItem);
                    agent_toughness = secondWData.getAdditionalToughness(secondItem);
                    mutation =secondWData.getTypeVariant(secondItem);
                }
            }
            armorData.setLuck(luck,stack);
            armorData.setMaxAdditionalDurability(extra_durability,stack);
            armorData.setAdditionalProtection(extra_protection,stack);
            armorData.setAdditionalToughness(agent_toughness,stack);
            armorData.setVariant(SporeArmorMutations.byId(mutation),stack);
        }
        enchants.forEach(stack::enchant);
    }

    public boolean canInsertIntoOutputSlot(ItemStack stack,int slot) {
        ItemStack outputStack = itemHandler.getStackInSlot(slot);
        return outputStack.isEmpty();
    }
    public void updateOutputSlot() {
        if (itemHandler.getStackInSlot(STRING_SLOT) == ItemStack.EMPTY){
            this.itemHandler.setStackInSlot(SurgeryTableBlockEntity.OUTPUT_SLOT, ItemStack.EMPTY);
            return;
        }
        Optional<SurgeryRecipe> match = this.getCurrentRecipe();
        if (match.isPresent()){
            ItemStack stack = match.get().getResultItem(null);
            if (canInsertIntoOutputSlot(stack,OUTPUT_SLOT)) {
                itemHandler.insertItem(OUTPUT_SLOT, stack.copy(), false);
            }
        }else {
            this.itemHandler.setStackInSlot(SurgeryTableBlockEntity.OUTPUT_SLOT, ItemStack.EMPTY);
        }
    }
    public void updateSecondOutputSlot() {
        Optional<GraftingRecipe> match = this.getCurrentGraftingRecipe();
        if (match.isPresent()){
            ItemStack stack = match.get().getResultItem(null);
            if (canInsertIntoOutputSlot(stack,GRATING_OUTPUT)) {
                itemHandler.insertItem(GRATING_OUTPUT, stack.copy(), false);
            }
        }else {
            this.itemHandler.setStackInSlot(SurgeryTableBlockEntity.GRATING_OUTPUT, ItemStack.EMPTY);
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, SurgeryTableBlockEntity entity) {
        entity.updateOutputSlot();
        entity.updateSecondOutputSlot();
    }
}
