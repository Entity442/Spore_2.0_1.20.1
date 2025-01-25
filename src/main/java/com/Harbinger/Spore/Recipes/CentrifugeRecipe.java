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

public class CentrifugeRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> inputItems;

    public CentrifugeRecipe(NonNullList<Ingredient> inputItems,ResourceLocation id, ItemStack output) {
        this.inputItems = inputItems;
        this.id = id;
        this.output = output;
    }
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide() || simpleContainer.getContainerSize() < 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
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
        return CentrifugeRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return CentrifugeRecipeType.INSTANCE;
    }

    public static class CentrifugeRecipeType implements RecipeType<CentrifugeRecipe> {
        public static final CentrifugeRecipeType INSTANCE = new CentrifugeRecipeType();
        public static final String ID = "centrifuge";

        private CentrifugeRecipeType() {}
    }
    public static class CentrifugeRecipeSerializer implements RecipeSerializer<CentrifugeRecipe> {
        public static final CentrifugeRecipeSerializer INSTANCE = new CentrifugeRecipeSerializer();
        public static final ResourceLocation ID = new ResourceLocation(Spore.MODID, "centrifuge");

        @Override
        public CentrifugeRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(4, Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                JsonObject ingredientJson = ingredients.get(i).getAsJsonObject();
                int slot = GsonHelper.getAsInt(ingredientJson, "slot", i);
                int amount = GsonHelper.getAsInt(ingredientJson, "amount", 1);
                ItemStack part = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "item"+i));
                part.setCount(amount);
                Ingredient ingredient = Ingredient.of(part);
                if (slot >= 0 && slot < inputs.size()) {
                    inputs.set(slot, ingredient);
                }
            }
            return new CentrifugeRecipe(inputs,resourceLocation, output);
        }

        @Override
        public @Nullable CentrifugeRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);
            inputs.replaceAll(ignored -> Ingredient.fromNetwork(friendlyByteBuf));
            ItemStack output = friendlyByteBuf.readItem();
            return new CentrifugeRecipe(inputs, resourceLocation, output);
        }
        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, CentrifugeRecipe surgeryRecipe) {
            friendlyByteBuf.writeInt(surgeryRecipe.inputItems.size());
            for (Ingredient ingredient : surgeryRecipe.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }
            friendlyByteBuf.writeItemStack(surgeryRecipe.getResultItem(null), false);
        }
    }
}
