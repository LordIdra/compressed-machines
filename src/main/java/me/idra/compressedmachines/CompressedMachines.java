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
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

import other.InformationItem;

import slimefunmachines.CompressedAutoDrier;
import slimefunmachines.CompressedElectricDustWasher;
import slimefunmachines.CompressedElectricGoldPan;
import slimefunmachines.CompressedElectricSmeltery;



public class CompressedMachines extends JavaPlugin implements SlimefunAddon {

    SlimefunItemStack[] getRecipe(int compression, SlimefunItemStack item) {
    	
    	if (compression == 2) {
    		return new SlimefunItemStack[] {item, item, null, null, null, null, null, null, null};
    	}
    	
    	else if (compression == 4) {
    		return new SlimefunItemStack[] {item, item, null, item, item, null, null, null, null};
    	}
    	
    	else if (compression == 8) {
    		return new SlimefunItemStack[] {item, item, item, item, null, item, item, item, item};
    	}
    	
    	return new SlimefunItemStack[] {item, null, null, null, null, null, null, null, null};
    }
    
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
        
        SlimefunItemStack autoDrier = SlimefunItems.AUTO_DRIER;
        SlimefunItemStack dustWasher = SlimefunItems.ELECTRIC_DUST_WASHER_3;
        SlimefunItemStack goldPan = SlimefunItems.ELECTRIC_GOLD_PAN_3;
        SlimefunItemStack smeltery = SlimefunItems.ELECTRIC_SMELTERY_2;
        
        

        /*
         *  MACHINE INFORMATION STRUCTURES
         */
        
        class machineInformation {
        	
        	machineInformation(int compressionLevel) {
        		compression = compressionLevel;
        	}
        	
        	void register(AContainer object)  {
        		
	            object.setCapacity(buffer);
	            object.setEnergyConsumption(power);
	            object.setProcessingSpeed(speed);
	            
	            object.register(CompressedMachines.this);
        	}
        	
        	int compression = 1;
        	
        	String 				ID;
        	Material 			material;
        	int 				speed;
        	int 				power;
        	int					buffer;
        	String				name;
        	String[] 			lore;
        	SlimefunItemStack 	basetype;
        	
        	SlimefunItemStack[]	recipe;
        	SlimefunItemStack	item;
        }
        
        
        
        /*
         *  MACHINE INFORMATION DEFINITIONS
         */
        
        // AUTO DRIER
        class autoDrierInformationClass extends machineInformation {
	        autoDrierInformationClass(int compressionLevel) { 
	        	super(compressionLevel);
	        	
	        	ID 			= "COMPRESSED_ELECTRIC_AUTO_DRIER_" + compression;
	        	material 	= Material.SMOKER;
	        	speed 		= 1;
	        	power 		= 12 * compression;
	        	name 		= "&7&l[&2&l" + String.valueOf(compression) + "x&7&l] &r&6Auto Drier";
	        	basetype	= autoDrier;
	        	lore		= new String[] {"", categoryName, LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
	        	
	        	buffer		= power * 10 * compression;
	        	recipe		= getRecipe					(compression, basetype);
	        	item		= new SlimefunItemStack		(ID, material, name, lore);
	        	
	        	register(new CompressedAutoDrier (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
	        }
        }
        
        // ELECTRIC DUST WASHER
        class electricDustWasherInformationClass extends machineInformation {
	        electricDustWasherInformationClass(int compressionLevel) { 
	        	super(compressionLevel);
	        	
	        	ID 			= "COMPRESSED_ELECTRIC_DUST_WASHER" + compression;
	        	material 	= Material.BLUE_STAINED_GLASS;
	        	speed 		= 10;
	        	power 		= 30 * compression;
	        	basetype	= dustWasher;
	        	name 		= "&7&l[&2&l" + String.valueOf(compression) + "x&7&l] &r&9Electric Dust Washer &7(&eIII&7)";
	        	lore		= new String[] {"", categoryName, LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
	        	
	        	buffer		= power * 10 * compression;
	        	recipe		= getRecipe					(compression, basetype);
	        	item		= new SlimefunItemStack		(ID, material, name, lore);
	        	
	        	register(new CompressedElectricDustWasher (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
	        }
        }
        
        // ELECTRIC GOLD PAN
        class electricGoldPanInformationClass extends machineInformation {
	        electricGoldPanInformationClass(int compressionLevel) { 
	        	super(compressionLevel);
	        	
	        	ID 			= "COMPRESSED_ELECTRIC_GOLD_PAN_" + compression;
	        	material 	= Material.BROWN_TERRACOTTA;
	        	speed 		= 10;
	        	power 		= 14 * compression;
	        	basetype	= goldPan;
	        	name 		= "&7&l[&2&l" + String.valueOf(compression) + "x&7&l] &r&6Electric Gold Pan &7(&eIII&7)";
	        	lore		= new String[] {"", categoryName, LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
	        	
	        	buffer		= power * 10 * compression;
	        	recipe		= getRecipe					(compression, basetype);
	        	item		= new SlimefunItemStack		(ID, material, name, lore);
	        	
	        	register(new CompressedElectricGoldPan (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
	        }
        }
        
        // ELECTRIC SMELTERY
        class electricSmelteryInformationClass extends machineInformation {
	        electricSmelteryInformationClass(int compressionLevel) { 
	        	super(compressionLevel);
	        	
	        	ID 			= "COMPRESSED_ELECTRIC_SMELTERY_" + compression;
	        	material 	= Material.FURNACE;
	        	speed 		= 10;
	        	power 		= 40 * compression;
	        	basetype	= smeltery;
	        	name 		= "&7&l[&2&l" + String.valueOf(compression) + "x&7&l] &r&cElectric Smeltery &7 - &eII";
	        	lore		= new String[] {"", "&4Alloys only, doesn't smelt Dust into Ingots", "", categoryName, LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
	        	
	        	buffer		= power * 10 * compression;
	        	recipe		= getRecipe					(compression, basetype);
	        	item		= new SlimefunItemStack		(ID, material, name, lore);
	        	
	        	register(new CompressedElectricSmeltery (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
	        }
        }
        
        
        int[] compression_levels = new int[] { 4, 8 };
        
        for (int level : compression_levels) {
        	
        	new autoDrierInformationClass				(level);
        	new electricGoldPanInformationClass			(level);
        	new electricDustWasherInformationClass		(level);
        	new electricSmelteryInformationClass		(level);
        }
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