package fr.cubixgames.cs.command;

import fr.cubixgames.cs.ColorSheep;

public class CommandManager {
	
	private ColorSheep cs;
	
	public CommandManager(ColorSheep cs) {
		this.cs = cs;
	}
	
	public void register() {
		cs.getCommand("game").setExecutor(new GameCmd(cs));
	}
	
}
