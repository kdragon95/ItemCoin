package kr.co.minecraftforum.kdragon.commands;

import kr.co.minecraftforum.kdragon.itemcoin.ItemCoin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCore implements CommandExecutor {
	
	private ItemCoin plugin;
	
	public CommandCore(ItemCoin plugin) {
		this.plugin = plugin;
	}
	
	private HelpCommand helpCommand = new HelpCommand();
	private InfoCommand infoCommand = new InfoCommand();
	private MobsInfoCommand mobsInfoCommand = new MobsInfoCommand();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		//��ɾ� ������ �÷��̾��϶� 
		if(sender instanceof Player) {
			Player csender = (Player) sender;
			String csenderName = csender.getName();
			World pworld = csender.getWorld();
			//args�� ���� ��
			if(args.length == 0) {
				if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.help")) {
					helpCommand.helpCommand(csender);
				}
				if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.help")) {
					csender.sendMessage(ChatColor.RED + "[ItemCoin] ������ �����ϴ�.");
				}
			}
			//args ���̰� 1�� ��
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("����")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.info")) {
						infoCommand.pluginInfo(csender);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.info")) {
						csender.sendMessage(ChatColor.RED + "[ItemCoin] ������ �����ϴ�.");
					}
				}
				if(args[0].equalsIgnoreCase("����")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.save")) {
						plugin.saveConfig(csender);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.save")) {
						csender.sendMessage(ChatColor.RED + "[ItemCoin] ������ �����ϴ�.");
					}
				}
			}
			//args ���̰� 2�� ��
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("����ȣ")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.mobsinfo")) {
						mobsInfoCommand.onCommand(csender, cmd, Label, args);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.mobsinfo")) {
						csender.sendMessage(ChatColor.RED + "[ItemCoin] ������ �����ϴ�.");
					}	
				}
				if(args[0].equalsIgnoreCase("�÷��̾�")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.toggle")) {
						plugin.ifOnlyDropWhenKilldeByPlayer(csender, args);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.toggle")) {
						sender.sendMessage(ChatColor.RED + "[ItemCoin] ������ �����ϴ�.");
					}
				}
			}
			//args ���̰� 3�� ��
			if(args.length == 3) {
				if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("3")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.coin")) {
						plugin.coinChange(csender, cmd, Label, args);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.coin")) {
						sender.sendMessage(ChatColor.RED + "[ItemCoin] ������ �����ϴ�.");
					}
					
				}
			}
			//args ���̰� 4�� ��
			if(args.length == 4) {
				
				if(args[0].equalsIgnoreCase("��")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.mobs")) {
						plugin.mobChange(csender, cmd, Label, args);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.mobs")) {
						sender.sendMessage(ChatColor.RED + "[ItemCoin] ������ �����ϴ�.");
					}
					
				}
				
			}
			//args ���̰� 5 �̻��� ��
			if(args.length >= 5) {
				csender.sendMessage(ChatColor.RED + "[ItemCoin] ��ɾ� ����! ��ɾ �ٽ� Ȯ���� �ּ���.");
			}
		}
		//��ɾ� ������ �÷��̾ �ƴ� ��
		if(!(sender instanceof Player)) {
			Bukkit.getLogger().info("[ItemCoin] �ش� ��ɾ�� �÷��̾ ��� �����մϴ�.");
		}
		return true;
	}
	
}
