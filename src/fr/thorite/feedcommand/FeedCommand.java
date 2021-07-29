package fr.thorite.feedcommand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class FeedCommand extends JavaPlugin {
	
	public void onEnable() {
		Bukkit.getServer().getLogger().info("FeedCommand enabled !");
	}
	
	public void onDisable() {
		Bukkit.getServer().getLogger().info("FeedCommand disabled !");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "The console cannot use FeedCommand");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("feed")) {
			if (args.length == 0) {
				player.setFoodLevel(24);
				player.sendMessage(ChatColor.GREEN + "You have been feed !");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				player.sendMessage(ChatColor.RED + "Could not find player !");
				return true;
			}
			target.setFoodLevel(24);
			target.sendMessage(ChatColor.GREEN + "You have been feed !");
			player.sendMessage(ChatColor.GREEN + target.getName() + " has been feed !");
		}
		return true;
	}
}