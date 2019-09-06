package me.projectx.command.commands;

import me.projectx.ClientBase;
import me.projectx.command.Command;
import me.projectx.module.Module;

public class toggle extends Command {

    @Override
    public String getAlias() {
        return "toggle";
    }

    @Override
    public String getSyntax() {
        return ClientBase.instance.Info[2] + "toggle [MOD] | t [MOD]";
    }

    @Override
    public void onCommand(String command, String[] args) throws Exception {
        boolean found = false;
        for(Module m: ClientBase.moduleHandler.getModuleList()){
            if(args[0].equalsIgnoreCase(m.getName())){
                m.toggle();
                found = true;
                ClientBase.instance.addChatMessage("Toggled " + m.getName() + "!");
            }
        }
        if(found == false){
            ClientBase.instance.addChatMessage("Unknown Module Please Try A Different Prefix!");
        }
    }

}
