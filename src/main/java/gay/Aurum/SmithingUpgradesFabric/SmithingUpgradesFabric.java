package gay.Aurum.SmithingUpgradesFabric;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import static gay.Aurum.SmithingUpgradesFabric.Recipes.RecipeHelper.addSmithingRecipe;
import static gay.Aurum.SmithingUpgradesFabric.Recipes.Materials.registerMaterials;
import static gay.Aurum.SmithingUpgradesFabric.Recipes.RecipeGen.RecipeGen;

public class SmithingUpgradesFabric implements ModInitializer {
	public static final String MOD_ID = "smithingupgradesfabric";

	@Override
	public void onInitialize() {
		registerMaterials();
		RecipeGen();
		addSmithingRecipe(new Identifier("compass"), new Identifier("stick"), new Identifier("debug_stick"));
		System.out.println("Hello Fabric world!");
	}
}
