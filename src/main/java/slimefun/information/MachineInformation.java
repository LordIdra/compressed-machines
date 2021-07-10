package slimefun.information;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.idra.compressedmachines.CompressedMachines;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;


class MachineInformation {
	
	private CompressedMachines pluginInstance;

    Category category;
    
	
	
    SlimefunItemStack[] getRecipe(SlimefunItemStack item) {
    	return new SlimefunItemStack[] {item, item, null, null, null, null, null, null, null};
    } 
    
    SlimefunItemStack[] getDeconstructRecipe(SlimefunItemStack item) {
    	return new SlimefunItemStack[] {item, null, null, null, null, null, null, null, null};
    }
    
    public String getCompressionPrefix(int compression) {
    	return "&7&l[&2&l" + compression + "x&7&l] ";
    }
    
    
    
	MachineInformation(int compressionLevel, CompressedMachines plugin, Category category) {
		this.category = category;
		pluginInstance = plugin;
		compression = compressionLevel;
	}
	
	
	
	void register(AContainer object)  {
		
        object.setCapacity(buffer);
        object.setEnergyConsumption(power);
        object.setProcessingSpeed(speed);
        
        object.register(pluginInstance);
        
        ItemStack newItem = new ItemStack(basetype);
        newItem.setAmount(2);
        RecipeType.ENHANCED_CRAFTING_TABLE.register(getDeconstructRecipe(item), newItem);
	}
	
	
	
	public int compression = 1;
	
	public String 				id;
	public Material 			material;
	public int 				speed;
	public int 				power;
	public int					buffer;
	public String				name;
	public String[] 			lore;
	
	public SlimefunItemStack	basetype;
	public SlimefunItemStack[]	recipe;
	public SlimefunItemStack	item;
}