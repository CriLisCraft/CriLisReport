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

    private static File reportsFile;
    private static File dataFile;

    private static FileConfiguration reports;
    private static FileConfiguration data;

    @SuppressWarnings("static-access")
    public Config(CriLisReport plugin) {

        this.plugin = plugin;

        this.dataFolder = plugin.getDataFolder();

        this.reportsFile = new File(plugin.getDataFolder(), "reports.yml");
        this.dataFile = new File(plugin.getDataFolder(), "data.yml");

        this.reports = YamlConfiguration.loadConfiguration(reportsFile);
        this.data = YamlConfiguration.loadConfiguration(dataFile);
    }

    public static void createAllFiles() {
        if (!(reportsFile.exists())) {
            plugin.getLogger().log(Level.INFO, "reports.yml not found, Creating a new one.");
            plugin.saveResource("reports.yml", true);
        }
        if (!(dataFile.exists())) {
            plugin.getLogger().log(Level.INFO, "data.yml not found, Creating a new one.");
            plugin.saveResource("data.yml", true);
        }
    }

    public static File getReportsFile() {
        return reportsFile;
    }

    public static File getDataFile() {
        return dataFile;
    }

    public static FileConfiguration getData() {
        return data;
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

    public static void saveReports() {
        saveFile(reportsFile, reports);
    }

    public static void saveData() {
        saveFile(dataFile, data);
    }
}
