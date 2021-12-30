package gay.Aurum.smithingupgrades.recipes;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import net.minecraft.util.Identifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import static gay.Aurum.smithingupgrades.SmithingUpgrades.MOD_ID;
import static gay.Aurum.smithingupgrades.recipes.Materials.*;

public class MaterialConfig {
    public static final Path MAT_FOLDER = FileSystems.getDefault().getPath("config","material/");

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void generate(){
        MaterialInfo wood = addMaterial("Wood", MOD_ID+":wooden_cluster");
        wood.setOutList(new String[] {"Stone","Iron"}, true);
        wood.addEquipment("sword", "wooden_sword");
        wood.addEquipment("sword", "wooden_sword");
        wood.addEquipment("axe", "wooden_axe");
        wood.addEquipment("pickaxe", "wooden_pickaxe");
        wood.addEquipment("shovel", "wooden_shovel");
        wood.addEquipment("hoe", "wooden_hoe");

        MaterialInfo stone = addMaterial("Stone", MOD_ID+":stone_cluster");
        setMaterialList("Stone", new String[] {"Wood","Iron"}, true,true);
        addEquipment("Stone","sword", "stone_sword");
        addEquipment("Stone","axe", "stone_axe");
        addEquipment("Stone","pickaxe", "stone_pickaxe");
        addEquipment("Stone","shovel", "stone_shovel");
        addEquipment("Stone","hoe", "stone_hoe");

        MaterialInfo Leather = addMaterial("Leather", "leather");
        setMaterialList("Leather", new String[] {"Iron","Iron_Block"}, true, true);
        addEquipment("Leather","helmet", "leather_helmet");
        addEquipment("Leather","chestplate", "leather_chestplate");
        addEquipment("Leather","leggings", "leather_leggings");
        addEquipment("Leather","boots", "leather_boots");
        addEquipment("Leather","horsearmor+via_iron", "leather_horse_armor");

        MaterialInfo Iron = addMaterial("Iron", MOD_ID+":iron_cluster");
        addEquipment("Iron","sword", "iron_sword");
        addEquipment("Iron","axe", "iron_axe");
        addEquipment("Iron","pickaxe", "iron_pickaxe");
        addEquipment("Iron","shovel", "iron_shovel");
        addEquipment("Iron","hoe", "iron_hoe");

        addEquipment("Iron","helmet", "iron_helmet");
        addEquipment("Iron","chestplate", "iron_chestplate");
        addEquipment("Iron","leggings", "iron_leggings");
        addEquipment("Iron","boots", "iron_boots");
        addEquipment("Iron","horsearmor", "iron_horse_armor");

        MaterialInfo Iron_Block = addMaterial("Iron_Block", MOD_ID+":cubic_iron_cluster");
        addEquipment("Iron_Block","horsearmor+via_iron", "iron_horse_armor");

        MaterialInfo Gold = addMaterial("Gold", MOD_ID+":golden_cluster");
        addEquipment("Gold","sword", "golden_sword");
        addEquipment("Gold","axe", "golden_axe");
        addEquipment("Gold","pickaxe", "golden_pickaxe");
        addEquipment("Gold","shovel", "golden_shovel");
        addEquipment("Gold","hoe", "golden_hoe");

        addEquipment("Gold","helmet", "golden_helmet");
        addEquipment("Gold","chestplate", "golden_chestplate");
        addEquipment("Gold","leggings", "golden_leggings");
        addEquipment("Gold","boots", "golden_boots");
        addEquipment("Gold","horsearmor", "golden_horse_armor");

        MaterialInfo Diamond = addMaterial("Diamond", MOD_ID+":diamond_cluster");
        setMaterialList("Diamond", new String[] {"Netherite"}, false, true);
        setMaterialList("Diamond", new String[] {"Wood"}, false, false);
        addEquipment("Diamond","sword", "diamond_sword");
        addEquipment("Diamond","axe", "diamond_axe");
        addEquipment("Diamond","pickaxe", "diamond_pickaxe");
        addEquipment("Diamond","shovel", "diamond_shovel");
        addEquipment("Diamond","hoe", "diamond_hoe");

        addEquipment("Diamond","helmet", "diamond_helmet");
        addEquipment("Diamond","chestplate", "diamond_chestplate");
        addEquipment("Diamond","leggings", "diamond_leggings");
        addEquipment("Diamond","boots", "diamond_boots");
        addEquipment("Diamond","horsearmor", "diamond_horse_armor");

        MaterialInfo Netherite = addMaterial("Netherite", "netherite_ingot");
        setMaterialList("Netherite", new String[] {"Diamond"}, true, false);
        addEquipment("Netherite","sword", "netherite_sword");
        addEquipment("Netherite","axe", "netherite_axe");
        addEquipment("Netherite","pickaxe", "netherite_pickaxe");
        addEquipment("Netherite","shovel", "netherite_shovel");
        addEquipment("Netherite","hoe", "netherite_hoe");

        addEquipment("Netherite","helmet", "netherite_helmet");
        addEquipment("Netherite","chestplate", "netherite_chestplate");
        addEquipment("Netherite","leggings", "netherite_leggings");
        addEquipment("Netherite","boots", "netherite_boots");
        for (MaterialInfo mat:MATERIAL_MAP.values()){
            try{save(mat);} catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void save(MaterialInfo mat) throws IOException {
        if(!Files.exists(MAT_FOLDER)) {
            Files.createDirectory(MAT_FOLDER);
        }
        JsonObject jsn = serialize(mat);
        Path path = FileSystems.getDefault().getPath("config", "material/"+mat.getName()+".json");
        try (BufferedWriter config = Files.newBufferedWriter(path, StandardOpenOption.CREATE);) {
            JsonWriter writer = GSON.newJsonWriter(config);
            GSON.toJson(jsn, writer);
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void load(){
        if(!Files.exists(MAT_FOLDER)){
            generate();
            return;
        }
        boolean hasFiles = false;
        for (File file:MAT_FOLDER.toFile().listFiles()) {
            Path path = file.toPath();
            try {
               BufferedReader config = Files.newBufferedReader(path);
               JsonParser parser = new JsonParser();
               JsonElement element = parser.parse(config);
               MaterialInfo material = deserialize(element);
               MATERIAL_MAP.put(material.getName(), material);
               hasFiles = true;
          }
            catch (IOException e) {
              e.printStackTrace();
            }
        }
        if(!hasFiles){
            generate();
        }
    }

    private static MaterialInfo deserialize(JsonElement element) throws IllegalStateException{
        JsonObject obj = element.getAsJsonObject();
        MaterialInfo info;

        String name = obj.get("name").getAsString();
        JsonElement mat = obj.get("material");
        if(mat == null){
             info = new MaterialInfo(name);
        }else{
            Boolean isitem = obj.get("isItem").getAsBoolean();
            info = new MaterialInfo(new Identifier(mat.getAsString()), isitem, name);
        }
        JsonObject equip = obj.get("equipment").getAsJsonObject();
        for (Map.Entry<String,JsonElement> entry:equip.entrySet()) {
            info.addEquipment(entry.getKey(),new Identifier(entry.getValue().getAsString()));
        }

        JsonObject inList = obj.get("inputList").getAsJsonObject();
        JsonArray inputList = inList.get("list").getAsJsonArray();
        info.setInList(new String[]{},inList.get("inclusive").getAsBoolean());
        for (JsonElement entry:inputList) {
            info.addToList(entry.getAsString(), false);
        }

        JsonObject outList = obj.get("outputList").getAsJsonObject();
        JsonArray outputList = outList.get("list").getAsJsonArray();
        info.setOutList(new String[]{},outList.get("inclusive").getAsBoolean());
        for (JsonElement entry:outputList) {
            info.addToList(entry.getAsString(), true);
        }

        return info;
    }

    private static JsonObject serialize(MaterialInfo fig){
        JsonObject obj = new JsonObject();

        obj.addProperty("name",fig.getName());
        if(fig.hasItems()){
            obj.addProperty("material", fig.getMatItem().toString());
        }
        obj.addProperty("isItem", fig.isItemOrTag());

        JsonObject equipment = new JsonObject();
        Map<String, Identifier> tools = fig.getEquipment();
        for (Map.Entry<String, Identifier> entry:tools.entrySet()) {
            equipment.addProperty(entry.getKey(),entry.getValue().toString());
        }
        obj.add("equipment",equipment);

        JsonObject inList = new JsonObject();
        JsonArray inArray = new JsonArray();
        MaterialsList inner = fig.getInList();
        for (String entry:inner.getList()) {
            inArray.add(entry);
        }
        inList.add("list",inArray);
        inList.addProperty("inclusive",inner.isInclusiveList());
        obj.add("inputList",inList);

        JsonObject outList = new JsonObject();
        JsonArray outArray = new JsonArray();
        MaterialsList outer = fig.getOutList();
        for (String entry:outer.getList()) {
            outArray.add(entry);
        }
        outList.add("list",outArray);
        outList.addProperty("inclusive",outer.isInclusiveList());
        obj.add("outputList",outList);

        return obj;
    }
}
