package com.cal.codeday.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cal.codeday.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 600;
        config.width = 1000;
        config.resizable = false;
        config.foregroundFPS = 60;
		new LwjglApplication(new Game(), config);
	}
}
