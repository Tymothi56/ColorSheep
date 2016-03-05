package fr.cubixgames.cs.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.manager.GameListener;

public class Move extends GameListener {

	public Move(ColorSheep instance) {
		super(instance);
	}
	
	@EventHandler
	public void event(PlayerMoveEvent e) {
		e.getPlayer().setFoodLevel(20);
		e.getPlayer().setSaturation((float) 20);
	}
	
}
