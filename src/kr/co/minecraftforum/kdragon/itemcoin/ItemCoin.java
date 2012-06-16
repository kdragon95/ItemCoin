package kr.co.minecraftforum.kdragon.itemcoin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import kr.co.minecraftforum.kdragon.commands.CommandCore;
import kr.co.minecraftforum.kdragon.listeners.EntityDeathListeners;
import kr.co.minecraftforum.kdragon.listeners.PlayerListeners;

public class ItemCoin extends JavaPlugin {
	
	Logger log = Bukkit.getLogger();
	
	public static Economy econ = null;
	public static Permission perms = null;
	
	public CommandCore ccore = new CommandCore(this);
	
	public static File customConfigFile;
	public static FileConfiguration customConfig;
	
	public static boolean ifKilledByPlayer;
	
	public static int coin1;
	public static int coin2;
	public static int coin3;
	public static double value1;
	public static double value2;
	public static double value3;
	public static String nameOfCoin1;
	public static String nameOfCoin2;
	public static String nameOfCoin3;
	
	private ConfigurationSection cfs;
	
	public static int[] blaze = {0, 0};
	public static int[] cave_spider = {0, 0};
	public static int[] chicken = {0, 0};
	public static int[] cow = {0, 0};
	public static int[] creeper = {0, 0};
	public static int[] ender_dragon = {0, 0};
	public static int[] enderman = {0, 0};
	public static int[] ghast = {0, 0};
	public static int[] giant = {0, 0};
	public static int[] iron_golem = {0, 0};
	public static int[] magma_cube = {0, 0};
	public static int[] mushroom_cow = {0, 0};
	public static int[] ocelot = {0, 0};
	public static int[] pig = {0, 0};
	public static int[] pig_zombie = {0, 0};
	public static int[] player = {0, 0};
	public static int[] sheep = {0, 0};
	public static int[] silverfish = {0, 0};
	public static int[] skeleton = {0, 0};
	public static int[] slime = {0, 0};
	public static int[] snowman = {0, 0};
	public static int[] spider = {0, 0};
	public static int[] squid = {0, 0};
	public static int[] villager = {0, 0};
	public static int[] wolf = {0, 0};
	public static int[] zombie = {0, 0};
	
	public static EntityType[] mobs = {EntityType.BLAZE, EntityType.CAVE_SPIDER, EntityType.CHICKEN, EntityType.COW, EntityType.CREEPER,
		 EntityType.ENDER_DRAGON, EntityType.ENDERMAN, EntityType.GHAST, EntityType.GIANT, EntityType.IRON_GOLEM, EntityType.MAGMA_CUBE,
		 EntityType.MUSHROOM_COW, EntityType.OCELOT, EntityType.PIG, EntityType.PIG_ZOMBIE, EntityType.SHEEP, EntityType.SILVERFISH,
		 EntityType.SKELETON, EntityType.SLIME, EntityType.SNOWMAN, EntityType.SPIDER, EntityType.SQUID, EntityType.VILLAGER,
		 EntityType.WOLF, EntityType.ZOMBIE, EntityType.PLAYER};
	
	public static String[] mobsName = {"blaze", "cave_spider", "chicken", "cow", "creeper", "ender_dragon", "enderman", "ghast", "giant",
		"iron_golem", "magma_cube", "mushroom_cow", "ocelot", "pig", "pig_zombie", "sheep", "silverfish", "skeleton", "slime", "snowman",
		"spider", "squid", "villager", "wolf", "zombie", "player"};
	
	@Override
	public void onEnable() {
		log.info(getName() + " enabled.");
		configEnable();
		useConfigInitialize();
		registerEvents();
		getCommand("코인").setExecutor(ccore);
		if(!setupEconomy() || !setupPermissions()) {
			log.severe("Could not find Vault plugin. Disabling this plugin...");
		}
	}
	
	@Override
	public void onDisable() {
		log.info(getName() + " disbaled.");
	}
	
	private void configEnable() {
		ifConfigExist();
		customConfigFile = new File(getDataFolder(), "config.yml");
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
	}
	
	private void ifConfigExist() {
		customConfigFile = new File(getDataFolder(), "config.yml");
		if(getDataFolder().exists()) {
			if(customConfigFile == null) {
				try {
					customConfigFile.createNewFile();
					configInitialize();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(customConfigFile != null) {}
		}
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
			try {
				customConfigFile.createNewFile();
				configInitialize();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void configInitialize() {
		customConfig = YamlConfiguration.loadConfiguration(getResource("config.yml"));
		try {
			customConfig.save(customConfigFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void registerEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDeathListeners(), this);
	}
	
	private boolean setupEconomy() {
		if(getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}
	
	private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
	
	private void useConfigInitialize() {
		ifKilledByPlayer = customConfig.getBoolean("only_drop_when_killed_by_player");
		
		coin1 = customConfig.getConfigurationSection("Coins").getConfigurationSection("coin1").getInt("item");
		coin2 = customConfig.getConfigurationSection("Coins").getConfigurationSection("coin2").getInt("item");
		coin3 = customConfig.getConfigurationSection("Coins").getConfigurationSection("coin3").getInt("item");
		value1 = customConfig.getConfigurationSection("Coins").getConfigurationSection("coin1").getDouble("value");
		value2 = customConfig.getConfigurationSection("Coins").getConfigurationSection("coin2").getDouble("value");
		value3 = customConfig.getConfigurationSection("Coins").getConfigurationSection("coin3").getDouble("value");
		nameOfCoin1 = Material.getMaterial(coin1).toString();
		nameOfCoin2 = Material.getMaterial(coin2).toString();
		nameOfCoin3 = Material.getMaterial(coin3).toString();
		
		cfs = customConfig.getConfigurationSection("Drop_amount");
		
		blaze[0] = cfs.getConfigurationSection("blaze").getInt("coin"); blaze[1] = cfs.getConfigurationSection("blaze").getInt("item");
		cave_spider[0] = cfs.getConfigurationSection("cave_spider").getInt("coin"); cave_spider[1] = cfs.getConfigurationSection("cave_spider").getInt("amount");
		chicken[0] = cfs.getConfigurationSection("chicken").getInt("coin"); chicken[1] = cfs.getConfigurationSection("chicken").getInt("amount");
		cow[0] = cfs.getConfigurationSection("cow").getInt("coin"); cow[1] = cfs.getConfigurationSection("cow").getInt("amount");
		creeper[0] = cfs.getConfigurationSection("creeper").getInt("coin"); creeper[1] = cfs.getConfigurationSection("creeper").getInt("amount");
		ender_dragon[0] = cfs.getConfigurationSection("ender_dragon").getInt("coin"); ender_dragon[1] = cfs.getConfigurationSection("ender_dragon").getInt("amount");
		enderman[0] = cfs.getConfigurationSection("enderman").getInt("coin"); enderman[1] = cfs.getConfigurationSection("enderman").getInt("amount");
		ghast[0] = cfs.getConfigurationSection("ghast").getInt("coin"); ghast[1] = cfs.getConfigurationSection("ghast").getInt("amount");
		giant[0] = cfs.getConfigurationSection("giant").getInt("coin"); giant[1] = cfs.getConfigurationSection("giant").getInt("amount");
		iron_golem[0] = cfs.getConfigurationSection("iron_golem").getInt("coin"); iron_golem[1] = cfs.getConfigurationSection("iron_golem").getInt("amount");
		magma_cube[0] = cfs.getConfigurationSection("magma_cube").getInt("coin"); magma_cube[1] = cfs.getConfigurationSection("magma_cube").getInt("amount");
		mushroom_cow[0] = cfs.getConfigurationSection("mushroom_cow").getInt("coin"); mushroom_cow[1] = cfs.getConfigurationSection("mushroom_cow").getInt("amount");
		ocelot[0] = cfs.getConfigurationSection("ocelot").getInt("coin"); ocelot[1] = cfs.getConfigurationSection("ocelot").getInt("amount");
		pig[0] = cfs.getConfigurationSection("pig").getInt("coin"); pig[1] = cfs.getConfigurationSection("pig").getInt("amount");
		pig_zombie[0] = cfs.getConfigurationSection("pig_zombie").getInt("coin"); pig_zombie[1] = cfs.getConfigurationSection("pig_zombie").getInt("amount");
		player[0] = cfs.getConfigurationSection("player").getInt("coin"); player[1] = cfs.getConfigurationSection("player").getInt("amount");
		sheep[0] = cfs.getConfigurationSection("sheep").getInt("coin"); sheep[1] = cfs.getConfigurationSection("sheep").getInt("amount");
		silverfish[0] = cfs.getConfigurationSection("silverfish").getInt("coin"); silverfish[1] = cfs.getConfigurationSection("silverfish").getInt("amount");
		skeleton[0] = cfs.getConfigurationSection("skeleton").getInt("coin"); skeleton[1] = cfs.getConfigurationSection("skeleton").getInt("amount");
		slime[0] = cfs.getConfigurationSection("slime").getInt("coin"); slime[1] = cfs.getConfigurationSection("slime").getInt("amount");
		snowman[0] = cfs.getConfigurationSection("snowman").getInt("coin"); snowman[1] = cfs.getConfigurationSection("snowman").getInt("amount");
		spider[0] = cfs.getConfigurationSection("spider").getInt("coin"); spider[1] = cfs.getConfigurationSection("spider").getInt("amount");
		squid[0] = cfs.getConfigurationSection("squid").getInt("coin"); squid[1] = cfs.getConfigurationSection("squid").getInt("amount");
		villager[0] = cfs.getConfigurationSection("villager").getInt("coin"); villager[1] = cfs.getConfigurationSection("villager").getInt("amount");
		wolf[0] = cfs.getConfigurationSection("wolf").getInt("coin"); wolf[1] = cfs.getConfigurationSection("wolf").getInt("amount");
		zombie[0] = cfs.getConfigurationSection("zombie").getInt("coin"); zombie[1] = cfs.getConfigurationSection("zombie").getInt("amount");
	}
	
	public void saveConfig(Player csender) {
		try {
			customConfig.save(ItemCoin.customConfigFile);
			this.getServer().getPluginManager().getPlugin("ItemCoin").reloadConfig();
			csender.sendMessage(ChatColor.GREEN + "[ItemCoin] 설정 저장 완료!");
		} catch (IOException e) {
			e.printStackTrace();
			csender.sendMessage(ChatColor.RED + "[ItemCoin] 내부 오류로 인해 설정 저장이 불가능합니다.");
		}
	}
	
	//플레이어 킬 드랍 설정 커맨드
	public void ifOnlyDropWhenKilldeByPlayer(Player csender, String[] args) {
		
		if(args[1].equalsIgnoreCase("1")) {
			customConfig.set("only_drop_when_killed_by_player", true);
			ifKilledByPlayer = true;
			csender.sendMessage(ChatColor.GREEN + "[ItemCoin] 이제 몹을 플레이어가 죽여야만 코인이 드랍됩니다.");
		}
		if(args[1].equalsIgnoreCase("2")) {
			customConfig.set("only_drop_when_killed_by_player", false);
			ifKilledByPlayer = false;
			csender.sendMessage(ChatColor.GREEN + "[ItemCoin] 이제 몹이 플레이어 킬 이외의 다른 원인에 의해 죽어도 코인이 드랍됩니다.");
		}
		
	}
	
	//코인 체인지 커맨드
	public void coinChange(Player csender, Command cmd, String Label, String[] args) {
		
		int itemCode = 0;
		Double value = 0.0d;
		Material item = null;
		boolean isNumber = false;
		boolean isDouble = false;
		
		//args[1]을 int형으로 변환
		try {
			itemCode = Integer.parseInt(args[1]);
			item = Material.getMaterial(itemCode);
			isNumber = true;
		} catch(NumberFormatException e) {
			csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 아이템 코드는 자연수만 허용됩니다.");
		}
		
		try {
			value = Double.parseDouble(args[2]);
			isDouble = true;
		} catch(NumberFormatException e) {
			csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 코인의 가치는 숫자만 (소수점 포함) 혀용됩니다.");
		}
		
		if(isNumber && isDouble) {
			//1번 코인을 변경
			if(args[0].equalsIgnoreCase("1")) {
				try {
					item = Material.getMaterial(itemCode);
					customConfig.getConfigurationSection("Coins").getConfigurationSection("coin1").set("item", itemCode);
					coin1 = item.getId();
					nameOfCoin1 = item.toString();
					value1 = value;
					csender.sendMessage(ChatColor.GREEN + "[ItemCoin] " + ChatColor.YELLOW + "1번 " + ChatColor.GREEN + "코인이" + ChatColor.YELLOW + item.name() + ChatColor.GREEN + ", 개당 " + ChatColor.YELLOW + value1 + " " + ItemCoin.econ.currencyNameSingular() + "(s)" + ChatColor.GREEN + " (으)로 변경되었습니다. 저장을 하여 서버에 적용해 주세요.");
				} catch(Exception e) {
					csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 존재하지 않는 아이템입니다.");
				}
			}
			if(args[0].equalsIgnoreCase("2")) {
				try {
					item = Material.getMaterial(itemCode);
					customConfig.getConfigurationSection("Coins").getConfigurationSection("coin2").set("item", itemCode);
					coin2 = item.getId();
					nameOfCoin3 = item.toString();
					value2 = value;
					csender.sendMessage(ChatColor.GREEN + "[ItemCoin] " + ChatColor.YELLOW + "2번 " + ChatColor.GREEN + "코인이" + ChatColor.YELLOW + item.name() + ChatColor.GREEN + ", 개당 " + ChatColor.YELLOW + value2 + " " + ItemCoin.econ.currencyNameSingular() + "(s)" + ChatColor.GREEN + " (으)로 변경되었습니다. 저장을 하여 서버에 적용해 주세요.");
				} catch(Exception e) {
					csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 존재하지 않는 아이템입니다.");
				}
			}
			if(args[0].equalsIgnoreCase("3")) {
				try {
					item = Material.getMaterial(itemCode);
					customConfig.getConfigurationSection("Coins").getConfigurationSection("coin3").set("item", itemCode);
					coin3 = item.getId();
					nameOfCoin3 = item.toString();
					value3 = value;
					csender.sendMessage(ChatColor.GREEN + "[ItemCoin] " + ChatColor.YELLOW + "3번 " + ChatColor.GREEN + "코인이" + ChatColor.YELLOW + item.name() + ChatColor.GREEN + ", 개당 " + ChatColor.YELLOW + value3 + " " + ItemCoin.econ.currencyNameSingular() + "(s)" + ChatColor.GREEN + " (으)로 변경되었습니다. 저장을 하여 서버에 적용해 주세요.");
				} catch(Exception e) {
					csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 존재하지 않는 아이템입니다.");
				}
			}
		}
			
	}
	
	public void mobChange(Player csender, Command cmd, String Label, String[] args) {
		
		boolean isValuableMobNumber = false;
		boolean isMob = false;
		boolean isCoin = false;
		boolean isAmount = false;
		EntityType mob = null;
		int mobNumber = 0;
		int coin = 0;
		int amount = 0;
		
		//유효한 몹 번호인지 확인
		try {
			mobNumber = Integer.parseInt(args[1]);
			isValuableMobNumber = true;
		} catch(NumberFormatException e) {
			csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 몹 번호는 자연수만 허용합니다.");
		}
		
		if(isValuableMobNumber) {
			try {
				mob = mobs[mobNumber - 1];
				isMob = true;
			} catch(ArrayIndexOutOfBoundsException e) {
				csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 존재하지 않는 몹 번호입니다.");
			}
		}
		
		//유효한 코인 번호인지 확인
		try {
			coin = Integer.parseInt(args[2]);
			isCoin = true;
		} catch(NumberFormatException e) {
			csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 코인 번호는 1에서 3까지의 자연수만 허용합니다.");
		}
		
		if(isCoin) {
			if(1 <= coin && coin <= 3) {}
			if(coin < 1 || coin > 3) {
				csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 코인 번호는 1에서 3까지의 자연수만 허용합니다.");
			}
		}
		
		//유효한 코인 가치인지 확인
		try {
			amount = Integer.parseInt(args[3]);
			isAmount = true;
		} catch(NumberFormatException e) {
			csender.sendMessage(ChatColor.RED + "[ItemCoin] 명령어 오류! 드랍 개수는 자연수만 허용합니다.");
		}
		
		//명령어 내용 수행부분
		if(isMob && isCoin && isAmount) {
			
			customConfig.getConfigurationSection("Drop_amount").getConfigurationSection(mobsName[mobNumber - 1]).set("coin", coin);
			customConfig.getConfigurationSection("Drop_amount").getConfigurationSection(mobsName[mobNumber - 1]).set("amount", amount);
			
			switch(mobNumber) {
			
			case 1:
				blaze[0] = coin; blaze[1] = amount;
				break;
			case 2:
				cave_spider[0] = coin; cave_spider[1] = amount;
				break;
			case 3:
				chicken[0] = coin; chicken[1] = amount;
				break;
			case 4:
				cow[0] = coin; cow[1] = amount;
				break;
			case 5:
				creeper[0] = coin; creeper[1] = amount;
				break;
			case 6:
				ender_dragon[0] = coin; ender_dragon[1] = amount;
				break;
			case 7:
				enderman[0] = coin; enderman[1] = amount;
				break;
			case 8:
				ghast[0] = coin; ghast[1] = amount;
				break;
			case 9:
				giant[0] = coin; giant[1] = amount;
				break;
			case 10:
				iron_golem[0] = coin; iron_golem[1] = amount;
				break;
			case 11:
				magma_cube[0] = coin; magma_cube[1] = amount;
				break;
			case 12:
				mushroom_cow[0] = coin; mushroom_cow[1] = amount;
				break;
			case 13:
				ocelot[0] = coin; ocelot[1] = amount;
				break;
			case 14:
				pig[0] = coin; pig[1] = amount;
				break;
			case 15:
				pig_zombie[0] = coin; pig_zombie[1] = amount;
				break;
			case 16:
				sheep[0] = coin; sheep[1] = amount;
				break;
			case 17:
				silverfish[0] = coin; silverfish[1] = amount;
				break;
			case 18:
				skeleton[0] = coin; skeleton[1] = amount;
				break;
			case 19:
				slime[0] = coin; slime[1] = amount;
				break;
			case 20:
				snowman[0] = coin; snowman[1] = amount;
				break;
			case 21:
				spider[0] = coin; spider[1] = amount;
				break;
			case 22:
				squid[0] = coin; squid[1] = amount;
				break;
			case 23:
				villager[0] = coin; villager[1] = amount;
				break;
			case 24:
				wolf[0] = coin; wolf[1] = amount;
				break;
			case 25:
				zombie[0] = coin; zombie[1] = amount;
				break;
			case 26:
				player[0] = coin; player[1] = amount;
				break;
			
			}
			
			csender.sendMessage(ChatColor.GREEN + "[ItemCoin] " + ChatColor.YELLOW + mob.getName() + ChatColor.GREEN + "의 드랍 코인이" + ChatColor.YELLOW + coin + "번 , " + amount + "개" + ChatColor.GREEN + "로 설정되었습니다. 저장을 하여 서버에 적용해 주세요.");
			
		}
		
	}
	
}
