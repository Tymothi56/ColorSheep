package fr.cubixgames.cs.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.cubixgames.cs.manager.helper.AbstractManager;
import fr.cubixgames.cs.player.ColorPlayer;

public class PlayerManager extends AbstractManager<ColorPlayer> {

	private Map<UUID, ColorPlayer> players = new HashMap<>();
	private List<ColorPlayer> online = new ArrayList<>();
	
	@Override
	public ColorPlayer register(ColorPlayer player) {
		Player p = Bukkit.getPlayer(player.getPlayerUUID());
		for(int i = 0; i < 3; i++) {
			p.sendMessage("");
		}
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.setLevel(0);
		p.setExp(0);
		p.setGameMode(GameMode.ADVENTURE);
		p.setFoodLevel(20);
		p.setSaturation((float) 20);
		return player;
	}
	
	public void addPlayer(UUID uuid) {
		players.put(uuid, new ColorPlayer(uuid));
		online.add(new ColorPlayer(uuid));
	}
	
	public void removePlayer(UUID uuid) {
		players.remove(uuid);
		online.remove(getColorPlayer(uuid));
	}
	
	public ColorPlayer getColorPlayer(UUID uuid) {
		return players.get(uuid);
	}
	
	public int getOnlineCount() {
		return players.size();
	}
	
	public List<ColorPlayer> getPlayers() {
		return online;
	}

}
