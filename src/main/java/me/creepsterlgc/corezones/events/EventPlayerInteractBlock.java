package main.java.me.creepsterlgc.corezones.events;

import java.util.Optional;

import main.java.me.creepsterlgc.core.utils.PermissionsUtils;
import main.java.me.creepsterlgc.core.utils.ZoneUtils;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;


public class EventPlayerInteractBlock {

    @Listener
    public void onPlayerInteractBlock(InteractBlockEvent.Primary event) {
    	
    	Optional<Player> optional = event.getCause().first(Player.class);
    	if(!optional.isPresent()) return;

    	Player player = optional.get();
    	
    	if(PermissionsUtils.has(player, "core.zone.bypass." + player.getWorld().getName().toLowerCase())) return;
    	
		if(!ZoneUtils.canInteract(player, event.getTargetBlock().getLocation().get())) {
			player.sendMessage(Texts.of(TextColors.RED, "You do not have permissions!"));
		    event.setCancelled(true);
		}
    	
    }
    
    @Listener
    public void onPlayerInteractBlock(InteractBlockEvent.Secondary event) {
    	
    	Optional<Player> optional = event.getCause().first(Player.class);
    	if(!optional.isPresent()) return;

    	Player player = optional.get();
    	
    	if(PermissionsUtils.has(player, "core.zone.bypass." + player.getWorld().getName().toLowerCase())) return;
    	
		if(!ZoneUtils.canInteract(player, event.getTargetBlock().getLocation().get())) {
			player.sendMessage(Texts.of(TextColors.RED, "You do not have permissions!"));
		    event.setCancelled(true);
		}
    	
    }
    
}
