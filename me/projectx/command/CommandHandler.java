package me.projectx.command;

import me.projectx.ClientBase;
import me.projectx.command.commands.bind;
import me.projectx.command.commands.toggle;
import me.projectx.command.commands.toggleT;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler {

    private List<Command> commandList;

    public CommandHandler() {
        commandList = new ArrayList<Command>();

        addCommand(new bind());

        addCommand(new toggle());
        addCommand(new toggleT());

    }

    public List<Command> getCommandList() { return commandList; }

    public void addCommand(Command cmd) { commandList.add(cmd); }

    public void callCommand(String input){
        String[] split = input.split(" ");
        String command = split[0];
        String args = input.substring(command.length()).trim();
        for(Command c: getCommandList()){
            if(c.getAlias().equalsIgnoreCase(command)){
                try{
                    c.onCommand(args, args.split(" "));
                }catch(Exception e){
                    ClientBase.instance.addChatMessage("Invalid Command Usage!");
                    ClientBase.instance.addChatMessage(c.getSyntax());
                }
                return;
            }
        }
        ClientBase.instance.addChatMessage("Command not found!");
    }

}
