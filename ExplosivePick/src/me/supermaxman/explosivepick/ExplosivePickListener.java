package me.supermaxman.explosivepick;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

	
public class ExplosivePickListener implements Listener {
	
	
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand() !=null && !e.isCancelled()) {
			ItemStack i = p.getItemInHand();
			if(i.getType()==Material.DIAMOND_PICKAXE && i.getItemMeta().hasLore()) {
				if(i.getItemMeta().getLore().contains(ChatColor.YELLOW + "" + ChatColor.BOLD + "Explosive I")) {
					p.getWorld().createExplosion(e.getBlock().getLocation(), 0);
					Random r2 = new Random();
					int count = r2.nextInt(3)+6;
					while(count >0) {
						Random r = new Random();
						int rng = r.nextInt(14)+1;
						Block b = e.getBlock();
						switch (rng) {
							case 1: b = e.getBlock().getRelative(BlockFace.UP);
								break;
							case 2: b = e.getBlock().getRelative(BlockFace.DOWN);
								break;
							case 3: b = e.getBlock().getRelative(BlockFace.EAST);
								break;
							case 4: b = e.getBlock().getRelative(BlockFace.WEST);
								break;
							case 5: b = e.getBlock().getRelative(BlockFace.NORTH);
								break;
							case 6:  b = e.getBlock().getRelative(BlockFace.SOUTH);
								break;
							case 7:  b = e.getBlock().getRelative(BlockFace.EAST_NORTH_EAST);
								break;
							case 8:  b = e.getBlock().getRelative(BlockFace.EAST_SOUTH_EAST);
								break;
							case 9:  b = e.getBlock().getRelative(BlockFace.WEST_NORTH_WEST);
								break;
							case 10:  b = e.getBlock().getRelative(BlockFace.WEST_SOUTH_WEST);
								break;
							case 11:  b = e.getBlock().getRelative(BlockFace.NORTH_NORTH_EAST);
								break;
							case 12:  b = e.getBlock().getRelative(BlockFace.NORTH_NORTH_WEST);
								break;
							case 13:  b = e.getBlock().getRelative(BlockFace.SOUTH_SOUTH_EAST);
								break;
							case 14:  b = e.getBlock().getRelative(BlockFace.SOUTH_SOUTH_WEST);
								break;
						}
						b.breakNaturally(i);
						count--;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) ) {
			if(e.getItem() !=null) {
				ItemStack i = e.getItem();
				if(i.getItemMeta().hasLore() && i.getType()==Material.DIAMOND_PICKAXE) {
					if(i.getItemMeta().getLore().contains(ChatColor.YELLOW + "" + ChatColor.BOLD + "Explosive I")) {
						i.setDurability((short) 0);
					}
				}
			}
		}
	}
	
}
