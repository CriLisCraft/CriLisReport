package com.criliscraft.report;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class CriLisReport extends JavaPlugin {

    @Override
    public void onDisable() {

        this.getLogger().log(Level.INFO, "Disabled");
    }

    @Override
    public void onEnable() {

        this.getLogger().log(Level.INFO, "Enabled");
    }
}
