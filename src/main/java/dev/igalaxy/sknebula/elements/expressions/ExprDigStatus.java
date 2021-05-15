package dev.igalaxy.sknebula.elements.expressions;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;
import com.comphenix.protocol.wrappers.EnumWrappers;
import dev.igalaxy.sknebula.events.PlayerDiggingEvent;
import org.bukkit.event.Event;

public class ExprDigStatus extends SimpleExpression<EnumWrappers.PlayerDigType> {

    static {
        Skript.registerExpression(ExprDigStatus.class, EnumWrappers.PlayerDigType.class, ExpressionType.SIMPLE, "[the] dig status");
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        if(!ScriptLoader.isCurrentEvent(PlayerDiggingEvent.class)) {
            Skript.error("Cannot use 'dig status' outside of the player digging event", ErrorQuality.SEMANTIC_ERROR);
            return false;
        }
        return true;
    }

    @Override
    protected EnumWrappers.PlayerDigType[] get(Event event) {
        return new EnumWrappers.PlayerDigType[]{((PlayerDiggingEvent)event).getStatus()};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends EnumWrappers.PlayerDigType> getReturnType() {
        return EnumWrappers.PlayerDigType.class;
    }

    @Override
    public String toString(Event e, boolean debug) {
        return "dig status";
    }

}
