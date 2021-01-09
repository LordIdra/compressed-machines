package me.idra.compressedmachines;



import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.multiblocks.EnhancedCraftingTable;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import misc_items.InformationItem;
import slimefun_machines.CompressedX4AutoDrier;
import slimefun_machines.CompressedX8AutoDrier;
import slimefun_machines.CompressedElectricDustWasher;
import slimefun_machines.CompressedElectricGoldPan;
import slimefun_machines.CompressedElectricSmeltery;



public class CompressedMachines extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
    	
        // Read the config file
        //Config cfg = new Config(this);

    	
        // Create a category to put our items into
        ItemStack categoryItem = new CustomItem(Material.OBSIDIAN, "Compressed Machines", "", "&aSpace and lag efficient machine variants");
        NamespacedKey categoryId = new NamespacedKey(this, "compressed_machines");
        Category category = new Category(categoryId, categoryItem);
        
        
        // Display an arbitrary item to tell the players that they can deconstruct machines in an enhanced crafting table
        SlimefunItemStack COMPRESSED_INFORMATION_ITEM = new SlimefunItemStack(
        		"COMPRESSED_INFORMATION_ITEM",
        		Material.NETHER_STAR,
        		"&4&lINFORMATION",
        		"&aCompressed machines can be converted back into their", "&anormal variants by putting them in the &2&lfirst slot &aof an", "&aenhanced crafting table");
        ItemStack[] COMPRESSED_INFORMATION_RECIPE = { 
        		null, null, null,
        		null, null, null,
        		null, null, null
        };
        
        InformationItem COMPRESSED_INFORMATION = new InformationItem(
        		category, 
        		COMPRESSED_INFORMATION_ITEM,
        		RecipeType.NULL, 
        		COMPRESSED_INFORMATION_RECIPE);
        
        COMPRESSED_INFORMATION.register(this);
        
        
        // Load the SF items we're going to compress
        ItemStack auto_drier = SlimefunItems.AUTO_DRIER;
        ItemStack carbon_press = SlimefunItems.CARBON_PRESS_3;
        ItemStack dust_washer = SlimefunItems.ELECTRIC_DUST_WASHER_3;
        ItemStack furnace = SlimefunItems.ELECTRIC_FURNACE_3;
        ItemStack gold_pan = SlimefunItems.ELECTRIC_GOLD_PAN_3;
        ItemStack ingot_factory = SlimefunItems.ELECTRIC_INGOT_FACTORY_3;
        ItemStack ingot_pulverizer = SlimefunItems.ELECTRIC_INGOT_PULVERIZER;
        ItemStack ore_grinder = SlimefunItems.ELECTRIC_ORE_GRINDER_2;
        ItemStack press = SlimefunItems.ELECTRIC_PRESS_2;
        ItemStack smeltery = SlimefunItems.ELECTRIC_SMELTERY_2;
        ItemStack crucible = SlimefunItems.ELECTRIFIED_CRUCIBLE_3;
        ItemStack food_composter = SlimefunItems.FOOD_COMPOSTER_2;
        ItemStack food_fabricator = SlimefunItems.FOOD_FABRICATOR_2;
        ItemStack geo_miner = SlimefunItems.GEO_MINER;
        ItemStack heated_pressure_chamber = SlimefunItems.HEATED_PRESSURE_CHAMBER_2;
        ItemStack oil_pump = SlimefunItems.OIL_PUMP;
        ItemStack refinery = SlimefunItems.REFINERY;

        
        
        
        
        
        

        /*
         * 
         *  
         *  MACHINE REPRESENTATIONS
         *  
         *  
         */
        
        /*
         * AUTO DRIERS
         */
        
        SlimefunItemStack ITEM_X4_COMPRESSED_AUTO_DRIER = new SlimefunItemStack(
        		"COMPRESSED_AUTO_DRIER_4",
        		Material.SMOKER,
        		"&7&l[&2&l4x&7&l] &r&6Auto Drier",
        		"", "&5Compressed Machine", LoreBuilder.speed(1), LoreBuilder.powerPerSecond(48));
        SlimefunItemStack ITEM_X8_COMPRESSED_AUTO_DRIER = new SlimefunItemStack(
        		"COMPRESSED_AUTO_DRIER_8",
        		Material.SMOKER,
        		"&7&l[&2&l8x&7&l] &r&6Auto Drier",
        		"", "&5Compressed Machine", LoreBuilder.speed(1), LoreBuilder.powerPerSecond(96));
        
        
        /*
         * GOLD PANS
         */
        
        SlimefunItemStack ITEM_X4_COMPRESSED_GOLD_PAN = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_GOLD_PAN_4",
        		Material.BROWN_TERRACOTTA,
        		"&7&l[&2&l4x&7&l] &r&6Electric Gold Pan &7(&eIII&7)",
        		"", "&5Compressed Machine", LoreBuilder.speed(10), LoreBuilder.powerPerSecond(56));
        SlimefunItemStack ITEM_X8_COMPRESSED_GOLD_PAN = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_GOLD_PAN_8",
        		Material.BROWN_TERRACOTTA,
        		"&7&l[&2&l8x&7&l] &r&6Electric Gold Pan &7(&eIII&7)",
        		"", "&5Compressed Machine", LoreBuilder.speed(10), LoreBuilder.powerPerSecond(112));
        
        
        /*
         * DUST WASHERS
         */
        
        SlimefunItemStack ITEM_X4_COMPRESSED_DUST_WASHER = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_DUST_WASHER_4",
        		Material.BLUE_STAINED_GLASS,
        		"&7&l[&2&l4x&7&l] &r&9Electric Dust Washer &7(&eIII&7)",
        		"", "&5Compressed Machine", LoreBuilder.speed(10), LoreBuilder.powerPerSecond(120));
        SlimefunItemStack ITEM_X8_COMPRESSED_DUST_WASHER = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_DUST_WASHER_8",
        		Material.BLUE_STAINED_GLASS,
        		"&7&l[&2&l8x&7&l] &r&9Electric Dust Washer &7(&eIII&7)",
        		"", "&5Compressed Machine", LoreBuilder.speed(10), LoreBuilder.powerPerSecond(240));
        
        
        /*
         * SMELTERIES
         */
        
        SlimefunItemStack ITEM_X4_COMPRESSED_SMELTERY = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_SMELTERY_4",
        		Material.FURNACE,
        		"&7&l[&2&l4x&7&l] &r&cElectric Smeltery &7 - &eII",
        		"", "&4Alloys only, doesn't smelt Dust into Ingots", "", "&5Compressed Machine", LoreBuilder.speed(3), LoreBuilder.powerPerSecond(160));
        SlimefunItemStack ITEM_X8_COMPRESSED_SMELTERY = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_SMELTERY_8",
        		Material.FURNACE,
        		"&7&l[&2&l8x&7&l] &r&cElectric Smeltery &7 - &eII",
        		"", "&4Alloys only, doesn't smelt Dust into Ingots", "", "&5Compressed Machine", LoreBuilder.speed(3), LoreBuilder.powerPerSecond(320));
        
        
        
        
        
        
        
        /*
         * 
         *  
         *  CRAFTING RECIPES
         *  
         *  
         */
        
        /*
         * AUTO DRIER
         */
        
        ItemStack[] RECIPE_X4_COMPRESSED_AUTO_DRIER = { 
        		auto_drier, auto_drier, null, 
        		auto_drier, auto_drier, null, 
        		null,	  null, 	null 
        };
        ItemStack[] RECIPE_X8_COMPRESSED_AUTO_DRIER = { 
        		auto_drier, auto_drier, auto_drier, 
        		auto_drier, null,	 	auto_drier, 
        		auto_drier, auto_drier, auto_drier 
        };
        
        
        /*
         * GOLD PANS
         */
        
        ItemStack[] RECIPE_X4_COMPRESSED_GOLD_PAN = { 
        		gold_pan, gold_pan, null, 
        		gold_pan, gold_pan, null, 
        		null,	  null, 	null 
        };
        ItemStack[] RECIPE_X8_COMPRESSED_GOLD_PAN = { 
        		gold_pan, gold_pan, gold_pan, 
        		gold_pan, null,	 	gold_pan, 
        		gold_pan, gold_pan, gold_pan 
        };
        
        
        /*
         * DUST WASHERS
         */
        
        ItemStack[] RECIPE_X4_COMPRESSED_DUST_WASHER = { 
        		dust_washer, dust_washer, null, 
        		dust_washer, dust_washer, null, 
        		null,	  null, 	null 
        };
        ItemStack[] RECIPE_X8_COMPRESSED_DUST_WASHER = { 
        		dust_washer, dust_washer, dust_washer,
        		dust_washer, null, 		  dust_washer,
        		dust_washer, dust_washer, dust_washer
        };
        
        
        /*
         * SMELTERIES
         */
        
        ItemStack[] RECIPE_X4_COMPRESSED_SMELTERY = { 
        		smeltery, smeltery, null, 
        		smeltery, smeltery, null, 
        		null,	  null, 	null 
        };
        ItemStack[] RECIPE_X8_COMPRESSED_SMELTERY = { 
        		smeltery, smeltery, smeltery,
        		smeltery, null, 	smeltery,
        		smeltery, smeltery, smeltery
        };
        
        
        
        
        
        
        
        
        /*
         * 
         *  
         *  FINAL OBJECTS
         *  
         *  
         */

        /*
         * AUTO DRIERS
         */
        
        CompressedX4AutoDrier X4_COMPRESSED_AUTO_DRIER = new CompressedX4AutoDrier(
        		category, 
        		ITEM_X4_COMPRESSED_AUTO_DRIER, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		RECIPE_X4_COMPRESSED_AUTO_DRIER);
        
        CompressedX8AutoDrier X8_COMPRESSED_AUTO_DRIER = new CompressedX8AutoDrier(
        		category, 
        		ITEM_X8_COMPRESSED_AUTO_DRIER, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		RECIPE_X8_COMPRESSED_AUTO_DRIER);
        
        X4_COMPRESSED_AUTO_DRIER.setCapacity(500);
        X4_COMPRESSED_AUTO_DRIER.setEnergyConsumption(48);
        X4_COMPRESSED_AUTO_DRIER.setProcessingSpeed(1);
        
        X8_COMPRESSED_AUTO_DRIER.setCapacity(1000);
        X8_COMPRESSED_AUTO_DRIER.setEnergyConsumption(96);
        X8_COMPRESSED_AUTO_DRIER.setProcessingSpeed(1);
        
        
        /*
         * GOLD PANS
         */
        
        CompressedElectricGoldPan X4_COMPRESSED_GOLD_PAN = new CompressedElectricGoldPan(
        		category, 
        		ITEM_X4_COMPRESSED_GOLD_PAN, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		RECIPE_X4_COMPRESSED_GOLD_PAN, 
        		4);
        
        CompressedElectricGoldPan X8_COMPRESSED_GOLD_PAN = new CompressedElectricGoldPan(
        		category, 
        		ITEM_X8_COMPRESSED_GOLD_PAN, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		RECIPE_X8_COMPRESSED_GOLD_PAN, 
        		8);
        
        X4_COMPRESSED_GOLD_PAN.setCapacity(500);
        X4_COMPRESSED_GOLD_PAN.setEnergyConsumption(56);
        X4_COMPRESSED_GOLD_PAN.setProcessingSpeed(10);
        
        X8_COMPRESSED_GOLD_PAN.setCapacity(1000);
        X8_COMPRESSED_GOLD_PAN.setEnergyConsumption(112);
        X8_COMPRESSED_GOLD_PAN.setProcessingSpeed(10);
        
        
        /*
         * DUST WASHERS
         */
        
        CompressedElectricDustWasher X4_COMPRESSED_DUST_WASHER = new CompressedElectricDustWasher(
        		category, 
        		ITEM_X4_COMPRESSED_DUST_WASHER, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		RECIPE_X4_COMPRESSED_DUST_WASHER, 
        		4);
        
        CompressedElectricDustWasher X8_COMPRESSED_DUST_WASHER = new CompressedElectricDustWasher(
        		category, 
        		ITEM_X8_COMPRESSED_DUST_WASHER, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		RECIPE_X8_COMPRESSED_DUST_WASHER, 
        		8);
        
        X4_COMPRESSED_DUST_WASHER.setCapacity(500);
        X4_COMPRESSED_DUST_WASHER.setEnergyConsumption(120);
        X4_COMPRESSED_DUST_WASHER.setProcessingSpeed(10);
        
        X8_COMPRESSED_DUST_WASHER.setCapacity(1000);
        X8_COMPRESSED_DUST_WASHER.setEnergyConsumption(240);
        X8_COMPRESSED_DUST_WASHER.setProcessingSpeed(10);

        
        /*
         * SMELTERIES
         */
        
        CompressedElectricSmeltery X4_COMPRESSED_SMELTERY = new CompressedElectricSmeltery(
        		category, 
        		ITEM_X4_COMPRESSED_SMELTERY, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		RECIPE_X4_COMPRESSED_SMELTERY, 
        		4);
        
        CompressedElectricSmeltery X8_COMPRESSED_SMELTERY = new CompressedElectricSmeltery(
        		category, 
        		ITEM_X8_COMPRESSED_SMELTERY, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		RECIPE_X8_COMPRESSED_SMELTERY,
        		8);
        
        X4_COMPRESSED_SMELTERY.setCapacity(500);
        X4_COMPRESSED_SMELTERY.setEnergyConsumption(160);
        X4_COMPRESSED_SMELTERY.setProcessingSpeed(3);
        
        X8_COMPRESSED_SMELTERY.setCapacity(1000);
        X8_COMPRESSED_SMELTERY.setEnergyConsumption(320);
        X8_COMPRESSED_SMELTERY.setProcessingSpeed(3);
        
        
        
        // Add the items to slimefun
        ((SlimefunItem)X4_COMPRESSED_AUTO_DRIER).register(this);
        ((SlimefunItem)X8_COMPRESSED_AUTO_DRIER).register(this);
        
        ((SlimefunItem)X4_COMPRESSED_GOLD_PAN).register(this);
        ((SlimefunItem)X8_COMPRESSED_GOLD_PAN).register(this);
        
        ((SlimefunItem)X4_COMPRESSED_DUST_WASHER).register(this);
        ((SlimefunItem)X8_COMPRESSED_DUST_WASHER).register(this);
        
        ((SlimefunItem)X4_COMPRESSED_SMELTERY).register(this);
        ((SlimefunItem)X8_COMPRESSED_SMELTERY).register(this);
        
        
        
        
        
        
        
        
        /*
         * 
         * 
         * REGISTER DECONSTRUCTION RECIPES
         *  
         *  
         */
        
        SlimefunItemStack output;
        ItemStack[] input;
        
        
        output = new SlimefunItemStack(SlimefunItems.AUTO_DRIER, 8);
        input = new ItemStack[] { ITEM_X4_COMPRESSED_AUTO_DRIER, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        output = new SlimefunItemStack(SlimefunItems.AUTO_DRIER, 8);
        input = new ItemStack[] { ITEM_X8_COMPRESSED_AUTO_DRIER, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_DUST_WASHER_3, 8);
        input = new ItemStack[] { ITEM_X4_COMPRESSED_DUST_WASHER, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_DUST_WASHER_3, 8);
        input = new ItemStack[] { ITEM_X8_COMPRESSED_DUST_WASHER, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_GOLD_PAN_3, 8);
        input = new ItemStack[] { ITEM_X4_COMPRESSED_GOLD_PAN, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_GOLD_PAN_3, 8);
        input = new ItemStack[] { ITEM_X8_COMPRESSED_GOLD_PAN, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_SMELTERY_2, 8);
        input = new ItemStack[] { ITEM_X4_COMPRESSED_SMELTERY, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_SMELTERY_2, 8);
        input = new ItemStack[] { ITEM_X8_COMPRESSED_SMELTERY, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
    }

    @Override
    public void onDisable() {
        // no tasks
    }

    @Override
    public String getBugTrackerURL() {
        return "github.com/LordIdra/CompressedMachines/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
