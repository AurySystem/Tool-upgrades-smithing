package gay.Aurum.smithingupgrades.Recipes;

import com.google.common.collect.Maps;
import net.minecraft.util.Identifier;

import java.util.Map;

//todo make this load from json instead
//diamond to netherite already exists and not going to let people skip to it for balance sake
//or skip from wood and stone to diamond without going through iron, might change for modded material entry later
public class Materials {
    public static final Map<String, MaterialInfo> MATERIAL_MAP = Maps.newHashMap();

    public static void registerMaterials(){
        addMaterial("Wood", new Identifier("minecraft","planks"), false);
        MATERIAL_MAP.get("Wood").addEquipment("sword+early", new Identifier("wooden_sword"));
        MATERIAL_MAP.get("Wood").addEquipment("axe+early", new Identifier("wooden_axe"));
        MATERIAL_MAP.get("Wood").addEquipment("pickaxe+early", new Identifier("wooden_pickaxe"));
        MATERIAL_MAP.get("Wood").addEquipment("shovel+early", new Identifier("wooden_shovel"));
        MATERIAL_MAP.get("Wood").addEquipment("hoe+early", new Identifier("wooden_hoe"));

        addMaterial("Stone", new Identifier("minecraft","stone_tool_materials"), false);
        MATERIAL_MAP.get("Stone").addEquipment("sword+early", new Identifier("stone_sword"));
        MATERIAL_MAP.get("Stone").addEquipment("axe+early", new Identifier("stone_axe"));
        MATERIAL_MAP.get("Stone").addEquipment("pickaxe+early", new Identifier("stone_pickaxe"));
        MATERIAL_MAP.get("Stone").addEquipment("shovel+early", new Identifier("stone_shovel"));
        MATERIAL_MAP.get("Stone").addEquipment("hoe+early", new Identifier("stone_hoe"));

        addMaterial("Leather", new Identifier("leather"), true);
        MATERIAL_MAP.get("Leather").addEquipment("helmet+early", new Identifier("leather_helmet"));
        MATERIAL_MAP.get("Leather").addEquipment("chestplate+early", new Identifier("leather_chestplate"));
        MATERIAL_MAP.get("Leather").addEquipment("leggings+early", new Identifier("leather_leggings"));
        MATERIAL_MAP.get("Leather").addEquipment("boots+early", new Identifier("leather_boots"));
        MATERIAL_MAP.get("Leather").addEquipment("horsearmor+early", new Identifier("leather_horse_armor"));

        addMaterial("Iron", new Identifier("iron_ingot"),true);
        MATERIAL_MAP.get("Iron").addEquipment("sword", new Identifier("iron_sword"));
        MATERIAL_MAP.get("Iron").addEquipment("axe", new Identifier("iron_axe"));
        MATERIAL_MAP.get("Iron").addEquipment("pickaxe", new Identifier("iron_pickaxe"));
        MATERIAL_MAP.get("Iron").addEquipment("shovel", new Identifier("iron_shovel"));
        MATERIAL_MAP.get("Iron").addEquipment("hoe", new Identifier("iron_hoe"));

        MATERIAL_MAP.get("Iron").addEquipment("helmet", new Identifier("iron_helmet"));
        MATERIAL_MAP.get("Iron").addEquipment("chestplate", new Identifier("iron_chestplate"));
        MATERIAL_MAP.get("Iron").addEquipment("leggings", new Identifier("iron_leggings"));
        MATERIAL_MAP.get("Iron").addEquipment("boots", new Identifier("iron_boots"));
        MATERIAL_MAP.get("Iron").addEquipment("horsearmor", new Identifier("iron_horse_armor"));

        MATERIAL_MAP.get("Iron").addEquipment("sword+early", new Identifier("iron_sword"));
        MATERIAL_MAP.get("Iron").addEquipment("axe+early", new Identifier("iron_axe"));
        MATERIAL_MAP.get("Iron").addEquipment("pickaxe+early", new Identifier("iron_pickaxe"));
        MATERIAL_MAP.get("Iron").addEquipment("shovel+early", new Identifier("iron_shovel"));
        MATERIAL_MAP.get("Iron").addEquipment("hoe+early", new Identifier("iron_hoe"));

        MATERIAL_MAP.get("Iron").addEquipment("helmet+early", new Identifier("iron_helmet"));
        MATERIAL_MAP.get("Iron").addEquipment("chestplate+early", new Identifier("iron_chestplate"));
        MATERIAL_MAP.get("Iron").addEquipment("leggings+early", new Identifier("iron_leggings"));
        MATERIAL_MAP.get("Iron").addEquipment("boots+early", new Identifier("iron_boots"));

        addMaterial("Iron_Block", new Identifier("iron_block"),true);
        MATERIAL_MAP.get("Iron_Block").addEquipment("horsearmor+early", new Identifier("iron_horse_armor"));

        addMaterial("Gold", new Identifier("gold_ingot"), true);
        MATERIAL_MAP.get("Gold").addEquipment("sword", new Identifier("golden_sword"));
        MATERIAL_MAP.get("Gold").addEquipment("axe", new Identifier("golden_axe"));
        MATERIAL_MAP.get("Gold").addEquipment("pickaxe", new Identifier("golden_pickaxe"));
        MATERIAL_MAP.get("Gold").addEquipment("shovel", new Identifier("golden_shovel"));
        MATERIAL_MAP.get("Gold").addEquipment("hoe", new Identifier("golden_hoe"));

        MATERIAL_MAP.get("Gold").addEquipment("helmet", new Identifier("golden_helmet"));
        MATERIAL_MAP.get("Gold").addEquipment("chestplate", new Identifier("golden_chestplate"));
        MATERIAL_MAP.get("Gold").addEquipment("leggings", new Identifier("golden_leggings"));
        MATERIAL_MAP.get("Gold").addEquipment("boots", new Identifier("golden_boots"));
        MATERIAL_MAP.get("Gold").addEquipment("horsearmor", new Identifier("golden_horse_armor"));

        addMaterial("Diamond", new Identifier("diamond"), true);
        MATERIAL_MAP.get("Diamond").addEquipment("sword", new Identifier("diamond_sword"));
        MATERIAL_MAP.get("Diamond").addEquipment("axe", new Identifier("diamond_axe"));
        MATERIAL_MAP.get("Diamond").addEquipment("pickaxe", new Identifier("diamond_pickaxe"));
        MATERIAL_MAP.get("Diamond").addEquipment("shovel", new Identifier("diamond_shovel"));
        MATERIAL_MAP.get("Diamond").addEquipment("hoe", new Identifier("diamond_hoe"));

        MATERIAL_MAP.get("Diamond").addEquipment("helmet", new Identifier("diamond_helmet"));
        MATERIAL_MAP.get("Diamond").addEquipment("chestplate", new Identifier("diamond_chestplate"));
        MATERIAL_MAP.get("Diamond").addEquipment("leggings", new Identifier("diamond_leggings"));
        MATERIAL_MAP.get("Diamond").addEquipment("boots", new Identifier("diamond_boots"));
        MATERIAL_MAP.get("Diamond").addEquipment("horsearmor", new Identifier("diamond_horse_armor"));

    }

    public static void addMaterial(String name, Identifier base, boolean isItem){
        MATERIAL_MAP.put(name, new MaterialInfo(base, isItem));
    }

    public static class MaterialInfo{
        private Map<String, Identifier> equipment;
        private Identifier mainMatItem;
        private boolean isItem;

        public MaterialInfo( Identifier mainMatItem, boolean isItem){
            this.mainMatItem = mainMatItem;
            this.equipment = Maps.newHashMap();
            this.isItem = isItem;
        }

        protected void addEquipment(String type, Identifier item){
            this.equipment.put(type, item);
        }

        protected Map<String, Identifier> getEquipment(){
            return this.equipment;
        }

        protected Identifier getMatItem(){
            return this.mainMatItem;
        }

        protected boolean isItemOrTag(){
            return this.isItem;
        }
    }
}
