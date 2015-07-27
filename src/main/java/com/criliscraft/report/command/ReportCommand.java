package com.criliscraft.report.command;

import com.criliscraft.report.CriLisReport;
import com.criliscraft.report.util.ChatLib;
import com.criliscraft.report.util.Manager;
import com.criliscraft.report.util.PermLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor {

    private final CriLisReport plugin;

    public ReportCommand(CriLisReport plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("report")) {
            if (!(source.hasPermission(PermLib.CLCREP_CMD_REPORT))) {
                source.sendMessage(ChatLib.Messages.NO_PERMS);
                return true;
            }
            if (!(source instanceof Player)) {
                source.sendMessage(ChatLib.Messages.NOT_A_PLAYER);
                return true;
            }
            if (length < 1) {
                source.sendMessage(ChatLib.Messages.CHAT_PREFIX_R + "Invalid Command Syntax!");
                source.sendMessage(ChatLib.Messages.CHAT_PREFIX_G + "/report <Your report>");
                source.sendMessage(ChatLib.Messages.CHAT_PREFIX_G + "Info like your name, location and time will automatically be recorded.");
            } else {
                Player p = (Player) source;
                Manager.getInstance().createReport(p.getName(), p.getUniqueId(), p.getLocation(), System.currentTimeMillis(), args);
                ChatLib.Returns.createdNewReport(p, args);
                return true;
            }
            return true;
        }
        return false;
    }
}
