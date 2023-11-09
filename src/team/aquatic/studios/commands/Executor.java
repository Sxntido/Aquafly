package team.aquatic.studios.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.aquatic.studios.Aquafly;
import team.aquatic.studios.files.Config;

public class Executor implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&b&lAquafly &8» &cError this command cannot be executed in console.")));
            return true;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAquafly &fversion 3.0 Powered by Aquatic Studios"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
            return true;

        }

        if (args[0].equalsIgnoreCase("help")) {
            if (p.hasPermission("aquafly.help") || p.hasPermission("aquafly.admin")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAquafly &fv3.0 &7| &fCommands"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/aquafly reload &7- &fReload plugin folder"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/aquafly help &7- &fDisplay the list of commands"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                return true;
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("messages.nopermission").replace("%prefix%", Config.getConfig().getString("modules.prefix"))));
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (p.hasPermission("aquafly.reload") || p.hasPermission("aquafly.admin")) {
                Config.getConfig().reload();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("messages.reload").replace("%prefix%", Config.getConfig().getString("modules.prefix"))));
                return true;
            }

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("messages.nopermission").replace("%prefix%", Config.getConfig().getString("modules.prefix"))));

        } else {

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("messages.error").replace("%prefix%", Config.getConfig().getString("modules.prefix"))));

        }
        return false;
    }
}