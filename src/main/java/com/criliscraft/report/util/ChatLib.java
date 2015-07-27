package com.criliscraft.report.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ChatLib {

    public static class Messages {
        public static final String CHAT_PREFIX = ChatColor.WHITE + "[" + ChatColor.DARK_BLUE + "CriLis " + ChatColor.DARK_GREEN + "Craft" + ChatColor.WHITE + "] ";
        public static final String CHAT_PREFIX_G = CHAT_PREFIX + ChatColor.GREEN;
        public static final String CHAT_PREFIX_Y = CHAT_PREFIX + ChatColor.YELLOW;
        public static final String CHAT_PREFIX_R = CHAT_PREFIX + ChatColor.RED;
        public static final String NO_PERMS = CHAT_PREFIX_R + "You do not have permission to use that command.";
        public static final String NOT_A_PLAYER = CHAT_PREFIX_R + "You have to be a player to use that command.";
    }

    public static class Returns {
        public static void createdNewReport(Player p, String[] r) {
            p.sendMessage(Messages.CHAT_PREFIX_G + "Successfully created a new report with the following: ");
            p.sendMessage(ChatColor.DARK_GREEN + "Name: " + ChatColor.AQUA + p.getName());
            p.sendMessage(ChatColor.DARK_GREEN + "UUID: " + ChatColor.AQUA + p.getUniqueId());
            p.sendMessage(ChatColor.DARK_GREEN + "Location: " + ChatColor.AQUA + p.getLocation().getWorld().getName() + ", " + p.getLocation().getX() + ", " + p.getLocation().getY() + ", " + p.getLocation().getZ());
            p.sendMessage(ChatColor.DARK_GREEN + "Time: " + ChatColor.AQUA + System.currentTimeMillis());
            p.sendMessage(ChatColor.DARK_GREEN + "Report: " + ChatColor.AQUA + Arrays.toString(r));
        }
        public static void openReports(Player p, int o) {
            if (o > 0) {
                p.sendMessage(Messages.CHAT_PREFIX_R + "There are currently " + ChatColor.AQUA + o + ChatColor.RED + " open reports.");
                p.sendMessage(Messages.CHAT_PREFIX_Y + "Use " + ChatColor.DARK_AQUA + "/rmod openlist " + ChatColor.YELLOW + "to view a list of open report id's.");
            } else {
                p.sendMessage(Messages.CHAT_PREFIX_Y + "There are no open reports.");
            }
        }
    }
}
