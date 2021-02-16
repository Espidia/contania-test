package de.contania.test;

import de.contania.test.listener.JoinListener;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Espidia
 */
public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Configuration configuration = getConfig();

        ItemStack joinItem = readJoinItem(configuration.getConfigurationSection("joinItem"));
        getServer().getPluginManager().registerEvents(new JoinListener(joinItem), this);
    }

    private ItemStack readJoinItem(ConfigurationSection section) {
        return new ItemStack(Material.valueOf(section.getString("type")), section.getInt("amount"));
    }

}
