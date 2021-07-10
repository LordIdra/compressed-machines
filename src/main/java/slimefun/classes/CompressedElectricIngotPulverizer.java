package slimefun.classes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricIngotPulverizer;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import other.ItemChecker;


public class CompressedElectricIngotPulverizer extends ElectricIngotPulverizer {
	
	private int compression = 1;

    public CompressedElectricIngotPulverizer(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int compressionLevel) {
        super(category, item, recipeType, recipe);
        
        compression = compressionLevel;
        compressRecipes();
    }
    
    
    
    public void compressRecipes() {
    	
        Config cfg = SlimefunPlugin.getCfg();
        int tickSpeed = 20 / cfg.getInt("URID.custom-ticker-delay");
        
    	for (int n = 0; n < recipes.size(); n++) {
    		
    		MachineRecipe recipe = recipes.get(n);
    		
    		ItemStack[] recipeInput = recipe.getInput().clone();
    		ItemStack[] recipeOutput = recipe.getOutput().clone();
    		
    		for (int i = 0; i < recipeInput.length; i++) {
    			ItemStack newItem = new ItemStack(recipeInput[i]);
    			newItem.setAmount(newItem.getAmount() * compression);
    			recipeInput[i] = newItem;
    		}
    		
    		for (int i = 0; i < recipeOutput.length; i++) {
    			ItemStack newItem = new ItemStack(recipeOutput[i]);
    			newItem.setAmount(newItem.getAmount() * compression);
    			recipeOutput[i] = newItem;
    		}
    		
    		recipes.set(n, new MachineRecipe(recipe.getTicks() / tickSpeed, recipeInput, recipeOutput));
    	}
    }
    
    
    
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 2);

        for (MachineRecipe recipe : recipes) {
            if (recipe.getInput().length != 1) {
                continue;
            }
            
            ItemStack recipeInput = new ItemStack(recipe.getInput()[0]);
            ItemStack recipeOutput = new ItemStack(recipe.getOutput()[0]);
            
            if (ItemChecker.isItemLegal(recipeInput) && ItemChecker.isItemLegal(recipeOutput)) {
            	displayRecipes.add(recipeInput);
            	displayRecipes.add(recipeOutput);
            }
        }

        return displayRecipes;
    }
    
    
    
    public int getCompression() {
    	return compression;
    }
}