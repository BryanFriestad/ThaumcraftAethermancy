package com.bryanf.aethermancy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ThaumcraftAethermancyMod.MODID, name = ThaumcraftAethermancyMod.NAME, version = ThaumcraftAethermancyMod.VERSION, dependencies = "required-after:aether_legacy;required-after:thaumcraft")
public class ThaumcraftAethermancyMod
{
    public static final String MODID = "aethermancy";
    public static final String NAME = "Thaumcraft Aethermancy";
    public static final String VERSION = "0.1";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
    
    @EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
