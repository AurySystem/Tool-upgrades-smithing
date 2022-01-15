package gay.Aurum.smithingupgrades.recipes;

import com.google.gson.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;

import java.util.Map;

import static gay.Aurum.smithingupgrades.recipes.Materials.*;

public class MaterialDeserializer {

    public static MaterialInfo apply(JsonObject obj, MaterialInfo info) {

        JsonElement mat = obj.get("material");

        Boolean isItem = JsonHelper.getBoolean(obj, "isItem", true);

        if(mat != null && mat.isJsonPrimitive()){
            if (mat.getAsString().isEmpty()){
                info.clearMatItem();
            }else {
                info.setMatItem(new Identifier(mat.getAsString()), isItem);
            }
        }
        info.setMatCount(JsonHelper.getInt(obj, "matCount", 1));

        if (JsonHelper.hasElement(obj, "equipment")) {
            JsonObject equip = JsonHelper.getObject(obj, "equipment");
            for (Map.Entry<String, JsonElement> entry: equip.entrySet()) {
                info.addEquipment(entry.getKey(), new Identifier(entry.getValue().getAsString()));
            }
        }

        if (JsonHelper.hasElement(obj, "inputList")) {
            JsonObject inList = JsonHelper.getObject(obj, "inputList");
            JsonArray inputList = JsonHelper.getArray(inList, "list", new JsonArray());
            info.setInList(new String[]{}, inList.get("inclusive").getAsBoolean());
            for (JsonElement entry: inputList) {
                info.addToList(entry.getAsString(), false);
            }
        }

        if (JsonHelper.hasElement(obj, "outputList")) {
            JsonObject outList = JsonHelper.getObject(obj, "outputList");
            JsonArray outputList = JsonHelper.getArray(outList, "list", new JsonArray());
            info.setOutList(new String[]{}, outList.get("inclusive").getAsBoolean());
            for (JsonElement entry: outputList) {
                info.addToList(entry.getAsString(), true);
            }
        }

        if (JsonHelper.hasElement(obj, "equipmentMatCount")) {
            JsonObject counts = JsonHelper.getObject(obj, "equipmentMatCount");
            for (Map.Entry<String, JsonElement> entry: counts.entrySet()) {
                info.addEquipmentCount(entry.getKey(), entry.getValue().getAsInt());
            }
        }
        return info;
    }
}
