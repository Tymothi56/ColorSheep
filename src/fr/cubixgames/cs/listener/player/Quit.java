package fr.cubixgames.cs.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.manager.GameListener;
import fr.cubixgames.cs.manager.GameStatus.GameState;
import fr.cubixgames.cs.player.ColorPlayer;
import fr.cubixgames.cs.state.lobby.LobbyTimer;

public class Quit extends GameListener {

	public Quit(ColorSheep instance) {
		super(instance);
	}

	private LobbyTimer lt = new LobbyTimer();
	
	@EventHandler
	public void event(PlayerQuitEvent e) {
		super.getPlayerManager().removePlayer(e.getPlayer().getUniqueId());
		if (super.getGameStatus().isState(GameState.LOBBY)) {
			e.setQuitMessage(super.getGameManager().getGameName() + "§c" + e.getPlayer().getDisplayName()
					+ " §7a quité la partie. (§c" + super.getPlayerManager().getOnlineCount() + "§7/"
					+ super.getGameManager().getMaxPlayer()+").");
			
			if(super.getPlayerManager().getOnlineCount() <= super.getGameManager().getMinPlayer()) {
				lt.stop();
				for(ColorPlayer cps : super.getPlayerManager().getPlayers()) {
					cps.sendMessage("§cDémarrage annulé, pas assez de joueurs.");
				}
			}
			
		}else{
			e.setQuitMessage(null);
		}
	}

}
