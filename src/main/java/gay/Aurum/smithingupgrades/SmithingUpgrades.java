package gay.Aurum.smithingupgrades;

import net.fabricmc.api.ModInitializer;

public class SmithingUpgrades implements ModInitializer {
	public static final String MOD_ID = "smithingupgrades";
	public static SmithingConfigs CONFIG = SmithingConfigs.load();

	@Override
	public void onInitialize() {
		LOGGER("Loading");
	}
	public static void LOGGER(String s){
		System.out.println(MOD_ID+": "+s);
	}

}
