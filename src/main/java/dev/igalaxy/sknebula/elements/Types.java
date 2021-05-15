package dev.igalaxy.sknebula.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.EnumSerializer;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ch.njol.skript.util.EnumUtils;
import com.comphenix.protocol.wrappers.EnumWrappers;

import javax.annotation.Nullable;
import java.util.Locale;

public class Types {
    static {
        EnumUtils<EnumWrappers.PlayerDigType> statuses = new EnumUtils<>(EnumWrappers.PlayerDigType.class, "digstatus");
        Classes.registerClass(new ClassInfo<>(EnumWrappers.PlayerDigType.class, "digstatus")
                .user("digstatus?")
                .name("Dig Status")
                .usage(statuses.getAllNames())
                .description("Dig status for the Player Dig event.")
                .defaultExpression(new EventValueExpression<>(EnumWrappers.PlayerDigType.class))
                .parser(new Parser<EnumWrappers.PlayerDigType>() {

                    @Override
                    @Nullable
                    public EnumWrappers.PlayerDigType parse(String input, ParseContext context) {
                        return statuses.parse(input);
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return true;
                    }

                    @Override
                    public String toString(EnumWrappers.PlayerDigType status, int flags) {
                        return statuses.toString(status, flags);
                    }

                    @Override
                    public String toVariableNameString(EnumWrappers.PlayerDigType status) {
                        return status.name().toLowerCase(Locale.ENGLISH);
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "\\S+";
                    }
                }).serializer(new EnumSerializer<>(EnumWrappers.PlayerDigType.class))
        );
    }
}
