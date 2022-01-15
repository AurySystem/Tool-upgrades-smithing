package gay.Aurum.smithingupgrades.duckinterfaces;

import net.minecraft.recipe.Ingredient;

public interface SmithingCountInterface {
    Ingredient getAddition();
    int getAdditionCount();
    void setAdditionCount(int count);
}
