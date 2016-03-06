package fr.cubixgames.cs.manager;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import fr.cubixgames.cs.manager.utils.ItemCreator;

public class GameInventory {
	
	private Inventory inv;
	private String name;
	
	public void createInventory(int line, String name) {
		this.inv = Bukkit.createInventory(null, 9*line, name);
		this.name = name;
	}
	
	public void addItem(ItemCreator item) {
		inv.addItem(item.craftItem());
	}
	
	public void setItem(ItemCreator item, int slot) {
		inv.setItem(slot, item.craftItem());
	}
	
	public Inventory craftInventory() {
		return inv;
	}
	
	public String getName() {
		return name;
	}
	
}
