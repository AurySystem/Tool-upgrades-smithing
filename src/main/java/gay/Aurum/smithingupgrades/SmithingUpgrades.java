package gay.Aurum.smithingupgrades;

import net.fabricmc.api.ModInitializer;

import static gay.Aurum.smithingupgrades.items.RegisterItems.RegisterItems;
import static gay.Aurum.smithingupgrades.recipes.Materials.registerMaterials;
import static gay.Aurum.smithingupgrades.recipes.RecipeGen.RecipeGen;

public class SmithingUpgrades implements ModInitializer {
	public static final String MOD_ID = "smithingupgrades";

	@Override
	public void onInitialize() {
		RegisterItems();
		registerMaterials();
		RecipeGen();
	}

	public static String createItemModelJson(String id, String type) {
		if ("generated".equals(type) || "handheld".equals(type)) {
			return "{\n" +
					"  \"parent\": \"item/" + type + "\",\n" +
					"  \"textures\": {\n" +
					"    \"layer0\": \"" + MOD_ID + ":" + id + "\"\n" +
					"  }\n" +
					"}";
		}
		else {
			return "";
		}
	}
}
