package fr.cubixgames.cs.listener.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.manager.GameListener;

public class Damage extends GameListener {

	public Damage(ColorSheep instance) {
		super(instance);
	}
	
	@EventHandler
	public void event(EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
}
