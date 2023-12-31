package com.impact.mods.railcraft.carts.base;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class InvTools {
	
	public static boolean isWildcard(ItemStack stack) {
		return isWildcard(stack.getItemDamage());
	}
	
	public static boolean isWildcard(int damage) {
		return damage == -1 || damage == OreDictionary.WILDCARD_VALUE;
	}
	
	/**
	 * A more robust item comparison function. Supports items with damage = -1 matching any sub-type.
	 *
	 * @param a An ItemStack
	 * @param b An ItemStack
	 * @return True if equal
	 */
	public static boolean isItemEqual(ItemStack a, ItemStack b) {
		return isItemEqual(a, b, true, true);
	}
	
	public static boolean isItemEqual(final ItemStack a, final ItemStack b, final boolean matchDamage,
									  final boolean matchNBT) {
		if (a == null || b == null) {
			return false;
		}
		if (a.getItem() != b.getItem()) {
			return false;
		}
		if (matchNBT && !ItemStack.areItemStackTagsEqual(a, b)) {
			return false;
		}
		if (matchDamage && a.getHasSubtypes()) {
			if (isWildcard(a) || isWildcard(b)) {
				return true;
			}
          return a.getItemDamage() == b.getItemDamage();
		}
		return true;
	}
	
	/**
	 * Returns true if the item is equal to any one of several possible matches.
	 *
	 * @param stack
	 * @param matches
	 * @return
	 */
	public static boolean isItemEqual(ItemStack stack, ItemStack... matches) {
		for (ItemStack match : matches) {
			if (isItemEqual(stack, match)) {
				return true;
			}
		}
		return false;
	}
}