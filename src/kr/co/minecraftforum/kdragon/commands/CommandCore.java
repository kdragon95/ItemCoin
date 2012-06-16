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
		//명령어 센더가 플레이어일때 
		if(sender instanceof Player) {
			Player csender = (Player) sender;
			String csenderName = csender.getName();
			World pworld = csender.getWorld();
			//args가 없을 때
			if(args.length == 0) {
				if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.help")) {
					helpCommand.helpCommand(csender);
				}
				if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.help")) {
					csender.sendMessage(ChatColor.RED + "[ItemCoin] 권한이 없습니다.");
				}
			}
			//args 길이가 1일 때
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("정보")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.info")) {
						infoCommand.pluginInfo(csender);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.info")) {
						csender.sendMessage(ChatColor.RED + "[ItemCoin] 권한이 없습니다.");
					}
				}
				if(args[0].equalsIgnoreCase("저장")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.save")) {
						plugin.saveConfig(csender);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.save")) {
						csender.sendMessage(ChatColor.RED + "[ItemCoin] 권한이 없습니다.");
					}
				}
			}
			//args 길이가 2일 때
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("몹번호")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.mobsinfo")) {
						mobsInfoCommand.onCommand(csender, cmd, Label, args);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.mobsinfo")) {
						csender.sendMessage(ChatColor.RED + "[ItemCoin] 권한이 없습니다.");
					}	
				}
				if(args[0].equalsIgnoreCase("플레이어")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.toggle")) {
						plugin.ifOnlyDropWhenKilldeByPlayer(csender, args);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.toggle")) {
						sender.sendMessage(ChatColor.RED + "[ItemCoin] 권한이 없습니다.");
					}
				}
			}
			//args 길이가 3일 때
			if(args.length == 3) {
				if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("3")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.coin")) {
						plugin.coinChange(csender, cmd, Label, args);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.coin")) {
						sender.sendMessage(ChatColor.RED + "[ItemCoin] 권한이 없습니다.");
					}
					
				}
			}
			//args 길이가 4일 때
			if(args.length == 4) {
				
				if(args[0].equalsIgnoreCase("몹")) {
					if(ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.mobs")) {
						plugin.mobChange(csender, cmd, Label, args);
					}
					if(!ItemCoin.perms.has(pworld, csenderName, "itemcoin.admin.mobs")) {
						sender.sendMessage(ChatColor.RED + "[ItemCoin] 권한이 없습니다.");
					}
					
				}
				
			}
			//args 길이가 5 이상일 때
			if(args.length >= 5) {
				csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 명령어를 다시 확인해 주세요.");
			}
		}
		//명령어 센더가 플레이어가 아닐 때
		if(!(sender instanceof Player)) {
			Bukkit.getLogger().info("[ItemCoin] 해당 명령어는 플레이어만 사용 가능합니다.");
		}
		return true;
	}
	
}
