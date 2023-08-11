package ihm.gljection.mixin;

import ihm.gljection.Mod;

import net.minecraft.client.Keyboard;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
	@Inject(method = "onKey", at = @At("HEAD"))
	public void onKey(
		long window, int key, int scancode, int action, int modifers,
		CallbackInfo ci
	) {
		Mod.INSTANCE.onKey(key, action);
	}
}
