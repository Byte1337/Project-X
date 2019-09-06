package me.projectx;

import me.projectx.command.CommandHandler;
import me.projectx.event.EventManager;
import me.projectx.event.EventTarget;
import me.projectx.event.events.EventBind;
import me.projectx.module.ModuleManager;
import me.projectx.module.SettingsManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.opengl.Display;

public class ClientBase {

    public String Info[] =
            {
                    "ProjectX",        // NAME //
                    " B1.0",        // VERS //
                    "."             // PREF //echo
            };

    public static ClientBase instance = new ClientBase();

    public static EventManager eventHandler;

    public static ModuleManager moduleHandler;

    public static CommandHandler cmdHandler;

    public SettingsManager settingsManager;

    public static Minecraft mc;

    public void start()
    {
        System.out.println("[" + Info[0] + "] This client base was coded and designed by Byte 7/2/19 ");
        System.out.println("[" + this.Info[0] + "] Starting ClientBase" + Info[1]);

        try {
            mc = Minecraft.getMinecraft();

            eventHandler = new EventManager();

            moduleHandler = new ModuleManager();

            cmdHandler = new CommandHandler();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Display.setTitle(this.Info[0]);

        EventManager.register(this);
    }

    public void stop()
    {
        System.out.println("[" + this.Info[0] + "] Closing client...");


        EventManager.unregister(this);
    }

    @EventTarget
    public void onKey(EventBind event) {
        moduleHandler.getModuleList().stream().filter(module -> module.getBind() == event.getBind()).forEach(module -> module.toggle());
    }
    public void addChatMessage(String s){
        Minecraft.getMinecraft();
		Minecraft.thePlayer.addChatMessage(new ChatComponentText("§0[§5" + ClientBase.instance.Info[0] + "§0] §9" + s));
    }

}
