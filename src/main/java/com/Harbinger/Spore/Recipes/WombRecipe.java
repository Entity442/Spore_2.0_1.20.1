package com.Harbinger.Spore.Recipes;

import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Spore;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;


public class WombRecipe implements Recipe<EntityContainer> {
    private final ResourceLocation id;
    private final String entityId;
    private final int type;
    private final String attribute;

    public WombRecipe(ResourceLocation id, String entityId, int type, String attribute) {
        this.id = id;
        this.entityId = entityId;
        this.type = type;
        this.attribute = attribute;
    }
    public String getEntityId() {
        return entityId;
    }
    public int getEntityType(){
        return type;
    }
    public String getAttribute() {
        return attribute;
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
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return WombRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return WombRecipeType.INSTANCE;
    }

    public static class WombRecipeType implements RecipeType<WombRecipe> {
        public static final WombRecipe.WombRecipeType INSTANCE = new WombRecipe.WombRecipeType();
        public static final String ID = "womb_crafting";

        private WombRecipeType() {}
    }

    public static class WombRecipeSerializer implements RecipeSerializer<WombRecipe> {
        public static final WombRecipe.WombRecipeSerializer INSTANCE = new WombRecipe.WombRecipeSerializer();
        public static final ResourceLocation ID = new ResourceLocation(Spore.MODID, "womb_crafting");

        @Override
        public WombRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            String entityId = GsonHelper.getAsString(jsonObject, "entity");
            int type = GsonHelper.getAsInt(jsonObject,"entity_type");
            String attribute = GsonHelper.getAsString(jsonObject, "attribute");
            return new WombRecipe(resourceLocation, entityId,type, attribute);
        }

        @Override
        public @Nullable WombRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf buf) {
            String entityId = buf.readUtf();
            int type = buf.readInt();
            String attribute = buf.readUtf();
            return new WombRecipe(resourceLocation, entityId, type, attribute);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, WombRecipe injectionRecipe) {
            friendlyByteBuf.writeUtf(injectionRecipe.entityId);
            friendlyByteBuf.writeInt(injectionRecipe.getEntityType());
            friendlyByteBuf.writeUtf(injectionRecipe.attribute);
        }
    }
}
