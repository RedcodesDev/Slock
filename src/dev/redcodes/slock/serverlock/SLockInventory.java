package dev.redcodes.slock.serverlock;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.redcodes.slock.Slock;

public class SLockInventory {

	Player p;
	
	public SLockInventory(Player p) {
		this.p = p;
	}
	
	public void open() {
		
		boolean slock = Slock.isLocked();
		
		Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, "§2Server Lock");
		
		ItemStack on = new ItemStack(Material.LIME_WOOL);
		ItemMeta onMeta = on.getItemMeta();
		onMeta.setDisplayName("§a§lOn");
		if(slock) {
			onMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		}
		on.setItemMeta(onMeta);
		
		ItemStack off = new ItemStack(Material.RED_WOOL);
		ItemMeta offMeta = off.getItemMeta();
		offMeta.setDisplayName("§c§lOff");
		if(!slock) {
			offMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		}
		off.setItemMeta(offMeta);
		
		ItemStack sign = new ItemStack(Material.NAME_TAG);
		ItemMeta signMeta = sign.getItemMeta();
		signMeta.setDisplayName("§bEnable/Disable the Server lock");
		sign.setItemMeta(signMeta);
		
		inv.setItem(4, sign);
		inv.setItem(12, on);
		inv.setItem(14, off);
		
		this.p.openInventory(inv);
		this.p.playSound(this.p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 10, 0);
		
	}
	
}
