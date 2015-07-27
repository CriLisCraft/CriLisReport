package com.criliscraft.report.util;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class PermLib {

    public static void init(PluginManager pm) {
        pm.addPermission(CLCREP_CMD_REPADMIN);
        pm.addPermission(CLCREP_ADMIN);
        pm.addPermission(CLCREP_CMD_REPMOD);
        pm.addPermission(CLCREP_MOD);
        pm.addPermission(CLCREP_CMD_REPORT);
        pm.addPermission(CLCREP_PLAYER);
    }

    //ADMIN
    public static final Permission CLCREP_CMD_REPADMIN = new Permission("clc.cmd.repadmin");
    public static final Permission CLCREP_ADMIN = new Permission("clc.admin");

    //MOD
    public static final Permission CLCREP_CMD_REPMOD = new Permission("clc.cmd.repmod");
    public static final Permission CLCREP_MOD = new Permission("clc.mod");

    //PLAYER
    public static final Permission CLCREP_CMD_REPORT = new Permission("clc.cmd.report");
    public static final Permission CLCREP_PLAYER = new Permission("clc.player");
}
