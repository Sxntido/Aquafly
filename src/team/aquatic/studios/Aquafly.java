package team.aquatic.studios;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import team.aquatic.studios.commands.Action;
import team.aquatic.studios.commands.Executor;
import team.aquatic.studios.events.BungeeSimulator;
import team.aquatic.studios.events.Completation;
import team.aquatic.studios.events.Styles;

public class Aquafly extends JavaPlugin {

    public static Aquafly instance;

    public static Aquafly getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        int pluginId = 19912;
        Metrics metrics = new Metrics(this, pluginId);

        registerCommands();
        registerEvents();

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&bAquafly &7- &fRunning the Server")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fCreator: &aSxntido")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fStatus: &aEnabled")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fVersion: &e3.0-SNAPSHOT")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&bAquafly &8» &fPowered by &bAquatic Studios")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));

    }

    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&bAquafly &7- &fRunning the Server")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fCreator: &aSxntido")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fStatus: &cDisabled")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fVersion: &e3.0-SNAPSHOT")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&bAquafly &8» &fPowered by &bAquatic Studios")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));

    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents((Listener) new BungeeSimulator(), (Plugin) this);
        pm.registerEvents((Listener) new Styles(), (Plugin) this);
    }

    public void registerCommands() {
        getCommand("fly").setExecutor(new Action());
        getCommand("aquafly").setExecutor(new Executor());
        getCommand("aquafly").setTabCompleter(new Completation());
    }
}
