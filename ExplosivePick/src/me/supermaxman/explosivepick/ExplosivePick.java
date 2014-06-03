package me.supermaxman.explosivepick;

import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;



public class ExplosivePick extends JavaPlugin {
	public static ExplosivePick plugin;
	public static final Logger log = Logger.getLogger("Minecraft");
	public static Permission permission = null;
	
	public void onEnable() {
		plugin = this;
		
        getCommand("ep").setExecutor(new ExplosivePickExecutor(this)); 
        getCommand("explosivepick").setExecutor(new ExplosivePickExecutor(this));    
        
        if (!setupPermissions()) {
        	log.severe("Vault fail!");
            this.setEnabled(false);
            return;
        }
        
		getServer().getPluginManager().registerEvents(new ExplosivePickListener(), plugin);
		
		log.info(getName() + " has been enabled.");
		
	}
	
	public void onDisable() {
		
		log.info(getName() + " has been disabled.");
	}
	
	private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
            return true;
        }
        return false;
    }
}