package slimefun.information;

import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.idra.compressedmachines.CompressedMachines;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import slimefun.classes.CompressedElectricDustWasher;

public class ElectricDustWasherInformation extends MachineInformation {
	public ElectricDustWasherInformation(int compressionLevel, SlimefunItemStack basetype, CompressedMachines plugin, Category category) { 
    	super(compressionLevel, plugin, category);
    	this.basetype = basetype;
    	
    	id 			= "COMPRESSED_ELECTRIC_DUST_WASHER" + compression;
    	speed 		= 10;
    	power 		= 30 * compression;
    	name 		= getCompressionPrefix(compression) + "&r&9Electric Dust Washer &7(&eIII&7)";
    	lore		= new String[] {"", category.getUnlocalizedName(), LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
    	
    	material 	= basetype.getType();
    	buffer		= power * 10 * compression;
    	recipe		= getRecipe					(basetype);
    	item		= new SlimefunItemStack		(id, material, name, lore);
    	
    	register(new CompressedElectricDustWasher (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
    	
    	this.basetype = item;
    }
}