package me.projectx.module;

import me.projectx.ClientBase;
import net.minecraft.network.play.server.S02PacketChat;
import org.lwjgl.input.Keyboard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Module {

    public enum Category {
        Movement,
        Combat,
        Render,
        Player,
            NONE
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Info {
        Category category()default Category.NONE;
        int bind()default Keyboard.KEY_NONE;
        String name()default "NONE";
    }

    private String name = getClass().getAnnotation(Info.class).name(), settingName;
    private Category category = getClass().getAnnotation(Info.class).category();
    private int bind = getClass().getAnnotation(Info.class).bind();
    private boolean enabled = false;

    public void onEnable() { ClientBase.eventHandler.register(this); ClientBase.moduleHandler.registerActivatedModule(this); }
    public void onDisable() { ClientBase.eventHandler.unregister(this); ClientBase.moduleHandler.unregisterActivatedModule(this);}

    public void onTick() {}
    public void onRender() {}
    public void onToggle() {}

    public void toggle()
    {
        enabled = !enabled;
        onToggle();
        if(enabled)
            onEnable();
        else
            onDisable();
    }

    public String getName() { return name; }

    public Category getCategory() { return category; }

    public boolean isEnabled() { return enabled; }

    public String getSettingName() { return settingName == null ? name : name + " §8" + settingName; }
    public void setSettingName(String settingName) { this.settingName = settingName; }

    public int getBind() { return bind; }
    public void setBind(int bind) { this.bind = bind; }

    public static boolean onSendChatMessage(String s){//EntityPlayerSP
        if(s.startsWith(ClientBase.instance.Info[2])){
            ClientBase.cmdHandler.callCommand(s.substring(1));
            return false;
        }
        for(Module m: ClientBase.moduleHandler.getModuleList()){
            if(m.isEnabled()){
                return m.onSendChatMessage(s);
            }
        }
        return true;
    }

    public static boolean onRecieveChatMessage(S02PacketChat packet){
        for(Module m: ClientBase.moduleHandler.getModuleList()){
            if(m.isEnabled()){
                return onRecieveChatMessage(packet);
            }
        }
        return true;
    }

}
