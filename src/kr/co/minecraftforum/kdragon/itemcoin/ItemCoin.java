package kr.co.minecraftforum.kdragon.itemcoin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import cosine.boseconomy.BOSEconomy;

import kr.co.minecraftforum.kdragon.listeners.EntityDeathListeners;
import kr.co.minecraftforum.kdragon.listeners.PlayerListeners;

public class ItemCoin extends JavaPlugin {
	
	Logger log = Bukkit.getLogger();
	
	public static BOSEconomy boseconomy = null;
	
	public static File customConfigFile;
	public static FileConfiguration customConfig;
	
	@Override
	public void onEnable() {
		log.info(getName() + " enabled.");
		configEnable();
		registerEvents();
		loadBOSEconomy();
	}
	
	@Override
	public void onDisable() {
		log.info(getName() + " disbaled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Lable, String[] args) {
		return true;
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
	
	private void loadBOSEconomy() {
		Plugin p = this.getServer().getPluginManager().getPlugin("BOSEconomy");
		if(p!=null) {
			boseconomy = (BOSEconomy) p;
		}
		if(p==null) {
			log.info("Could not find BOSEconomy. Disabling this plugin...");
			this.getServer().getPluginManager().disablePlugin(this);
		}
	}
	
}
