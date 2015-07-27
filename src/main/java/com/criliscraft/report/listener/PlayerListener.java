package com.criliscraft.report.listener;

import com.criliscraft.report.CriLisReport;
import com.criliscraft.report.util.ChatLib;
import com.criliscraft.report.util.Manager;
import com.criliscraft.report.util.PermLib;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerListener implements Listener {

    private final CriLisReport plugin;

    public PlayerListener(CriLisReport plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission(PermLib.CLCREP_MOD)) {
            List<Integer> r = Manager.getInstance().getOpenReports();
            int i = r.size();
            ChatLib.Returns.openReports(p, i);
        }
    }
}
