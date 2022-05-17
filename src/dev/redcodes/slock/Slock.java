package dev.redcodes.slock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev.redcodes.slock.data.ConfigCreator;
import dev.redcodes.slock.data.FileConfig;
import dev.redcodes.slock.data.stats.Metrics;
import dev.redcodes.slock.serverlock.commands.SlockCommand;
import dev.redcodes.slock.serverlock.listener.PlayerInventoryListener;
import dev.redcodes.slock.serverlock.listener.PlayerJoinListener;

public class Slock extends JavaPlugin {

	private static Slock plugin;
	private static String prefix;

	@Override
	public void onEnable() {

		plugin = this;

		ConfigCreator.createConfigs();

		FileConfig msgConfig = new FileConfig("Slock", "messages.yml");

		prefix = msgConfig.getString("Prefix").replace("&", "§") + " ";

		FileConfig config = new FileConfig("Slock", "config.yml");

		if (!config.getBoolean("enabled")) {
			Bukkit.getConsoleSender().sendMessage(prefix + "§cSLock was disabled by the config.");
			this.setEnabled(false);
			return;
		}

		// Setup bstats
		int bstatsId = 15222;
		new Metrics(plugin, bstatsId);

		// Version checking

		String[] allowedVersions = new String[] {
			"1.13",
			"1.14",
			"1.15",
			"1.16",
			"1.17",
			"1.18"
		};
		
		String versionString = Bukkit.getVersion();
		
		boolean allowed = false;
		
		for(String version : allowedVersions) {
			if(versionString.contains(version)) {
				allowed = true;
			}
		}
		
		if(!allowed) {
			Bukkit.getConsoleSender().sendMessage(prefix + "§cThe Minecraft Version of this Server is not supported. SLock has been disabled.");
			Bukkit.getConsoleSender().sendMessage(prefix + "§bPlease check if there is another Version available on the SLock Spigot page: https://www.spigotmc.org/resources/slock-1-8-1-12-2-the-simplest-minecraft-server-locker.92670/");
			this.setEnabled(false);
			return;
		}

		getCommand("slock").setExecutor(new SlockCommand());

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoinListener(), this);
		pm.registerEvents(new PlayerInventoryListener(), this);

		Bukkit.getServer().getConsoleSender().sendMessage(prefix + "§cSlock Plugin by §6§lRedi");
		Bukkit.getServer().getConsoleSender().sendMessage(prefix + "§aSlock was started successfully");

	}

	@Override
	public void onDisable() {

		Bukkit.getConsoleSender().sendMessage(prefix + "§cSlock was disabled successfully");

	}

	public static Slock getPlugin() {
		return plugin;
	}

	public static String getPrefix() {
		return prefix;
	}

	public static boolean isLocked() {
		FileConfig config = new FileConfig("Slock", "config.yml");

		return config.getBoolean("locked");
	}

	public static void setLocked(boolean lock) {
		FileConfig config = new FileConfig("Slock", "config.yml");

		config.set("locked", lock);
		config.saveConfig();
	}
}