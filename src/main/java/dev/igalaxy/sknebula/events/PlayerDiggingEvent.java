package dev.igalaxy.sknebula.events;

import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerDiggingEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final EnumWrappers.PlayerDigType status;
    private final BlockPosition position;
    private final EnumWrappers.Direction direction;
    private boolean cancelled;

    public PlayerDiggingEvent(Player player, EnumWrappers.PlayerDigType status, BlockPosition position, EnumWrappers.Direction direction) {
        super(false);
        this.player = player;
        this.status = status;
        this.position = position;
        this.direction = direction;
    }

    public Player getPlayer() {
        return player;
    }

    public EnumWrappers.PlayerDigType getStatus() {
        return status;
    }

    public BlockPosition getPosition() {
        return position;
    }

    public EnumWrappers.Direction getDirection() {
        return direction;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
