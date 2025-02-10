package com.Harbinger.Spore.Recipes;

import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Spore;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;


public class InjectionRecipe implements Recipe<EntityContainer> {
    private final ResourceLocation id;
    private final String entityId;
    private final int type;
    private final ItemStack result;

    public InjectionRecipe(ResourceLocation id, String entityId, int type, ItemStack result) {
        this.id = id;
        this.entityId = entityId;
        this.type = type;
        this.result = result;
    }
    public String getEntityId() {
        return entityId;
    }
    public int getEntityType(){
        return type;
    }

    @Override
    public boolean matches(EntityContainer entityContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        EntityType<?> entityType = entityContainer.entity().getType();
        EntityType<?> expectedType = EntityType.byString(entityId).orElse(null);
        if (expectedType == null) return false;

        if (entityContainer.entity() instanceof VariantKeeper keeper) {
            return keeper.getTypeVariant() == this.getEntityType() && entityType.equals(expectedType);
        }
        return entityType.equals(expectedType);
    }

    @Override
    public ItemStack assemble(EntityContainer entityContainer, RegistryAccess registryAccess) {
        return result == null ? ItemStack.EMPTY : result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return result.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return InjectionRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return InjectionRecipeType.INSTANCE;
    }

    public static class InjectionRecipeType implements RecipeType<InjectionRecipe> {
        public static final InjectionRecipe.InjectionRecipeType INSTANCE = new InjectionRecipe.InjectionRecipeType();
        public static final String ID = "injection";

        private InjectionRecipeType() {}
    }

    public static class InjectionRecipeSerializer implements RecipeSerializer<InjectionRecipe> {
        public static final InjectionRecipe.InjectionRecipeSerializer INSTANCE = new InjectionRecipe.InjectionRecipeSerializer();
        public static final ResourceLocation ID = new ResourceLocation(Spore.MODID, "injection");

        @Override
        public InjectionRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));
            String entityId = GsonHelper.getAsString(jsonObject, "entity");
            int type = GsonHelper.getAsInt(jsonObject,"entity_type");
            return new InjectionRecipe(resourceLocation, entityId,type, output);
        }

        @Override
        public @Nullable InjectionRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            String entityId = friendlyByteBuf.readUtf();
            ItemStack result = friendlyByteBuf.readItem();
            int type = friendlyByteBuf.readInt();
            return new InjectionRecipe(resourceLocation, entityId,type, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, InjectionRecipe injectionRecipe) {
            friendlyByteBuf.writeUtf(injectionRecipe.getEntityId());
            friendlyByteBuf.writeInt(injectionRecipe.getEntityType());
            friendlyByteBuf.writeItem(injectionRecipe.getResultItem(null) != null ? injectionRecipe.getResultItem(null) : ItemStack.EMPTY);
        }
    }
}
