package dev.redcodes.slock.data;


public class ConfigCreator {

	public static void createConfigs() {
		
		FileConfig config = new FileConfig("Slock", "config.yml");
		config.addDefault("enabled", true);
		config.addDefault("locked", false);
		config.options().copyDefaults(true);
		config.saveConfig();
		
		FileConfig msgConfig = new FileConfig("Slock", "messages.yml");
		msgConfig.options().header("Here you can edit all of the Messages for the Plugin\n\nYou can also use Color Codes (https://www.spigotmc.org/attachments/example2-png.323205/)");
		msgConfig.addDefault("Prefix", "[&aSlock&r]");
		msgConfig.addDefault("Messages.SlockOn", "&cThe Server is now locked.");
		msgConfig.addDefault("Messages.SlockOff", "&aThe Server is now unlocked.");
		msgConfig.addDefault("Messages.Kick", "&4The Server was locked by an administrator.");
		msgConfig.addDefault("Messages.KickOnJoin", "&4The Server is locked.");
		msgConfig.addDefault("Messages.Bypass", "&cThe Server is currently locked. &aYou bypassed the lock.");
		msgConfig.addDefault("Messages.Errors.NoPermission", "&4You dont have Permission to run this command.");
		msgConfig.addDefault("Messages.Errors.FalseArguments", "&bDid you mean &n/slock [on/off]&r&b?");
		msgConfig.addDefault("Messages.Errors.SlockAlreadyOn", "&4The Server is already locked.");
		msgConfig.addDefault("Messages.Errors.SlockAlreadyOff","&4The Server is already unlocked.");
		msgConfig.options().copyDefaults(true);
		msgConfig.options().copyHeader(true);
		msgConfig.saveConfig();
		
		
	}
	
}
