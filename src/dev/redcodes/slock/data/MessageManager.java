package dev.redcodes.slock.data;

import dev.redcodes.slock.Slock;

public class MessageManager {

	public static String getMessage(String key) {
		FileConfig config = new FileConfig("Slock", "messages.yml");

		String msg = config.getString(key);

		if (msg != null) {
			return Slock.getPrefix() + msg.replace("&", "§");
		}
		
		return "§4There was an Error while getting the message with the key \"" + key + "\".";
	}

}
