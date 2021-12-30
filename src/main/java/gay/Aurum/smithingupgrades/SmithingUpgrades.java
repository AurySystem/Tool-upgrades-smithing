package gay.Aurum.smithingupgrades;

import net.fabricmc.api.ModInitializer;

import static gay.Aurum.smithingupgrades.items.RegisterItems.RegisterItems;
import static gay.Aurum.smithingupgrades.recipes.Materials.registerMaterials;
import static gay.Aurum.smithingupgrades.recipes.RecipeGen.RecipeGen;

public class SmithingUpgrades implements ModInitializer {
	public static final String MOD_ID = "smithingupgrades";
	public static SmithingConfigs CONFIG;

	@Override
	public void onInitialize() {
		SmithingConfigs.init();
		CONFIG = SmithingConfigs.load();
		RegisterItems();
		registerMaterials();
		RecipeGen();
	}
}
