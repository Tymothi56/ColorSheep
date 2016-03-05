package fr.cubixgames.cs.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cubixgames.cs.ColorSheep;
import fr.cubixgames.cs.manager.GameCommand;
import fr.cubixgames.cs.manager.utils.SoundUtils;
import fr.cubixgames.cs.player.ColorPlayer;
import fr.cubixgames.cs.state.lobby.LobbyTimer;
import fr.cubixgames.cubixapi.api.bdd.PlayerInfo;
import fr.cubixgames.cubixapi.api.bdd.RankList;

public class GameCmd extends GameCommand implements CommandExecutor {

	public GameCmd(ColorSheep instance) {
		super(instance);
	}

	private LobbyTimer lt = new LobbyTimer();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) return true;
		Player p = (Player) sender;
		ColorPlayer cp = super.getColorPlayer(p.getUniqueId());
//		PlayerInfo pi = new PlayerInfo(p.getUniqueId());
		
//		if(pi.getRank() == RankList.ADMINISTRATEUR) {
			if(args.length == 0) {
				cp.sendMessage("§cUsage: /game <start>");
			}else{
				if(args[0].equalsIgnoreCase("start")) {
					lt.setTimer(10);
					lt.start();
				}else{
					cp.sendSound(SoundUtils.ERROR);
					cp.sendMessage("§cUsage: /game <start>");
				}
			}
//		}else{
//			cp.sendSound(SoundUtils.ERROR);
//			cp.sendMessage("§c§oCommand invalide.");
//		}
		
		return false;
	}

}
