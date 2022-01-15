package gay.Aurum.smithingupgrades.mixin;

import com.google.gson.JsonObject;
import gay.Aurum.smithingupgrades.duckinterfaces.SmithingCountInterface;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(SmithingRecipe.Serializer.class)
public abstract class SmithingRecipeSerializerMixin {

    @Inject(method = "read(Lnet/minecraft/util/Identifier;Lcom/google/gson/JsonObject;)Lnet/minecraft/recipe/SmithingRecipe;", at = @At("RETURN"), cancellable = true)
    public void read(Identifier identifier, JsonObject jsonObject, CallbackInfoReturnable<SmithingRecipe> cir) {
        ((SmithingCountInterface) cir.getReturnValue()).setAdditionCount(JsonHelper.getInt(jsonObject, "additioncount", 1));
        for (ItemStack stack:
             ((AdditionAccessor)cir.getReturnValue()).getAddition().getMatchingStacks()) {
            stack.setCount(((SmithingCountInterface) cir.getReturnValue()).getAdditionCount());
        }
        cir.setReturnValue(cir.getReturnValue());
    }

    @Inject(method = "write(Lnet/minecraft/network/PacketByteBuf;Lnet/minecraft/recipe/SmithingRecipe;)V", at = @At("HEAD"))
    public void write(PacketByteBuf packetByteBuf, SmithingRecipe smithingRecipe, CallbackInfo cir) {
        for (ItemStack stack:
                ((AdditionAccessor)smithingRecipe).getAddition().getMatchingStacks()) {
            stack.setCount(((SmithingCountInterface) smithingRecipe).getAdditionCount());
        }
    }
}
