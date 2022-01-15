package gay.Aurum.smithingupgrades.mixin;

import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SmithingRecipe.class)
public interface AdditionAccessor {
    @Accessor("addition")
    public Ingredient getAddition();
    @Accessor("addition")
    public void setAddition(Ingredient addition); //?
}
