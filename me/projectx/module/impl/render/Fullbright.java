package me.projectx.module.impl.render;

import me.projectx.ClientBase;
import me.projectx.event.EventTarget;
import me.projectx.event.events.EventTick;
import me.projectx.event.events.EventUpdate;
import me.projectx.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

@Module.Info(
        category = Module.Category.Movement,
        bind = Keyboard.KEY_F,
        name = "Fullbright"
)
public class Fullbright extends Module {
    private float oldBrightness;

    @Override
    public void onEnable() {
        super.onEnable();

        oldBrightness = Minecraft.gameSettings.gammaSetting;
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        Minecraft.gameSettings.gammaSetting = 10F;
    }

    @Override
    public void onDisable() {
        super.onDisable();

        Minecraft.gameSettings.gammaSetting = oldBrightness;
    }
}
