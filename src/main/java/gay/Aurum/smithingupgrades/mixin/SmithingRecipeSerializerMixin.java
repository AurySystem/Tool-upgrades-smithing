package gay.Aurum.smithingupgrades.mixin;

import com.google.gson.JsonObject;
import gay.Aurum.smithingupgrades.duckinterfaces.SmithingCountInterface;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SmithingRecipe.Serializer.class)
public class SmithingRecipeSerializerMixin {

    @Inject(method = "read", at = @At("RETURN"), cancellable = true)
    public void read(Identifier identifier, JsonObject jsonObject, CallbackInfoReturnable<SmithingRecipe> cir) {
        ((SmithingCountInterface) cir.getReturnValue()).setAdditionCount(JsonHelper.getInt(jsonObject, "additioncount", 1));
        cir.setReturnValue(cir.getReturnValue());
    }
}
