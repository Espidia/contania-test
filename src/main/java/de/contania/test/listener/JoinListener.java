package de.contania.test.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Espidia
 */
public class JoinListener implements Listener {

    private final ItemStack joinItem;

    public JoinListener(ItemStack joinItem) {
        this.joinItem = joinItem;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().addItem(this.joinItem);
    }

}
