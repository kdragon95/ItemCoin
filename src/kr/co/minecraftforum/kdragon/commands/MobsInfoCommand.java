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
			csender.sendMessage(ChatColor.RED + "[ItemCoin] ��ɾ� ����! ������ ��ȣ�� �ڿ����� ����մϴ�.");
		}
		
		if(ifSucceed) {
			if(page <= 0) {
				csender.sendMessage(ChatColor.RED + "[ItemCoin] ��ɾ� ����! ������ ��ȣ�� �ڿ����� ����մϴ�.");
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
				csender.sendMessage(ChatColor.RED + "[ItemCoin] ��ɾ� ����! �������� �ʴ� �������Դϴ�.");
			}
		}
		
	}

	private void infoMob1(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin ������ (1)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "������" + ChatColor.YELLOW + " 1");
		csender.sendMessage(ChatColor.GREEN + "�����Ź�" + ChatColor.YELLOW + " 2");
		csender.sendMessage(ChatColor.GREEN + "��" + ChatColor.YELLOW + " 3");
		csender.sendMessage(ChatColor.GREEN + "��" + ChatColor.YELLOW + " 4");
		csender.sendMessage(ChatColor.GREEN + "ũ����" + ChatColor.YELLOW + " 5");
		csender.sendMessage(ChatColor.GREEN + "���� �巡��" + ChatColor.YELLOW + " 6");
		
	}
	
	private void infoMob2(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin ������ (2)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "������" + ChatColor.YELLOW + " 7");
		csender.sendMessage(ChatColor.GREEN + "����Ʈ" + ChatColor.YELLOW + " 8");
		csender.sendMessage(ChatColor.GREEN + "���̾�Ʈ" + ChatColor.YELLOW + " 9");
		csender.sendMessage(ChatColor.GREEN + "���̾� ��" + ChatColor.YELLOW + " 10");
		csender.sendMessage(ChatColor.GREEN + "���׸� ť��" + ChatColor.YELLOW + " 11");
		csender.sendMessage(ChatColor.GREEN + "������" + ChatColor.YELLOW + " 12");
		
	}
	
	private void infoMob3(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin ������ (3)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "������" + ChatColor.YELLOW + " 13");
		csender.sendMessage(ChatColor.GREEN + "����" + ChatColor.YELLOW + " 14");
		csender.sendMessage(ChatColor.GREEN + "�������" + ChatColor.YELLOW + " 15");
		csender.sendMessage(ChatColor.GREEN + "��" + ChatColor.YELLOW + " 16");
		csender.sendMessage(ChatColor.GREEN + "������" + ChatColor.YELLOW + " 17");
		csender.sendMessage(ChatColor.GREEN + "���̷���" + ChatColor.YELLOW + " 18");
		
	}
	
	private void infoMob4(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin ������ (4)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "������" + ChatColor.YELLOW + " 19");
		csender.sendMessage(ChatColor.GREEN + "�����" + ChatColor.YELLOW +  "20");
		csender.sendMessage(ChatColor.GREEN + "�Ź�" + ChatColor.YELLOW + " 21");
		csender.sendMessage(ChatColor.GREEN + "��¡��" + ChatColor.YELLOW + " 22");
		csender.sendMessage(ChatColor.GREEN + "�����ֹ�" + ChatColor.YELLOW + " 23");
		csender.sendMessage(ChatColor.GREEN + "����" + ChatColor.YELLOW + " 24");
		
	}
	
	private void infoMob5(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "--------------------" + ChatColor.YELLOW + "ItemCoin ������ (5)" + ChatColor.GREEN + "--------------------");
		csender.sendMessage(ChatColor.GREEN + "����" + ChatColor.YELLOW + " 25");
		csender.sendMessage(ChatColor.GREEN + "�÷��̾�(���)" + ChatColor.YELLOW + " 26");
		
	}
	
}
