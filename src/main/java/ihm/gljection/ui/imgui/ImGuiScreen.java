package ihm.gljection.ui.imgui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import imgui.ImGui;

public class ImGuiScreen extends Screen implements ImGuiClient {
	protected ImGuiScreen(String name) {
		super(Text.literal(name));
		ImGuiLoader.register(this);
	}

	@Override
	public void render(
		DrawContext context, int mouseX, int mouseY, float delta
	) {
		if (MinecraftClient.getInstance().world == null)
			super.renderBackground(context);
	}

	@Override
	public void renderGui() {
	}

	@Override
	public boolean guiEnabled() {
		return MinecraftClient.getInstance().currentScreen == this;
	}
}
