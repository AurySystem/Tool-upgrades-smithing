package gay.Aurum.smithingupgrades;

import gay.Aurum.smithingupgrades.recipes.MaterialReloadListener;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

import static gay.Aurum.smithingupgrades.recipes.Materials.registerMaterials;
import static gay.Aurum.smithingupgrades.recipes.RecipeGen.RecipeGen;

public class SmithingUpgrades implements ModInitializer {
	public static final String MOD_ID = "smithingupgrades";
	public static SmithingConfigs CONFIG = SmithingConfigs.load();
	public static final MaterialReloadListener MATLISTENER = new MaterialReloadListener();

	@Override
	public void onInitialize() {
		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(MATLISTENER);
		registerMaterials();
		RecipeGen();
	}
	public static void logger(String s){
		System.out.println(MOD_ID+": "+s);
	}

}
