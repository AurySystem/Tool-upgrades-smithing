package gay.Aurum.smithingupgrades.recipes;

import com.google.common.collect.Maps;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import static gay.Aurum.smithingupgrades.SmithingUpgrades.MOD_ID;

/**
 * Holds the material Map, materialInfo, and methods for adding and modifying
 */
public class Materials {
    public static final Map<String, MaterialInfo> MATERIAL_MAP = Maps.newHashMap();

    public static class MaterialInfo{
        private String name;
        private Map<String, Identifier> equipment;
        private Map<String, Integer> perEquipmentCount;
        private MaterialsList materialsListOut;
        private MaterialsList materialsListIn;
        private Identifier mainMatItem;
        private int matCount;
        private boolean isItem;
        private boolean noItems;

        public MaterialInfo(String name){
            this.name = name;
            this.equipment = Maps.newHashMap();
            this.perEquipmentCount = Maps.newHashMap();
            this.materialsListOut = new MaterialsList(true);
            this.materialsListIn = new MaterialsList(false);
            this.isItem = false;
            this.noItems = true;
        }

        public void addEquipment(String type, Identifier item){
            this.equipment.put(type, item);
        }

        public void addEquipment(String type, String item){
            Identifier parse = Identifier.tryParse(item);
            if(parse != null) {
                this.equipment.put(type, parse);
            }
        }

        public void removeEquipment(String type){
            this.equipment.remove(type);
        }

        public void addEquipmentCount(String type, int a){
            this.perEquipmentCount.put(type, a);
        }
        public void removeEquipmentCount(String type){
            this.perEquipmentCount.remove(type);
        }

        public Map<String, Integer> getPerEquipmentCount(){
            return this.perEquipmentCount;
        }
        public Map<String, Identifier> getEquipment(){
            return this.equipment;
        }

        public Identifier getMatItem(){
            return this.mainMatItem;
        }

        public void setMatItem(Identifier matItem, boolean isItem) {
            this.mainMatItem = matItem;
            this.isItem = isItem;
            this.noItems = false;
        }

        public int getMatCount(){
            return this.matCount;
        }

        public void setMatCount(int matCount){
            this.matCount = matCount;
        }

        public String getName(){
            return this.name;
        }

        public boolean isItemOrTag(){
            return this.isItem;
        }

        public boolean hasItems(){
            return !this.noItems;
        }

        public void setList(String[] list, boolean isOutList, boolean inclusive){
            if(isOutList){
                this.materialsListOut.setList(list,inclusive);
            }else {
                this.materialsListIn.setList(list,inclusive);
            }
        }

        public void setInList(String[] list, boolean inclusive){
            this.materialsListIn.setList(list,inclusive);
        }
        public void setOutList(String[] list, boolean inclusive){
            this.materialsListOut.setList(list,inclusive);
        }

        public void addToList(String entry, boolean listDirection){
            if(listDirection){
                this.materialsListOut.addToList(entry);
            }else {
                this.materialsListIn.addToList(entry);
            }
        }

        public void removeFromList(String entry, boolean listDirection){
            if(listDirection){
                this.materialsListOut.removeFromList(entry);
            }else {
                this.materialsListIn.removeFromList(entry);
            }
        }

        public MaterialsList getOutList(){
            return this.materialsListOut;
        }

        public MaterialsList getInList(){
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

        protected void removeFromList(String entry){
            this.materialsList.remove(entry);
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
