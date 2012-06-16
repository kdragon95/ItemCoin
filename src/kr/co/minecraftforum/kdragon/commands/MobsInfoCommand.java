package kr.co.minecraftforum.kdragon.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class MobsInfoCommand {
	
	protected void onCommand(Player csender, Command cmd, String Label, String[] args) {
		
		int page = 0;
		boolean ifSucceed = false;
		
		try {
			page = Integer.parseInt(args[1]);
			ifSucceed = true;
		} catch(NumberFormatException e) {
			csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 페이지 번호는 자연수만 허용합니다.");
		}
		
		if(ifSucceed) {
			if(page <= 0) {
				csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 페이지 번호는 자연수만 허용합니다.");
			}
			if(page == 1) {
				infoMob1(csender);
			}
			if(page == 2) {
				infoMob2(csender);
			}
			if(page == 3) {
				infoMob3(csender);
			}
			if(page == 4) {
				infoMob4(csender);
			}
			if(page == 5) {
				infoMob5(csender);
			}
			if(page >= 6) {
				csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 존재하지 않는 페이지입니다.");
			}
		}
		
	}

	private void infoMob1(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin 몹정보 (1)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "블레이즈" + ChatColor.YELLOW + " 1");
		csender.sendMessage(ChatColor.GREEN + "동굴거미" + ChatColor.YELLOW + " 2");
		csender.sendMessage(ChatColor.GREEN + "닭" + ChatColor.YELLOW + " 3");
		csender.sendMessage(ChatColor.GREEN + "소" + ChatColor.YELLOW + " 4");
		csender.sendMessage(ChatColor.GREEN + "크리퍼" + ChatColor.YELLOW + " 5");
		csender.sendMessage(ChatColor.GREEN + "엔더 드래곤" + ChatColor.YELLOW + " 6");
		
	}
	
	private void infoMob2(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin 몹정보 (2)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "엔더맨" + ChatColor.YELLOW + " 7");
		csender.sendMessage(ChatColor.GREEN + "가스트" + ChatColor.YELLOW + " 8");
		csender.sendMessage(ChatColor.GREEN + "자이언트" + ChatColor.YELLOW + " 9");
		csender.sendMessage(ChatColor.GREEN + "아이언 골렘" + ChatColor.YELLOW + " 10");
		csender.sendMessage(ChatColor.GREEN + "마그마 큐브" + ChatColor.YELLOW + " 11");
		csender.sendMessage(ChatColor.GREEN + "버섯소" + ChatColor.YELLOW + " 12");
		
	}
	
	private void infoMob3(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin 몹정보 (3)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "오셀롯" + ChatColor.YELLOW + " 13");
		csender.sendMessage(ChatColor.GREEN + "돼지" + ChatColor.YELLOW + " 14");
		csender.sendMessage(ChatColor.GREEN + "좀비돼지" + ChatColor.YELLOW + " 15");
		csender.sendMessage(ChatColor.GREEN + "양" + ChatColor.YELLOW + " 16");
		csender.sendMessage(ChatColor.GREEN + "좀벌레" + ChatColor.YELLOW + " 17");
		csender.sendMessage(ChatColor.GREEN + "스켈레톤" + ChatColor.YELLOW + " 18");
		
	}
	
	private void infoMob4(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin 몹정보 (4)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "슬라임" + ChatColor.YELLOW + " 19");
		csender.sendMessage(ChatColor.GREEN + "눈사람" + ChatColor.YELLOW +  "20");
		csender.sendMessage(ChatColor.GREEN + "거미" + ChatColor.YELLOW + " 21");
		csender.sendMessage(ChatColor.GREEN + "오징어" + ChatColor.YELLOW + " 22");
		csender.sendMessage(ChatColor.GREEN + "마을주민" + ChatColor.YELLOW + " 23");
		csender.sendMessage(ChatColor.GREEN + "늑대" + ChatColor.YELLOW + " 24");
		
	}
	
	private void infoMob5(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin 몹정보 (5)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "좀비" + ChatColor.YELLOW + " 25");
		csender.sendMessage(ChatColor.GREEN + "플레이어(사람)" + ChatColor.YELLOW + " 26");
		
	}
	
}
