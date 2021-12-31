package gay.Aurum.smithingupgrades.recipes;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import gay.Aurum.smithingupgrades.SmithingUpgrades;
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

import static gay.Aurum.smithingupgrades.recipes.Materials.*;

public class MaterialConfig {
    public static final Path MOD_FOLDER = FileSystems.getDefault().getPath("config","toolsmithingupgrades/");
    public static final Path MAT_FOLDER = FileSystems.getDefault().getPath("config","toolsmithingupgrades/material/");

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void generate(){
        MaterialInfo wood = addMaterial("Wood", "planks",false);
        wood.setOutList(new String[] {"Stone","Iron"}, true);
        wood.addEquipment("sword", "wooden_sword");
        wood.addEquipment("sword", "wooden_sword");
        wood.addEquipment("axe", "wooden_axe");
        wood.addEquipment("pickaxe", "wooden_pickaxe");
        wood.addEquipment("shovel", "wooden_shovel");
        wood.addEquipment("hoe", "wooden_hoe");

        MaterialInfo stone = addMaterial("Stone", "stone_tool_materials",false);
        stone.setOutList(new String[] {"Wood","Iron"}, true);
        stone.addEquipment("sword", "stone_sword");
        stone.addEquipment("axe", "stone_axe");
        stone.addEquipment("pickaxe", "stone_pickaxe");
        stone.addEquipment("shovel", "stone_shovel");
        stone.addEquipment("hoe", "stone_hoe");

        MaterialInfo leather = addMaterial("Leather", "leather");
        leather.setOutList(new String[] {"Iron"}, true);
        leather.addEquipment("helmet", "leather_helmet");
        leather.addEquipment("chestplate", "leather_chestplate");
        leather.addEquipment("leggings", "leather_leggings");
        leather.addEquipment("boots", "leather_boots");
        leather.addEquipment("horsearmor", "leather_horse_armor");

        MaterialInfo iron = addMaterial("Iron", "iron_block");
        iron.addEquipment("sword", "iron_sword");
        iron.addEquipment("axe", "iron_axe");
        iron.addEquipment("pickaxe", "iron_pickaxe");
        iron.addEquipment("shovel", "iron_shovel");
        iron.addEquipment("hoe", "iron_hoe");

        iron.addEquipment("helmet", "iron_helmet");
        iron.addEquipment("chestplate", "iron_chestplate");
        iron.addEquipment("leggings", "iron_leggings");
        iron.addEquipment("boots", "iron_boots");
        iron.addEquipment("horsearmor", "iron_horse_armor");

        MaterialInfo gold = addMaterial("Gold", "gold_block");
        gold.addEquipment("sword", "golden_sword");
        gold.addEquipment("axe", "golden_axe");
        gold.addEquipment("pickaxe", "golden_pickaxe");
        gold.addEquipment("shovel", "golden_shovel");
        gold.addEquipment("hoe", "golden_hoe");

        gold.addEquipment("helmet", "golden_helmet");
        gold.addEquipment("chestplate", "golden_chestplate");
        gold.addEquipment("leggings", "golden_leggings");
        gold.addEquipment("boots", "golden_boots");
        gold.addEquipment("horsearmor", "golden_horse_armor");

        MaterialInfo diamond = addMaterial("Diamond", "diamond_block");
        diamond.setOutList(new String[] {"Netherite"}, false);
        diamond.setInList(new String[] {"Wood"}, false);
        diamond.addEquipment("sword", "diamond_sword");
        diamond.addEquipment("axe", "diamond_axe");
        diamond.addEquipment("pickaxe", "diamond_pickaxe");
        diamond.addEquipment("shovel", "diamond_shovel");
        diamond.addEquipment("hoe", "diamond_hoe");

        diamond.addEquipment("helmet", "diamond_helmet");
        diamond.addEquipment("chestplate", "diamond_chestplate");
        diamond.addEquipment("leggings", "diamond_leggings");
        diamond.addEquipment("boots", "diamond_boots");
        diamond.addEquipment("horsearmor", "diamond_horse_armor");

        MaterialInfo netherite = addMaterial("Netherite", "netherite_ingot");
        netherite.setInList( new String[] {"Diamond"}, true);
        netherite.addEquipment("sword", "netherite_sword");
        netherite.addEquipment("axe", "netherite_axe");
        netherite.addEquipment("pickaxe", "netherite_pickaxe");
        netherite.addEquipment("shovel", "netherite_shovel");
        netherite.addEquipment("hoe", "netherite_hoe");

        netherite.addEquipment("helmet", "netherite_helmet");
        netherite.addEquipment("chestplate", "netherite_chestplate");
        netherite.addEquipment("leggings", "netherite_leggings");
        netherite.addEquipment("boots", "netherite_boots");

        for (MaterialInfo mat:MATERIAL_MAP.values()){
            try{save(mat);} catch (IOException e) {
                SmithingUpgrades.logger(e.toString()+" Error saving material: " + mat.getName());
            }
        }
    }

    public static void save(MaterialInfo mat) throws IOException {
        if(!Files.exists(MOD_FOLDER)) {
            Files.createDirectory(MOD_FOLDER);
        }
        if(!Files.exists(MAT_FOLDER)) {
            Files.createDirectory(MAT_FOLDER);
        }
        JsonObject jsn = serialize(mat);
        Path path = FileSystems.getDefault().getPath("config", "toolsmithingupgrades/material/"+mat.getName()+".json");
        try (BufferedWriter config = Files.newBufferedWriter(path, StandardOpenOption.CREATE);) {
            JsonWriter writer = GSON.newJsonWriter(config);
            GSON.toJson(jsn, writer);
            return;
        } catch (IOException e) {
            SmithingUpgrades.logger(e.toString()+" Error saving material: " + mat.getName());
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
                SmithingUpgrades.logger(e.toString()+" Error loading material: " + file.getName());
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
