package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.game.Screens.DooniPong;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(144);
		config.useVsync(true);
		config.setWindowedMode(800,600);
		config.setTitle("Dooni Pong");
		new Lwjgl3Application(new DooniPong(), config);
	}
}
