package fr.cubixgames.cs.listener.player;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.manager.GameListener;
import fr.cubixgames.cs.manager.GameStatus.GameState;
import fr.cubixgames.cs.player.ColorPlayer;
import fr.cubixgames.cs.state.lobby.LobbyTimer;

public class Join extends GameListener {

	public Join(ColorSheep instance) {
		super(instance);
	}

	private LobbyTimer lt = new LobbyTimer();
	
	@EventHandler
	public void event(PlayerJoinEvent e) {
		super.getPlayerManager().addPlayer(e.getPlayer().getUniqueId());
		if (super.getGameStatus().isState(GameState.LOBBY)) {
			ColorPlayer cp = super.getColorPlayer(e.getPlayer().getUniqueId());
			e.setJoinMessage(super.getGameManager().getGameName() + "§a" + cp.getPlayerName()
					+ " §7a rejoint la partie." + " (§a" + super.getPlayerManager().getOnlineCount() + "§7/"
					+ super.getGameManager().getMaxPlayer() + ")");
			
			if(super.getPlayerManager().getOnlineCount() >= super.getGameManager().getMinPlayer()) {
				lt.setTimer(60);
				lt.start();
			}
			
		} else {
			e.setJoinMessage(null);
			e.getPlayer().setGameMode(GameMode.SPECTATOR);
		}
	}

}
