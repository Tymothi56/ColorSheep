package fr.cubixgames.cs.manager.utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

public class TitleUtils {
	
	public static void sendTitle(Player p, String title, String subTitle, int time) {
		IChatBaseComponent cbc1 = ChatSerializer.a("{\"text\": \""+title+"\"}");
		IChatBaseComponent cbc2 = ChatSerializer.a("{\"text\": \""+subTitle+"\"}");
		PacketPlayOutTitle packet1 = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, time, 20);
		PacketPlayOutTitle packet2 = new PacketPlayOutTitle(EnumTitleAction.TITLE, cbc1);
		PacketPlayOutTitle packet3 = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, cbc2);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet1);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet2);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet3);
	}
	
	public static void sendActionBar(Player p, String msg) {
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \""+msg+"\"}");
		PacketPlayOutChat packet = new PacketPlayOutChat(cbc, (byte) 2);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	}
	
}
