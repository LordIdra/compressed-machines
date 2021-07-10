package me.idra.compressedmachines;



import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

import other.InformationItem;

import slimefun.information.AutoDrierInformation;
import slimefun.information.CarbonPressInformation;
import slimefun.information.ElectricDustWasherInformation;
import slimefun.information.ElectricFurnaceInformation;
import slimefun.information.ElectricGoldPanInformation;
import slimefun.information.ElectricIngotFactoryInformation;
import slimefun.information.ElectricIngotPulverizerInformation;
import slimefun.information.ElectricSmelteryInformation;



public class CompressedMachines extends JavaPlugin implements SlimefunAddon {
    
    
    @Override
    public void onEnable() {

        // Read the config file
        @SuppressWarnings("unused")
		Config cfg = new Config(this);
        
        
        // Display an arbitrary item to tell players about the plugin
        ItemStack categoryItem = new CustomItem(Material.OBSIDIAN, "Compressed Machines", "", "&aSpace and lag efficient machine variants");
        NamespacedKey categoryId = new NamespacedKey(this, "compressed_machines");
        Category category = new Category(categoryId, categoryItem);
        
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
        
        
        // Load the SF items and compress them
        
        /* 
         * MACHINES TO BE ADDED
         * 
         * ELECTRIC_FURNACE_3
         * ELECTRIC_INGOT_FACTORY_3
         * ELECTRIC_INGOT_PULVERIZER
         * 
         * ELECTRIC_ORE_GRINDER_2
         * ELECTRIC_PRESS_2
         * ELECTRIFIED_CRUCIBLE_3
         * 
         * FOOD_COMPOSTER_2
         * FOOD_FABRICATOR_2
         * GEO_MINER
         * 
         * HEATED_PRESSURE_CHAMBER_2
         * OIL_PUMP
         * REFINERY
         */
        
        
        int[] compressionLevels = new int[] { 2, 4, 8, 16, 32, 64 };
        SlimefunItemStack basetype;
        
        basetype = SlimefunItems.AUTO_DRIER;
        for (int level : compressionLevels) {
        	basetype = new AutoDrierInformation					(level, basetype, this, category).basetype;
        }
        
        basetype = SlimefunItems.CARBON_PRESS_3;
        for (int level : compressionLevels) {
        	basetype = new CarbonPressInformation				(level, basetype, this, category).basetype;
        }
        
        basetype = SlimefunItems.ELECTRIC_DUST_WASHER_3;
        for (int level : compressionLevels) {
        	basetype = new ElectricDustWasherInformation		(level, basetype, this, category).basetype;
        }
        
        basetype = SlimefunItems.ELECTRIC_FURNACE_3;
        for (int level : compressionLevels) {
        	basetype = new ElectricFurnaceInformation			(level, basetype, this, category).basetype;
        }
        
        basetype = SlimefunItems.ELECTRIC_GOLD_PAN_3;
        for (int level : compressionLevels) {
        	basetype = new ElectricGoldPanInformation			(level, basetype, this, category).basetype;
        }
        
        basetype = SlimefunItems.ELECTRIC_INGOT_FACTORY_3;
        for (int level : compressionLevels) {
        	basetype = new ElectricIngotFactoryInformation		(level, basetype, this, category).basetype;
        }
        
        basetype = SlimefunItems.ELECTRIC_INGOT_PULVERIZER;
        for (int level : compressionLevels) {
        	basetype = new ElectricIngotPulverizerInformation	(level, basetype, this, category).basetype;
        }
        
        basetype = SlimefunItems.ELECTRIC_SMELTERY_2;
        for (int level : compressionLevels) {
        	basetype = new ElectricSmelteryInformation			(level, basetype, this, category).basetype;
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