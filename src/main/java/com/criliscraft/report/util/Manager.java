package com.criliscraft.report.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Manager {

    private static Manager m = new Manager();

    public static Manager getInstance() {
        return m;
    }

    public void createReport(String n, UUID u, Location l, long t, String r) {
        incrementReportsNumber();
        int i = getReportsNumber();
        setName(i, n);
        setUUID(i, u);
        setLocation(i, l);
        setTime(i, t);
        setStatus(i, "OPEN");
        setMod(i, "NOT_ASSIGNED");
        setReport(i, r);
        Config.saveReports();
    }

    public void createReport(String n, UUID u, Location l, long t, String[] r) {
        incrementReportsNumber();
        int i = getReportsNumber();
        setName(i, n);
        setUUID(i, u);
        setLocation(i, l);
        setTime(i, t);
        setStatus(i, "OPEN");
        setMod(i, "NOT_ASSIGNED");
        setReport(i, r);
        Config.saveReports();
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

        if (!v.equals("OPEN") || !v.equals("CLOSED") || !v.equals("INPR")) {
            Config.getReports().set(idTS(i) + ".status", "ERROR");
            return;
        }
        Config.getReports().set(idTS(i) + ".status", v);
    }

    public String getStatus(int i) {
        return Config.getReports().getString(idTS(i) + ".status");
    }

    public void setMod(int i, String v) {
        Config.getReports().set(idTS(i) + ".mod", v);
    }

    public String getMod(int i) {
        return Config.getReports().getString(idTS(i) + ".mod");
    }

    public void setReport(int i, String[] v) {
        StringBuilder b = new StringBuilder();
        for (String s : v) {
            b.append(s);
        }
        Config.getReports().set(idTS(i) + ".report", b.toString());
    }

    public void setReport(int i, String v) {
        Config.getReports().set(idTS(i) + ".report", v);
    }

    public String getReport(int i) {
        return Config.getReports().getString(idTS(i) + ".report");
    }

    public List<Integer> getOpenReports() {
        int r = getReportsNumber();
        List<Integer> rep = new ArrayList<Integer>();
        for (int i = 0; i < r; i++) {
            if (getStatus(i).equals("OPEN")) {
                rep.add(i);
            } else {
                rep.add(0);
            }
        }
        return rep;
    }

    public List<Integer> getClosedReports() {
        int r = getReportsNumber();
        List<Integer> rep = new ArrayList<Integer>();
        for (int i = 0; i < r; i++) {
            if (getStatus(i).equals("CLOSED")) {
                rep.add(i);
            }
        }
        rep.add(0);
        return rep;
    }

    public List<Integer> getInprReports() {
        int r = getReportsNumber();
        List<Integer> rep = new ArrayList<Integer>();
        for (int i = 0; i < r; i++) {
            if (getStatus(i).equals("INPR")) {
                rep.add(i);
            }
        }
        rep.add(0);
        return rep;
    }

    public List<Integer> getErrorReports() {
        int r = getReportsNumber();
        List<Integer> rep = new ArrayList<Integer>();
        for (int i = 0; i < r; i++) {
            if (getStatus(i).equals("ERROR")) {
                rep.add(i);
            }
        }
        rep.add(0);
        return rep;
    }

    public String idTS(int id) {
        return String.valueOf(id);
    }

    public String uuidTS(UUID uuid) {
        return uuid.toString();
    }

    public UUID sTU(String uuid) {
        return UUID.fromString(uuid);
    }

    public void setReportsNumber(int i) {
        Config.getData().set("reports", i);
        Config.saveData();
    }

    public int getReportsNumber() {
        return Config.getData().getInt("reports");
    }

    public void incrementReportsNumber() {
        int i = getReportsNumber();
        i = i + 1;
        setReportsNumber(i);
        Config.saveData();
    }
}
