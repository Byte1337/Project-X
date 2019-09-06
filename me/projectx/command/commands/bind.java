package me.projectx.command.commands;

import me.projectx.ClientBase;
import me.projectx.command.Command;
import me.projectx.module.Module;

import org.lwjgl.input.Keyboard;

public class bind extends Command {


    @Override
    public String getAlias() {
        return "bind";
    }

     @Override
    public String getSyntax() {
        return ClientBase.instance.Info[2] + "bind set [MOD] [Key] | " + ClientBase.instance.Info[2] +"bind del [MOD] | " + ClientBase.instance.Info[2] + "bind clear";
    }

    @Override
    public void onCommand(String command, String[] args) throws Exception {
        if(args[0].equalsIgnoreCase("set")){
            args[2] = args[2].toUpperCase();
            int key = Keyboard.getKeyIndex(args[2]);

            for(Module m: ClientBase.moduleHandler.getModuleList()){
                if(args[1].equalsIgnoreCase(m.getName())){
                    m.setBind(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
                    ClientBase.instance.addChatMessage(args[1] + " has been binded to " + args[2]);
                }
            }

        }else if(args[0].equalsIgnoreCase("del")){
            for(Module m: ClientBase.moduleHandler.getModuleList()){
                if(m.getName().equalsIgnoreCase(args[1])){
                    m.setBind(0);
                    ClientBase.instance.addChatMessage(args[1] + " has been unbinded");
                }
            }
        }else if(args[0].equalsIgnoreCase("clear")){
            for(Module m: ClientBase.moduleHandler.getModuleList()){
                m.setBind(0);
            }
            ClientBase.instance.addChatMessage("All keys cleared");
        }
    }

}
