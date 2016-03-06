package fr.cubixgames.cs.manager.utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
	
	private ItemStack i;
	private ItemMeta im;
	
	public ItemCreator(Material mat) {
		i = new ItemStack(mat);
		im = i.getItemMeta();
	}
	
	public ItemCreator(Material mat, short ID) {
		i = new ItemStack(mat);
		i.setDurability(ID);
		im = i.getItemMeta();
	}
	
	public ItemCreator setName(String name) {
		im.setDisplayName(name);
		return this;
	}
	
	public ItemCreator setLore(List<String> lore) {
		im.setLore(lore);
		return this;
	}
	
	public ItemCreator addEnchantemant(Enchantment ench, int level, boolean show) {
		im.addEnchant(ench, level, show);
		return this;
	}
	
	public ItemCreator setUnbrekable() {
		im.spigot().setUnbreakable(true);
		return this;
	}
	
	public ItemCreator setAmount(int am) {
		i.setAmount(am);
		return this;
	}
	
	public ItemStack craftItem() {
		i.setItemMeta(im);
		return i;
	}
	
}
