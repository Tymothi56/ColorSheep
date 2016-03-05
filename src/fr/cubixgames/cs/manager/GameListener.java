package fr.cubixgames.cs.manager;

import java.util.UUID;

import org.bukkit.event.Listener;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.player.ColorPlayer;

public class GameListener implements Listener {
	
	protected ColorSheep instance;
	
	public GameListener(ColorSheep instance) {
		this.instance = instance;
	}
	
	public ColorPlayer getColorPlayer(UUID uuid) {
		return instance.getPlayerManager().getColorPlayer(uuid);
	}
	
	public GameManager getGameManager() {
		return instance.getGameManager();
	}
	
	public PlayerManager getPlayerManager() {
		return instance.getPlayerManager();
	}
	
	public GameStatus getGameStatus() {
		return instance.getGameStatus();
	}
	
}
