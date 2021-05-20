package dev.redcodes.slock.serverlock.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.redcodes.slock.Slock;
import dev.redcodes.slock.data.MessageManager;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if (Slock.isLocked()) {
			if (e.getPlayer().hasPermission("slock.bypass") || e.getPlayer().hasPermission("slock.*")) {
				e.getPlayer().sendMessage(MessageManager.getMessage("Messages.Bypass"));
			} else {
				e.getPlayer().kickPlayer(MessageManager.getMessage("Messages.KickOnJoin"));
			}
		}
	}

}
