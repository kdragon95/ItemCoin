package kr.co.minecraftforum.kdragon.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HelpCommand {
	
	protected void helpCommand(Player csender) {
		csender.sendMessage(ChatColor.GREEN + "------------------------" + ChatColor.YELLOW + "ItemCoin ����" + ChatColor.GREEN + "------------------------");
		csender.sendMessage(ChatColor.GREEN + "/���� ���� " + ChatColor.YELLOW + "�÷����� ������ ���ϴ�.");
		csender.sendMessage(ChatColor.GREEN + "/���� ����ȣ [������] " + ChatColor.YELLOW + "�� ��ȣ�� ���ϴ�.");
		csender.sendMessage(ChatColor.GREEN + "/���� [���ι�ȣ] [�������ڵ�] [��ġ] " + ChatColor.YELLOW + "���ΰ� ���� �ϳ��� ��ġ�� �����մϴ�.");
		csender.sendMessage(ChatColor.GREEN + "/���� �� [����ȣ] [���ι�ȣ] [����] " + ChatColor.YELLOW + "���� ����� ������ ������ ������ �����մϴ�.");
		csender.sendMessage(ChatColor.GREEN + "/���� �÷��̾� [1,2] " + ChatColor.YELLOW + "�÷��̾ �׿��� ���� ����� �� ���θ� �����մϴ�. (1=true, 2=false)");
		csender.sendMessage(ChatColor.GREEN + "/���� ���� " + ChatColor.YELLOW + "�÷����� ���� ������ ���ε��մϴ�.");
	}
	
}
