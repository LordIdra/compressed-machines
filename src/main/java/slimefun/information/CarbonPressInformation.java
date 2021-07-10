package slimefun.information;

import org.bukkit.Bukkit;

import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.idra.compressedmachines.CompressedMachines;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import slimefun.classes.CompressedCarbonPress;

public class CarbonPressInformation extends MachineInformation {
	public CarbonPressInformation(int compressionLevel, SlimefunItemStack basetype, CompressedMachines plugin, Category category) { 
    	super(compressionLevel, plugin, category);
    	Bukkit.getLogger().info("CARBON PRESS ENABLED");
    	this.basetype = basetype;
    	
    	id 			= "COMPRESSED_CARBON_PRESS" + compression;
    	speed 		= 15;
    	power 		= 180 * compression;
    	name 		= getCompressionPrefix(compression) + "&r&cCarbon Press &7- &eIII";
    	lore		= new String[] {"", category.getUnlocalizedName(), LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
    	
    	material 	= basetype.getType();
    	buffer		= power * 10 * compression;
    	recipe		= getRecipe					(basetype);
    	item		= new SlimefunItemStack		(id, material, name, lore);
    	
    	register(new CompressedCarbonPress (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
    	
    	this.basetype = item;
    }
}