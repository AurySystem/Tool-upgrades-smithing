package gay.Aurum.smithingupgrades.recipes;

import gay.Aurum.smithingupgrades.items.RegisterItems;

import static gay.Aurum.smithingupgrades.items.RegisterItems.ITEM_MAP;
import static gay.Aurum.smithingupgrades.recipes.Materials.MATERIAL_MAP;
import static gay.Aurum.smithingupgrades.recipes.RecipeHelper.addSmithingRecipe;
import static gay.Aurum.smithingupgrades.recipes.RecipeHelper.addShapelessRecipe;

public class RecipeGen {

    public static void RecipeGen() {

        for (RegisterItems.ItemMat itemMat : ITEM_MAP.values()) {
            addShapelessRecipe(itemMat.getMatItem(), itemMat.getCount(), itemMat.getOutItem(), itemMat.isItemOrTag());
        }

        for (String matId : MATERIAL_MAP.keySet()) {
            Materials.MaterialInfo mat = MATERIAL_MAP.get(matId);

            for (String type : mat.getEquipment().keySet()) {
                for (String matId2 : MATERIAL_MAP.keySet()) {
                    if (!matId2.equals(matId)) {
                        Materials.MaterialInfo mat2 = MATERIAL_MAP.get(matId2);
                        if (mat2.getInList().isEmpty() || (mat2.getInList().isInclusiveList() == mat2.getInList().contains(matId))) {
                            if (mat.getOutList().isEmpty() || (mat.getOutList().isInclusiveList() == mat.getOutList().contains(matId2))) {

                                if (mat2.hasItems() && mat2.getEquipment().get(type) != null) {
                                    addSmithingRecipe(mat.getEquipment().get(type), mat2.getMatItem(), mat2.getEquipment().get(type), mat2.isItemOrTag());

                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
