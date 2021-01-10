package me.idra.compressedmachines;



import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import other.InformationItem;
import slimefunmachines.CompressedElectricDustWasher;
import slimefunmachines.CompressedElectricGoldPan;
import slimefunmachines.CompressedElectricSmeltery;
import slimefunmachines.CompressedX4AutoDrier;
import slimefunmachines.CompressedX8AutoDrier;



public class CompressedMachines extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
    	
        // Read the config file
        @SuppressWarnings("unused")
		Config cfg = new Config(this);

    	
        // Create a category to put our items into
        ItemStack categoryItem = new CustomItem(Material.OBSIDIAN, "Compressed Machines", "", "&aSpace and lag efficient machine variants");
        NamespacedKey categoryId = new NamespacedKey(this, "compressed_machines");
        Category category = new Category(categoryId, categoryItem);
        String categoryName = "&5Compressed Machine";
        
        
        // Display an arbitrary item to tell the players that they can deconstruct machines in an enhanced crafting table
        SlimefunItemStack compressedInformationItem = new SlimefunItemStack(
        		"COMPRESSED_INFORMATION_ITEM",
        		Material.NETHER_STAR,
        		"&4&lINFORMATION",
        		"&aCompressed machines can be converted back into their", "&anormal variants by putting them in the &2&lfirst slot &aof an", "&aenhanced crafting table");
        ItemStack[] compressedInformationRecipe = { 
        		null, null, null,
        		null, null, null,
        		null, null, null
        };
        
        InformationItem compressedInformation = new InformationItem(
        		category, 
        		compressedInformationItem,
        		RecipeType.NULL, 
        		compressedInformationRecipe);
        
        compressedInformation.register(this);
        
        
        // Load the SF items we're going to compress
        
        /* 
         * MACHINES TO BE ADDED
         * 
         * ELECTRIC_FURNACE_3
         * ELECTRIC_INGOT_FACTORY_3
         * ELECTRIC_INGOT_PULVERIZER
         * ELECTRIC_ORE_GRINDER_2
         * ELECTRIC_PRESS_2
         * ELECTRIFIED_CRUCIBLE_3
         * FOOD_COMPOSTER_2
         * FOOD_FABRICATOR_2
         * GEO_MINER
         * HEATED_PRESSURE_CHAMBER_2
         * OIL_PUMP
         * REFINERY
         */
        
        ItemStack autoDrier = SlimefunItems.AUTO_DRIER;
        ItemStack carbonPress = SlimefunItems.CARBON_PRESS_3;
        ItemStack dustWasher = SlimefunItems.ELECTRIC_DUST_WASHER_3;
        ItemStack goldPan = SlimefunItems.ELECTRIC_GOLD_PAN_3;
        ItemStack smeltery = SlimefunItems.ELECTRIC_SMELTERY_2;
        
        
        
        

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
        
        SlimefunItemStack itemCompressedAutoDrier4 = new SlimefunItemStack(
        		"COMPRESSED_AUTO_DRIER_4",
        		Material.SMOKER,
        		"&7&l[&2&l4x&7&l] &r&6Auto Drier",
        		"", categoryName, LoreBuilder.speed(1), LoreBuilder.powerPerSecond(48));
        SlimefunItemStack itemCompressedAutoDrier8 = new SlimefunItemStack(
        		"COMPRESSED_AUTO_DRIER_8",
        		Material.SMOKER,
        		"&7&l[&2&l8x&7&l] &r&6Auto Drier",
        		"", categoryName, LoreBuilder.speed(1), LoreBuilder.powerPerSecond(96));
        
        
        /*
         * CARBON PRESSES
         */
        
        SlimefunItemStack itemCompressedCarbonPress4 = new SlimefunItemStack(
        		"COMPRESSED_AUTO_DRIER_4",
        		Material.SMOKER,
        		"&7&l[&2&l4x&7&l] &r&6Auto Drier",
        		"", categoryName, LoreBuilder.speed(1), LoreBuilder.powerPerSecond(48));
        SlimefunItemStack itemCompressedCarbonPress8 = new SlimefunItemStack(
        		"COMPRESSED_AUTO_DRIER_8",
        		Material.SMOKER,
        		"&7&l[&2&l8x&7&l] &r&6Auto Drier",
        		"", categoryName, LoreBuilder.speed(1), LoreBuilder.powerPerSecond(96));
        
        
        /*
         * GOLD PANS
         */
        
        SlimefunItemStack itemCompressedGoldPan4 = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_GOLD_PAN_4",
        		Material.BROWN_TERRACOTTA,
        		"&7&l[&2&l4x&7&l] &r&6Electric Gold Pan &7(&eIII&7)",
        		"", categoryName, LoreBuilder.speed(10), LoreBuilder.powerPerSecond(56));
        SlimefunItemStack itemCompressedGoldPan8 = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_GOLD_PAN_8",
        		Material.BROWN_TERRACOTTA,
        		"&7&l[&2&l8x&7&l] &r&6Electric Gold Pan &7(&eIII&7)",
        		"", categoryName, LoreBuilder.speed(10), LoreBuilder.powerPerSecond(112));
        
        
        /*
         * DUST WASHERS
         */
        
        SlimefunItemStack itemCompressedDustWasher4 = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_DUST_WASHER_4",
        		Material.BLUE_STAINED_GLASS,
        		"&7&l[&2&l4x&7&l] &r&9Electric Dust Washer &7(&eIII&7)",
        		"", categoryName, LoreBuilder.speed(10), LoreBuilder.powerPerSecond(120));
        SlimefunItemStack itemCompressedDustWasher8 = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_DUST_WASHER_8",
        		Material.BLUE_STAINED_GLASS,
        		"&7&l[&2&l8x&7&l] &r&9Electric Dust Washer &7(&eIII&7)",
        		"", categoryName, LoreBuilder.speed(10), LoreBuilder.powerPerSecond(240));
        
        
        /*
         * SMELTERIES
         */
        
        SlimefunItemStack itemCompressedSmeltery4 = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_SMELTERY_4",
        		Material.FURNACE,
        		"&7&l[&2&l4x&7&l] &r&cElectric Smeltery &7 - &eII",
        		"", "&4Alloys only, doesn't smelt Dust into Ingots", "", categoryName, LoreBuilder.speed(3), LoreBuilder.powerPerSecond(160));
        SlimefunItemStack itemCompressedSmeltery8 = new SlimefunItemStack(
        		"COMPRESSED_ELECTRIC_SMELTERY_8",
        		Material.FURNACE,
        		"&7&l[&2&l8x&7&l] &r&cElectric Smeltery &7 - &eII",
        		"", "&4Alloys only, doesn't smelt Dust into Ingots", "", categoryName, LoreBuilder.speed(3), LoreBuilder.powerPerSecond(320));
        
        
        
        
        
        
        
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
        
        ItemStack[] recipeCompressedAutoDrier4 = { 
        		autoDrier, autoDrier, null, 
        		autoDrier, autoDrier, null, 
        		null,	  null, 	null 
        };
        ItemStack[] recipeCompressedAutoDrier8 = { 
        		autoDrier, autoDrier, autoDrier, 
        		autoDrier, null,	  autoDrier, 
        		autoDrier, autoDrier, autoDrier 
        };
        
        
        /*
         * GOLD PANS
         */
        
        ItemStack[] recipeCompressedGoldPan4 = { 
        		goldPan, goldPan, null, 
        		goldPan, goldPan, null, 
        		null,	  null, 	null 
        };
        ItemStack[] recipeCompressedGoldPan8 = { 
        		goldPan, goldPan, goldPan, 
        		goldPan, null,	 	goldPan, 
        		goldPan, goldPan, goldPan 
        };
        
        
        /*
         * DUST WASHERS
         */
        
        ItemStack[] recipeCompressedDustWasher4 = { 
        		dustWasher, dustWasher, null, 
        		dustWasher, dustWasher, null, 
        		null,	  null, 	null 
        };
        ItemStack[] recipeCompressedDustWasher8 = { 
        		dustWasher, dustWasher, dustWasher,
        		dustWasher, null, 		  dustWasher,
        		dustWasher, dustWasher, dustWasher
        };
        
        
        /*
         * SMELTERIES
         */
        
        ItemStack[] recipeCompressedSmeltery4 = { 
        		smeltery, smeltery, null, 
        		smeltery, smeltery, null, 
        		null,	  null, 	null 
        };
        ItemStack[] recipeCompressedSmeltery8 = { 
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
        
        CompressedX4AutoDrier compressedAutoDrier4 = new CompressedX4AutoDrier(
        		category, 
        		itemCompressedAutoDrier4, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		recipeCompressedAutoDrier4);
        
        CompressedX8AutoDrier compressedAutoDrier8 = new CompressedX8AutoDrier(
        		category, 
        		itemCompressedAutoDrier8, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		recipeCompressedAutoDrier8);
        
        compressedAutoDrier4.setCapacity(500);
        compressedAutoDrier4.setEnergyConsumption(48);
        compressedAutoDrier4.setProcessingSpeed(2);
        
        compressedAutoDrier8.setCapacity(1000);
        compressedAutoDrier8.setEnergyConsumption(96);
        compressedAutoDrier8.setProcessingSpeed(2);
        
        
        /*
         * GOLD PANS
         */
        
        CompressedElectricGoldPan compressedGoldPan4 = new CompressedElectricGoldPan(
        		category, 
        		itemCompressedGoldPan4, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		recipeCompressedGoldPan4, 
        		4);
        
        CompressedElectricGoldPan compressedGoldPan8 = new CompressedElectricGoldPan(
        		category, 
        		itemCompressedGoldPan8, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		recipeCompressedGoldPan8, 
        		8);
        
        compressedGoldPan4.setCapacity(500);
        compressedGoldPan4.setEnergyConsumption(56);
        compressedGoldPan4.setProcessingSpeed(16);
        
        compressedGoldPan8.setCapacity(1000);
        compressedGoldPan8.setEnergyConsumption(112);
        compressedGoldPan8.setProcessingSpeed(16);
        
        
        /*
         * DUST WASHERS
         */
        
        CompressedElectricDustWasher compressedDustWasher4 = new CompressedElectricDustWasher(
        		category, 
        		itemCompressedDustWasher4, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		recipeCompressedDustWasher4, 
        		4);
        
        CompressedElectricDustWasher compressedDustWasher8 = new CompressedElectricDustWasher(
        		category, 
        		itemCompressedDustWasher8, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		recipeCompressedDustWasher8, 
        		8);
        
        compressedDustWasher4.setCapacity(500);
        compressedDustWasher4.setEnergyConsumption(120);
        compressedDustWasher4.setProcessingSpeed(16);
        
        compressedDustWasher8.setCapacity(1000);
        compressedDustWasher8.setEnergyConsumption(240);
        compressedDustWasher8.setProcessingSpeed(16);

        
        /*
         * SMELTERIES
         */
        
        CompressedElectricSmeltery compressedSmeltery4 = new CompressedElectricSmeltery(
        		category, 
        		itemCompressedSmeltery4, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		recipeCompressedSmeltery4, 
        		4);
        
        CompressedElectricSmeltery compressedSmeltery8 = new CompressedElectricSmeltery(
        		category, 
        		itemCompressedSmeltery8, 
        		RecipeType.ENHANCED_CRAFTING_TABLE, 
        		recipeCompressedSmeltery8,
        		8);
        
        compressedSmeltery4.setCapacity(500);
        compressedSmeltery4.setEnergyConsumption(160);
        compressedSmeltery4.setProcessingSpeed(5);
        
        compressedSmeltery8.setCapacity(1000);
        compressedSmeltery8.setEnergyConsumption(320);
        compressedSmeltery8.setProcessingSpeed(5);
        
        
        
        // Add the items to slimefun
        compressedAutoDrier4.register(this);
        compressedAutoDrier8.register(this);
        
        compressedGoldPan4.register(this);
        compressedGoldPan8.register(this);
        
        compressedDustWasher4.register(this);
        compressedDustWasher8.register(this);
        
        compressedSmeltery4.register(this);
        compressedSmeltery8.register(this);
        
        
        
        
        
        
        
        
        /*
         * 
         * 
         * REGISTER DECONSTRUCTION RECIPES
         *  
         *  
         */
        
        SlimefunItemStack output;
        ItemStack[] input;
        
        
        output = new SlimefunItemStack(SlimefunItems.AUTO_DRIER, 4);
        input = new ItemStack[] { itemCompressedAutoDrier4, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        output = new SlimefunItemStack(SlimefunItems.AUTO_DRIER, 8);
        input = new ItemStack[] { itemCompressedAutoDrier8, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_DUST_WASHER_3, 4);
        input = new ItemStack[] { itemCompressedDustWasher4, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_DUST_WASHER_3, 8);
        input = new ItemStack[] { itemCompressedDustWasher8, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_GOLD_PAN_3, 4);
        input = new ItemStack[] { itemCompressedGoldPan4, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_GOLD_PAN_3, 8);
        input = new ItemStack[] { itemCompressedGoldPan8, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_SMELTERY_2, 4);
        input = new ItemStack[] { itemCompressedSmeltery4, null, null, null, null, null, null, null, null };
        RecipeType.ENHANCED_CRAFTING_TABLE.register(input, output);
        
        output = new SlimefunItemStack(SlimefunItems.ELECTRIC_SMELTERY_2, 8);
        input = new ItemStack[] { itemCompressedSmeltery8, null, null, null, null, null, null, null, null };
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
