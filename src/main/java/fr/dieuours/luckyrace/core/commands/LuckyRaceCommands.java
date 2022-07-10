package fr.dieuours.luckyrace.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LuckyRaceCommands implements CommandExecutor {

    /**
     * @param sender CommandSender
     * @param cmd    Command
     * @param msg    String
     * @param args   String[]
     * @see CommandSender
     * @see Command
     * @see CommandExecutor
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (cmd.getName().equalsIgnoreCase("luckyrace")) {
            if (args.length == 0) {
                if (sender.hasPermission("luckyrace.help")) {
                    sender.sendMessage(EnglishResponse.getHelp());
                } else {
                    sender.sendMessage(EnglishResponse.getNotPermission());
                }
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("create")) {
                    sender.sendMessage(EnglishResponse.getNotEnoughArgs());
                }
            }
        }
        return false;
    }

    //TODO complete the list
    /**
     * create
     * delete
     * setSpawn
     * /luckyrace create <name>
     * */
}
