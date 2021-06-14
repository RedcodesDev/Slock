package dev.redcodes.slock.serverlock.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.ProxiedCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.CommandMinecart;

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
		} else if (sender instanceof ConsoleCommandSender) {
			ConsoleCommandSender obj = (ConsoleCommandSender) sender;

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					if (!Slock.isLocked()) {
						Slock.setLocked(true);

						for (Player plr : Bukkit.getOnlinePlayers()) {
							if (!(plr.hasPermission("slock.bypass") && plr.hasPermission("slock.*"))) {
								plr.kickPlayer(MessageManager.getMessage("Messages.Kick"));
							}
						}

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOn"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOn"));
					}

				} else if (args[0].equalsIgnoreCase("off")) {

					if (Slock.isLocked()) {
						Slock.setLocked(false);

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOff"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOff"));
					}
				} else {
					obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
				}
			} else {
				obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
			}
		} else if (sender instanceof RemoteConsoleCommandSender) {

			RemoteConsoleCommandSender obj = (RemoteConsoleCommandSender) sender;

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					if (!Slock.isLocked()) {
						Slock.setLocked(true);

						for (Player plr : Bukkit.getOnlinePlayers()) {
							if (!(plr.hasPermission("slock.bypass") && plr.hasPermission("slock.*"))) {
								plr.kickPlayer(MessageManager.getMessage("Messages.Kick"));
							}
						}

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOn"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOn"));
					}

				} else if (args[0].equalsIgnoreCase("off")) {

					if (Slock.isLocked()) {
						Slock.setLocked(false);

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOff"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOff"));
					}
				} else {
					obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
				}
			} else {
				obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
			}

		} else if (sender instanceof BlockCommandSender) {

			BlockCommandSender obj = (BlockCommandSender) sender;

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					if (!Slock.isLocked()) {
						Slock.setLocked(true);

						for (Player plr : Bukkit.getOnlinePlayers()) {
							if (!(plr.hasPermission("slock.bypass") && plr.hasPermission("slock.*"))) {
								plr.kickPlayer(MessageManager.getMessage("Messages.Kick"));
							}
						}

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOn"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOn"));
					}

				} else if (args[0].equalsIgnoreCase("off")) {

					if (Slock.isLocked()) {
						Slock.setLocked(false);

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOff"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOff"));
					}
				} else {
					obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
				}
			} else {
				obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
			}

		} else if (sender instanceof CommandMinecart) {

			CommandMinecart obj = (CommandMinecart) sender;

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					if (!Slock.isLocked()) {
						Slock.setLocked(true);

						for (Player plr : Bukkit.getOnlinePlayers()) {
							if (!(plr.hasPermission("slock.bypass") && plr.hasPermission("slock.*"))) {
								plr.kickPlayer(MessageManager.getMessage("Messages.Kick"));
							}
						}

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOn"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOn"));
					}

				} else if (args[0].equalsIgnoreCase("off")) {

					if (Slock.isLocked()) {
						Slock.setLocked(false);

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOff"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOff"));
					}
				} else {
					obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
				}
			} else {
				obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
			}

		} else if (sender instanceof ProxiedCommandSender) {

			ProxiedCommandSender obj = (ProxiedCommandSender) sender;

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					if (!Slock.isLocked()) {
						Slock.setLocked(true);

						for (Player plr : Bukkit.getOnlinePlayers()) {
							if (!(plr.hasPermission("slock.bypass") && plr.hasPermission("slock.*"))) {
								plr.kickPlayer(MessageManager.getMessage("Messages.Kick"));
							}
						}

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOn"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOn"));
					}

				} else if (args[0].equalsIgnoreCase("off")) {

					if (Slock.isLocked()) {
						Slock.setLocked(false);

						obj.sendMessage(MessageManager.getMessage("Messages.SlockOff"));

					} else {
						obj.sendMessage(MessageManager.getMessage("Messages.Errors.SlockAlreadyOff"));
					}
				} else {
					obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
				}
			} else {
				obj.sendMessage(MessageManager.getMessage("Messages.Errors.FalseArguments"));
			}

		} else {
			sender.sendMessage(MessageManager.getMessage("Messages.Errors.InvalidSender"));
		}

		return false;
	}

}
