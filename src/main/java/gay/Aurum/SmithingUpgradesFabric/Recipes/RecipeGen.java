package gay.Aurum.SmithingUpgradesFabric.Recipes;

import net.minecraft.util.Identifier;
import static gay.Aurum.SmithingUpgradesFabric.Recipes.Materials.MATERIAL_MAP;
import static gay.Aurum.SmithingUpgradesFabric.Recipes.RecipeHelper.addSmithingRecipe;

public class RecipeGen {

    public static void RecipeGen(){

        for (String matId : MATERIAL_MAP.keySet()) {
            Materials.MaterialInfo mat = MATERIAL_MAP.get(matId);

            for(String type : mat.getEquipment().keySet()){
                for (String matId2: MATERIAL_MAP.keySet()){
                    if (matId2 != matId) {
                        Materials.MaterialInfo mat2 = MATERIAL_MAP.get(matId2);

                        if (mat2.getEquipment().get(type) != null) {
                            addSmithingRecipe(mat.getEquipment().get(type), mat2.getMatItem(), mat2.getEquipment().get(type));
                        }
                    }
                }

            }
        }
    }
}
