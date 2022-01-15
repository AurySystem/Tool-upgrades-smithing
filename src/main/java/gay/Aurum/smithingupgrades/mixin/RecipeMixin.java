package gay.Aurum.smithingupgrades.mixin;


import com.google.gson.JsonElement;
import gay.Aurum.smithingupgrades.recipes.MaterialDeserializer;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.profiler.Profiler;
import org.apache.commons.io.IOUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;

import static gay.Aurum.smithingupgrades.SmithingUpgrades.MOD_ID;
import static gay.Aurum.smithingupgrades.recipes.Materials.MATERIAL_MAP;
import static gay.Aurum.smithingupgrades.recipes.RecipeGen.RecipeGen;
import static gay.Aurum.smithingupgrades.recipes.RecipeHelper.SMITHING_MAP;
import static gay.Aurum.smithingupgrades.recipes.Materials.*;

@Mixin(RecipeManager.class)
public class RecipeMixin {
	@Shadow @Final private static Gson GSON;
	@Shadow @Final private static Logger LOGGER;

	@Inject(method = "apply", at = @At("HEAD"))
	public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
		MATERIAL_MAP.clear();
		SMITHING_MAP.clear();

		for(Identifier path:resourceManager.findResources("smithing_table_materials", path -> path.endsWith(".json"))) {
			Identifier id = new Identifier(path.getNamespace(), path.getPath().replace(".json","").replace("smithing_table_materials/",""));
			try {
				Collection<Resource> resources = resourceManager.getAllResources(path);
				String name = id.getPath();
				MaterialInfo matInfo = new MaterialInfo(name);
				for (Resource res : resources) {
					String contents = IOUtils.toString(res.getInputStream(), StandardCharsets.UTF_8);
					JsonElement ele = JsonHelper.deserialize(GSON, contents, JsonElement.class);
					if (ele != null && ele.isJsonObject()) {
						MaterialDeserializer.apply(ele.getAsJsonObject(), matInfo);
					}
					MATERIAL_MAP.put(matInfo.getName(), matInfo);
					res.close();
				}
				LOGGER.info(MOD_ID+": completed material: {}", id);
			} catch (IOException e) {
				LOGGER.error(MOD_ID+": *screaming*", id, e);
			}
		}

		RecipeGen();
		map.putAll(SMITHING_MAP);
	}
}
