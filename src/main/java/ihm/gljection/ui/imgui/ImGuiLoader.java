package ihm.gljection.ui.imgui;

import net.minecraft.client.MinecraftClient;

import java.util.List;
import java.util.ArrayList;

import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;

public class ImGuiLoader {
	private static boolean initialized = false;
	private static long winHandle;

	private static final ImGuiImplGlfw imglfw = new ImGuiImplGlfw();
	private static final ImGuiImplGl3 imgl3 = new ImGuiImplGl3();

	private static List<ImGuiClient> clients = new ArrayList<>();

	public static void init(long handle) {
		if (initialized)
			return;
		initialized = true;
		winHandle = handle;

		ImGui.createContext();
		ImGuiIO io = ImGui.getIO();
		io.setIniFilename(null);

		imglfw.init(winHandle, true);
		imgl3.init();
	}

	public static void render() {
		imglfw.newFrame();
		ImGui.newFrame();

		for (ImGuiClient client : clients) {
			if (client.guiEnabled())
				client.renderGui();
		}

		ImGui.render();
		imgl3.renderDrawData(ImGui.getDrawData());
	}

	public static void register(ImGuiClient client) {
		clients.add(client);
	}
}
