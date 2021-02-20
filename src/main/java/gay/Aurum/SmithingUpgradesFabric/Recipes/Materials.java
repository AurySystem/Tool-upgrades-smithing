package gay.Aurum.SmithingUpgradesFabric.Recipes;

import com.google.common.collect.Maps;
import net.minecraft.util.Identifier;

import java.util.Map;

//todo make this load from json instead
public class Materials {
    public static final Map<String, MaterialInfo> MATERIAL_MAP = Maps.newHashMap();

    public static void registerMaterials(){
        addMaterial("Iron", new Identifier("iron_ingot"));
        MATERIAL_MAP.get("Iron").addEquipment("sword", new Identifier("iron_sword"));
        MATERIAL_MAP.get("Iron").addEquipment("hoe", new Identifier("iron_hoe"));
        MATERIAL_MAP.get("Iron").addEquipment("axe", new Identifier("iron_axe"));

        addMaterial("Gold", new Identifier("gold_ingot"));
        MATERIAL_MAP.get("Gold").addEquipment("sword", new Identifier("golden_sword"));
        MATERIAL_MAP.get("Gold").addEquipment("hoe", new Identifier("golden_hoe"));
        MATERIAL_MAP.get("Gold").addEquipment("axe", new Identifier("golden_axe"));

        addMaterial("Diamond", new Identifier("diamond"));
        MATERIAL_MAP.get("Diamond").addEquipment("sword", new Identifier("diamond_sword"));
        MATERIAL_MAP.get("Diamond").addEquipment("hoe", new Identifier("diamond_hoe"));
    }

    public static void addMaterial(String name, Identifier base){
        MATERIAL_MAP.put(name, new MaterialInfo(base));
    }

    public static class MaterialInfo{
        private Map<String, Identifier> equipment;
        private Identifier mainMatItem;

        public MaterialInfo( Identifier mainMatItem){
            this.mainMatItem = mainMatItem;
            this.equipment = Maps.newHashMap();
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
    }
}
