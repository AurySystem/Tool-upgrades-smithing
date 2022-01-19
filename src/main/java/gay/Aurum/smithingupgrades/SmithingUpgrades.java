package gay.Aurum.smithingupgrades;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class SmithingUpgrades implements ModInitializer {
	public static final String MOD_ID = "smithingupgrades";

	@Override
	public void onInitialize() {
		LOGGER("Loading");
		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MOD_ID,"costpertool"),modContainer, ResourcePackActivationType.NORMAL);
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MOD_ID,"costpermaterial3"),modContainer, ResourcePackActivationType.NORMAL);
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MOD_ID,"costpermaterial4"),modContainer, ResourcePackActivationType.NORMAL);
		});
	}
	public static void LOGGER(String s){
		System.out.println(MOD_ID+": "+s);
	}

}
