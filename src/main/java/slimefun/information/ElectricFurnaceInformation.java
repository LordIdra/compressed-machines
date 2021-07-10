package slimefun.information;

import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.idra.compressedmachines.CompressedMachines;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import slimefun.classes.CompressedElectricFurnace;

public class ElectricFurnaceInformation extends MachineInformation {
	public ElectricFurnaceInformation(int compressionLevel, SlimefunItemStack basetype, CompressedMachines plugin, Category category) { 
    	super(compressionLevel, plugin, category);
    	this.basetype = basetype;
    	
    	id 			= "COMPRESSED_ELECTRIC_FURNACE_" + compression;
    	speed 		= 4;
    	power 		= 10 * compression;
    	name 		= getCompressionPrefix(compression) +"&r&cElectric Furnace &7 - &eIII";
    	lore		= new String[] {"", category.getUnlocalizedName(), LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
    	
    	material 	= basetype.getType();
    	buffer		= power * 10 * compression;
    	recipe		= getRecipe					(basetype);
    	item		= new SlimefunItemStack		(id, material, name, lore);
    	
    	register(new CompressedElectricFurnace (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
    	
    	this.basetype = item;
    }
}