package gay.Aurum.smithingupgrades;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import static gay.Aurum.smithingupgrades.Recipes.RecipeHelper.addSmithingRecipe;
import static gay.Aurum.smithingupgrades.Recipes.Materials.registerMaterials;
import static gay.Aurum.smithingupgrades.Recipes.RecipeGen.RecipeGen;

public class SmithingUpgrades implements ModInitializer {
	public static final String MOD_ID = "smithingupgradesfabric";

	@Override
	public void onInitialize() {
		registerMaterials();
		RecipeGen();
		addSmithingRecipe(new Identifier("compass"), new Identifier("stick"), new Identifier("debug_stick"), true);
		System.out.println("Hello Fabric world!");
	}
}
