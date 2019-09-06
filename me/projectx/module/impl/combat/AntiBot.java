package me.projectx.module.impl.combat;

import me.projectx.ClientBase;
import me.projectx.event.EventTarget;
import me.projectx.event.events.EventTick;
import me.projectx.module.Module;
import me.projectx.module.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

    @Module.Info(
        category = Module.Category.Combat,
        bind = Keyboard.KEY_NONE,
        name = "AntiBot"
)

    public class AntiBot extends Module {
    @EventTarget
    public void onTick(EventTick event) {
        this.setSettingName("WatchDog");
        this.setSettingName("Mineplex");
        this.setSettingName("Cubecraft");
        this.setSettingName("Packet");
        this.setSettingName("Advanced");
    }
    /*public static List<EntityPlayer> getTabPlayerList() {
        final List<EntityPlayer> list = new ArrayList<>();
        final List players = GuiPlayerTabOverlay.field_175252_a.sortedCopy(Minecraft.thePlayer.sendQueue.func_175106_d());
        for (final Object o : players) {
            final NetworkPlayerInfo info = (NetworkPlayerInfo) o;
            if (info == null) {
                continue;
            }
            list.add(Minecraft.theWorld.getPlayerEntityByName(info.field_178867_a.getName()));
        }
        return list;*/
    }

