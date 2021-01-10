package other;

import org.bukkit.inventory.ItemStack;

public class ItemChecker {
	
	public static boolean isItemLegal(ItemStack item) {
		
		if (item.getAmount() > item.getMaxStackSize()) return false;
		
		return true;
	}
	
	public static boolean isRecipeLegal(ItemStack[] inputs, ItemStack[] outputs) {
		
		for (ItemStack input : inputs) {
			if (!isItemLegal(input)) {
				return false;
			}
		}
		
		for (ItemStack output : outputs) {
			if (!isItemLegal(output)) {
				return false;
			}
		}
		
		return true;
	}
}
