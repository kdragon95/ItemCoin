package kr.co.minecraftforum.kdragon.commands;

import kr.co.minecraftforum.kdragon.itemcoin.ItemCoin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class InfoCommand {
	
	protected void pluginInfo(Player csender) {
		
		csender.sendMessage(ChatColor.GREEN + "---------------------" + ChatColor.YELLOW + "ItemCoin ������" + ChatColor.GREEN + "---------------------");
		csender.sendMessage(ChatColor.GREEN + "���� 1" + ChatColor.YELLOW + " : " + ItemCoin.nameOfCoin1 + ", " + ItemCoin.value1);
		csender.sendMessage(ChatColor.GREEN + "���� 2" + ChatColor.YELLOW + " : " + ItemCoin.nameOfCoin2 + ", " + ItemCoin.value2);
		csender.sendMessage(ChatColor.GREEN + "���� 3" + ChatColor.YELLOW + " : " + ItemCoin.nameOfCoin3 + ", " + ItemCoin.value3);
		csender.sendMessage(ChatColor.GREEN + "����" + ChatColor.YELLOW + " : " + ItemCoin.econ.currencyNameSingular());
		csender.sendMessage(ChatColor.GREEN + "---------------------" + ChatColor.YELLOW + "������ : kdragon" + ChatColor.GREEN + "---------------------");
		
	}
	
}
