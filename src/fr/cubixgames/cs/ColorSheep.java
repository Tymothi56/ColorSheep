package fr.cubixgames.cs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.cubixgames.cs.manager.GameManager;
import fr.cubixgames.cs.manager.GameStatus;
import fr.cubixgames.cs.manager.PlayerManager;
import fr.cubixgames.cs.manager.utils.Console;

public class ColorSheep extends JavaPlugin {
	
	private static ColorSheep pl;
	private GameStatus gs;
	private PlayerManager pm;
	private GameManager gm;
	private Console cs;
	
	@Override
	public void onLoad() {
		pl = this;
		pm = new PlayerManager();
		gm = new GameManager();
		gs = new GameStatus(gm);
		cs = new Console();
	}
	
	@Override
	public void onEnable() {
		cs.sendMessage("------ColorSheep------");
		cs.sendMessage("Plugin load.");
		cs.sendMessage("Author "+this.getDescription().getAuthors());
		cs.sendMessage("Version:"+this.getDescription().getVersion());
		cs.sendMessage("----------------------");
		gs.lobby();
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			pm.addPlayer(pls.getUniqueId());
		}
		
	}
	
	public static ColorSheep getInstance() {
		return pl;
	}
	
	public GameManager getGameManager() {
		return gm;
	}
	
	public PlayerManager getPlayerManager() {
		return pm;
	}
	
	public GameStatus getGameStatus() {
		return gs;
	}
	
}
