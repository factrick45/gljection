package ihm.gljection;

import ihm.gljection.ui.screens.ShiftScreen;

import net.minecraft.client.MinecraftClient;

import net.fabricmc.api.ModInitializer;
import org.lwjgl.glfw.GLFW;

public class Mod implements ModInitializer {
	public static final Mod INSTANCE = new Mod();

	private MinecraftClient mc = MinecraftClient.getInstance();

	@Override
	public void onInitialize() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}

	public void onKey(int key, int action) {
		if (action != GLFW.GLFW_PRESS)
			return;
		if (key == GLFW.GLFW_KEY_RIGHT_SHIFT)
			mc.setScreen(ShiftScreen.INSTANCE);
	}
}
