package fr.cubixgames.cs.manager;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.listener.ListenerManager;
import fr.cubixgames.cs.manager.helper.InterfaceGameStatus;

public class GameStatus implements InterfaceGameStatus {

	private GameState gs;
	private GameManager gm;
	
	public GameStatus(GameManager gm) {
		this.gm = gm;
	}
	
	@Override
	public void lobby() {
		new ListenerManager(ColorSheep.getInstance()).register();
		gs = GameState.LOBBY;
		gm.setGameName("§bColor§6Sheep §7 > §f");
		gm.setMaxPlayer(8);
		gm.setMinPlayer(4);
	}
	
	@Override
	public void game() {
		gs = GameState.GAME;
	}

	@Override
	public void end() {
		gs = GameState.END;
	}
	
	public boolean isState(GameState isState) {
		return gs == isState;
	}
	
	public GameState getState() {
		return gs;
	}
	
	public enum GameState {
		LOBBY,
		GAME,
		END;
	}

}


