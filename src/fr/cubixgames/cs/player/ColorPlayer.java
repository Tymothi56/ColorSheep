package fr.cubixgames.cs.player;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.manager.GameInventory;
import fr.cubixgames.cs.manager.utils.SoundUtils;
import fr.cubixgames.cs.manager.utils.TitleUtils;

public class ColorPlayer {
	
	private UUID uuid;
	private String name;
	
	public ColorPlayer(UUID uuid) {
		this.uuid = uuid;
		this.name = Bukkit.getPlayer(uuid).getName();
		ColorSheep.getInstance().getPlayerManager().register(this);
	}
	
	public UUID getPlayerUUID() {
		return uuid;
	}
	
	public String getPlayerName() {
		return name;
	}
	
	public Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}
	
	public void openInventory(GameInventory inv) {
		Bukkit.getPlayer(uuid).openInventory(inv.craftInventory());
	}
	
	public void sendActionBar(String msg) {
		TitleUtils.sendActionBar(Bukkit.getPlayer(uuid), msg);
	}
	
	public void sendTitle(String title, String subTitle, int time) {
		TitleUtils.sendTitle(Bukkit.getPlayer(uuid), title, subTitle, time);
	}
	
	public void sendSound(SoundUtils sound) {
		Bukkit.getPlayer(uuid).playSound(Bukkit.getPlayer(uuid).getLocation(), sound.getSound(), 20, 5);
	}
	
	public void sendMessage(String msg) {
		Bukkit.getPlayer(uuid).sendMessage(ColorSheep.getInstance().getGameManager().getGameName()+msg);
	}
	
}
