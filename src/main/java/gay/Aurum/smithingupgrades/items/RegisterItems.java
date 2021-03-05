package gay.Aurum.smithingupgrades.items;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

import static gay.Aurum.smithingupgrades.SmithingUpgrades.MOD_ID;

public class RegisterItems {
    public static final Map<String, ItemMat> ITEM_MAP = Maps.newHashMap();
    private static int defaultCount = 3;

    private static FabricItemSettings settings = new FabricItemSettings().group(ItemGroup.MATERIALS);
    public static Item WOODEN_CLUSTER = registerCluster("wooden_cluster", new Item(settings), "minecraft:planks", false);
    public static Item STONE_CLUSTER = registerCluster("stone_cluster", new Item(settings), "minecraft:stone_tool_materials", false);
    public static Item IRON_CLUSTER = registerCluster("iron_cluster", new Item(settings), "iron_ingot");
    public static Item GOLDEN_CLUSTER = registerCluster("golden_cluster", new Item(settings), "gold_ingot");
    public static Item DIAMOND_CLUSTER = registerCluster("diamond_cluster", new Item(settings), "diamond");

    public static Item COPPER_CLUSTER;
    public static Item TIN_CLUSTER;
    public static Item BRONZE_CLUSTER;
    public static Item LEAD_CLUSTER;
    public static Item SILVER_CLUSTER;
    public static Item STEEL_CLUSTER;

    public static Item NETHER_RUBY_CLUSTER;
    public static Item CINCINNASITE_CLUSTER;

    public static Item LOG_CLUSTER;
    public static Item SMOOTH_STONE_CLUSTER;
    public static Item CUBIC_IRON_CLUSTER;
    public static Item CUBIC_GOLD_CLUSTER;
    public static Item CUBIC_DIAMOND_CLUSTER;
    public static Item CUBIC_EMERALD_CLUSTER;
    public static Item CUBIC_LAPIS_CLUSTER;
    public static Item CUBIC_QUARTZ_CLUSTER;
    public static Item CUBIC_MAGMA_CLUSTER;
    public static Item CUBIC_SLIME_CLUSTER;
    public static Item OBSIDIAN_CLUSTER;
    public static Item PRISMARINE_CLUSTER;
    public static Item DRAGONHEAD_CLUSTER;

    public static Item CUBIC_NETHER_RUBY_CLUSTER;
    public static Item CUBIC_CINCINNASITE_CLUSTER;


    public static final Tag<Item> GUATDIAN_KEY_ITEMS = TagRegistry.item(new Identifier("battletowers:guardian_key_items"));;
    public static Item GUARDIAN_KEY_CORE;


    public static void RegisterItems(){
        if(FabricLoader.getInstance().isModLoaded("indrev")){
            COPPER_CLUSTER = registerCluster("copper_cluster", new Item(settings), "c:copper_ingots",false);
            TIN_CLUSTER = registerCluster("tin_cluster", new Item(settings), "c:tin_ingots",false);
            BRONZE_CLUSTER = registerCluster("bronze_cluster", new Item(settings), "c:bronze_ingots",false);
            LEAD_CLUSTER = registerCluster("lead_cluster", new Item(settings), "c:lead_ingots",false);
            SILVER_CLUSTER = registerCluster("silver_cluster", new Item(settings), "c:silver_ingots",false);
            STEEL_CLUSTER = registerCluster("steel_cluster", new Item(settings), "c:steel_ingots",false);
        }
        if(FabricLoader.getInstance().isModLoaded("betternether")){
            NETHER_RUBY_CLUSTER = registerCluster("nether_ruby_cluster", new Item(settings), "betternether:nether_ruby");
            CINCINNASITE_CLUSTER = registerCluster("cincinnasite_cluster", new Item(settings), "betternether:cincinnasite_ingot");
        }
        if(FabricLoader.getInstance().isModLoaded("battletowers")){
            GUARDIAN_KEY_CORE = registerCluster("guardian_key_core", new Item(settings), "battletowers:guardian_key_items", 4, false);
        }
        if(FabricLoader.getInstance().isModLoaded("vanilla-hammers") || FabricLoader.getInstance().isModLoaded("vanillaexcavators")){

            LOG_CLUSTER = registerCluster("log_cluster", new Item(settings), "minecraft:logs", false);
            SMOOTH_STONE_CLUSTER = registerCluster("smooth_stone_cluster", new Item(settings), "stone");
            CUBIC_IRON_CLUSTER = registerCluster("cubic_iron_cluster", new Item(settings), "iron_block");
            CUBIC_GOLD_CLUSTER = registerCluster("cubic_gold_cluster", new Item(settings), "gold_block");
            CUBIC_DIAMOND_CLUSTER = registerCluster("cubic_diamond_cluster", new Item(settings), "diamond_block");
            CUBIC_EMERALD_CLUSTER = registerCluster("cubic_emerald_cluster", new Item(settings), "emerald_block");
            CUBIC_LAPIS_CLUSTER = registerCluster("cubic_lapis_cluster", new Item(settings), "lapis_block");
            CUBIC_QUARTZ_CLUSTER = registerCluster("cubic_quartz_cluster", new Item(settings), "quartz_block");
            CUBIC_MAGMA_CLUSTER = registerCluster("cubic_magma_cluster", new Item(settings), "magma_block");
            CUBIC_SLIME_CLUSTER = registerCluster("cubic_slime_cluster", new Item(settings), "slime_block");
            OBSIDIAN_CLUSTER = registerCluster("obsidian_cluster", new Item(settings), "obsidian");
            PRISMARINE_CLUSTER = registerCluster("prismarine_cluster", new Item(settings), "prismarine");
            DRAGONHEAD_CLUSTER = registerCluster("dragon_head_cluster", new Item(settings), "dragon_head");
            if(FabricLoader.getInstance().isModLoaded("betternether")){
                CUBIC_NETHER_RUBY_CLUSTER = registerCluster("cubic_nether_ruby_cluster", new Item(settings), "betternether:nether_ruby_block");
                CUBIC_CINCINNASITE_CLUSTER = registerCluster("cubic_cincinnasite_cluster", new Item(settings), "betternether:cincinnasite_forged");
            }
        }
    }

    protected static Item registerCluster(String name, Item item, String matItem, int count, boolean isItem){
        Identifier temp = Identifier.tryParse(matItem);
        if (temp != null){
            ITEM_MAP.put(name, new ItemMat(temp, count, isItem, new Identifier(MOD_ID, name)));
        }
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
        return item;
    }

    protected static Item registerCluster(String name, Item item, String matItem, boolean isItem){
        return registerCluster(name, item, matItem, defaultCount, isItem);
    }

    protected static Item registerCluster(String name, Item item, String matItem){
        return registerCluster(name, item, matItem, defaultCount, true);
    }

    public static class ItemMat{
        private Identifier matItem;
        private Identifier outItem;
        private int count;
        private boolean isItem;

        public ItemMat( Identifier matItem, int count, boolean isItem, Identifier outItem){
            this.matItem = matItem;
            this.outItem = outItem;
            this.count = count;
            this.isItem = isItem;
        }

        public Identifier getMatItem(){
            return this.matItem;
        }

        public Identifier getOutItem(){
            return this.outItem;
        }

        public int getCount(){
            return this.count;
        }

        public boolean isItemOrTag(){
            return this.isItem;
        }
    }
}
