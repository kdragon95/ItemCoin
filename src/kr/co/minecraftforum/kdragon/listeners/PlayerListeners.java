package kr.co.minecraftforum.kdragon.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import kr.co.minecraftforum.kdragon.itemcoin.ItemCoin;

public class PlayerListeners implements Listener {
	
	private int configItem = ItemCoin.customConfig.getInt("Item");
	private int configEarn = ItemCoin.customConfig.getInt("value_per_one");
	
	@EventHandler
	public void playerItemPickupEvent(PlayerPickupItemEvent e) {
		
		String player = e.getPlayer().getName();
		boolean isOnline = e.getPlayer().isOnline();
		int pickupItem = e.getItem().getItemStack().getTypeId();
		double value = e.getItem().getItemStack().getAmount();
		double total = configEarn * value;
		
		if(configItem == pickupItem) {
			e.setCancelled(true);
			e.getItem().remove();
			ItemCoin.boseconomy.addPlayerMoney(player, total, isOnline);
			e.getPlayer().sendMessage(ChatColor.YELLOW + "" + total + ItemCoin.boseconomy.getMoneyNamePlural() + ChatColor.GRAY + "À»(¸¦) È¹µæÇÏ¿´½À´Ï´Ù.");
		}
		
	}
	
}
