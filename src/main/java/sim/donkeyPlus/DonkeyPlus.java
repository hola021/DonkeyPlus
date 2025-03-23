package sim.donkeyPlus;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import sim.donkeyPlus.events.dupe;

public final class DonkeyPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        
        getServer().getPluginManager().registerEvents(new dupe(this), this);
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[DonkeyPlus] The Plugin is now Enabled");
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[DonkeyPlus] The Plugin is now Disabled");
    }
}

