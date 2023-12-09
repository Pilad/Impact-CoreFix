package com.impact.events;

import com.impact.util.vector.PlayerPos;
import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class PlayerMoveEvent extends PlayerEvent {
	
	public final PlayerPos before;
	public final PlayerPos after;
	
	public PlayerMoveEvent(EntityPlayerMP player, PlayerPos before, PlayerPos after) {
		super(player);
		this.before = before;
		this.after  = after;
	}
}