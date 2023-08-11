package ihm.gljection.mixin;

import ihm.gljection.ui.imgui.ImGuiLoader;

import net.minecraft.client.util.Window;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public class WindowMixin {
	@Shadow
	public long getHandle() { return 0; }

	@Inject(method = "<init>", at = @At("TAIL"))
	public void onWindowInit(CallbackInfo ci) {
		ImGuiLoader.init(this.getHandle());
	}
}
