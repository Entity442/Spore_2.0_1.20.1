package com.Harbinger.Spore.Sentities.Utility;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class CorpseEntity extends Entity {
    private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(CorpseEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<String> OWNER_ID = SynchedEntityData.defineId(CorpseEntity.class, EntityDataSerializers.STRING);
    private final SimpleContainer inventory = new SimpleContainer(20);
    public CorpseEntity(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(TYPE, 0);
        this.entityData.define(OWNER_ID,"");
    }
    public SimpleContainer getInventory(){
        return inventory;
    }
    public void addToInventory(ItemStack stack){
        this.inventory.addItem(stack);
    }
    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        setCorpseType(compoundTag.getInt("corpse_type"));
        setOwnerId(compoundTag.getString("owner_id"));
        ListTag listtag = compoundTag.getList("Items",10);

        for (int i = 0; i < listtag.size(); i++) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = (compoundtag.getByte("Slot") & 255) % this.inventory.getContainerSize();
            this.inventory.setItem(j, ItemStack.of(compoundtag));
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putInt("corpse_type",getCorpseType());
        compoundTag.putString("owner_id",getOwnerId());
        ListTag listtag = new ListTag();
        for (int i = 0; i < this.inventory.getContainerSize(); i++) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putByte("Slot", (byte)i);
                listtag.add(itemstack.save(compoundtag));
            }
        }
        compoundTag.put("Items", listtag);
    }

    public void setCorpseType(int e){
        entityData.set(TYPE,e);
    }
    public int getCorpseType(){
        return entityData.get(TYPE);
    }
    public void setOwnerId(String e){
        entityData.set(OWNER_ID,e);
    }
    public String getOwnerId(){
        return entityData.get(OWNER_ID);
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (player.isShiftKeyDown()){
            addToInventory(new ItemStack(Items.APPLE,random.nextInt(32)));
            addToInventory(new ItemStack(Items.HAY_BLOCK,random.nextInt(32)));
        }else {
            for (int i = 0; i < inventory.getContainerSize();i++){
                ItemStack stack = inventory.getItem(i);
                if (stack != ItemStack.EMPTY){
                    summonItem(stack);
                    break;
                }
            }
            if (inventory.isEmpty()){this.discard();}
        }
        return InteractionResult.SUCCESS;
    }
    public void summonItem(ItemStack stack){
        ItemEntity entity = new ItemEntity(level(),this.getX(),this.getY(),this.getZ(),stack);
        level().addFreshEntity(entity);
    }

    @Override
    public boolean mayInteract(Level p_146843_, BlockPos p_146844_) {
        return super.mayInteract(p_146843_, p_146844_);
    }
}
