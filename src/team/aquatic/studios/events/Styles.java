package team.aquatic.studios.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.aquatic.studios.Aquafly;
import team.aquatic.studios.files.Config;

public class Styles implements Listener {

    @EventHandler
    public void nothing(PlayerJoinEvent e) {
        if (Config.getConfig().getBoolean("styles.default.switch")) {
            Player p = e.getPlayer();
            if (p.hasPermission(Config.getConfig().getString("styles.default.permission"))) {
                p.setAllowFlight(true);
                p.setFlying(true);
            }
        }
    }

    @EventHandler
    public void levitation(PlayerJoinEvent e) {
        if (Config.getConfig().getBoolean("styles.levitation.switch")) {
            Player p = e.getPlayer();
            if (p.hasPermission(Config.getConfig().getString("styles.levitation.permission"))) {
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

    @EventHandler
    public void jumped(PlayerJoinEvent e) {
        if (Config.getConfig().getBoolean("styles.jumped.switch")) {
            Player p = e.getPlayer();
            if (p.hasPermission(Config.getConfig().getString("styles.jumped.permission"))) {
                p.setAllowFlight(true);
                p.setFlying(true);
                p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
            }
        }
    }

    @EventHandler
    public void vector(PlayerJoinEvent e) {
        if (Config.getConfig().getBoolean("styles.vector.switch")) {
            Player p = e.getPlayer();
            if (p.hasPermission(Config.getConfig().getString("styles.vector.permission"))) {
                p.setAllowFlight(true);
                p.setFlying(true);
                p.setVelocity(p.getLocation().getDirection().multiply(0.1D).setY(2.6D));
            }
        }
    }

}