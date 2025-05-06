package cn.JvavRE.giveMyArmorStandBack;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GiveMyArmorStandBack extends JavaPlugin implements Listener {
    @EventHandler
    public void onArmorStandDeath(EntityDeathEvent event) {
        if (event.getEntityType() != EntityType.ARMOR_STAND) return;
        if (!(event.getDamageSource().getCausingEntity() instanceof Player player)) return;
        if (!player.hasPermission("givemyarmorstandback.use")) return;
        if (player.getInventory().getItemInMainHand().getType() != Material.DIAMOND_SWORD) return;

        event.getDrops().clear();
        event.setDroppedExp(0);

        event.setCancelled(true);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("防盔甲架摧毁已开启");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("防盔甲架摧毁已关闭");
    }
}
