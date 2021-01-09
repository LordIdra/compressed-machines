package slimefunmachines;


import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import other.CompressedAutoDrierBase;


public class CompressedX8AutoDrier extends CompressedAutoDrierBase {
	
	protected static final int COMPRESSION = 8;

    public CompressedX8AutoDrier(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
}