package com.tonymacdonald1995.villageinfo;

import com.tonymacdonald1995.villageinfo.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(modid = VillageInfoMod.MODID, name = VillageInfoMod.NAME, version = VillageInfoMod.VERSION)
public class VillageInfoMod {
    public static final String MODID = "villageinfo";
    public static final String NAME = "Village Info Mod";
    public static final String VERSION = "1.0.0";

    @SidedProxy(serverSide = "com.tonymacdonald1995.villageinfo.proxy.CommonProxy", clientSide = "com.tonymacdonald1995.villageinfo.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
