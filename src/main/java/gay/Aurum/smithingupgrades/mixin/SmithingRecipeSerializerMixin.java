package gay.Aurum.smithingupgrades.mixin;

import com.google.gson.JsonObject;
import gay.Aurum.smithingupgrades.SmithingUpgrades;
import gay.Aurum.smithingupgrades.duckinterfaces.SmithingCountInterface;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(SmithingRecipe.Serializer.class)
public abstract class SmithingRecipeSerializerMixin {

    @Inject(method = "read(Lnet/minecraft/util/Identifier;Lcom/google/gson/JsonObject;)Lnet/minecraft/recipe/SmithingRecipe;", at = @At("RETURN"), cancellable = true)
    public void read(Identifier identifier, JsonObject jsonObject, CallbackInfoReturnable<SmithingRecipe> cir) {
        ((SmithingCountInterface) cir.getReturnValue()).setAdditionCount(JsonHelper.getInt(jsonObject, "additioncount", 1));
        cir.setReturnValue(cir.getReturnValue());
    }

    @Inject(method = "read(Lnet/minecraft/util/Identifier;Lnet/minecraft/network/PacketByteBuf;)Lnet/minecraft/recipe/SmithingRecipe;", at = @At("RETURN"), cancellable = true)
    public void read(Identifier identifier, PacketByteBuf packetByteBuf, CallbackInfoReturnable<SmithingRecipe> cir) {
        Optional<Integer> aaa = packetByteBuf.readOptional(PacketByteBuf::readInt);
        if(aaa.isPresent()){
            ((SmithingCountInterface) cir.getReturnValue()).setAdditionCount(aaa.get());
        } else{
            ((SmithingCountInterface) cir.getReturnValue()).setAdditionCount(1);
        }
        cir.setReturnValue(cir.getReturnValue());
    }

    @Inject(method = "write(Lnet/minecraft/network/PacketByteBuf;Lnet/minecraft/recipe/SmithingRecipe;)V", at = @At("TAIL"))
    public void write(PacketByteBuf packetByteBuf, SmithingRecipe smithingRecipe, CallbackInfo cir) {
        if(SmithingUpgrades.CONFIG.getRequiresCustomClient()){
            Optional<Integer> writeTemp = Optional.of(((SmithingCountInterface) smithingRecipe).getAdditionCount());
            packetByteBuf.writeOptional(writeTemp, PacketByteBuf::writeInt);
        }
    }
}
