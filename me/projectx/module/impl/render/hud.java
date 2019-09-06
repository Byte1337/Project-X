package me.projectx.module.impl.render;

import org.lwjgl.input.Keyboard;

import me.projectx.module.Module;

@Module.Info(
        bind = Keyboard.KEY_O,
        name = "HUD"
)
public class hud extends Module {

    public static boolean showNone = false;

    public static boolean player = true;

}
