package com.bryanf.aethermancy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.gildedgames.the_aether.AetherConfig;

@Mod(modid = ThaumcraftAethermancyMod.MODID, dependencies = "required-after:aether_legacy;required-after:thaumcraft", useMetadata = true)
public class ThaumcraftAethermancyMod
{
    public static final String MODID = "aethermancy";

    public static Logger logger;
    
    @Instance(MODID)
    public ThaumcraftAethermancyMod instance;
    
    public static final int TWILIGH_FOREST_DIMENSION_ID = 7;
    
    public ThaumcraftAethermancyMod()
    {
//    	logger.log(Level.INFO,"Aether Dimension number is: " + AetherConfig.dimension.aether_dimension_id);
    	FMLInterModComms.sendMessage("Thaumcraft", "dimensionBlacklist", new String(AetherConfig.dimension.aether_dimension_id + ":1")); //only allow ore and node spawning in the Aether.
//    	FMLInterModComms.sendMessage("Thaumcraft", "dimensionBlacklist", new String(TWILIGH_FOREST_DIMENSION_ID + ":1")); //only allow ore and node spawning in the Twilight Forest.
    }

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
