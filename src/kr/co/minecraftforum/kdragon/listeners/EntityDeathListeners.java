package kr.co.minecraftforum.kdragon.listeners;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import kr.co.minecraftforum.kdragon.itemcoin.ItemCoin;

public class EntityDeathListeners implements Listener {
	
	private int configDrop = ItemCoin.customConfig.getInt("Item");
	
	private int configBlaze = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("blaze");
	private int configCave_spider = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("cave_spider");
	private int configChicken = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("chicken");
	private int configCow = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("cow");
	private int configCreeper = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("creeper");
	private int configEnder_dragon = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("ender_dragon");
	private int configEnderman = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("enderman");
	private int configGhast = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("ghast");
	private int configGiant = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("giant");
	private int configIron_golem = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("iron_golem");
	private int configMagma_cube = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("magma_cube");
	private int configMushroom_cow = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("mushroom_cow");
	private int configOcelot = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("ocelot");
	private int configPig = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("pig");
	private int configPig_zombie = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("pig_zombie");
	private int configPlayer = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("player");
	private int configSheep = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("sheep");
	private int configSilverfish = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("silverfish");
	private int configSkeleton = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("skeleton");
	private int configSlime = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("slime");
	private int configSnowman = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("snowman");
	private int configSpider = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("spider");
	private int configSquid = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("squid");
	private int configVillager = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("villager");
	private int configWolf = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("wolf");
	private int configZombie = ItemCoin.customConfig.getConfigurationSection("Drop_amount").getInt("zombie");
	
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
