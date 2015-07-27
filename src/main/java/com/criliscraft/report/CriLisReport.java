package com.criliscraft.report;

import com.criliscraft.report.command.ReportCommand;
import com.criliscraft.report.listener.PlayerListener;
import com.criliscraft.report.util.Config;
import com.criliscraft.report.util.PermLib;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class CriLisReport extends JavaPlugin {

    private PluginManager pm = this.getServer().getPluginManager();

    @Override
    public void onDisable() {

        Config.saveReports();

        this.getLogger().log(Level.INFO, "Disabled");
    }

    @Override
    public void onEnable() {

        new PlayerListener(this);

        PermLib.init(this.pm);

        this.getCommand("report").setExecutor(new ReportCommand(this));

        new Config(this);
        Config.createAllFiles();

        this.getLogger().log(Level.INFO, "Enabled");
    }
}
