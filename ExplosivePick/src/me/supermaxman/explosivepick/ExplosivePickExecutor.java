package me.supermaxman.explosivepick;


import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExplosivePickExecutor extends BaseExecutor {
    @SuppressWarnings("deprecation")
	@Override
    protected void run(Player player, String[] args) {
    	if(ExplosivePick.permission.has(player, "explosivepick.pick.create")) {
			if(args.length>0) {
				Player p = ExplosivePick.plugin.getServer().getPlayer(args[0]);
				if(p!=null) {
					ItemStack i = new ItemStack(Material.DIAMOND_PICKAXE);
					ItemMeta m = i.getItemMeta();
				    ArrayList<String> l = new ArrayList<String>();
				    l.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Explosive I");
				    m.setLore(l);
				    i.setItemMeta(m);
					p.getInventory().addItem(i);
				}else {
		    		player.sendMessage(ChatColor.RED + "That player could not be found.");
				}
			}else {
	    		ItemStack i = new ItemStack(Material.DIAMOND_PICKAXE);
				ItemMeta m = i.getItemMeta();
			    ArrayList<String> l = new ArrayList<String>();
			    l.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Explosive I");
			    m.setLore(l);
			    i.setItemMeta(m);
				player.getInventory().addItem(i);
			}
		}else {
    		player.sendMessage(ChatColor.RED + "You do not have permission to use that command.");
		}
    }

    public ExplosivePickExecutor(ExplosivePick pl) {
        super(pl);
    }
}
