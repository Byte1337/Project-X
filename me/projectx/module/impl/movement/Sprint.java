package me.projectx.module.impl.movement;

import me.projectx.ClientBase;
import me.projectx.event.EventTarget;
import me.projectx.event.events.EventTick;
import me.projectx.module.Module;

import org.lwjgl.input.Keyboard;

@Module.Info(
        category = Module.Category.Movement,
        bind = Keyboard.KEY_Z,
        name = "Sprint"
)
public class Sprint extends Module {

    @EventTarget
    public void onTick(EventTick event) {
        ClientBase.mc.thePlayer.setSprinting(!ClientBase.mc.thePlayer.isCollidedHorizontally && ClientBase.mc.thePlayer.moveForward > 0);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        ClientBase.mc.thePlayer.setSprinting(false);
    }

}
