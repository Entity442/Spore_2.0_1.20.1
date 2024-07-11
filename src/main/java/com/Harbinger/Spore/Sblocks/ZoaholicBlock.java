package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.SBlockEntities.ZoaholicBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ZoaholicBlock extends BaseEntityBlock {
    public ZoaholicBlock() {
        super(Properties.of().sound(SoundType.STONE).strength(6f, 20f));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ZoaholicBlockEntity(pos,state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }



    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        {
            return box(0.1, 0, 0.1, 15.9, 16, 15.9).move(offset.x, offset.y, offset.z);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        super.use(state, level, pos, player, hand, result);
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof ZoaholicBlockEntity zoaholicBlock){
            ItemStack stack = player.getItemInHand(hand);
            if (!zoaholicBlock.HasBrain() && stack.getItem() == Sitems.CEREBRUM.get()){
                zoaholicBlock.setBrain(true);
                stack.shrink(1);
            }else if (!zoaholicBlock.HasHeart() && stack.getItem() == Sitems.MUTATED_HEART.get()){
                zoaholicBlock.setHasHeart(true);
                stack.shrink(1);
            }else if (!zoaholicBlock.hasEnoughInnards() && stack.getItem() == Sitems.INNARDS.get()){
                zoaholicBlock.setAmountOfInnards(zoaholicBlock.getAmountOfInnards()+1);
                stack.shrink(1);
            }else if (zoaholicBlock.getBiomass() <=9000 && stack.getItem() == Sitems.BIOMASS.get()){
                zoaholicBlock.addBiomass(3000);
                stack.shrink(1);
            }else{
                if (zoaholicBlock.isActive()){
                    zoaholicBlock.setProcessing(200);
                }else
                if (zoaholicBlock.HasHeart()&& zoaholicBlock.hasEnoughInnards()&& zoaholicBlock.HasBrain()){
                    player.displayClientMessage(Component.literal("Biomass: "+zoaholicBlock.getBiomass()+"/12000"),true);
                } else{
                    player.displayClientMessage(Component.literal("Missing required organs"),true);
                }
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153274_, BlockEntityType<T> type) {
        return createCDUTicker(level, type, SblockEntities.ZOAHOLIC.get());
    }

    @javax.annotation.Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createCDUTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends ZoaholicBlockEntity> p_151990_) {
        return level.isClientSide ? createTickerHelper(type, p_151990_, ZoaholicBlockEntity::clientTick) : createTickerHelper(type, p_151990_, ZoaholicBlockEntity::serverTick);
    }



    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter getter, List<Component> components, TooltipFlag tooltipFlag) {
        CompoundTag tag = stack.getOrCreateTag();
        if (getBrain(tag) && getHeart(tag) && getInnards(tag)>=2){
            components.add(Component.literal("Biomass: "+ getBiomassTag(tag)+"/600"));
        }else{
            components.add(Component.literal("Missing organs:"));
            if (!getBrain(tag)){
                components.add(Sitems.CEREBRUM.get().getDescription());
            }if (!getHeart(tag)){
                components.add(Sitems.MUTATED_HEART.get().getDescription());
            }if (getInnards(tag) <1){
                components.add(Sitems.INNARDS.get().getDescription());
            }if (getInnards(tag) <2){
                components.add(Sitems.INNARDS.get().getDescription());
            }
        }
        super.appendHoverText(stack, getter, components, tooltipFlag);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (level.getBlockEntity(pos) instanceof ZoaholicBlockEntity zoaholicBlockEntity){
            ItemStack stack = new ItemStack(this);
            CompoundTag tag = stack.getOrCreateTag();
            setBiomassTag(zoaholicBlockEntity.getBiomass(),tag);
            setHeart(zoaholicBlockEntity.HasHeart(), tag);
            setBrain(zoaholicBlockEntity.HasBrain(), tag);
            setInnards(zoaholicBlockEntity.getAmountOfInnards(), tag);
            ItemEntity item = new ItemEntity(level, pos.getX() , pos.getY(),pos.getZ(),stack);
            level.addFreshEntity(item);
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, @NotNull ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        if (level.getBlockEntity(pos) instanceof ZoaholicBlockEntity zoaholicBlock){
            CompoundTag tag = stack.getOrCreateTag();
            zoaholicBlock.setBiomass(getBiomassTag(tag));
            zoaholicBlock.setAmountOfInnards(getInnards(tag));
            zoaholicBlock.setHasHeart(getHeart(tag));
            zoaholicBlock.setBrain(getBrain(tag));
        }
    }

    public void setBiomassTag(int value, CompoundTag tag){
        tag.putInt("biomass",value);
    }
    public int getBiomassTag(CompoundTag tag){
        return tag.getInt("biomass");
    }
    public void setHeart(boolean value, CompoundTag tag){
        tag.putBoolean("heart",value);
    }
    public boolean getHeart(CompoundTag tag){
        return tag.getBoolean("heart");
    }
    public void setBrain(boolean value, CompoundTag tag){
        tag.putBoolean("brain",value);
    }
    public boolean getBrain(CompoundTag tag){
        return tag.getBoolean("brain");
    }
    public void setInnards(int value, CompoundTag tag){
        tag.putInt("innards",value);
    }
    public int getInnards(CompoundTag tag){
        return tag.getInt("innards");
    }

}
