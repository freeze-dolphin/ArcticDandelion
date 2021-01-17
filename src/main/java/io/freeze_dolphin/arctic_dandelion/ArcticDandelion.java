package io.freeze_dolphin.arctic_dandelion;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;

public class ArcticDandelion extends JavaPlugin {

	private Config config = new Config(this); 
	private Plugin plug = this;

	@Override
	public void onEnable() {
		
		getLogger().info("Loading internal modules...");
		for (String s : config.getStringList("enabled-modules")) {
			try {
				Class<?> c = Class.forName("io.freeze_dolphin.arctic_dandelion.modules." + s);
				c.newInstance();
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
				getLogger().severe("Internal module '" + "io.freeze_dolphin.arctic_dandelion.modules." + s + "' is not found!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		getLogger().info("Loading groovy modules...");
		

	}

	public Config getC() {
		return config;
	}

	public Plugin getInstance() {
		return plug;
	}

}
