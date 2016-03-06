package fr.cubixgames.cs.state.lobby;

import org.bukkit.Material;

import fr.cubixgames.cs.manager.GameInventory;
import fr.cubixgames.cs.manager.helper.InterfaceInventory;
import fr.cubixgames.cs.manager.utils.ItemCreator;
import fr.cubixgames.cs.player.ColorPlayer;

public class ColorChoose extends GameInventory implements InterfaceInventory {

	GameInventory gi = new GameInventory();
	
	@Override
	public void open(ColorPlayer p) {
		gi.createInventory(3, "Choose your Color");
		gi.setItem(new ItemCreator(Material.WOOL,(short) 1), 9);
		gi.setItem(new ItemCreator(Material.WOOL,(short) 4), 10);
		gi.setItem(new ItemCreator(Material.WOOL,(short) 14), 11);
		gi.setItem(new ItemCreator(Material.WOOL,(short) 11), 12);
		gi.setItem(new ItemCreator(Material.WOOL,(short) 13), 13);
		gi.setItem(new ItemCreator(Material.WOOL,(short) 12), 14);
		gi.setItem(new ItemCreator(Material.WOOL,(short) 9), 15);
		gi.setItem(new ItemCreator(Material.WOOL,(short) 7), 16);
		p.openInventory(gi);
	}
	
}
