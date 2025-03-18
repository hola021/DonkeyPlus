package sim.donkeyPlus.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import java.util.Random;

public class dupe  implements  Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent b){
        Entity entity = b.getEntity();

        if((entity.getType() == EntityType.DONKEY || entity.getType() == EntityType.LLAMA)
                && (!(entity instanceof LivingEntity livingEntity) || livingEntity.isInvisible())) {
            Random random = new Random();
            int randomInt = random.nextInt(6);
            for (int i = 0; i < randomInt; i++) {
                for (int x = 0; x < b.getDrops().size(); x++)
                    entity.getWorld().dropItemNaturally(entity.getLocation(), b.getDrops().get(x));
            }
        }

    }
}
