package dev.redcodes.slock.data;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileConfig extends YamlConfiguration {

	public String filePath;
	public String folderPath;
	public String seperator;

	public FileConfig(String folder, String fileName) {

		
		seperator = System.getProperty("file.seperator");

		if (seperator == null) {
			seperator = "/";
		}
		
		folderPath = "plugins" + seperator + folder;
		filePath = "plugins" + seperator + folder + seperator + fileName;
		File folderFile = new File(folderPath);
		File file = new File(filePath);
		try {
			folderFile.mkdirs();
			file.createNewFile();

			load(filePath);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void saveConfig() {
		try {
			save(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
