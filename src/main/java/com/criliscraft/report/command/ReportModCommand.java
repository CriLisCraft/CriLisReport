package com.criliscraft.report.command;

import com.criliscraft.report.CriLisReport;
import com.criliscraft.report.util.PermLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReportModCommand implements CommandExecutor {

    private final CriLisReport plugin;

    public ReportModCommand(CriLisReport plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("reportmod")) {
            if (!(source.hasPermission(PermLib.CLCREP_CMD_REPMOD))) {

            }
        }
        return false;
    }
}
