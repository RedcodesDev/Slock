package dev.redcodes.slock.serverlock.listener;

import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import dev.redcodes.slock.Slock;

public class PlayerInventoryListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getView().getTitle().equals("§2Server Lock")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null) {
				Player p = (Player) e.getWhoClicked();
				switch (e.getCurrentItem().getType()) {

				case LIME_WOOL:
					
					Slock.setLocked(true);
					e.getCurrentItem().addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
					e.getClickedInventory().getItem(14).removeEnchantment(Enchantment.KNOCKBACK);
					p.playSound(p.getLocation(), Sound.ENTITY_DROWNED_SHOOT, 10, 0);
					
					break;

				case RED_WOOL:
					Slock.setLocked(false);
					e.getCurrentItem().addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
					e.getClickedInventory().getItem(12).removeEnchantment(Enchantment.KNOCKBACK);
					p.playSound(p.getLocation(), Sound.ENTITY_DROWNED_SHOOT, 10, 0);
					break;

				default:
					p.playSound(p.getLocation(), Sound.ENTITY_ARMOR_STAND_BREAK, 10, 0);
					break;

				}
			}
		}
	}

}
