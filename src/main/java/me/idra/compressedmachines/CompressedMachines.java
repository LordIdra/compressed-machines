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

	
	
    SlimefunItemStack[] getRecipe(SlimefunItemStack item) {    	
    	return new SlimefunItemStack[] {item, item, null, null, null, null, null, null, null};
    }
    
    
    
    public String getCompressionPrefix(int compression) {
    	return "&7&l[&2&l" + compression + "x&7&l] ";
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
        
        
        // Display an arbitrary item to tell players about the plugin
        SlimefunItemStack compressedInformationItem = new SlimefunItemStack(
        		"COMPRESSED_INFORMATION_ITEM",
        		Material.NETHER_STAR,
        		"&4&lINFORMATION",
        		"&aCompressed machines act the same as normal machines, but can",
        		"&aprocess up to 64 items at a time. If you have lots of normal",
        		"&amachines, convert them into compressed machines to save",
        		"&aspace and help reduce server lag.",
        		"",
        		"&aCompressed machines can be converted back into their", 
        		"&anormal variants by putting them in the &2&lfirst slot &aof an", 
        		"&aenhanced crafting table");
        
        InformationItem compressedInformation = new InformationItem(
        		category,
        		compressedInformationItem,
        		RecipeType.NULL,
        		new ItemStack[] {null, null, null, null, null, null, null, null, null});
        
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
        
        class MachineInformation {
        	
        	MachineInformation(int compressionLevel) {
        		compression = compressionLevel;
        	}
        	
        	void register(AContainer object)  {
        		
	            object.setCapacity(buffer);
	            object.setEnergyConsumption(power);
	            object.setProcessingSpeed(speed);
	            
	            object.register(CompressedMachines.this);
        	}
        	
        	int compression = 1;
        	
        	String 				id;
        	Material 			material;
        	int 				speed;
        	int 				power;
        	int					buffer;
        	String				name;
        	String[] 			lore;
        	
        	SlimefunItemStack	basetype;
        	SlimefunItemStack[]	recipe;
        	SlimefunItemStack	item;
        }
        
        
        
        /*
         *  MACHINE INFORMATION DEFINITIONS
         */
        
        // AUTO DRIER
        class AutoDrierInformationClass extends MachineInformation {
	        AutoDrierInformationClass(int compressionLevel, SlimefunItemStack basetype) { 
	        	super(compressionLevel);
	        	
	        	id 			= "COMPRESSED_ELECTRIC_AUTO_DRIER_" + compression;
	        	material 	= Material.SMOKER;
	        	speed 		= 1;
	        	power 		= 12 * compression;
	        	name 		= getCompressionPrefix(compression) + "&r&6Auto Drier";
	        	lore		= new String[] {"", categoryName, LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
	        	
	        	buffer		= power * 10 * compression;
	        	recipe		= getRecipe					(basetype);
	        	item		= new SlimefunItemStack		(id, material, name, lore);
	        	
	        	register(new CompressedAutoDrier (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
	        	
	        	this.basetype = item;
	        }
        }
        
        // ELECTRIC DUST WASHER
        class ElectricDustWasherInformationClass extends MachineInformation {
	        ElectricDustWasherInformationClass(int compressionLevel, SlimefunItemStack basetype) { 
	        	super(compressionLevel);
	        	
	        	id 			= "COMPRESSED_ELECTRIC_DUST_WASHER" + compression;
	        	material 	= Material.BLUE_STAINED_GLASS;
	        	speed 		= 10;
	        	power 		= 30 * compression;
	        	name 		= getCompressionPrefix(compression) + "&r&9Electric Dust Washer &7(&eIII&7)";
	        	lore		= new String[] {"", categoryName, LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
	        	
	        	buffer		= power * 10 * compression;
	        	recipe		= getRecipe					(basetype);
	        	item		= new SlimefunItemStack		(id, material, name, lore);
	        	
	        	register(new CompressedElectricDustWasher (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
	        	
	        	this.basetype = item;
	        }
        }
        
        // ELECTRIC GOLD PAN
        class ElectricGoldPanInformationClass extends MachineInformation {
	        ElectricGoldPanInformationClass(int compressionLevel, SlimefunItemStack basetype) { 
	        	super(compressionLevel);
	        	
	        	id 			= "COMPRESSED_ELECTRIC_GOLD_PAN_" + compression;
	        	material 	= Material.BROWN_TERRACOTTA;
	        	speed 		= 10;
	        	power 		= 14 * compression;
	        	name 		= getCompressionPrefix(compression) + "&r&6Electric Gold Pan &7(&eIII&7)";
	        	lore		= new String[] {"", categoryName, LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
	        	
	        	buffer		= power * 10 * compression;
	        	recipe		= getRecipe					(basetype);
	        	item		= new SlimefunItemStack		(id, material, name, lore);
	        	
	        	register(new CompressedElectricGoldPan (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
	        	
	        	this.basetype = item;
	        }
        }
        
        // ELECTRIC SMELTERY
        class ElectricSmelteryInformationClass extends MachineInformation {
	        ElectricSmelteryInformationClass(int compressionLevel, SlimefunItemStack basetype) { 
	        	super(compressionLevel);
	        	
	        	id 			= "COMPRESSED_ELECTRIC_SMELTERY_" + compression;
	        	material 	= Material.FURNACE;
	        	speed 		= 10;
	        	power 		= 40 * compression;
	        	name 		= getCompressionPrefix(compression) +"&r&cElectric Smeltery &7 - &eII";
	        	lore		= new String[] {"", "&4Alloys only, doesn't smelt Dust into Ingots", "", categoryName, LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
	        	
	        	buffer		= power * 10 * compression;
	        	recipe		= getRecipe					(basetype);
	        	item		= new SlimefunItemStack		(id, material, name, lore);
	        	
	        	register(new CompressedElectricSmeltery (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
	        	
	        	this.basetype = item;
	        }
        }
        
        
        int[] compressionLevels = new int[] { 2, 4, 8, 16, 32, 64 };
        SlimefunItemStack basetype;
        
        basetype = autoDrier;
        for (int level : compressionLevels) {
        	basetype = new AutoDrierInformationClass				(level, basetype).basetype;
        }
        
        basetype = goldPan;
        for (int level : compressionLevels) {
        	basetype = new ElectricGoldPanInformationClass			(level, basetype).basetype;
        }
        
        basetype = dustWasher;
        for (int level : compressionLevels) {
        	basetype = new ElectricDustWasherInformationClass		(level, basetype).basetype;
        }
        
        basetype = smeltery;
        for (int level : compressionLevels) {
        	basetype = new ElectricSmelteryInformationClass			(level, basetype).basetype;
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