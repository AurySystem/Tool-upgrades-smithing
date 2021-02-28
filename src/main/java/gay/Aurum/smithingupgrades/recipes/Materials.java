package gay.Aurum.smithingupgrades.recipes;

import com.google.common.collect.Maps;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import static gay.Aurum.smithingupgrades.SmithingUpgrades.MOD_ID;

//todo make this load from json instead
//diamond to netherite already exists and not going to let people skip to it for balance sake
//or skip from wood and stone to diamond without going through iron, might change for modded material entry later
/*added an exclusion inclusion list option to stop this weird tagging system from getting out of hand.
the tagging for material groups is still there partially for special cases where things need to have certain items upgrade with a different item
 */
public class Materials {
    public static final Map<String, MaterialInfo> MATERIAL_MAP = Maps.newHashMap();

    public static void registerMaterials(){
        addMaterial("Wood", MOD_ID+":wooden_cluster");
        setMaterialList("Wood", new String[] {"Stone","Iron"}, true,true);
        addEquipment("Wood","sword", "wooden_sword");
        addEquipment("Wood","sword", "wooden_sword");
        addEquipment("Wood","axe", "wooden_axe");
        addEquipment("Wood","pickaxe", "wooden_pickaxe");
        addEquipment("Wood","shovel", "wooden_shovel");
        addEquipment("Wood","hoe", "wooden_hoe");

        addMaterial("Stone", MOD_ID+":stone_cluster");
        setMaterialList("Stone", new String[] {"Wood","Iron"}, true,true);
        addEquipment("Stone","sword", "stone_sword");
        addEquipment("Stone","axe", "stone_axe");
        addEquipment("Stone","pickaxe", "stone_pickaxe");
        addEquipment("Stone","shovel", "stone_shovel");
        addEquipment("Stone","hoe", "stone_hoe");

        addMaterial("Leather", "leather");
        setMaterialList("Leather", new String[] {"Iron","Iron_Block"}, true, true);
        addEquipment("Leather","helmet", "leather_helmet");
        addEquipment("Leather","chestplate", "leather_chestplate");
        addEquipment("Leather","leggings", "leather_leggings");
        addEquipment("Leather","boots", "leather_boots");
        addEquipment("Leather","horsearmor+via_iron", "leather_horse_armor");

        addMaterial("Iron", MOD_ID+":iron_cluster");
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

        addMaterial("Iron_Block", MOD_ID+":cubic_iron_cluster");
        addEquipment("Iron_Block","horsearmor+via_iron", "iron_horse_armor");

        addMaterial("Logs", MOD_ID+":log_cluster");
        setMaterialList("Logs", new String[] {"Stone_Smooth","Iron_Block"}, true, true);

        addMaterial("Stone_Smooth", MOD_ID+":smooth_stone_cluster");
        setMaterialList("Stone_Smooth", new String[] {"Logs","Iron_Block"}, true, true);

        addMaterial("Gold_Block", MOD_ID+":cubic_gold_cluster");
        addMaterial("Diamond_Block", MOD_ID+":cubic_diamond_cluster");

        addMaterial("Gold", MOD_ID+":golden_cluster");
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

        addMaterial("Diamond", MOD_ID+":diamond_cluster");
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

        addMaterial("Netherite", "netherite_ingot");
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

        if(FabricLoader.getInstance().isModLoaded("indrev")){
            addMaterial("Copper", MOD_ID+":copper_cluster");
            addEquipment("Copper","sword", "indrev:copper_sword");
            addEquipment("Copper","axe", "indrev:copper_axe");
            addEquipment("Copper","pickaxe", "indrev:copper_pickaxe");
            addEquipment("Copper","shovel", "indrev:copper_shovel");
            addEquipment("Copper","hoe", "indrev:copper_hoe");

            addEquipment("Copper","helmet", "indrev:copper_helmet");
            addEquipment("Copper","chestplate", "indrev:copper_chestplate");
            addEquipment("Copper","leggings", "indrev:copper_leggings");
            addEquipment("Copper","boots", "indrev:copper_boots");

            addMaterial("Tin", MOD_ID+":tin_cluster");
            addEquipment("Tin","sword", "indrev:tin_sword");
            addEquipment("Tin","axe", "indrev:tin_axe");
            addEquipment("Tin","pickaxe", "indrev:tin_pickaxe");
            addEquipment("Tin","shovel", "indrev:tin_shovel");
            addEquipment("Tin","hoe", "indrev:tin_hoe");

            addEquipment("Tin","helmet", "indrev:tin_helmet");
            addEquipment("Tin","chestplate", "indrev:tin_chestplate");
            addEquipment("Tin","leggings", "indrev:tin_leggings");
            addEquipment("Tin","boots", "indrev:tin_boots");

            addMaterial("Lead", MOD_ID+":lead_cluster");
            addEquipment("Lead","sword", "indrev:lead_sword");
            addEquipment("Lead","axe", "indrev:lead_axe");
            addEquipment("Lead","pickaxe", "indrev:lead_pickaxe");
            addEquipment("Lead","shovel", "indrev:lead_shovel");
            addEquipment("Lead","hoe", "indrev:lead_hoe");

            addEquipment("Lead","helmet", "indrev:lead_helmet");
            addEquipment("Lead","chestplate", "indrev:lead_chestplate");
            addEquipment("Lead","leggings", "indrev:lead_leggings");
            addEquipment("Lead","boots", "indrev:lead_boots");

            addMaterial("Silver", MOD_ID+":silver_cluster");
            addEquipment("Silver","sword", "indrev:silver_sword");
            addEquipment("Silver","axe", "indrev:silver_axe");
            addEquipment("Silver","pickaxe", "indrev:silver_pickaxe");
            addEquipment("Silver","shovel", "indrev:silver_shovel");
            addEquipment("Silver","hoe", "indrev:silver_hoe");

            addEquipment("Silver","helmet", "indrev:silver_helmet");
            addEquipment("Silver","chestplate", "indrev:silver_chestplate");
            addEquipment("Silver","leggings", "indrev:silver_leggings");
            addEquipment("Silver","boots", "indrev:silver_boots");

            addMaterial("Bronze", MOD_ID+":bronze_cluster");
            addEquipment("Bronze","sword", "indrev:bronze_sword");
            addEquipment("Bronze","axe", "indrev:bronze_axe");
            addEquipment("Bronze","pickaxe", "indrev:bronze_pickaxe");
            addEquipment("Bronze","shovel", "indrev:bronze_shovel");
            addEquipment("Bronze","hoe", "indrev:bronze_hoe");

            addEquipment("Bronze","helmet", "indrev:bronze_helmet");
            addEquipment("Bronze","chestplate", "indrev:bronze_chestplate");
            addEquipment("Bronze","leggings", "indrev:bronze_leggings");
            addEquipment("Bronze","boots", "indrev:bronze_boots");

            addMaterial("Steel", MOD_ID+":steel_cluster");
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
        if(FabricLoader.getInstance().isModLoaded("betternether")){
            addMaterial("Cincinnasite",MOD_ID+":cincinnasite_cluster");
            setMaterialList("Cincinnasite", new String[] {"Diamond"}, false, true);
            addEquipment("Cincinnasite","sword", "betternether:cincinnasite_sword");
            addEquipment("Cincinnasite","axe", "betternether:cincinnasite_axe");
            addEquipment("Cincinnasite","pickaxe", "betternether:cincinnasite_pickaxe");
            addEquipment("Cincinnasite","shovel", "betternether:cincinnasite_shovel");
            addEquipment("Cincinnasite","hoe", "betternether:cincinnasite_hoe");

            addEquipment("Cincinnasite","sword", "betternether:cincinnasite_sword");
            addEquipment("Cincinnasite","axe", "betternether:cincinnasite_axe");
            addEquipment("Cincinnasite","pickaxe", "betternether:cincinnasite_pickaxe");
            addEquipment("Cincinnasite","shovel", "betternether:cincinnasite_shovel");
            addEquipment("Cincinnasite","hoe", "betternether:cincinnasite_hoe");

            addEquipment("Cincinnasite","helmet", "betternether:cincinnasite_helmet");
            addEquipment("Cincinnasite","chestplate", "betternether:cincinnasite_chestplate");
            addEquipment("Cincinnasite","leggings", "betternether:cincinnasite_leggings");
            addEquipment("Cincinnasite","boots", "betternether:cincinnasite_boots");

            addEquipment("Iron","shears", "shears");
            addEquipment("Cincinnasite","shears", "betternether:cincinnasite_shears");

            addMaterial("Cincinnasite_Diamond",MOD_ID+":diamond_cluster");
            setMaterialList("Cincinnasite_Diamond", new String[] {"Cincinnasite"}, true, false);
            addEquipment("Cincinnasite_Diamond","sword", "betternether:cincinnasite_sword_diamond");
            addEquipment("Cincinnasite_Diamond","axe", "betternether:cincinnasite_axe_diamond");
            addEquipment("Cincinnasite_Diamond","pickaxe", "betternether:cincinnasite_pickaxe_diamond");
            addEquipment("Cincinnasite_Diamond","shovel", "betternether:cincinnasite_shovel_diamond");
            addEquipment("Cincinnasite_Diamond","hoe", "betternether:cincinnasite_hoe_diamond");

            addMaterial("Nether_Ruby",MOD_ID+":nether_ruby_cluster");
            addEquipment("Nether_Ruby","sword", "betternether:nether_ruby_sword");
            addEquipment("Nether_Ruby","axe", "betternether:nether_ruby_axe");
            addEquipment("Nether_Ruby","pickaxe", "betternether:nether_ruby_pickaxe");
            addEquipment("Nether_Ruby","shovel", "betternether:nether_ruby_shovel");
            addEquipment("Nether_Ruby","hoe", "betternether:nether_ruby_hoe");

            addEquipment("Nether_Ruby","helmet", "betternether:nether_ruby_helmet");
            addEquipment("Nether_Ruby","chestplate", "betternether:nether_ruby_chestplate");
            addEquipment("Nether_Ruby","leggings", "betternether:nether_ruby_leggings");
            addEquipment("Nether_Ruby","boots", "betternether:nether_ruby_boots");

            addMaterial("Nether_Ruby_Block",MOD_ID+":cubic_nether_ruby_cluster");
            addMaterial("Cincinnasite_Block",MOD_ID+":cubic_cincinnasite_cluster");
            setMaterialList("Cincinnasite_Block", new String[] {"Diamond"}, false, true);
        }
        if(FabricLoader.getInstance().isModLoaded("vanilla-hammers") || FabricLoader.getInstance().isModLoaded("vanillaexcavators")){

            addMaterial("Emerald_Block", MOD_ID+":cubic_emerald_cluster");
            addMaterial("Lapis_Block", MOD_ID+":cubic_lapis_cluster");
            addMaterial("Quartz_Block", MOD_ID+":cubic_quartz_cluster");
            addMaterial("Magma_Block", MOD_ID+":cubic_magma_cluster");
            addMaterial("Slime_Block", MOD_ID+":cubic_slime_cluster");
            addMaterial("Dragon_Head", MOD_ID+":dragon_Head_cluster");
            addMaterial("Obsidian", MOD_ID+":obsidian_cluster");
            addMaterial("Prismarine", MOD_ID+":prismarine_cluster");

            if(FabricLoader.getInstance().isModLoaded("vanilla-hammers")){
                addEquipment("Logs","hammer", "vanilla-hammers:wooden_hammer");
                addEquipment("Stone_Smooth","hammer", "vanilla-hammers:stone_hammer");
                addEquipment("Iron_Block","hammer", "vanilla-hammers:iron_hammer");
                addEquipment("Gold_Block","hammer", "vanilla-hammers:golden_hammer");
                addEquipment("Diamond_Block","hammer", "vanilla-hammers:diamond_hammer");
                addEquipment("Emerald_Block", "hammer","vanilla-hammers:emerald_hammer");
                addEquipment("Lapis_Block", "hammer","vanilla-hammers:lapis_hammer");
                addEquipment("Quartz_Block", "hammer","vanilla-hammers:quartz_hammer");
                addEquipment("Magma_Block","hammer", "vanilla-hammers:fiery_hammer");
                addEquipment("Slime_Block", "hammer","vanilla-hammers:slime_hammer");
                addEquipment("Dragon_Head", "hammer","vanilla-hammers:ender_hammer");
                addEquipment("Obsidian", "hammer","vanilla-hammers:obsidian_hammer");
                addEquipment("Prismarine", "hammer","vanilla-hammers:prismarine_hammer");

                if(FabricLoader.getInstance().isModLoaded("betternether")){

                    addEquipment("Nether_Ruby_Block","hammer", "betternether:nether_ruby_hammer");
                    addEquipment("Cincinnasite_Block","hammer", "betternether:cincinnasite_hammer");
                    addEquipment("Cincinnasite_Diamond","hammer", "betternether:cincinnasite_hammer_diamond");
                }
            }

            if(FabricLoader.getInstance().isModLoaded("vanillaexcavators")){
                addEquipment("logs","excavator", "vanillaexcavators:wooden_excavator");
                addEquipment("Stone_Smooth","excavator", "vanillaexcavators:stone_excavator");
                addEquipment("Iron_Block","excavator", "vanillaexcavators:iron_excavator");
                addEquipment("Gold_Block","excavator", "vanillaexcavators:golden_excavator");
                addEquipment("Diamond_Block","excavator", "vanillaexcavators:diamond_excavator");
                addEquipment("Emerald_Block", "excavator","vanillaexcavators:emerald_excavator");
                addEquipment("Lapis_Block", "excavator","vanillaexcavators:lapis_excavator");
                addEquipment("Quartz_Block", "excavator","vanillaexcavators:quartz_excavator");
                addEquipment("Magma_Block","excavator", "vanillaexcavators:fiery+excavator");
                addEquipment("Slime_Block", "excavator","vanillaexcavators:slime_excavator");
                addEquipment("Dragon_Head", "excavator","vanillaexcavators:ender_excavator");
                addEquipment("Obsidian", "excavator","vanillaexcavators:obsidian_excavator");
                addEquipment("Prismarine", "excavator","vanillaexcavators:prismarine_excavator");

                if(FabricLoader.getInstance().isModLoaded("betternether")){
                    addEquipment("Nether_Ruby_Block","excavator", "betternether:nether_ruby_excavator");
                    addEquipment("Cincinnasite_Block","excavator", "betternether:cincinnasite_excavator");
                    addEquipment("Cincinnasite_Diamond","excavator", "betternether:cincinnasite_excavator_diamond");
                }
            }
        }

        if(FabricLoader.getInstance().isModLoaded("battletowers")){
            addMaterial("Key_Guard", MOD_ID+":guardian_key_core");
            setMaterialList("Key_Guard", new String[] {"Diamond","Netherite"}, true, false);
            addEquipment("Key_Guard","sword", "battletowers:key_sword");
            addEquipment("Key_Guard","axe", "battletowers:key_axe");
            addEquipment("Key_Guard","pickaxe", "battletowers:key_pickaxe");
            addEquipment("Key_Guard","shovel", "battletowers:key_shovel");
            addEquipment("Key_Guard","hoe", "battletowers:key_hoe");

            addEquipment("Key_Guard","helmet", "battletowers:key_helmet");
            addEquipment("Key_Guard","chestplate", "battletowers:key_chestplate");
            addEquipment("Key_Guard","leggings", "battletowers:key_leggings");
            addEquipment("Key_Guard","boots", "battletowers:key_boots");
        }

    }

    public static void addMaterial(String name, String upgrade, boolean isItem){
        Identifier temp = Identifier.tryParse(upgrade);
        if (temp != null){
            if (MATERIAL_MAP.get(name) == null) {
                MATERIAL_MAP.put(name, new MaterialInfo(temp, isItem));
            }else {
                MATERIAL_MAP.replace(name, new MaterialInfo(temp, isItem));
            }
        }
    }

    public static void addMaterial(String name, String upgrade){
        addMaterial(name, upgrade, true);
    }

    public static void addMaterial(String name){
        if (MATERIAL_MAP.get(name) == null) {
            MATERIAL_MAP.put(name, new MaterialInfo());
        }else {
            MATERIAL_MAP.replace(name, new MaterialInfo());
        }
    }

    private static void addEquipment(String name, String type, String item){
        Identifier temp = Identifier.tryParse(item);
        if (temp != null && MATERIAL_MAP.get(name) != null) {
        MATERIAL_MAP.get(name).addEquipment(type, temp);
        }
    }

    private static void setMaterialList(String name, String[] materialsList, boolean isListInclusive, boolean isOutList){
        if (MATERIAL_MAP.get(name) != null) {
            MATERIAL_MAP.get(name).setList(materialsList, isOutList, isListInclusive);

        }
    }

    private static void addMaterialToList(String name, String materialName, boolean isListInclusive, boolean isOutList){
        if (MATERIAL_MAP.get(name) != null) {
            MATERIAL_MAP.get(name).addToList(name, isOutList);
        }
    }

    public static class MaterialInfo{
        private Map<String, Identifier> equipment;
        private MaterialsList materialsListOut;
        private MaterialsList materialsListIn;
        private Identifier mainMatItem;
        private boolean isItem;
        private boolean noItems;

        public MaterialInfo( Identifier mainMatItem, boolean isItem){
            this.mainMatItem = mainMatItem;
            this.equipment = Maps.newHashMap();
            this.materialsListOut = new MaterialsList(true);
            this.materialsListIn = new MaterialsList(false);
            this.isItem = isItem;
        }

        public MaterialInfo(){
            this.equipment = Maps.newHashMap();
            this.materialsListOut = new MaterialsList(true);
            this.materialsListIn = new MaterialsList(false);
            this.isItem = false;
            this.noItems = true;
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

        protected boolean hasItems(){
            return !this.noItems;
        }

        protected void setList(String[] list, boolean listDirection, boolean inclusive){
            if(listDirection){
                this.materialsListOut.setList(list,inclusive);
            }else {
                this.materialsListIn.setList(list,inclusive);
            }
        }

        protected void addToList(String entry, boolean listDirection){
            if(listDirection){
                this.materialsListOut.addToList(entry);
            }else {
                this.materialsListIn.addToList(entry);
            }
        }
        protected MaterialsList getOutList(){
            return this.materialsListOut;
        }

        protected MaterialsList getInList(){
            return this.materialsListIn;
        }

    }

    public static class MaterialsList{
        private ArrayList<String> materialsList;
        private boolean inclusiveList;
        private boolean listDirection;


        public MaterialsList(boolean listDirection){
            this.materialsList = new ArrayList<String>();
            this.listDirection = listDirection;
        }

        protected void setList(String[] materialsList, boolean inclusiveList){
            Collections.addAll(this.materialsList, materialsList);
            this.inclusiveList = inclusiveList;
        }
        protected void addToList(String entry){
            this.materialsList.add(entry);
        }

        protected boolean isListOut(){
            return this.listDirection;
        }

        protected boolean contains(String o){
            return this.materialsList.contains(o);
        }

        protected boolean isEmpty(){
            return this.materialsList.isEmpty();
        }
        protected ArrayList<String> getList(){
            return new ArrayList<String>(materialsList);
        }
        protected boolean isInclusiveList(){
            return this.inclusiveList;
        }
    }
}
