package team.aquatic.studios.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import team.aquatic.studios.Aquafly;
import team.aquatic.studios.files.Config;

import java.util.List;

public class BungeeSimulator implements Listener {

    private List<String> enabledWorlds;

    public BungeeSimulator() {
        enabledWorlds = Config.getConfig().getStringList("bungee.simulator.list");
    }

    private List<String> getEnabledWorlds() {
        return enabledWorlds;

    }

    @EventHandler
    public void nothing(final PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        if (p.hasPermission(Config.getConfig().getString("styles.default.permission"))) {
            for (int i = 0; i < getEnabledWorlds().size(); i++) {
                if (enabledWorlds.get(i).equals(p.getWorld().getName())) {
                    if (Config.getConfig().getBoolean("styles.default.simulator.switch")) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void levitation(final PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        if (p.hasPermission(Config.getConfig().getString("styles.levitation.permission"))) {
            for (int i = 0; i < getEnabledWorlds().size(); i++) {
                if (enabledWorlds.get(i).equals(p.getWorld().getName())) {
                    if (Config.getConfig().getBoolean("styles.levitation.simulator.switch")) {
                        Location location = p.getLocation();
                        location.setX(location.getBlockX());
                        location.setY(location.getBlockY() + Config.getConfig().getInt("styles.levitation.number"));
                        location.setZ(location.getBlockZ());

                        p.teleport(location);
                        p.setAllowFlight(true);
                        p.setFlying(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void jumped(final PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        if (p.hasPermission(Config.getConfig().getString("styles.jumped.permission"))) {
            for (int i = 0; i < getEnabledWorlds().size(); i++) {
                if (enabledWorlds.get(i).equals(p.getWorld().getName())) {
                    if (Config.getConfig().getBoolean("styles.jumped.simulator.switch")) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
                    }
                }
            }
        }
    }

    @EventHandler
    public void vector(final PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        if (p.hasPermission(Config.getConfig().getString("styles.vector.permission"))) {
            for (int i = 0; i < getEnabledWorlds().size(); i++) {
                if (enabledWorlds.get(i).equals(p.getWorld().getName())) {
                    if (Config.getConfig().getBoolean("styles.vector.simulator.switch")) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.setVelocity(p.getLocation().getDirection().multiply(0.1D).setY(2.6D));
                    }
                }
            }
        }
    }

}
