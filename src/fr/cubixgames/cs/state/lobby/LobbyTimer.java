package fr.cubixgames.cs.state.lobby;

import org.bukkit.Bukkit;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.manager.helper.InterfaceTask;
import fr.cubixgames.cs.manager.utils.SoundUtils;
import fr.cubixgames.cs.player.ColorPlayer;

public class LobbyTimer implements InterfaceTask {
	
	private ColorSheep instance = ColorSheep.getInstance();
	
	private boolean run;
	private int timer;
	private int task;
	
	@Override
	public void start() {
		run = true;
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(ColorSheep.getInstance(), new Runnable() {
			@Override
			public void run() {
				if(timer <= 0) {
					run = false;
					instance.getGameStatus().game();
					stop();
				}else{
					for(ColorPlayer cps : instance.getPlayerManager().getPlayers()) {
						cps.getPlayer().setLevel(getTimer());
						if(timer == 60 || timer == 30 || timer == 15 || timer == 10 || (timer <= 5 && timer != 0)) {
							cps.sendTitle("§7Début de la partie dans:", "§6"+getTimer()+" sec.", 10);
							cps.sendSound(SoundUtils.TIMER);
						}
					}
					timer--;
				}
			}
		}, 20, 20);
	}

	@Override
	public void stop() {
		run = false;
		Bukkit.getScheduler().cancelTask(task);
	}
	
	public boolean isRun() {
		return run;
	}
	
	public int getTimer() {
		return timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	
	
}
