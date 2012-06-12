package kr.co.minecraftforum.kdragon.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import kr.co.minecraftforum.kdragon.itemcoin.ItemCoin;

public class PlayerListeners implements Listener {
	
	private int configItem = ItemCoin.customConfig.getInt("Item");
	private double configEarn = ItemCoin.customConfig.getDouble("value_per_one");
	
	@EventHandler
	public void playerItemPickupEvent(PlayerPickupItemEvent e) {
		
		String player = e.getPlayer().getName();
		int pickupItem = e.getItem().getItemStack().getTypeId();
		double value = e.getItem().getItemStack().getAmount();
		double total = configEarn * value;
		
		if(configItem == pickupItem) {
			e.setCancelled(true);
			e.getItem().remove();
			if(ItemCoin.econ.hasAccount(player)) {
				ItemCoin.econ.depositPlayer(player, total);
				e.getPlayer().sendMessage(ChatColor.YELLOW + "" + total + " " + ItemCoin.econ.currencyNamePlural() + ChatColor.GRAY + "을(를) 획득하였습니다.");
			}
			if(!ItemCoin.econ.hasAccount(player)) {
				e.getPlayer().sendMessage(ChatColor.RED + "[알림!] 계좌가 존재하지 않아 돈을 획득 할 수 없습니다. 서버 관리자에게 문의 해 주세요.");
			}
		}
		
	}
	
}
