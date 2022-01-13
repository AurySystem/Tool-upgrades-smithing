package gay.Aurum.smithingupgrades;

import net.fabricmc.api.ModInitializer;

import static gay.Aurum.smithingupgrades.recipes.Materials.registerMaterials;
import static gay.Aurum.smithingupgrades.recipes.RecipeGen.RecipeGen;

public class SmithingUpgrades implements ModInitializer {
	public static final String MOD_ID = "smithingupgrades";
	public static SmithingConfigs CONFIG = SmithingConfigs.load();

	@Override
	public void onInitialize() {
		SmithingConfigs.init();
		registerMaterials();
		RecipeGen();
	}
	public static void logger(String s){
		System.out.println(MOD_ID+": "+s);
	}

}
