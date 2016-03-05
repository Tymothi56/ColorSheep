package fr.cubixgames.cs.manager;

public class GameManager {
	
	private String gameName;
	private int maxPlayer;
	private int minPlayer;
	
	public void setMinPlayer(int minPlayer) {
		this.minPlayer = minPlayer;
	}
	
	public int getMinPlayer() {
		return minPlayer;
	}
	
	public void setMaxPlayer(int player) {
		maxPlayer = player;
	}
	
	public int getMaxPlayer() {
		return maxPlayer;
	}
	
	public void setGameName(String name) {
		gameName = name;
	}
	
	public String getGameName() {
		return gameName;
	}
	
}
