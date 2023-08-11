package ihm.gljection.mixin;

import ihm.gljection.ui.imgui.ImGuiLoader;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
	@Inject(method = "render", at = @At("TAIL"))
	public void onRender(CallbackInfo ci) {
		// this recreates the behavior of vanilla draw calls
		if (MinecraftClient.getInstance().skipGameRender)
			return;
		ImGuiLoader.render();
	}
}
