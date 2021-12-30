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
        MaterialConfig.load();
    }

    public static MaterialInfo addMaterial(String name, String upgrade, boolean isItem){
        MaterialInfo info = new MaterialInfo(upgrade, isItem, name);
        if (MATERIAL_MAP.get(name) == null) {
            MATERIAL_MAP.put(name, info);
        }else {
            MATERIAL_MAP.replace(name, info);
        }
        return info;
    }

    public static MaterialInfo addMaterial(String name, String upgrade){
        return addMaterial(name, upgrade, true);
    }

    public static MaterialInfo addMaterial(String name){
        MaterialInfo info = new MaterialInfo(name);
        if (MATERIAL_MAP.get(name) == null) {
            MATERIAL_MAP.put(name, info);
        }else {
            MATERIAL_MAP.replace(name, info);
        }
        return info;
    }

    static void addEquipment(String name, String type, String item){
        Identifier temp = Identifier.tryParse(item);
        if (temp != null && MATERIAL_MAP.get(name) != null) {
        MATERIAL_MAP.get(name).addEquipment(type, temp);
        }
    }

    static void setMaterialList(String name, String[] materialsList, boolean isListInclusive, boolean isOutList){
        if (MATERIAL_MAP.get(name) != null) {
            MATERIAL_MAP.get(name).setList(materialsList, isOutList, isListInclusive);

        }
    }

    static void addMaterialToList(String name, String materialName, boolean isListInclusive, boolean isOutList){
        if (MATERIAL_MAP.get(name) != null) {
            MATERIAL_MAP.get(name).addToList(materialName, isOutList);
        }
    }

    public static class MaterialInfo{
        private String name;
        private Map<String, Identifier> equipment;
        private MaterialsList materialsListOut;
        private MaterialsList materialsListIn;
        private Identifier mainMatItem;
        private boolean isItem;
        private boolean noItems;

        public MaterialInfo( Identifier mainMatItem, boolean isItem, String name){
            this.name = name;
            this.mainMatItem = mainMatItem;
            this.equipment = Maps.newHashMap();
            this.materialsListOut = new MaterialsList(true);
            this.materialsListIn = new MaterialsList(false);
            this.isItem = isItem;
        }

        public MaterialInfo( String mainMatItem, boolean isItem, String name){
            this.name = name;
            this.mainMatItem = Identifier.tryParse(mainMatItem);
            this.isItem = isItem;
            if(this.mainMatItem == null){
                this.isItem = false;
                this.noItems = true;
            }
            this.equipment = Maps.newHashMap();
            this.materialsListOut = new MaterialsList(true);
            this.materialsListIn = new MaterialsList(false);
        }
        public MaterialInfo(String name){
            this.name = name;
            this.equipment = Maps.newHashMap();
            this.materialsListOut = new MaterialsList(true);
            this.materialsListIn = new MaterialsList(false);
            this.isItem = false;
            this.noItems = true;
        }

        protected void addEquipment(String type, Identifier item){
            this.equipment.put(type, item);
        }

        protected void addEquipment(String type, String item){
            Identifier parse = Identifier.tryParse(item);
            if(parse != null) {
                this.equipment.put(type, parse);
            }else{

            }
        }

        protected Map<String, Identifier> getEquipment(){
            return this.equipment;
        }

        protected Identifier getMatItem(){
            return this.mainMatItem;
        }

        protected String getName(){
            return this.name;
        }

        protected boolean isItemOrTag(){
            return this.isItem;
        }

        protected boolean hasItems(){
            return !this.noItems;
        }

        protected void setList(String[] list, boolean isOutList, boolean inclusive){
            if(isOutList){
                this.materialsListOut.setList(list,inclusive);
            }else {
                this.materialsListIn.setList(list,inclusive);
            }
        }

        protected void setInList(String[] list, boolean inclusive){
            this.materialsListIn.setList(list,inclusive);
        }
        protected void setOutList(String[] list, boolean inclusive){
            this.materialsListOut.setList(list,inclusive);
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
