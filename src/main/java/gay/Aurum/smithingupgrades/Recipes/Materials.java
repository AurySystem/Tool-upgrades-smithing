package gay.Aurum.smithingupgrades.Recipes;

import com.google.common.collect.Maps;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.util.Map;

//todo make this load from json instead
//diamond to netherite already exists and not going to let people skip to it for balance sake
//or skip from wood and stone to diamond without going through iron, might change for modded material entry later
public class Materials {
    public static final Map<String, MaterialInfo> MATERIAL_MAP = Maps.newHashMap();

    public static void registerMaterials(){
        addMaterial("Wood", "minecraft:planks", false);
        addEquipment("Wood","sword+early", "wooden_sword");
        addEquipment("Wood","sword+early", "wooden_sword");
        addEquipment("Wood","axe+early", "wooden_axe");
        addEquipment("Wood","pickaxe+early", "wooden_pickaxe");
        addEquipment("Wood","shovel+early", "wooden_shovel");
        addEquipment("Wood","hoe+early", "wooden_hoe");

        addMaterial("Stone", "minecraft:stone_tool_materials", false);
        addEquipment("Stone","sword+early", "stone_sword");
        addEquipment("Stone","axe+early", "stone_axe");
        addEquipment("Stone","pickaxe+early", "stone_pickaxe");
        addEquipment("Stone","shovel+early", "stone_shovel");
        addEquipment("Stone","hoe+early", "stone_hoe");

        addMaterial("Leather", "leather", true);
        addEquipment("Leather","helmet+early", "leather_helmet");
        addEquipment("Leather","chestplate+early", "leather_chestplate");
        addEquipment("Leather","leggings+early", "leather_leggings");
        addEquipment("Leather","boots+early", "leather_boots");
        addEquipment("Leather","horsearmor+early", "leather_horse_armor");

        addMaterial("Iron", "iron_ingot",true);
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

        addEquipment("Iron","sword+early", "iron_sword");
        addEquipment("Iron","axe+early", "iron_axe");
        addEquipment("Iron","pickaxe+early", "iron_pickaxe");
        addEquipment("Iron","shovel+early", "iron_shovel");
        addEquipment("Iron","hoe+early", "iron_hoe");

        addEquipment("Iron","helmet+early", "iron_helmet");
        addEquipment("Iron","chestplate+early", "iron_chestplate");
        addEquipment("Iron","leggings+early", "iron_leggings");
        addEquipment("Iron","boots+early", "iron_boots");

        addMaterial("Iron_Block", "iron_block",true);
        addEquipment("Iron_Block","horsearmor+early", "iron_horse_armor");

        addMaterial("Gold", "gold_ingot", true);
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

        addMaterial("Diamond", "minecraft:diamond", true);
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

        if(FabricLoader.getInstance().isModLoaded("indrev")){
            addMaterial("Copper", "indrev:copper_ingot",true);
            addEquipment("Copper","sword", "indrev:copper_sword");
            addEquipment("Copper","axe", "indrev:copper_axe");
            addEquipment("Copper","pickaxe", "indrev:copper_pickaxe");
            addEquipment("Copper","shovel", "indrev:copper_shovel");
            addEquipment("Copper","hoe", "indrev:copper_hoe");

            addEquipment("Copper","helmet", "indrev:copper_helmet");
            addEquipment("Copper","chestplate", "indrev:copper_chestplate");
            addEquipment("Copper","leggings", "indrev:copper_leggings");
            addEquipment("Copper","boots", "indrev:copper_boots");

            addMaterial("Tin", "indrev:tin_ingot",true);
            addEquipment("Tin","sword", "indrev:tin_sword");
            addEquipment("Tin","axe", "indrev:tin_axe");
            addEquipment("Tin","pickaxe", "indrev:tin_pickaxe");
            addEquipment("Tin","shovel", "indrev:tin_shovel");
            addEquipment("Tin","hoe", "indrev:tin_hoe");

            addEquipment("Tin","helmet", "indrev:tin_helmet");
            addEquipment("Tin","chestplate", "indrev:tin_chestplate");
            addEquipment("Tin","leggings", "indrev:tin_leggings");
            addEquipment("Tin","boots", "indrev:tin_boots");

            addMaterial("Lead", "indrev:lead_ingot",true);
            addEquipment("Lead","sword", "indrev:lead_sword");
            addEquipment("Lead","axe", "indrev:lead_axe");
            addEquipment("Lead","pickaxe", "indrev:lead_pickaxe");
            addEquipment("Lead","shovel", "indrev:lead_shovel");
            addEquipment("Lead","hoe", "indrev:lead_hoe");

            addEquipment("Lead","helmet", "indrev:lead_helmet");
            addEquipment("Lead","chestplate", "indrev:lead_chestplate");
            addEquipment("Lead","leggings", "indrev:lead_leggings");
            addEquipment("Lead","boots", "indrev:lead_boots");

            addMaterial("Silver", "indrev:silver_ingot",true);
            addEquipment("Silver","sword", "indrev:silver_sword");
            addEquipment("Silver","axe", "indrev:silver_axe");
            addEquipment("Silver","pickaxe", "indrev:silver_pickaxe");
            addEquipment("Silver","shovel", "indrev:silver_shovel");
            addEquipment("Silver","hoe", "indrev:silver_hoe");

            addEquipment("Steel","helmet", "indrev:silver_helmet");
            addEquipment("Steel","chestplate", "indrev:silver_chestplate");
            addEquipment("Steel","leggings", "indrev:silver_leggings");
            addEquipment("Steel","boots", "indrev:silver_boots");

            addMaterial("Bronze", "indrev:bronze_ingot",true);
            addEquipment("Steel","sword", "indrev:bronze_sword");
            addEquipment("Steel","axe", "indrev:bronze_axe");
            addEquipment("Steel","pickaxe", "indrev:bronze_pickaxe");
            addEquipment("Steel","shovel", "indrev:bronze_shovel");
            addEquipment("Steel","hoe", "indrev:bronze_hoe");

            addEquipment("Steel","helmet", "indrev:bronze_helmet");
            addEquipment("Steel","chestplate", "indrev:bronze_chestplate");
            addEquipment("Steel","leggings", "indrev:bronze_leggings");
            addEquipment("Steel","boots", "indrev:bronze_boots");

            addMaterial("Steel", "indrev:steel_ingot",true);
            addEquipment("Steel","sword", "indrev:steel_sword");
            addEquipment("Steel","axe", "indrev:steel_axe");
            addEquipment("Steel","pickaxe", "indrev:steel_pickaxe");
            addEquipment("Steel","shovel", "indrev:steel_shovel");
            addEquipment("Steel","hoe", "indrev:steel_hoe");

            addEquipment("Steel","helmet", "indrev:steel_helmet");
            addEquipment("Steel","chestplate", "indrev:steel_chestplate");
            addEquipment("Steel","leggings", "indrev:steel_leggings");
            addEquipment("Steel","boots", "indrev:steel_boots");
        }
        if(FabricLoader.getInstance().isModLoaded("vanilla-hammers") || FabricLoader.getInstance().isModLoaded("vanillaexcavators")){

            addMaterial("Gold_Block", "gold_block",true);
            addMaterial("Diamond_Block", "diamond_block",true);
            addMaterial("Emerald_Block", "emerald_block",true);
            addMaterial("Lapis_Block", "lapis_block",true);
            addMaterial("Quartz_Block", "quartz_block",true);
            addMaterial("Magma_Block", "magma_block",true);
            addMaterial("Slime_Block", "slime_block",true);
            addMaterial("Dragon_Head", "dragon_head",true);
            addMaterial("Obsidian", "obsidian",true);
            addMaterial("Prismarine", "prismarine",true);

            if(FabricLoader.getInstance().isModLoaded("vanilla-hammers")){
                addEquipment("Wood","hammer+early", "vanilla-hammers:wooden_hammer");
                addEquipment("Stone","hammer+early", "vanilla-hammers:stone_hammer");
                addEquipment("Iron_Block","hammer+early", "vanilla-hammers:iron_hammer");
                addEquipment("Iron_Block","hammer", "vanilla-hammers:iron_hammer");
                addEquipment("Gold_Block","hammer", "vanilla-hammers:gold_hammer");
                addEquipment("Diamond_Block","hammer", "vanilla-hammers:diamond_hammer");
                addEquipment("Emerald_Block", "hammer","vanilla-hammers:emerald_hammer");
                addEquipment("Lapis_Block", "hammer","vanilla-hammers:lapis_hammer");
                addEquipment("Quartz_Block", "hammer","vanilla-hammers:quartz_hammer");
                addEquipment("Magma_Block","hammer", "vanilla-hammers:fiery_hammer");
                addEquipment("Slime_Block", "hammer","vanilla-hammers:slime_hammer");
                addEquipment("Dragon_Head", "hammer","vanilla-hammers:ender_hammer");
                addEquipment("Obsidian", "hammer","vanilla-hammers:obsidian_hammer");
                addEquipment("Prismarine", "hammer","vanilla-hammers:prismarine_hammer");
            }

            if(FabricLoader.getInstance().isModLoaded("vanillaexcavators")){
                addEquipment("Wood","excavator+early", "vanillaexcavators:wooden_excavator");
                addEquipment("Stone","excavator+early", "vanillaexcavators:stone_excavator");
                addEquipment("Iron_Block","excavator+early", "vanillaexcavators:iron_excavator");
                addEquipment("Iron_Block","excavator", "vanillaexcavators:iron_excavator");
                addEquipment("Gold_Block","excavator", "vanillaexcavators:gold_excavator");
                addEquipment("Diamond_Block","excavator", "vanillaexcavators:diamond_excavator");
                addEquipment("Emerald_Block", "excavator","vanillaexcavators:emerald_excavator");
                addEquipment("Lapis_Block", "excavator","vanillaexcavators:lapis_excavator");
                addEquipment("Quartz_Block", "excavator","vanillaexcavators:quartz_excavator");
                addEquipment("Magma_Block","excavator", "vanillaexcavators:fiery+excavator");
                addEquipment("Slime_Block", "excavator","vanillaexcavators:slime_excavator");
                addEquipment("Dragon_Head", "excavator","vanillaexcavators:ender_excavator");
                addEquipment("Obsidian", "excavator","vanillaexcavators:obsidian_excavator");
                addEquipment("Prismarine", "excavator","vanillaexcavators:prismarine_excavator");
            }
        }
    }

    public static void addMaterial(String name, String upgrade, boolean isItem){
        Identifier temp = Identifier.tryParse(upgrade);
        if (temp != null) {
            MATERIAL_MAP.put(name, new MaterialInfo(temp, isItem));
        }
    }

    private static void addEquipment(String name, String type, String item){
        Identifier temp = Identifier.tryParse(item);
        if (temp != null && MATERIAL_MAP.get(name) != null) {
        MATERIAL_MAP.get(name).addEquipment(type, temp);
        }
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
