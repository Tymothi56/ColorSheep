package fr.cubixgames.cs.listener;

import org.bukkit.plugin.PluginManager;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.listener.entity.Damage;
import fr.cubixgames.cs.listener.player.Join;
import fr.cubixgames.cs.listener.player.Quit;

public class ListenerManager {
	
	private ColorSheep pl;
	
	public ListenerManager(ColorSheep pl) {
		this.pl = pl;
	}
	
	public void register() {
		PluginManager pm = pl.getServer().getPluginManager();
		pm.registerEvents(new Join(pl), pl);
		pm.registerEvents(new Quit(pl), pl);
		pm.registerEvents(new Move(pl), pl);
		
		pm.registerEvents(new Damage(pl) ,pl);
	}
	
}
