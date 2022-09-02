package com.game;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.game.screens.DooniPong;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(144);
		config.useVsync(true);
		config.setWindowedMode(1100,650);
		config.setTitle("Dooni Pong");
		config.setResizable(false);
		config.setWindowIcon(Files.FileType.Internal,"images/fav.png");
		new Lwjgl3Application(new DooniPong(), config);
	}
}
