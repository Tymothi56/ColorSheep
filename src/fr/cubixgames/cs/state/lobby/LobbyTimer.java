package fr.cubixgames.cs.state.lobby;

import org.bukkit.Bukkit;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.manager.helper.InterfaceTask;
import fr.cubixgames.cs.player.ColorPlayer;

public class LobbyTimer implements InterfaceTask {
	
	private ColorSheep instance = ColorSheep.getInstance();
	
	private int timer;
	private int task;
	
	@Override
	public void start() {
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(ColorSheep.getInstance(), new Runnable() {
			@Override
			public void run() {
				if(timer <= 0) {
					stop();
				}else{
					for(ColorPlayer cps : instance.getPlayerManager().getPlayers()) {
						cps.getPlayer().setLevel(getTimer());
						if(timer == 60 || timer == 30 || timer == 15 || timer == 10 || (timer <= 5 && timer != 0)) {
							cps.sendTitle("§7Début de la partie dans:", "§6"+getTimer()+" sec.", 10);
						}
					}
					timer--;
				}
			}
		}, 20, 20);
	}

	@Override
	public void stop() {
		Bukkit.getScheduler().cancelTask(task);
	}
	
	public int getTimer() {
		return timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	
	
}
