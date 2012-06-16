package kr.co.minecraftforum.kdragon.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import kr.co.minecraftforum.kdragon.itemcoin.ItemCoin;

public class EntityDeathListeners implements Listener {
	
	private ItemStack itemCoin = null;
	
	@EventHandler
	public void entityDeathListener(EntityDeathEvent e) {
		
		Player killer = e.getEntity().getKiller();
		String world = e.getEntity().getWorld().getName();
		Location loc = e.getEntity().getLocation();
		EntityType etype = e.getEntityType();
		EntityType gtype = null;
		
		if(etype == gtype.BLAZE) {
			itemStack(ItemCoin.blaze[0], ItemCoin.blaze[1]);
		}
		if(etype == gtype.CAVE_SPIDER) {
			itemStack(ItemCoin.cave_spider[0], ItemCoin.cave_spider[1]);
		}
		if(etype == gtype.CHICKEN) {
			itemStack(ItemCoin.chicken[0], ItemCoin.chicken[1]);
		}
		if(etype == gtype.COW) {
			itemStack(ItemCoin.cow[0], ItemCoin.cow[1]);
		}
		if(etype == gtype.CREEPER) {
			itemStack(ItemCoin.creeper[0], ItemCoin.creeper[1]);
		}
		if(etype == gtype.ENDER_DRAGON) {
			itemStack(ItemCoin.ender_dragon[0], ItemCoin.ender_dragon[1]);
		}
		if(etype == gtype.ENDERMAN) {
			itemStack(ItemCoin.enderman[0], ItemCoin.enderman[1]);
		}
		if(etype == gtype.GHAST) {
			itemStack(ItemCoin.ghast[0], ItemCoin.ghast[1]);
		}
		if(etype == gtype.GIANT) {
			itemStack(ItemCoin.giant[0], ItemCoin.giant[1]);
		}
		if(etype == gtype.IRON_GOLEM) {
			itemStack(ItemCoin.iron_golem[0], ItemCoin.iron_golem[1]);
		}
		if(etype == gtype.MAGMA_CUBE) {
			itemStack(ItemCoin.magma_cube[0], ItemCoin.magma_cube[1]);
		}
		if(etype == gtype.MUSHROOM_COW) {
			itemStack(ItemCoin.mushroom_cow[0], ItemCoin.mushroom_cow[1]);
		}
		if(etype == gtype.OCELOT) {
			itemStack(ItemCoin.ocelot[0], ItemCoin.ocelot[1]);
		}
		if(etype == gtype.PIG) {
			itemStack(ItemCoin.pig[0], ItemCoin.pig[1]);
		}
		if(etype == gtype.PIG_ZOMBIE) {
			itemStack(ItemCoin.pig_zombie[0], ItemCoin.pig_zombie[1]);
		}
		if(etype == gtype.PLAYER) {
			itemStack(ItemCoin.player[0], ItemCoin.player[1]);
		}
		if(etype == gtype.SHEEP) {
			itemStack(ItemCoin.sheep[0], ItemCoin.sheep[1]);
		}
		if(etype == gtype.SILVERFISH) {
			itemStack(ItemCoin.silverfish[0], ItemCoin.silverfish[1]);
		}
		if(etype == gtype.SKELETON) {
			itemStack(ItemCoin.skeleton[0], ItemCoin.skeleton[1]);
		}
		if(etype == gtype.SLIME) {
			itemStack(ItemCoin.slime[0], ItemCoin.slime[1]);
		}
		if(etype == gtype.SNOWMAN) {
			itemStack(ItemCoin.snowman[0], ItemCoin.snowman[1]);
		}
		if(etype == gtype.SPIDER) {
			itemStack(ItemCoin.spider[0], ItemCoin.spider[1]);
		}
		if(etype == gtype.SQUID) {
			itemStack(ItemCoin.squid[0], ItemCoin.squid[1]);
		}
		if(etype == gtype.VILLAGER) {
			itemStack(ItemCoin.villager[0], ItemCoin.villager[1]);
		}
		if(etype == gtype.WOLF) {
			itemStack(ItemCoin.wolf[0], ItemCoin.wolf[1]);
		}
		if(etype == gtype.ZOMBIE) {
			itemStack(ItemCoin.zombie[0], ItemCoin.zombie[1]);
		}
		
		//플레이어가 죽였을 때만 드랍 하도록 설정 되어 있으면
		if(ItemCoin.ifKilledByPlayer) {
			if(killer != null) {
				if(itemCoin.getAmount() != 0) {
					Bukkit.getWorld(world).dropItemNaturally(loc, itemCoin);
				}
				if(itemCoin.getAmount() == 0) {}
			}
			if(killer == null) {}
		}
		
		//죽으면 무조건 드랍 하도록 설정되어 있으면
		if(!ItemCoin.ifKilledByPlayer) {
			if(itemCoin.getAmount() != 0) {
				Bukkit.getWorld(world).dropItemNaturally(loc, itemCoin);
			}
			if(itemCoin.getAmount() == 0) {}
		}
		
	}
	
	//coin과 amount를 넣으면 ItemStack(설정된 아이템, 개수) 를 생성하는 메서드
	private void itemStack(int coin, int amount) {
		if(coin == 1) {
			itemCoin = new ItemStack(Material.getMaterial(ItemCoin.coin1), amount);
		}
		if(coin == 2) {
			itemCoin = new ItemStack(Material.getMaterial(ItemCoin.coin2), amount);
		}
		if(coin == 3) {
			itemCoin = new ItemStack(Material.getMaterial(ItemCoin.coin3), amount);
		}
	}

}
