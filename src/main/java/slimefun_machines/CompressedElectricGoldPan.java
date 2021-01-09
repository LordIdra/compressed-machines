package slimefun_machines;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.tools.GoldPan;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

public class CompressedElectricGoldPan extends AContainer implements RecipeDisplayItem {

    private final GoldPan goldPan = (GoldPan) SlimefunItems.GOLD_PAN.getItem();
    private final GoldPan netherGoldPan = (GoldPan) SlimefunItems.NETHER_GOLD_PAN.getItem();
    
	private int compression;

    public CompressedElectricGoldPan(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int compressionLevel) {
        super(category, item, recipeType, recipe);
        
        compression = compressionLevel;
    }

    
    @Override
    public List<ItemStack> getDisplayRecipes() {
    	
        List<ItemStack> recipes = new ArrayList<>();

        recipes.addAll(goldPan.getDisplayRecipes());
        recipes.addAll(netherGoldPan.getDisplayRecipes());
        
        for (int i = 0; i < recipes.size(); i++) {
        	ItemStack currentRecipe = recipes.get(i).clone();
        	currentRecipe.setAmount(currentRecipe.getAmount() * compression);
        	recipes.set(i, currentRecipe);
        }

        return recipes;
    }

    
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.DIAMOND_SHOVEL);
    }

    
    @Override
    protected MachineRecipe findNextRecipe(BlockMenu menu) {
    	
        if (!hasFreeSlot(menu)) {
            return null;
        }

        for (int slot : getInputSlots()) {
        	
            if (SlimefunUtils.isItemSimilar(menu.getItemInSlot(slot), new ItemStack(Material.GRAVEL), true, false)) {
            	if (menu.getItemInSlot(slot).getAmount() >= compression) {
            		
	                ItemStack output = goldPan.getRandomOutput().clone();
	                output.setAmount(compression);
	                MachineRecipe recipe = new MachineRecipe(3 / getSpeed(), new ItemStack[0], new ItemStack[] { output });
	
	                if (output.getType() != Material.AIR && menu.fits(output, getOutputSlots())) {
	                    menu.consumeItem(slot, compression);
	                    return recipe;
	                }
            	}
                
            } else if (SlimefunUtils.isItemSimilar(menu.getItemInSlot(slot), new ItemStack(Material.SOUL_SAND), true, false) && (menu.getItemInSlot(slot).getAmount() >= compression)) {
	            ItemStack output = netherGoldPan.getRandomOutput().clone();
	            output.setAmount(compression);
	            MachineRecipe recipe = new MachineRecipe(4 / getSpeed(), new ItemStack[0], new ItemStack[] { output });
	
	            if (output.getType() != Material.AIR && menu.fits(output, getOutputSlots())) {
	                menu.consumeItem(slot, compression);
	                return recipe;
            	}
            }
        }

        return null;
    }

    
    private boolean hasFreeSlot(BlockMenu menu) {
        for (int slot : getOutputSlots()) {
        	ItemStack itemInSlot = menu.getItemInSlot(slot);
        	
            if (itemInSlot == null) {
                return true;
            }
        }

        return false;
    }
    
    
    @Override
    public String getMachineIdentifier() {
        return "ELECTRIC_GOLD_PAN";
    }
    
    public int getCompression() {
    	return compression;
    }
}