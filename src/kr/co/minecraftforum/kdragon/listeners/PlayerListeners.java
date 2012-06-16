package kr.co.minecraftforum.kdragon.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import kr.co.minecraftforum.kdragon.itemcoin.ItemCoin;

public class PlayerListeners implements Listener {
	
	@EventHandler
	public void playerItemPickupEvent(PlayerPickupItemEvent e) {
		
		String player = e.getPlayer().getName();
		int pickupItem = e.getItem().getItemStack().getTypeId();
		double amount = e.getItem().getItemStack().getAmount();
		
		if(ItemCoin.coin1 == pickupItem) {
			e.setCancelled(true);
			e.getItem().remove();
			if(ItemCoin.econ.hasAccount(player)) {
				ItemCoin.econ.depositPlayer(player, ItemCoin.value1*amount);
				e.getPlayer().sendMessage(ChatColor.YELLOW + "" + ItemCoin.value1*amount + " " + ItemCoin.econ.currencyNamePlural() + ChatColor.GRAY + "을(를) 획득하였습니다.");
			}
			if(!ItemCoin.econ.hasAccount(player)) {
				e.getPlayer().sendMessage(ChatColor.RED + "[알림!] 계좌가 존재하지 않아 돈을 획득 할 수 없습니다. 서버 관리자에게 문의 해 주세요.");
			}
		}
		
		if(ItemCoin.coin2 == pickupItem) {
			e.setCancelled(true);
			e.getItem().remove();
			if(ItemCoin.econ.hasAccount(player)) {
				ItemCoin.econ.depositPlayer(player, ItemCoin.value2*amount);
				e.getPlayer().sendMessage(ChatColor.YELLOW + "" + ItemCoin.value2*amount + " " + ItemCoin.econ.currencyNamePlural() + ChatColor.GRAY + "을(를) 획득하였습니다.");
			}
			if(!ItemCoin.econ.hasAccount(player)) {
				e.getPlayer().sendMessage(ChatColor.RED + "[알림!] 계좌가 존재하지 않아 돈을 획득 할 수 없습니다. 서버 관리자에게 문의 해 주세요.");
			}
		}
		
		if(ItemCoin.coin3 == pickupItem) {
			e.setCancelled(true);
			e.getItem().remove();
			if(ItemCoin.econ.hasAccount(player)) {
				ItemCoin.econ.depositPlayer(player, ItemCoin.value3*amount);
				e.getPlayer().sendMessage(ChatColor.YELLOW + "" + ItemCoin.value3*amount + " " + ItemCoin.econ.currencyNamePlural() + ChatColor.GRAY + "을(를) 획득하였습니다.");
			}
			if(!ItemCoin.econ.hasAccount(player)) {
				e.getPlayer().sendMessage(ChatColor.RED + "[알림!] 계좌가 존재하지 않아 돈을 획득 할 수 없습니다. 서버 관리자에게 문의 해 주세요.");
			}
		}
		
	}
	
}
