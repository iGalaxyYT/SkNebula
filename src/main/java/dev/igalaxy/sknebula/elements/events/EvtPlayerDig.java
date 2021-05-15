package dev.igalaxy.sknebula.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Direction;
import ch.njol.skript.util.Getter;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import dev.igalaxy.sknebula.events.PlayerDiggingEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class EvtPlayerDig extends SkriptEvent {

    static {
        Skript.registerEvent("player dig", EvtPlayerDig.class, PlayerDiggingEvent.class,"[player] dig[ging]")
                .description("Called when a player sends a digging status to the server, e.g. when they start or stop digging.")
                .examples("on player digging:");
        EventValues.registerEventValue(PlayerDiggingEvent.class, Player.class, new Getter<Player, PlayerDiggingEvent>() {
            @Override
            @Nullable
            public Player get(PlayerDiggingEvent event) {
                return event.getPlayer();
            }
        }, 0);
        EventValues.registerEventValue(PlayerDiggingEvent.class, Location.class, new Getter<Location, PlayerDiggingEvent>() {
            @Override
            @Nullable
            public Location get(PlayerDiggingEvent event) {
                return event.getPosition().toLocation(event.getPlayer().getWorld());
            }
        }, 0);
        EventValues.registerEventValue(PlayerDiggingEvent.class, Block.class, new Getter<Block, PlayerDiggingEvent>() {
            @Override
            @Nullable
            public Block get(PlayerDiggingEvent event) {
                return event.getPosition().toLocation(event.getPlayer().getWorld()).getBlock();
            }
        }, 0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event event) {
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "on player digging";
    }
}
