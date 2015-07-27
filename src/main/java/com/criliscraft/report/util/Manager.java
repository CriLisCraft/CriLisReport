package com.criliscraft.report.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.UUID;

public class Manager {

    private static Manager m = new Manager();

    public static Manager getInstance() {
        return m;
    }

    public void createReport(String n) {

    }

    public void setName(int i, String v) {
        Config.getReports().set(idTS(i) + ".name", v);
    }

    public String getName(int i) {
        return Config.getReports().getString(idTS(i) + ".name");
    }

    public void setUUID(int i, UUID v) {
        Config.getReports().set(idTS(i) + ".uuid", uuidTS(v));
    }

    public UUID getUUID(int i) {
        return sTU(Config.getReports().getString(idTS(i) + ".uuid"));
    }

    public void setLocation(int i, Location v) {
        Config.getReports().set(idTS(i) + ".world", v.getWorld().getName());
        Config.getReports().set(idTS(i) + ".x", v.getX());
        Config.getReports().set(idTS(i) + ".y", v.getY());
        Config.getReports().set(idTS(i) + ".z", v.getZ());
    }

    public Location getLocation(int i) {
        new Location(Bukkit.getWorld("Plantera"), 0, 0, 0);
        World world = Bukkit.getWorld(Config.getReports().getString(idTS(i) + ".world"));
        double x = Config.getReports().getDouble(idTS(i) + ".x");
        double y = Config.getReports().getDouble(idTS(i) + ".y");
        double z = Config.getReports().getDouble(idTS(i) + ".z");
        return new Location(world, x, y, z);
    }

    public void setTime(int i, long v) {
        Config.getReports().set(idTS(i) + ".time", v);
    }

    public long getTime(int i) {
        return Config.getReports().getLong(idTS(i) + ".time");
    }

    public void setStatus(int i, String v) {

        if (!v.equals("OPEN") || !v.equals("CLOSED")) {
            Config.getReports().set(idTS(i) + ".status", "ERROR");
            return;
        }
        Config.getReports().set(idTS(i) + ".status", v);
    }

    public String getStatus(int i) {
        return Config.getReports().getString(idTS(i) + ".status");
    }

    //TODO mod, report

    //UTIL METHODS

    public String idTS(int id) {
        return String.valueOf(id);
    }

    public String uuidTS(UUID uuid) {
        return uuid.toString();
    }

    public UUID sTU(String uuid) {
        return UUID.fromString(uuid);
    }
}
