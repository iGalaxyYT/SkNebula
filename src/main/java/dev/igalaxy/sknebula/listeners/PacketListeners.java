package dev.igalaxy.sknebula.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import dev.igalaxy.sknebula.SkNebula;
import dev.igalaxy.sknebula.events.PlayerDiggingEvent;
import org.bukkit.Bukkit;

public class PacketListeners {
    static {

        SkNebula instance = SkNebula.getInstance();

        // PlayerDiggingEvent
        instance.getProtocolManager().addPacketListener(new PacketAdapter(instance, PacketType.Play.Client.BLOCK_DIG) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                StructureModifier<BlockPosition> positionFields = packet.getBlockPositionModifier();
                StructureModifier<EnumWrappers.PlayerDigType> statusFields = packet.getPlayerDigTypes();
                StructureModifier<EnumWrappers.Direction> directionFields = packet.getDirections();
                BlockPosition position = positionFields.read(0);
                EnumWrappers.PlayerDigType status = statusFields.read(0);
                EnumWrappers.Direction direction = directionFields.read(0);
                PlayerDiggingEvent dig = new PlayerDiggingEvent(event.getPlayer(), status, position, direction);
                Bukkit.getPluginManager().callEvent(dig);
                if(dig.isCancelled()) event.setCancelled(true);
            }
        });

    }
}
