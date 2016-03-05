package fr.cubixgames.cs.manager;

import java.util.UUID;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.player.ColorPlayer;

public class GameCommand {
	
protected ColorSheep instance;
	
	public GameCommand(ColorSheep instance) {
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
