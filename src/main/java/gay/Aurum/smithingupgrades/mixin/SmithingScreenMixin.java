package gay.Aurum.smithingupgrades.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SmithingScreenHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SmithingScreenHandler.class)
public abstract class SmithingScreenMixin extends ForgingScreenHandler{
    @Shadow
    private SmithingRecipe currentRecipe;

    public SmithingScreenMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    @ModifyArg(method = "onTakeOutput", at = @At(value = "INVOKE",target = "Lnet/minecraft/screen/SmithingScreenHandler;decrementStack(I)V",ordinal = 1))
    private int hackTheStack(int slot) {
        ItemStack itemStack = this.input.getStack(slot);
        itemStack.increment(1);
        itemStack.decrement( ((AdditionAccessor) currentRecipe).getAddition().getMatchingStacks()[0].getCount() );
        this.input.setStack(slot, itemStack);
        return slot;
    }
}
