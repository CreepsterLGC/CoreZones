package main.java.me.creepsterlgc.corezones;

import java.util.logging.Logger;

import main.java.me.creepsterlgc.core.files.FileCommands;
import main.java.me.creepsterlgc.corezones.commands.CommandSelection;
import main.java.me.creepsterlgc.corezones.commands.CommandZone;
import main.java.me.creepsterlgc.corezones.events.EventEntitySpawn;
import main.java.me.creepsterlgc.corezones.events.EventPlayerBlockBreak;
import main.java.me.creepsterlgc.corezones.events.EventPlayerBlockPlace;
import main.java.me.creepsterlgc.corezones.events.EventPlayerInteractBlock;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

@Plugin(id = "CoreZones", name = "Zones Module for Core", dependencies = "required-after:Core")

public class CoreZones {

	@Inject
	private Game game;
	
	@Inject
	Logger logger;
	
	public static CoreZones corezones;
	
	public static CoreZones getInstance() { return corezones; }
	public Game getGame() { return game; }
	
    @Listener
    public void onEnable(GameStartingServerEvent event) {
    	
    	game.getEventManager().registerListeners(this, new EventEntitySpawn());
    	game.getEventManager().registerListeners(this, new EventPlayerBlockPlace());
    	game.getEventManager().registerListeners(this, new EventPlayerBlockBreak());
    	game.getEventManager().registerListeners(this, new EventPlayerInteractBlock());
    	
    	if(FileCommands.SELECTION()) game.getCommandDispatcher().register(this, new CommandSelection(), "selection", "s");
    	if(FileCommands.ZONE()) game.getCommandDispatcher().register(this, new CommandZone(), "zone", "z");
    	
    }
    
}