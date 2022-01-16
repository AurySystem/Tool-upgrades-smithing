package gay.Aurum.smithingupgrades.mixin;

import com.google.gson.JsonObject;
import gay.Aurum.smithingupgrades.duckinterfaces.SmithingCountInterface;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(SmithingRecipe.class)
public class SmithingRecipeMixin implements SmithingCountInterface {
    @Unique
    int additionCount;

    @Shadow
    Ingredient addition;
    @Shadow
    Ingredient base;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void interceptConstructor(Identifier id, Ingredient base, Ingredient addition, ItemStack result, CallbackInfo ci) {
        ((SmithingCountInterface)(Object)this).setAdditionCount(1);
    }

    @Inject(method = "testAddition", at = @At("RETURN"), cancellable = true)
    public void extendTestAddition(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(this.addition.test(stack) && stack.getCount() >= this.additionCount);
    }

    @Inject(method = "matches", at = @At("RETURN"), cancellable = true)
    public void extendMatches(Inventory inventory, World world, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(this.base.test(inventory.getStack(0)) && this.addition.test(inventory.getStack(1)) && (inventory.getStack(1).getCount() >= this.additionCount ));
    }

    @Override @Unique
    public int getAdditionCount() {
        return this.additionCount;
    }

    @Override @Unique
    public void setAdditionCount(int count) {
        this.additionCount = count;
    }

}

