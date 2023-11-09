package team.aquatic.studios.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import team.aquatic.studios.Aquafly;
import team.aquatic.studios.files.Config;
import team.aquatic.studios.tools.XSound;

import java.util.ArrayList;

public class Action implements CommandExecutor {
    public static ArrayList<String> flytoggle = new ArrayList<String>();

    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player p = (Player) sender;
        if (sender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&b&lJoinEffects &8» &cError this command cannot be executed in console.")));
        }

        if (p.hasPermission("aquafly.action") || p.hasPermission("aquafly.admin")) {
            if (flytoggle.contains(p.getName())) {
                p.setAllowFlight(false);
                p.setFlying(false);
                flytoggle.remove(p.getName());
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("messages.disabled").replace("%prefix%", Config.getConfig().getString("modules.prefix"))));
                if (Config.getConfig().getBoolean("aquafly.disabled.switch")) {
                    p.sendTitle(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("aquafly.disabled.title")), ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("aquafly.disabled.subtitle")));
                }


            } else {
                p.setAllowFlight(true);
                p.setFlying(true);
                flytoggle.add(p.getName());
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("messages.enabled").replace("%prefix%", Config.getConfig().getString("modules.prefix"))));
                if (Config.getConfig().getBoolean("aquafly.enabled.switch")) {
                    p.sendTitle(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("aquafly.enabled.title")), ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("aquafly.enabled.subtitle")));
                    //Sounds.APISounds(p, Config.getConfig().getString("aquafly.enabled.sound"));
                    XSound.play(p, Config.getConfig().getString("aquafly.enabled.sound"));
                }

            }

        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("messages.permission").replace("%prefix%", Config.getConfig().getString("modules.prefix"))));
            if (Config.getConfig().getBoolean("aquafly.permission.switch")) {
                p.sendTitle(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("aquafly.permission.title")), ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("aquafly.permission.subtitle")));
                //Sounds.APISounds(p, Config.getConfig().getString("aquafly.permission.sound"));
                XSound.play(p, Config.getConfig().getString("aquafly.permission.sound"));
                return true;
            }
        }
        return false;
    }
}