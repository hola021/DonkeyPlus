package sim.donkeyPlus.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import java.util.Random;
import org.bukkit.plugin.Plugin;

public class dupe implements Listener {
    private final Plugin plugin;
    
    public dupe(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent b) {
        if (!plugin.getConfig().getBoolean("dupe.enabled")) return;
        
        Entity entity = b.getEntity();

        if ((entity.getType() == EntityType.DONKEY || entity.getType() == EntityType.LLAMA)
                && (!(entity instanceof LivingEntity livingEntity) || livingEntity.isInvisible())) {
            int minMultiplier = plugin.getConfig().getInt("dupe.min-dupe", 0);
            int maxMultiplier = plugin.getConfig().getInt("dupe.max-dupe", 4);
            Random random = new Random();
            int randomInt = random.nextInt(maxMultiplier - minMultiplier + 1) + minMultiplier;
            
            for (int i = 0; i < randomInt; i++) {
                for (int x = 0; x < b.getDrops().size(); x++)
                    entity.getWorld().dropItemNaturally(entity.getLocation(), b.getDrops().get(x));
            }
        }
    }
}
