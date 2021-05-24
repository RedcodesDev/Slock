package dev.redcodes.slock.serverlock.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.redcodes.slock.Slock;
import dev.redcodes.slock.data.MessageManager;
import dev.redcodes.slock.serverlock.SLockInventory;

public class SlockCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (p.hasPermission("slock.slock") || p.hasPermission("slock.*")) {

				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("on")) {
						if (!Slock.isLocked()) {
							Slock.setLocked(true);

							for (Player plr : Bukkit.getOnlinePlayers()) {
								if (!(plr.hasPermission("slock.bypass") && plr.hasPermission("slock.*"))) {
									plr.kickPlayer(MessageManager.getMessage("Messages.Kick"));
								}
							}

							p.sendMessage(MessageManager.getMessage("Messages.SlockOn"));
							p.playSound(p.getLocation(), Sound.BLOCK_IRON_DOOR_CLOSE, 10, 0);

						} else {
							p.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOn"));
							p.playSound(p.getLocation(), Sound.ENTITY_POLAR_BEAR_HURT, 10, 0);
						}

					} else if (args[0].equalsIgnoreCase("off")) {

						if (Slock.isLocked()) {
							Slock.setLocked(false);

							p.sendMessage(MessageManager.getMessage("Messages.SlockOff"));
							p.playSound(p.getLocation(), Sound.BLOCK_IRON_DOOR_OPEN, 10, 0);

						} else {
							p.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOff"));
							p.playSound(p.getLocation(), Sound.ENTITY_POLAR_BEAR_HURT, 10, 0);
						}
					} else {
						p.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
						p.playSound(p.getLocation(), Sound.ENTITY_POLAR_BEAR_HURT, 10, 0);
					}
				} else {
					SLockInventory inv = new SLockInventory(p);
					inv.open();
				}
			} else {
				p.sendMessage(MessageManager.getMessage("Messages.Errors.NoPermission"));
				p.playSound(p.getLocation(), Sound.ENTITY_POLAR_BEAR_HURT, 10, 0);
			}
		}

		return false;
	}

}
