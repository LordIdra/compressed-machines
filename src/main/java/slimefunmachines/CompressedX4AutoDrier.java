package slimefunmachines;


import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import other.CompressedAutoDrierBase;


public class CompressedX4AutoDrier extends CompressedAutoDrierBase {
	
	protected static final int compression = 4;

    public CompressedX4AutoDrier(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
}