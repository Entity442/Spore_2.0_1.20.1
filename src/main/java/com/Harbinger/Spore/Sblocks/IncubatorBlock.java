package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.SBlockEntities.IncubatorBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IncubatorBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public IncubatorBlock() {
        super(Properties.of().sound(SoundType.STONE).strength(6f, 20f));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new IncubatorBlockEntity(pos,state);
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
        if (entity instanceof IncubatorBlockEntity blockEntity){
            ItemStack item = player.getItemInHand(hand);
            if (item.getItem() == Sitems.BIOMASS.get()){
                if (blockEntity.getFuel() > 0){
                    player.displayClientMessage(Component.literal("Current fuel " + blockEntity.getFuel() + "/" + blockEntity.maxFuel),true);
                }else{
                    blockEntity.setFuel(blockEntity.maxFuel);
                    item.shrink(1);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153274_, BlockEntityType<T> type) {
        return createIncubatorTicker(level, type, SblockEntities.INCUBATOR.get());
    }
    public int getEntityFuel(Level level,BlockPos pos){
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof  IncubatorBlockEntity blockEntity){
            return blockEntity.getFuel();
        }
        return 0;
    }

    @javax.annotation.Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createIncubatorTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends IncubatorBlockEntity> p_151990_) {
        return level.isClientSide ? createTickerHelper(type, p_151990_, IncubatorBlockEntity::clientTick) : createTickerHelper(type, p_151990_, IncubatorBlockEntity::serverTick);
    }

    public void setFuelTag(ItemStack stack,int value){
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("fuel",value);
    }
    public int getFuelTag(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTag();
        return tag.getInt("fuel");
    }



    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter getter, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, getter, components, tooltipFlag);
        components.add(Component.translatable("cdu.line").withStyle(ChatFormatting.BLUE));
        components.add(Sitems.ICE_CANISTER.get().getDescription());
        components.add(Component.literal(this.getFuelTag(stack) +"/12000").withStyle(ChatFormatting.DARK_BLUE));
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        ItemStack stack = new ItemStack(this);
        this.setFuelTag(stack,this.getEntityFuel(level,pos));
        ItemEntity item = new ItemEntity(level, pos.getX() , pos.getY(),pos.getZ(),stack);
        level.addFreshEntity(item);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof IncubatorBlockEntity cduBlockEntity){
            CompoundTag tag = stack.getOrCreateTag();
            cduBlockEntity.setFuel(tag.getInt("fuel"));
        }
    }

    public BlockState rotate(BlockState p_54360_, Rotation p_54361_) {
        return p_54360_.setValue(FACING, p_54361_.rotate(p_54360_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_54357_, Mirror p_54358_) {
        return p_54357_.rotate(p_54358_.getRotation(p_54357_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54370_) {
        p_54370_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
