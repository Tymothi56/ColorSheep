package fr.cubixgames.cs.manager.utils;

import org.bukkit.Sound;

public enum SoundUtils {
	
	ERROR(Sound.NOTE_BASS),
	TIMER(Sound.LEVEL_UP),
	FORCE_START(Sound.ENDERDRAGON_GROWL),
	COLOR(Sound.CLICK),
	END(Sound.ANVIL_BREAK);
	
	private Sound sound;
	
	SoundUtils(Sound sound) {
		this.sound = sound;
	}
	
	public Sound getSound() {
		return sound;
	}
	
}
