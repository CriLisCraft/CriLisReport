package com.criliscraft.report.util;

import com.criliscraft.report.CriLisReport;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class Config {

    private static CriLisReport plugin;

    private static File dataFolder;

    private static File configFile;
    private static File reportsFile;

    private static FileConfiguration config;
    private static FileConfiguration reports;

    @SuppressWarnings("static-access")
    public Config(CriLisReport plugin) {

        this.plugin = plugin;

        this.dataFolder = plugin.getDataFolder();

        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        this.reportsFile = new File(plugin.getDataFolder(), "reports.yml");

        this.config = YamlConfiguration.loadConfiguration(configFile);
        this.reports = YamlConfiguration.loadConfiguration(reportsFile);
    }

    public static void createAllFiles() {
        if (!(configFile.exists())) {
            plugin.getLogger().log(Level.INFO, "config.yml not found, Creating a new one.");
            plugin.saveResource("config.yml", true);
        }
        if (!(reportsFile.exists())) {
            plugin.getLogger().log(Level.INFO, "reports.yml not found, Creating a new one.");
            plugin.saveResource("reports.yml", true);
        }
    }

    public static File getConfigFile() {
        return  configFile;
    }

    public static File getReportsFile() {
        return reportsFile;
    }

    public static FileConfiguration getConfig() {
        return config;
    }

    public static FileConfiguration getReports() {
        return reports;
    }

    public static void saveFile(File file, FileConfiguration config) {
        try {
            config.save(file);
        } catch (IOException e) {
            plugin.getLogger().log(Level.WARNING, "An error occurred while attempting to save a file.", e);
        }
    }

    public static void saveConfig() {
        saveFile(configFile, config);
    }

    public static void saveReports() {
        saveFile(reportsFile, reports);
    }
}
