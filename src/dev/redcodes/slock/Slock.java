package dev.redcodes.slock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev.redcodes.slock.data.ConfigCreator;
import dev.redcodes.slock.data.FileConfig;
import dev.redcodes.slock.serverlock.commands.SlockCommand;
import dev.redcodes.slock.serverlock.listener.PlayerInventoryListener;
import dev.redcodes.slock.serverlock.listener.PlayerJoinListener;

public class Slock extends JavaPlugin {

	private static Slock plugin;
	private static String prefix;

	public void onEnable() {

		plugin = this;

		ConfigCreator.createConfigs();

		FileConfig msgConfig = new FileConfig("Slock", "messages.yml");

		prefix = msgConfig.getString("Prefix").replace("&", "§") + " ";

		FileConfig config = new FileConfig("Slock", "config.yml");

		if (!config.getBoolean("enabled")) {
			Bukkit.getConsoleSender().sendMessage(prefix + "§cSlock was disabled by the config.");
			this.setEnabled(false);
			return;
		}
		
		//Version checking
		//TODO: Rewrite Version checking

//		String version = Bukkit.getVersion().substring(Bukkit.getVersion().lastIndexOf(":") + 1).replace(")", "")
//				.trim();
//		String majorVersion = version.substring(0, version.lastIndexOf(".")).trim();
//		int majorVersionNum = Integer.valueOf(majorVersion.replace("1.", ""));
//		
//		System.out.println(version);
//		System.out.println(majorVersion);
//		System.out.println(majorVersionNum);
//		
//		if(majorVersionNum < 13) {
//			Bukkit.getConsoleSender().sendMessage(prefix + "§cSlock was disabled because the Minecraft Version \"" + version + "\" is not supported.");
//			this.setEnabled(false);
//			return;
//		}

		getCommand("slock").setExecutor(new SlockCommand());
		

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoinListener(), this);
		pm.registerEvents(new PlayerInventoryListener(), this);

		Bukkit.getServer().getConsoleSender().sendMessage(prefix + "§cSlock Plugin by §6§lRedi");
		Bukkit.getServer().getConsoleSender().sendMessage(prefix + "§aSlock was started successfully");

	}

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