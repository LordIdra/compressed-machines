package slimefun_machines;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.multiblocks.OreWasher;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

public class CompressedElectricDustWasher extends AContainer {

    private OreWasher oreWasher;
    private final boolean legacyMode;
    
    private int compression = 1;

    public CompressedElectricDustWasher(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int compressionLevel) {
        super(category, item, recipeType, recipe);

        legacyMode = SlimefunPlugin.getCfg().getBoolean("options.legacy-dust-washer");
        
        compression = compressionLevel;
    }

    @Override
    public void preRegister() {
        super.preRegister();

        oreWasher = (OreWasher) SlimefunItems.ORE_WASHER.getItem();
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
    	
        List<ItemStack> recipes = new ArrayList<>();

        recipes.addAll(oreWasher.getDisplayRecipes());
        
        for (int i = 0; i < recipes.size(); i++) {
        	ItemStack currentRecipe = recipes.get(i).clone();
        	currentRecipe.setAmount(currentRecipe.getAmount() * compression);
        	recipes.set(i, currentRecipe);
        }

        return recipes;
    }
    
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.GOLDEN_SHOVEL);
    }

    @Override
    protected MachineRecipe findNextRecipe(BlockMenu menu) {
        for (int slot : getInputSlots()) {
            if (SlimefunUtils.isItemSimilar(menu.getItemInSlot(slot), SlimefunItems.SIFTED_ORE, true, false)) {
            	if (menu.getItemInSlot(slot).getAmount() >= compression) {
	                if (!legacyMode && !hasFreeSlot(menu)) {
	                    return null;
	                }
	
	                ItemStack dust = oreWasher.getRandomDust().clone();
	                dust.setAmount(compression);
	                MachineRecipe recipe = new MachineRecipe(4 / getSpeed(), new ItemStack[0], new ItemStack[] { dust });
	
	                if (!legacyMode || menu.fits(recipe.getOutput()[0], getOutputSlots())) {
	                    menu.consumeItem(slot, compression);
	                    return recipe;
	                }
                }
            } else if (SlimefunUtils.isItemSimilar(menu.getItemInSlot(slot), SlimefunItems.PULVERIZED_ORE, true) && (menu.getItemInSlot(slot).getAmount() >= compression)) {
            		
            	ItemStack oreCluster = SlimefunItems.PURE_ORE_CLUSTER.clone();
            	oreCluster.setAmount(compression);
	            MachineRecipe recipe = new MachineRecipe(4 / getSpeed(), new ItemStack[0], new ItemStack[] { oreCluster });
	
	            if (menu.fits(recipe.getOutput()[0], getOutputSlots())) {
	                menu.consumeItem(slot, compression);
	                return recipe;
            	}
            }
        }

        return null;
    }

    private boolean hasFreeSlot(BlockMenu menu) {
        for (int slot : getOutputSlots()) {
            ItemStack item = menu.getItemInSlot(slot);

            if (item == null || item.getType() == Material.AIR) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getMachineIdentifier() {
        return "ELECTRIC_DUST_WASHER";
    }

    public int getCompression() {
    	return compression;
    }
}