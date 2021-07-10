package slimefun.classes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.RecipeChoice.MaterialChoice;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricFurnace;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;


public class CompressedElectricFurnace extends ElectricFurnace {
	
	private int compression = 1;

    public CompressedElectricFurnace(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int compressionLevel) {
        super(category, item, recipeType, recipe);
        compression = compressionLevel;
        compressRecipes();
    }
    
    
    @Override
    public void registerDefaultRecipes() {
    	Bukkit.getLogger().info("FUCK FUCK FUCK");
        SlimefunPlugin.getMinecraftRecipeService().subscribe(snapshot -> {
            for (FurnaceRecipe recipe : snapshot.getRecipes(FurnaceRecipe.class)) {
                RecipeChoice choice = recipe.getInputChoice();

                if (choice instanceof MaterialChoice) {
                    for (Material input : ((MaterialChoice) choice).getChoices()) {
                        registerRecipe(4, new ItemStack[] { new ItemStack(input) }, new ItemStack[] { recipe.getResult() });
                    }
                }
            }
        });
    }
    
    public void compressRecipes() {
    	
        Config cfg = SlimefunPlugin.getCfg();
        int tickSpeed = 20 / cfg.getInt("URID.custom-ticker-delay");
        
        Bukkit.getLogger().info("RECIPES SIZE: " + recipes.size());
        
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
    		
    		Bukkit.getLogger().info("RECIPES COMPRESSED LEVEL " + compression);
    		
    		recipes.set(n, new MachineRecipe(recipe.getTicks() / tickSpeed, recipeInput, recipeOutput));
    	}
    }
    
    
    
    public int getCompression() {
    	return compression;
    }
}