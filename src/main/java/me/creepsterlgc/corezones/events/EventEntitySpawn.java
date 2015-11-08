package main.java.me.creepsterlgc.corezones.events;

import main.java.me.creepsterlgc.core.customized.CoreZone;
import main.java.me.creepsterlgc.core.utils.ZoneUtils;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.monster.Monster;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.SpawnEntityEvent;


public class EventEntitySpawn {
	
	@Listener
    public void onEntitySpawn(SpawnEntityEvent event) {
		
    	for(Entity entity : event.getEntities()) {
    		
    	   	for(CoreZone zone : ZoneUtils.getRegions(entity.getLocation())) {
    	   		
	    	 	if(!zone.getAnimalSpawning() && (entity instanceof Animal || entity.getType().equals(EntityTypes.BAT))) {
	    	    	  event.setCancelled(true);
	    	    	  return;
	    		}
	    		if(!zone.getMonsterSpawning() && entity instanceof Monster)
	    		{
	    	    	event.setCancelled(true);
	    	        return;
	    		}
	    	      
    		}
    	
    	}
		
    }

}
