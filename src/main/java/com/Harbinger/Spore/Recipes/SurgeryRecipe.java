package com.Harbinger.Spore.Recipes;

import com.Harbinger.Spore.Spore;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SurgeryRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;

    public SurgeryRecipe(NonNullList<Ingredient> inputItems, ItemStack output, ResourceLocation id) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide() || simpleContainer.getContainerSize() < 16) {
            return false;
        }
        for (int i = 0; i < 16; i++) {
            if (!inputItems.get(i).test(simpleContainer.getItem(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output == null ? ItemStack.EMPTY : output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SurgeryRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return SurgeryRecipeType.INSTANCE;
    }

    public static class SurgeryRecipeType implements RecipeType<SurgeryRecipe> {
        public static final SurgeryRecipeType INSTANCE = new SurgeryRecipeType();
        public static final String ID = "surgery";

        private SurgeryRecipeType() {}
    }
    public static class SurgeryRecipeSerializer implements RecipeSerializer<SurgeryRecipe> {
        public static final SurgeryRecipeSerializer INSTANCE = new SurgeryRecipeSerializer();
        public static final ResourceLocation ID = new ResourceLocation(Spore.MODID, "surgery");

        @Override
        public SurgeryRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(16, Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                JsonObject ingredientJson = ingredients.get(i).getAsJsonObject();
                int slot = GsonHelper.getAsInt(ingredientJson, "slot", i);
                if (slot >= 0 && slot < inputs.size()) {
                    inputs.set(slot, Ingredient.fromJson(ingredientJson));
                }
            }
            return new SurgeryRecipe(inputs, output, resourceLocation);
        }

        @Override
        public @Nullable SurgeryRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);
            inputs.replaceAll(ignored -> Ingredient.fromNetwork(friendlyByteBuf));
            ItemStack output = friendlyByteBuf.readItem();
            return new SurgeryRecipe(inputs, output, resourceLocation);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, SurgeryRecipe surgeryRecipe) {
            friendlyByteBuf.writeInt(surgeryRecipe.inputItems.size());
            for (Ingredient ingredient : surgeryRecipe.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }
            friendlyByteBuf.writeItemStack(surgeryRecipe.getResultItem(null), false);
        }
    }
}
