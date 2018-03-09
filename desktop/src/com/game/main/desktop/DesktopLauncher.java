package com.game.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.main.TDMain;

import static com.game.main.Constants.TITLE;
import static com.game.main.Constants.V_HEIGHT;
import static com.game.main.Constants.V_WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = TITLE;
		config.width = V_WIDTH;
		config.height =V_HEIGHT;
		new LwjglApplication(new TDMain(), config);
	}
}
