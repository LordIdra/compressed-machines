package other;

import org.bukkit.inventory.ItemStack;

public class ItemChecker {
	private ItemChecker() {
		throw new IllegalStateException("Utility class");
	}
	  
	public static boolean isItemLegal(ItemStack item) {
		
		return (item.getAmount() <= item.getMaxStackSize());
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
