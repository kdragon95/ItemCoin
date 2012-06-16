package kr.co.minecraftforum.kdragon.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HelpCommand {
	
	protected void helpCommand(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "------------------------" + ChatColor.YELLOW + "ItemCoin 도움말" + ChatColor.GREEN + "------------------------");
		csender.sendMessage(ChatColor.GREEN + "/코인 정보 " + ChatColor.YELLOW + "플러그인 정보를 봅니다.");
		csender.sendMessage(ChatColor.GREEN + "/코인 몹번호 [페이지] " + ChatColor.YELLOW + "몹 번호를 봅니다.");
		csender.sendMessage(ChatColor.GREEN + "/코인 [코인번호] [아이템코드] [가치] " + ChatColor.YELLOW + "코인과 코인 하나의 가치를 설정합니다.");
		csender.sendMessage(ChatColor.GREEN + "/코인 몹 [몹번호] [코인번호] [개수] " + ChatColor.YELLOW + "몹이 드랍할 코인의 종류와 개수를 설정합니다.");
		csender.sendMessage(ChatColor.GREEN + "/코인 플레이어 [1,2] " + ChatColor.YELLOW + "플레이어가 죽였을 때만 드랍할 지 여부를 설정합니다. (1=true, 2=false)");
		csender.sendMessage(ChatColor.GREEN + "/코인 저장 " + ChatColor.YELLOW + "플러그인 설정 파일을 리로드합니다.");
	}
	
}
