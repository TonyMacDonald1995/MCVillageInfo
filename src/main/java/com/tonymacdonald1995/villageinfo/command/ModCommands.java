package com.tonymacdonald1995.villageinfo.command;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class ModCommands {

    public static void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new VillageInfo());
    }
}
