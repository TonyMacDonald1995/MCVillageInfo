package com.tonymacdonald1995.villageinfo.proxy;

import com.tonymacdonald1995.villageinfo.command.ModCommands;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

    public void serverStarting(FMLServerStartingEvent event) {
        ModCommands.registerCommands(event);
    }
}
