package kr.co.minecraftforum.kdragon.listeners;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import kr.co.minecraftforum.kdragon.itemcoin.ItemCoin;

public class EntityDeathListeners implements Listener {
	
	private int configDrop = ItemCoin.customConfig.getInt("Item");
	
	private ConfigurationSection cfc = ItemCoin.customConfig.getConfigurationSection("Drop_amount");
	
	private int configBlaze = cfc.getInt("blaze");
	private int configCave_spider = cfc.getInt("cave_spider");
	private int configChicken = cfc.getInt("chicken");
	private int configCow = cfc.getInt("cow");
	private int configCreeper = cfc.getInt("creeper");
	private int configEnder_dragon = cfc.getInt("ender_dragon");
	private int configEnderman = cfc.getInt("enderman");
	private int configGhast = cfc.getInt("ghast");
	private int configGiant = cfc.getInt("giant");
	private int configIron_golem = cfc.getInt("iron_golem");
	private int configMagma_cube = cfc.getInt("magma_cube");
	private int configMushroom_cow = cfc.getInt("mushroom_cow");
	private int configOcelot = cfc.getInt("ocelot");
	private int configPig = cfc.getInt("pig");
	private int configPig_zombie = cfc.getInt("pig_zombie");
	private int configPlayer = cfc.getInt("player");
	private int configSheep = cfc.getInt("sheep");
	private int configSilverfish = cfc.getInt("silverfish");
	private int configSkeleton = cfc.getInt("skeleton");
	private int configSlime = cfc.getInt("slime");
	private int configSnowman = cfc.getInt("snowman");
	private int configSpider = cfc.getInt("spider");
	private int configSquid = cfc.getInt("squid");
	private int configVillager = cfc.getInt("villager");
	private int configWolf = cfc.getInt("wolf");
	private int configZombie = cfc.getInt("zombie");
	
	ItemStack itemCoin = null;
	
	@EventHandler
	public void entityDeathListener(EntityDeathEvent e) {
		
		String world = e.getEntity().getWorld().getName();
		Location loc = e.getEntity().getLocation();
		EntityType etype = e.getEntityType();
		EntityType gtype = null;
		
		if(etype == gtype.BLAZE) {
			isAmount(configBlaze);
		}
		if(etype == gtype.CAVE_SPIDER) {
			isAmount(configCave_spider);
		}
		if(etype == gtype.CHICKEN) {
			isAmount(configChicken);
		}
		if(etype == gtype.COW) {
			isAmount(configCow);
		}
		if(etype == gtype.CREEPER) {
			isAmount(configCreeper);
		}
		if(etype == gtype.ENDER_DRAGON) {
			isAmount(configEnder_dragon);
		}
		if(etype == gtype.ENDERMAN) {
			isAmount(configEnderman);
		}
		if(etype == gtype.GHAST) {
			isAmount(configGhast);
		}
		if(etype == gtype.GIANT) {
			isAmount(configGiant);
		}
		if(etype == gtype.IRON_GOLEM) {
			isAmount(configIron_golem);
		}
		if(etype == gtype.MAGMA_CUBE) {
			isAmount(configMagma_cube);
		}
		if(etype == gtype.MUSHROOM_COW) {
			isAmount(configMushroom_cow);
		}
		if(etype == gtype.OCELOT) {
			isAmount(configOcelot);
		}
		if(etype == gtype.PIG) {
			isAmount(configPig);
		}
		if(etype == gtype.PIG_ZOMBIE) {
			isAmount(configPig_zombie);
		}
		if(etype == gtype.PLAYER) {
			isAmount(configPlayer);
		}
		if(etype == gtype.SHEEP) {
			isAmount(configSheep);
		}
		if(etype == gtype.SILVERFISH) {
			isAmount(configSilverfish);
		}
		if(etype == gtype.SKELETON) {
			isAmount(configSkeleton);
		}
		if(etype == gtype.SLIME) {
			isAmount(configSlime);
		}
		if(etype == gtype.SNOWMAN) {
			isAmount(configSnowman);
		}
		if(etype == gtype.SPIDER) {
			isAmount(configSpider);
		}
		if(etype == gtype.SQUID) {
			isAmount(configSquid);
		}
		if(etype == gtype.VILLAGER) {
			isAmount(configVillager);
		}
		if(etype == gtype.WOLF) {
			isAmount(configWolf);
		}
		if(etype == gtype.ZOMBIE) {
			isAmount(configZombie);
		}
		
		if(itemCoin.getAmount() != 0) {
			Bukkit.getWorld(world).dropItemNaturally(loc, itemCoin);
		}
		if(itemCoin.getAmount() == 0) {}
	}
	
	private void isAmount(int amount) {
			itemCoin = new ItemStack(Material.getMaterial(configDrop), amount);
	}
		
}
