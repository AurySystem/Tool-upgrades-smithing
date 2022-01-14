package gay.Aurum.smithingupgrades.recipes;

import com.google.gson.*;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.profiler.Profiler;

import java.util.Map;

import static gay.Aurum.smithingupgrades.recipes.Materials.*;
import static gay.Aurum.smithingupgrades.SmithingUpgrades.MOD_ID;
import static gay.Aurum.smithingupgrades.recipes.Materials.MATERIAL_MAP;

public class MaterialReloadListener extends JsonDataLoader implements IdentifiableResourceReloadListener {

    public MaterialReloadListener() {
        super(new GsonBuilder().setPrettyPrinting().create(), "smithing_table_materials");
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> prepared, ResourceManager manager, Profiler profiler) {
        MATERIAL_MAP.clear();
        for (Identifier id:prepared.keySet()){
            JsonObject obj = prepared.get(id).getAsJsonObject();
            MaterialInfo info;

            String name = JsonHelper.getString(obj,"name",id.toString());
            JsonElement mat = obj.get("material");
            if(mat == null){
                info = new MaterialInfo(name);
            }else{
                Boolean isItem = JsonHelper.getBoolean(obj,"isItem",true);
                info = new MaterialInfo(new Identifier(mat.getAsString()), isItem, name,
                        JsonHelper.getInt(obj, "matCount", 1));
            }

            if(JsonHelper.hasElement(obj,"equipment")){
                JsonObject equip = JsonHelper.getObject(obj,"equipment");
                for (Map.Entry<String,JsonElement> entry:equip.entrySet()) {
                    info.addEquipment(entry.getKey(),new Identifier(entry.getValue().getAsString()));
                }
            }

            if(JsonHelper.hasElement(obj,"inputList")){
                JsonObject inList = JsonHelper.getObject(obj,"inputList");
                JsonArray inputList = JsonHelper.getArray(inList,"list", new JsonArray());
                info.setInList(new String[]{},inList.get("inclusive").getAsBoolean());
                for (JsonElement entry:inputList) {
                    info.addToList(entry.getAsString(), false);
                }
            }

            if(JsonHelper.hasElement(obj,"outputList")){
                JsonObject outList = JsonHelper.getObject(obj,"outputList");
                JsonArray outputList = JsonHelper.getArray(outList,"list", new JsonArray());
                info.setOutList(new String[]{},outList.get("inclusive").getAsBoolean());
                for (JsonElement entry:outputList) {
                    info.addToList(entry.getAsString(), true);
                }
            }

            JsonElement countsEle = obj.get("equipmentMatCount");
            if(countsEle != null){
                JsonObject counts = countsEle.getAsJsonObject();
                for (Map.Entry<String,JsonElement> entry:counts.entrySet()) {
                    info.addEquipmentCount(entry.getKey(),entry.getValue().getAsInt());
                }
            }
            MATERIAL_MAP.put(name, info);
        }
    }

    @Override
    public Identifier getFabricId() {
        return new Identifier(MOD_ID,"smithing_table_materials");
    }

}
