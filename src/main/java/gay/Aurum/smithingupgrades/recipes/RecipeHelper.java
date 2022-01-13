package gay.Aurum.smithingupgrades.recipes;


import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

import java.util.Map;

import static gay.Aurum.smithingupgrades.SmithingUpgrades.MOD_ID;

public class RecipeHelper {
    public static final Map<Identifier, JsonObject> SMITHING_MAP = Maps.newHashMap();

    public static void addSmithingRecipe(Identifier input, Identifier upgrade, Identifier output, boolean isItem, int additionCount){
        SMITHING_MAP.put( new Identifier(MOD_ID, input.getPath()+"_"+upgrade.getPath()), createSmithingRecipe(input, upgrade, output, isItem,additionCount));
    }


    private static JsonObject createSmithingRecipe(Identifier input, Identifier upgrade, Identifier output, boolean isItem,int additionCount){
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

        recipe.addProperty("additioncount", 3);

        return recipe;
    }


}
