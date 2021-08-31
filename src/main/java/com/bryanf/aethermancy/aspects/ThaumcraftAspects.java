package com.bryanf.aethermancy.aspects;

import org.apache.logging.log4j.Level;

import com.bryanf.aethermancy.ThaumcraftAethermancyMod;

import com.gildedgames.the_aether.blocks.BlocksAether;
import com.gildedgames.the_aether.blocks.util.EnumCloudType;
import com.gildedgames.the_aether.blocks.util.EnumLogType;
import com.gildedgames.the_aether.blocks.util.EnumStoneType;

import com.gildedgames.the_aether.items.ItemsAether;
import com.gildedgames.the_aether.items.util.EnumDartShooterType;
import com.gildedgames.the_aether.items.util.EnumDartType;
import com.gildedgames.the_aether.items.util.EnumSkyrootBucketType;
import com.gildedgames.the_aether.entities.passive.mountable.EntityPhyg;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;
import thaumcraft.api.internal.CommonInternals;
import thaumcraft.api.research.ScanEntity;
import thaumcraft.api.research.ScanningManager;

@Mod.EventBusSubscriber(modid = "aethermancy")
public class ThaumcraftAspects
{
	private static AspectRegistryEvent event;
	
	@SubscribeEvent	
	public static void ApplyAspects(AspectRegistryEvent e)
	{
		ThaumcraftAethermancyMod.logger.log(Level.INFO, "Starting to apply TC aspects to Aether objects");
		ThaumcraftAspects.event = e;
		blocks();
		items();
		mobs();
		ThaumcraftAethermancyMod.logger.log(Level.INFO, "Done applying TC aspects to Aether objects");
	}
	
	private static void blocks()
	{
		RegisterBlock(BlocksAether.aether_portal, new AspectList()
				.add(Aspect.WATER, 4)
				.add(Aspect.MOTION, 4));
		
		RegisterBlock(BlocksAether.aether_dirt, new AspectList()
				.add(Aspect.AIR, 3)
				.add(Aspect.ORDER, 1));
		
		RegisterBlock(BlocksAether.ambrosium_torch, new AspectList()
				.add(Aspect.LIGHT, 5)
				.add(Aspect.ENERGY, 1));
		
		RegisterBlock(BlocksAether.aercloud, EnumCloudType.Blue.getMeta(), new AspectList()
				.add(Aspect.FLIGHT, 10));
		RegisterBlock(BlocksAether.aercloud, EnumCloudType.Cold.getMeta(), new AspectList()
				.add(Aspect.COLD, 5)
				.add(Aspect.AIR, 5));
		RegisterBlock(BlocksAether.aercloud, EnumCloudType.Golden.getMeta(), new AspectList()
				.add(Aspect.DESIRE, 10)
				.add(Aspect.AIR, 4));
		
		RegisterBlock(BlocksAether.golden_oak_sapling, new AspectList()
				.add(Aspect.LIFE, 1)
				.add(Aspect.DESIRE, 5)
				.add(Aspect.PLANT, 11));
		RegisterBlock(BlocksAether.skyroot_sapling, new AspectList()
				.add(Aspect.PLANT, 15)
				.add(Aspect.LIFE, 5));
		RegisterBlock(BlocksAether.white_flower, new AspectList()
				.add(Aspect.PLANT, 5));
		RegisterBlock(BlocksAether.purple_flower, new AspectList()
				.add(Aspect.PLANT, 5));
		
		RegisterBlock(BlocksAether.holystone, new AspectList()
				.add(Aspect.EARTH, 3)
				.add(Aspect.SOUL, 1));
		RegisterBlock(BlocksAether.holystone_brick, new AspectList()
				.add(Aspect.ORDER, 1)
				.add(Aspect.SOUL, 1)
				.add(Aspect.EARTH, 3));
		RegisterBlock(BlocksAether.mossy_holystone, new AspectList()
				.add(Aspect.ORDER, 1)
				.add(Aspect.SOUL, 1)
				.add(Aspect.EARTH, 3)
				.add(Aspect.PLANT, 2));
		
		// DUNGEON BLOCKS
		RegisterBlock(BlocksAether.dungeon_block, EnumStoneType.Sentry.getMeta(), new AspectList()
				.add(Aspect.LIGHT, 3)
				.add(Aspect.EARTH, 5));
		RegisterBlock(BlocksAether.pillar, new AspectList()
				.add(Aspect.ORDER, 5));
		RegisterBlock(BlocksAether.pillar_top, new AspectList()
				.add(Aspect.ORDER, 5));
		
		RegisterBlock(BlocksAether.quicksoil, new AspectList()
				.add(Aspect.EARTH, 3)
				.add(Aspect.MOTION, 3)
				.add(Aspect.ENTROPY, 3));
		RegisterBlock(BlocksAether.icestone, new AspectList()
				.add(Aspect.COLD, 10)
				.add(Aspect.CRYSTAL, 10));
		
		RegisterBlock(BlocksAether.aether_log, EnumLogType.Skyroot.getMeta(), new AspectList()
				.add(Aspect.PLANT, 7)
				.add(Aspect.FLIGHT, 15));
		RegisterBlock(BlocksAether.aether_log, EnumLogType.Oak.getMeta(), new AspectList()
				.add(Aspect.PLANT, 7)
				.add(Aspect.FLIGHT, 10)
				.add(Aspect.DESIRE, 5));
		RegisterBlock(BlocksAether.skyroot_plank, new AspectList()
				.add(Aspect.PLANT, 1)
				.add(Aspect.FLIGHT, 2));
		
		RegisterBlock(BlocksAether.freezer, new AspectList()
				.add(Aspect.COLD, 10)
				.add(Aspect.CRAFT, 10));
		RegisterBlock(BlocksAether.incubator, new AspectList()
				.add(Aspect.LIFE, 20));
		
		RegisterBlock(BlocksAether.gravitite_ore, new AspectList()
				.add(Aspect.METAL, 10)
				.add(Aspect.EXCHANGE, 10)
				.add(Aspect.MOTION, 10));
		RegisterBlock(BlocksAether.enchanted_gravitite, new AspectList()
				.add(Aspect.METAL, 10)
				.add(Aspect.EXCHANGE, 10)
				.add(Aspect.MAGIC, 5));
		
		RegisterBlock(BlocksAether.berry_bush_stem, new AspectList()
				.add(Aspect.PLANT, 5));
		RegisterBlock(BlocksAether.berry_bush, new AspectList()
				.add(Aspect.PLANT, 5));
		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.AetherGrass), new int[]{0}, (new AspectList().add(Aspect.PLANT, 1)).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.EnchantedAetherGrass), new int[]{0}, (new AspectList().add(Aspect.PLANT, 1)).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.EnchantedGrass), new int[]{0}, (new AspectList().add(Aspect.PLANT, 1)).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.Aerogel), new int[]{0}, (new AspectList()).add(Aspect.WATER, 2).add(Aspect.FIRE, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.Altar), new int[]{0}, (new AspectList()).add(Aspect.GREED, 2).add(Aspect.EARTH, 3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.GreenSkyrootLeaves), new int[]{0}, (new AspectList()).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.GoldenOakLeaves), new int[]{0}, (new AspectList()).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.AmbrosiumOre), new int[]{0}, (new AspectList()).add(Aspect.LIGHT, 1).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.ZaniteOre), new int[]{0}, (new AspectList()).add(Aspect.METAL, 3).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.EnchantedGravitite), new int[]{0}, (new AspectList()).add(Aspect.METAL, 3).add(Aspect.GREED, 2).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.Trap), new int[]{0}, (new AspectList()).add(Aspect.EARTH, 4).add(Aspect.TRAP, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootChestMimic), new int[]{0}, (new AspectList()).add(Aspect.VOID, 4).add(Aspect.TREE, 3).add(Aspect.TRAP, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.DivineDungeonStone), new int[]{0}, (new AspectList()).add(Aspect.MAGIC, 2).add(Aspect.EARTH, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.DivineLightDungeonStone), new int[]{0}, (new AspectList()).add(Aspect.MAGIC, 2).add(Aspect.LIGHT, 2).add(Aspect.EARTH, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.DivineLightDungeonStone), new int[]{0}, (new AspectList()).add(Aspect.MAGIC, 2).add(Aspect.LIGHT, 2).add(Aspect.EARTH, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.WhiteGoldPillar), new int[]{0,1,3,4}, (new AspectList()).add(Aspect.EARTH, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.ZaniteBlock), new int[]{0,1,3,4}, (new AspectList()).add(Aspect.METAL, 8));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.QuicksoilGlass), new int[]{0}, (new AspectList()).add(Aspect.MOTION, 1).add(Aspect.CRYSTAL, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.QuicksoilGlassPane), new int[]{0}, (new AspectList()).add(Aspect.MOTION, 1).add(Aspect.CRYSTAL, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.Present), new int[]{0}, (new AspectList()).add(Aspect.TRAP, 3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.BerryBush), new int[]{0}, (new AspectList()).add(Aspect.PLANT, 3).add(Aspect.HUNGER, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.BerryBushStem), new int[]{0}, (new AspectList()).add(Aspect.PLANT, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.HolystoneStairs), new int[]{0}, (new AspectList()).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.MossyHolystoneStairs), new int[]{0}, (new AspectList()).add(Aspect.EARTH, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.IcestoneStairs), new int[]{0}, (new AspectList()).add(Aspect.COLD, 2).add(Aspect.EARTH, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootStairs), new int[]{0}, (new AspectList()).add(Aspect.TREE, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.CarvedStairs), new int[]{0}, (new AspectList()).add(Aspect.EARTH, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.HolystoneWall), new int[]{0}, (new AspectList()).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.MossyHolystoneWall), new int[]{0}, (new AspectList()).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.IcestoneWall), new int[]{0}, (new AspectList()).add(Aspect.COLD, 1).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.CarvedWall), new int[]{0}, (new AspectList()).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.HolystoneWall), new int[]{0}, (new AspectList()).add(Aspect.EARTH, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootLogWall), new int[]{0}, (new AspectList()).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.TallAetherGrass), new int[]{0}, (new AspectList()).add(Aspect.PLANT, 1).add(Aspect.AIR, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.DarkBlueSkyrootLeaves), new int[]{0}, (new AspectList()).add(Aspect.PLANT, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.BlueSkyrootLeaves), new int[]{0}, (new AspectList()).add(Aspect.PLANT, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.DarkBlueSkyrootSapling), new int[]{0}, (new AspectList()).add(Aspect.TREE, 1).add(Aspect.PLANT, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.BlueSkyrootSapling), new int[]{0}, (new AspectList()).add(Aspect.TREE, 1).add(Aspect.PLANT, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootChest), new int[]{0}, (new AspectList()).add(Aspect.VOID, 4).add(Aspect.TREE, 3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SliderLabyrinthDoor), new int[]{0}, (new AspectList()).add(Aspect.MECHANISM, 2).add(Aspect.MOTION, 1).add(Aspect.MAGIC, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.PurpleCrystalSapling), new int[]{0}, (new AspectList()).add(Aspect.TREE, 1).add(Aspect.PLANT, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.PurpleCrystalLeaves), new int[]{0}, (new AspectList()).add(Aspect.PLANT, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.PurpleFruitLeaves), new int[]{0}, (new AspectList()).add(Aspect.HUNGER, 1).add(Aspect.PLANT, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.BlockOrangeTree), new int[]{0}, (new AspectList()).add(Aspect.HUNGER, 1).add(Aspect.PLANT, 3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.ContinuumOre), new int[]{0}, (new AspectList()).add(Aspect.METAL, 3).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootCraftingTable), new int[]{0}, (new AspectList()).add(Aspect.CRAFT, 4).add(Aspect.TREE, 3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.BloodMossHolystone), new int[]{0}, (new AspectList()).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1).add(Aspect.FLESH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.DivineCarvedWall), new int[]{0}, (new AspectList()).add(Aspect.MAGIC, 1).add(Aspect.EARTH, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.DivineCarvedStairs), new int[]{0}, (new AspectList()).add(Aspect.MAGIC, 2).add(Aspect.EARTH, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.ColdFire), new int[]{0}, (new AspectList()).add(Aspect.COLD, 4).add(Aspect.FIRE, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootDoor), new int[]{0}, (new AspectList()).add(Aspect.TREE, 8).add(Aspect.MECHANISM, 2).add(Aspect.MOTION, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootTrapDoor), new int[]{0}, (new AspectList()).add(Aspect.TREE, 2).add(Aspect.MOTION, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootBookshelf), new int[]{0}, (new AspectList()).add(Aspect.TREE, 4).add(Aspect.MIND, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SkyrootSign), new int[]{0}, (new AspectList()).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.HolystoneFurnace), new int[]{0}, (new AspectList()).add(Aspect.EARTH, 3).add(Aspect.ENTROPY, 3).add(Aspect.FIRE, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherBlocks.SkyrootLadder), new int[]{0}, (new AspectList()).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SkyrootBed), new int[]{0}, (new AspectList()).add(Aspect.CRAFT, 3).add(Aspect.CLOTH, 6));
	}
	private static void items()
	{
		RegisterItem(ItemsAether.zanite_gemstone,  new AspectList()
				.add(Aspect.CRYSTAL, 15)
				.add(Aspect.MAGIC, 3));
		
		RegisterItem(ItemsAether.skyroot_stick, new AspectList()
				.add(Aspect.FLIGHT, 1));
		
		RegisterItem(ItemsAether.ambrosium_shard, new AspectList()
				.add(Aspect.ENERGY, 7)
				.add(Aspect.LIFE, 1)
				.add(Aspect.AIR, 5));
		
		RegisterItem(ItemsAether.swetty_ball, new AspectList()
				.add(Aspect.WATER, 5)
				.add(Aspect.AIR, 5));
		RegisterItem(ItemsAether.swet_cape, new AspectList()
				.add(Aspect.DESIRE, 25)
				.add(Aspect.MIND, 25));
				
		
		RegisterItem(ItemsAether.lore_book, new AspectList()
				.add(Aspect.MIND, 10)
				.add(Aspect.SOUL, 10));
		
		RegisterItem(ItemsAether.golden_parachute, OreDictionary.WILDCARD_VALUE, new AspectList()
				.add(Aspect.FLIGHT, 15)
				.add(Aspect.MAGIC, 5)
				.add(Aspect.DESIRE, 5));
		
		RegisterItem(ItemsAether.white_apple, new AspectList()
				.add(Aspect.PLANT, 3)
				.add(Aspect.LIFE, 3)
				.add(Aspect.MAGIC, 1));
		
//		NBTTagCompound white_moa_egg_nbt = new NBTTagCompound();
//		white_moa_egg_nbt.setInteger("typeId", 0);
//		RegisterItem(ItemsAether.moa_egg, white_moa_egg_nbt,  new AspectList()
//				.add(Aspect.LIFE, 8)
//				.add(Aspect.BEAST, 8));
//		
//		NBTTagCompound blue_moa_egg_nbt = new NBTTagCompound();
//		blue_moa_egg_nbt.setInteger("typeId", 1);
//		RegisterItem(ItemsAether.moa_egg, blue_moa_egg_nbt,  new AspectList()
//				.add(Aspect.LIFE, 9)
//				.add(Aspect.BEAST, 9));
//		
//		NBTTagCompound black_moa_egg_nbt = new NBTTagCompound();
//		black_moa_egg_nbt.setInteger("typeId", 2);
//		RegisterItem(ItemsAether.moa_egg, black_moa_egg_nbt,  new AspectList()
//				.add(Aspect.LIFE, 10)
//				.add(Aspect.BEAST, 10));
//		
//		NBTTagCompound orange_moa_egg_nbt = new NBTTagCompound();
//		orange_moa_egg_nbt.setInteger("typeId", 3);
//		RegisterItem(ItemsAether.moa_egg, orange_moa_egg_nbt,  new AspectList()
//				.add(Aspect.LIFE, 11)
//				.add(Aspect.BEAST, 11));
		
		RegisterItem(ItemsAether.moa_egg, new AspectList()
				.add(Aspect.LIFE, 8)
				.add(Aspect.BEAST, 8)
				.add(Aspect.FLIGHT, 8));
		
		RegisterItem(ItemsAether.aechor_petal, new AspectList()
				.add(Aspect.PLANT, 3)
				.add(Aspect.DESIRE, 1)
				.add(Aspect.AIR, 1));
		
		RegisterItem(ItemsAether.dart, EnumDartType.Golden.getMeta(), new AspectList()
				.add(Aspect.AVERSION, 10)
				.add(Aspect.FLIGHT, 2));
		RegisterItem(ItemsAether.dart, EnumDartType.Enchanted.getMeta(), new AspectList()
				.add(Aspect.AVERSION, 10)
				.add(Aspect.FLIGHT, 3)
				.add(Aspect.ENERGY, 2));
		RegisterItem(ItemsAether.dart, EnumDartType.Poison.getMeta(), new AspectList()
				.add(Aspect.AVERSION, 10)
				.add(Aspect.FLIGHT, 3)
				.add(Aspect.DEATH, 2));
		
		RegisterItem(ItemsAether.skyroot_bucket, EnumSkyrootBucketType.Empty.getMeta(), new AspectList()
				.add(Aspect.FLIGHT, 5)
				.add(Aspect.PLANT, 1)
				.add(Aspect.VOID, 3));
		RegisterItem(ItemsAether.skyroot_bucket, EnumSkyrootBucketType.Poison.getMeta(), new AspectList()
				.add(Aspect.FLIGHT, 5)
				.add(Aspect.PLANT, 1)
				.add(Aspect.DEATH, 5));
		
		RegisterItem(ItemsAether.blue_berry, new AspectList()
				.add(Aspect.PLANT, 6)
				.add(Aspect.LIFE, 6));
		
		RegisterItem(ItemsAether.dart_shooter, EnumDartShooterType.Golden.getMeta(), new AspectList()
				.add(Aspect.AVERSION, 12)
				.add(Aspect.FLIGHT, 6)
				.add(Aspect.DESIRE, 2));
		
		RegisterItem(ItemsAether.golden_amber, new AspectList()
				.add(Aspect.DESIRE, 5)
				.add(Aspect.TRAP, 5));

//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyrieLance), new int[]{0}, (new AspectList()).add(Aspect.METAL, 5).add(Aspect.GREED,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyriePickaxe), new int[]{0}, (new AspectList()).add(Aspect.METAL, 6).add(Aspect.GREED, 6).add(Aspect.MINE, 4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyrieShovel), new int[]{0}, (new AspectList()).add(Aspect.METAL, 4).add(Aspect.GREED, 4).add(Aspect.TOOL, 4).add(Aspect.TREE, 2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyrieAxe), new int[]{0}, (new AspectList()).add(Aspect.METAL, 6).add(Aspect.GREED, 6).add(Aspect.TOOL, 4));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.PigSlayer), new int[]{0}, (new AspectList()).add(Aspect.EARTH, 5).add(Aspect.HUNGER,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.VampireBlade), new int[]{0}, (new AspectList()).add(Aspect.METAL, 5).add(Aspect.ELDRITCH,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.FlamingSword), new int[]{0}, (new AspectList()).add(Aspect.METAL, 5).add(Aspect.FIRE,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.HolySword), new int[]{0}, (new AspectList()).add(Aspect.METAL, 5).add(Aspect.LIGHT,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.LightningSword), new int[]{0}, (new AspectList()).add(Aspect.METAL, 5).add(Aspect.WEATHER,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.LightningKnife), new int[]{0}, (new AspectList()).add(Aspect.METAL, 5).add(Aspect.WEATHER,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.HammerOfNotch), new int[]{0}, (new AspectList()).add(Aspect.METAL, 5).add(Aspect.FLIGHT,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.CandyCaneSword), new int[]{0}, (new AspectList()).add(Aspect.HUNGER, 5).add(Aspect.LIGHT,5).add(Aspect.WEAPON,4).add(Aspect.TREE, 1));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.DartShooter), new int[]{0,1,2,3}, (new AspectList()).add(Aspect.FLIGHT,2).add(Aspect.WEAPON,3).add(Aspect.TREE, 2));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.IronBubble), new int[]{0}, (new AspectList()).add(Aspect.METAL,2));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.IronRing), new int[]{0}, (new AspectList()).add(Aspect.METAL,4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.GoldenRing), new int[]{0}, (new AspectList()).add(Aspect.METAL,4).add(Aspect.GREED,2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ZaniteRing), new int[]{0}, (new AspectList()).add(Aspect.METAL,4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.IceRing), new int[]{0}, (new AspectList()).add(Aspect.COLD,4));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.IronPendant), new int[]{0}, (new AspectList()).add(Aspect.CLOTH,5).add(Aspect.METAL,1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.GoldenPendant), new int[]{0}, (new AspectList()).add(Aspect.CLOTH,5).add(Aspect.METAL,1).add(Aspect.GREED,2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ZanitePendant), new int[]{0}, (new AspectList()).add(Aspect.CLOTH,5).add(Aspect.METAL,1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.IcePendant), new int[]{0}, (new AspectList()).add(Aspect.CLOTH,5).add(Aspect.COLD,1));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.RegenerationStone), new int[]{0}, (new AspectList()).add(Aspect.LIFE,4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.PiggieBank), new int[]{0}, (new AspectList()).add(Aspect.EXCHANGE,4));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.GoldenAmber), new int[]{0}, (new AspectList()).add(Aspect.GREED,2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ContinuumOrb), new int[]{0}, (new AspectList()).add(Aspect.ELDRITCH,2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SwetJelly), new int[]{0}, (new AspectList()).add(Aspect.FLESH,1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SkyrootBowl), new int[]{0}, (new AspectList()).add(Aspect.TREE,1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.StomperPop), new int[]{0}, (new AspectList()).add(Aspect.DEATH,2));
//		
//		//ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.AetherMusicDisc), new int[]{0}, (new AspectList()).add(Aspect.GREED,4).add(Aspect.SENSES,4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.MoaMusicDisc), new int[]{0}, (new AspectList()).add(Aspect.GREED,4).add(Aspect.SENSES,4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.AerwhaleMusicDisc), new int[]{0}, (new AspectList()).add(Aspect.GREED,4).add(Aspect.SENSES,4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.LabyrinthMusicDisc), new int[]{0}, (new AspectList()).add(Aspect.GREED,4).add(Aspect.SENSES,4));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyrieMusicDisc), new int[]{0}, (new AspectList()).add(Aspect.GREED,4).add(Aspect.SENSES,4));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SkyrootWaterBucket), new int[]{0}, (new AspectList()).add(Aspect.WATER,4).add(Aspect.TREE,8).add(Aspect.VOID,1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SkyrootPoisonBucket), new int[]{0}, (new AspectList()).add(Aspect.POISON,4).add(Aspect.TREE,8).add(Aspect.VOID,1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SkyrootMilkBucket), new int[]{0}, (new AspectList()).add(Aspect.WATER,2).add(Aspect.HUNGER,2).add(Aspect.TREE,8).add(Aspect.HEAL,2).add(Aspect.VOID,1));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.OrbOfArkenzus), new int[]{0}, (new AspectList()).add(Aspect.LIFE,8));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.PinkBabySwet), new int[]{0}, (new AspectList()).add(Aspect.LIFE,8));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.EtherealStone), new int[]{0}, (new AspectList()).add(Aspect.LIFE,8));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.FleetingStone), new int[]{0}, (new AspectList()).add(Aspect.LIFE,8));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.FangrinCapsule), new int[]{0}, (new AspectList()).add(Aspect.LIFE,8));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.DeathSeal), new int[]{0}, (new AspectList()).add(Aspect.LIFE,8));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.KraisithCapsule), new int[]{0}, (new AspectList()).add(Aspect.LIFE,8));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SoaringStone), new int[]{0}, (new AspectList()).add(Aspect.LIFE,8));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ZaniteHelmet), new int[]{0}, (new AspectList()).add(Aspect.METAL,6).add(Aspect.ARMOR,2));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ZaniteChestplate), new int[]{0}, (new AspectList()).add(Aspect.METAL,6).add(Aspect.ARMOR,5));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ZaniteLeggings), new int[]{0}, (new AspectList()).add(Aspect.METAL,6).add(Aspect.ARMOR,5));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ZaniteBoots), new int[]{0}, (new AspectList()).add(Aspect.METAL,6).add(Aspect.ARMOR,2));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.GravititeHelmet), new int[]{0}, (new AspectList()).add(Aspect.GREED,6).add(Aspect.METAL,6).add(Aspect.ARMOR,3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.GravititeChestplate), new int[]{0}, (new AspectList()).add(Aspect.GREED,5).add(Aspect.METAL,5).add(Aspect.ARMOR,5));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.GravititeLeggings), new int[]{0}, (new AspectList()).add(Aspect.GREED,6).add(Aspect.METAL,6).add(Aspect.ARMOR,6));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.GravititeBoots), new int[]{0}, (new AspectList()).add(Aspect.GREED,5).add(Aspect.METAL,3).add(Aspect.ARMOR,5));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ObsidianHelmet), new int[]{0}, (new AspectList()).add(Aspect.EARTH,6).add(Aspect.METAL,6).add(Aspect.ARMOR,3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ObsidianChestplate), new int[]{0}, (new AspectList()).add(Aspect.EARTH,5).add(Aspect.METAL,5).add(Aspect.ARMOR,5));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ObsidianLeggings), new int[]{0}, (new AspectList()).add(Aspect.EARTH,6).add(Aspect.METAL,6).add(Aspect.ARMOR,6));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ObsidianBoots), new int[]{0}, (new AspectList()).add(Aspect.EARTH,5).add(Aspect.METAL,3).add(Aspect.ARMOR,5));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ObsidianHelmet), new int[]{0}, (new AspectList()).add(Aspect.EARTH,6).add(Aspect.METAL,6).add(Aspect.ARMOR,3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ObsidianChestplate), new int[]{0}, (new AspectList()).add(Aspect.EARTH,5).add(Aspect.METAL,5).add(Aspect.ARMOR,5));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ObsidianLeggings), new int[]{0}, (new AspectList()).add(Aspect.EARTH,6).add(Aspect.METAL,6).add(Aspect.ARMOR,6));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ObsidianBoots), new int[]{0}, (new AspectList()).add(Aspect.EARTH,5).add(Aspect.METAL,3).add(Aspect.ARMOR,5));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.PhoenixHelmet), new int[]{0}, (new AspectList()).add(Aspect.FIRE,6).add(Aspect.METAL,6).add(Aspect.ARMOR,3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.PhoenixChestplate), new int[]{0}, (new AspectList()).add(Aspect.FIRE,5).add(Aspect.METAL,5).add(Aspect.ARMOR,5));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.PhoenixLeggings), new int[]{0}, (new AspectList()).add(Aspect.FIRE,6).add(Aspect.METAL,6).add(Aspect.ARMOR,6));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.PhoenixBoots), new int[]{0}, (new AspectList()).add(Aspect.FIRE,5).add(Aspect.METAL,3).add(Aspect.ARMOR,5));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.NeptuneHelmet), new int[]{0}, (new AspectList()).add(Aspect.WATER,6).add(Aspect.METAL,6).add(Aspect.ARMOR,3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.NeptuneChestplate), new int[]{0}, (new AspectList()).add(Aspect.WATER,5).add(Aspect.METAL,5).add(Aspect.ARMOR,5));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.NeptuneLeggings), new int[]{0}, (new AspectList()).add(Aspect.WATER,6).add(Aspect.METAL,6).add(Aspect.ARMOR,6));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.NeptuneBoots), new int[]{0}, (new AspectList()).add(Aspect.WATER,5).add(Aspect.METAL,3).add(Aspect.ARMOR,5));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyrieHelmet), new int[]{0}, (new AspectList()).add(Aspect.AIR,6).add(Aspect.METAL,6).add(Aspect.ARMOR,3));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyrieChestplate), new int[]{0}, (new AspectList()).add(Aspect.AIR,5).add(Aspect.METAL,5).add(Aspect.ARMOR,5));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyrieLeggings), new int[]{0}, (new AspectList()).add(Aspect.AIR,6).add(Aspect.METAL,6).add(Aspect.ARMOR,6));
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.ValkyrieBoots), new int[]{0}, (new AspectList()).add(Aspect.AIR,5).add(Aspect.METAL,3).add(Aspect.ARMOR,5));
//		
//		ThaumcraftApi.registerObjectTag(new ItemStack(AetherItems.SentryBoots), new int[]{0}, (new AspectList()).add(Aspect.BEAST,5).add(Aspect.METAL,3).add(Aspect.ARMOR,5));	
	}
	
	private static void mobs()
	{
		// PASSIVE
		RegisterEntity("phyg", new AspectList()
				.add(Aspect.BEAST, 10)
				.add(Aspect.FLIGHT, 10));
		RegisterEntity("moa", new AspectList()
				.add(Aspect.BEAST, 15)
				.add(Aspect.MOTION, 15));
		RegisterEntity("flying_cow", new AspectList()
				.add(Aspect.BEAST, 15)
				.add(Aspect.FLIGHT, 15));
		RegisterEntity("sheepuff", new AspectList()
				.add(Aspect.BEAST, 10)
				.add(Aspect.AIR, 5)
				.add(Aspect.CRAFT, 5));
		RegisterEntity("aerbunny", new AspectList()
				.add(Aspect.BEAST, 5)
				.add(Aspect.AIR, 5)
				.add(Aspect.MOTION, 5));
		RegisterEntity("aerwhale", new AspectList()
				.add(Aspect.FLIGHT, 10)
				.add(Aspect.AIR, 10)
				.add(Aspect.BEAST, 25));
		
		// NEUTRAL
		RegisterEntity("mimic", new AspectList()
				.add(Aspect.TRAP, 10)
				.add(Aspect.MAGIC, 10)
				.add(Aspect.DARKNESS, 10));
		RegisterEntity("valkyrie", new AspectList()
				.add(Aspect.MAN, 15)
				.add(Aspect.SOUL, 15));
		
		// HOSTILE
		RegisterEntity("cockatrice", new AspectList()
				.add(Aspect.BEAST, 10)
				.add(Aspect.DEATH, 5)
				.add(Aspect.FLUX, 5));
		RegisterEntity("zephyr", new AspectList()
				.add(Aspect.COLD, 15)
				.add(Aspect.FLIGHT, 15));
		RegisterEntity("sentry", new AspectList()
				.add(Aspect.EARTH, 10)
				.add(Aspect.MECHANISM, 10));
		RegisterEntity("swet", new AspectList()
				.add(Aspect.WATER, 10)
				.add(Aspect.MOTION, 10)
				.add(Aspect.TRAP, 10));
		RegisterEntity("aechor_plant", new AspectList()
				.add(Aspect.PLANT, 10)
				.add(Aspect.DEATH, 5)
				.add(Aspect.FLUX, 5));
		RegisterEntity("whirlwind", new AspectList()
				.add(Aspect.ENTROPY, 5)
				.add(Aspect.AIR, 5)
				.add(Aspect.EXCHANGE, 10));
		
		
		//BOSSES
		RegisterEntity("slider", new AspectList()
				.add(Aspect.MECHANISM, 30)
				.add(Aspect.SENSES, 5)
				.add(Aspect.AVERSION, 10)
				.add(Aspect.PROTECT, 10)
				.add(Aspect.MOTION, 10));
		RegisterEntity("valkyrie_queen", new AspectList()
				.add(Aspect.MAN, 25)
				.add(Aspect.SOUL, 25)
				.add(Aspect.AVERSION, 20)
				.add(Aspect.DESIRE, 15));
		RegisterEntity("fire_minion", new AspectList()
				.add(Aspect.FIRE, 15)
				.add(Aspect.PROTECT, 15));
		RegisterEntity("sun_spirit", new AspectList()
				.add(Aspect.FIRE, 20)
				.add(Aspect.AVERSION, 30)
				.add(Aspect.ORDER, 20));
	}
	
	private static void RegisterBlock(Block b, AspectList aspects)
	{
		ItemStack stack = new ItemStack(b);
		if (ThaumcraftApi.exists(stack))
		{
			ThaumcraftAethermancyMod.logger.log(Level.WARN, "Attemped to Re-Register Block: "+b.getLocalizedName());
			return;
		}
		event.register.registerObjectTag(stack, aspects);
	}
	
	private static void RegisterBlock(Block b, int meta_data, AspectList list)
	{
		ItemStack stack = new ItemStack(b, 1, meta_data);
		if (ThaumcraftApi.exists(stack))
		{
			ThaumcraftAethermancyMod.logger.log(Level.WARN, "Attemped to Re-Register Block: "+b.getLocalizedName());
			return;
		}
		event.register.registerObjectTag(stack, list);
	}

	/**
	 * Will register the block with each specified meta data.
	 * @param b The block to register
	 * @param meta_data The meta data
	 * @param list The list of aspects to apply to each block+meta data
	 */
    private static void RegisterBlock(Block b, int[] meta_data, AspectList list) 
    {
        for (int meta : meta_data) RegisterBlock(b, meta, list);
    }
	
	private static void RegisterItem(Item i, AspectList aspects)
	{
		ItemStack stack = new ItemStack(i);
		if (ThaumcraftApi.exists(stack))
		{
			ThaumcraftAethermancyMod.logger.log(Level.WARN, "Attemped to Re-Register Item: "+i.getUnlocalizedName());
			return;
		}
		event.register.registerObjectTag(stack, aspects);
	}
	
	private static void RegisterItem(Item i, int meta_data, AspectList aspects)
	{
		ItemStack stack = new ItemStack(i, 1, meta_data);
		if (ThaumcraftApi.exists(stack))
		{
			ThaumcraftAethermancyMod.logger.log(Level.WARN, "Attemped to Re-Register Item: "+i.getUnlocalizedName());
			return;
		}
		event.register.registerObjectTag(stack, aspects);
	}
	
	private static void RegisterItem(Item i, NBTTagCompound nbts, AspectList aspects)
	{
		ItemStack stack = new ItemStack(i, 1, 0, nbts);
		if (ThaumcraftApi.exists(stack))
		{
			ThaumcraftAethermancyMod.logger.log(Level.WARN, "Attemped to Re-Register Item: "+i.getUnlocalizedName());
			return;
		}
		event.register.registerObjectTag(stack, aspects);
	}
	
	private static void RegisterEntity(String entity_name, AspectList aspects)
	{
		ThaumcraftApi.EntityTags tags = new ThaumcraftApi.EntityTags(entity_name, aspects);
		CommonInternals.scanEntities.add(tags);
	}
}
