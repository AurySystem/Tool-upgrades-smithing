package gay.Aurum.smithingupgrades.recipes;


import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

import java.util.Map;

import static gay.Aurum.smithingupgrades.SmithingUpgrades.MOD_ID;

public class RecipeHelper {
    public static final Map<Identifier, JsonObject> SMITHING_MAP = Maps.newHashMap();
    public static final Map<Identifier, JsonObject> SHAPELSS_MAP = Maps.newHashMap();

    public static void addSmithingRecipe(Identifier input, Identifier upgrade, Identifier output, boolean isItem){
        SMITHING_MAP.put( new Identifier(MOD_ID, input.getPath()+"_"+upgrade.getPath()), createSmithingRecipe(input, upgrade, output, isItem));
    }

    public static void addShapelessRecipe(Identifier input, int count, Identifier output, boolean isItem){
        SHAPELSS_MAP.put( new Identifier(MOD_ID, output.getPath()), createShapelessRecipe(input, count, output, isItem));
    }

    private static JsonObject createSmithingRecipe(Identifier input, Identifier upgrade, Identifier output, boolean isItem){
        JsonObject recipe = new JsonObject();
        recipe.addProperty("type","minecraft:smithing");

        JsonObject base = new JsonObject();
        base.addProperty("item", input.toString());
        recipe.add("base", base);

        JsonObject addon = new JsonObject();
        addon.addProperty(isItem?"item":"tag", upgrade.toString());
        recipe.add("addition", addon);

        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        recipe.add("result", result);

        return recipe;
    }

    private static JsonObject createShapelessRecipe(Identifier input, int count, Identifier output, boolean isItem){
        JsonObject recipe = new JsonObject();
        recipe.addProperty("type","minecraft:crafting_shapeless");

        JsonArray ingredients = new JsonArray();

        JsonObject ingredientEntry = new JsonObject();
        ingredientEntry.addProperty(isItem?"item":"tag", input.toString());
        for (int i = 0; i < count; i++) {
            ingredients.add(ingredientEntry);
        }

        recipe.add("ingredients", ingredients);

        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        recipe.add("result", result);

        return recipe;
    }

}
