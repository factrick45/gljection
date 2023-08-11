package ihm.gljection.ui.screens;

import ihm.gljection.ui.imgui.ImGuiScreen;

import imgui.ImGui;

public class ShiftScreen extends ImGuiScreen {
	public static final ShiftScreen INSTANCE = new ShiftScreen();

	private ShiftScreen() {
		super("Shift menu");
	}

	@Override
	public void renderGui() {
		ImGui.showDemoWindow();
	}

	@Override
	public boolean shouldPause() {
		return false;
	}
}
