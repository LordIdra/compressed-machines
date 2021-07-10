package slimefun.information;

import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.idra.compressedmachines.CompressedMachines;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import slimefun.classes.CompressedElectricSmeltery;

public class ElectricSmelteryInformation extends MachineInformation {
	public ElectricSmelteryInformation(int compressionLevel, SlimefunItemStack basetype, CompressedMachines plugin, Category category) { 
    	super(compressionLevel, plugin, category);
    	this.basetype = basetype;
    	
    	id 			= "COMPRESSED_ELECTRIC_SMELTERY_" + compression;
    	speed 		= 10;
    	power 		= 40 * compression;
    	name 		= getCompressionPrefix(compression) +"&r&cElectric Smeltery &7 - &eII";
    	lore		= new String[] {"", "&4Alloys only, doesn't smelt Dust into Ingots", "", category.getUnlocalizedName(), LoreBuilder.speed(speed), LoreBuilder.powerPerSecond(power)};
    	
    	material 	= basetype.getType();
    	buffer		= power * 10 * compression;
    	recipe		= getRecipe					(basetype);
    	item		= new SlimefunItemStack		(id, material, name, lore);
    	
    	register(new CompressedElectricSmeltery (category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, compression));
    	
    	this.basetype = item;
    }
}