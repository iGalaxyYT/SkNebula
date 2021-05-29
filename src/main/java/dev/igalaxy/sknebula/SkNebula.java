package dev.igalaxy.sknebula;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import dev.igalaxy.sknebula.bstats.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class SkNebula extends JavaPlugin {

    private static SkNebula instance;
    private ProtocolManager protocolManager;
    private SkriptAddon addon;

    @Override
    public void onEnable() {
        instance = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
        try {
            addon = Skript.registerAddon(this)
                    .loadClasses("dev.igalaxy.sknebula", "elements", "listeners")
                    .setLanguageFileDirectory("lang");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int pluginId = 11515;
        Metrics metrics = new Metrics(this, pluginId);

        Bukkit.getConsoleSender().sendMessage("[SkNebula] SkNebula has been enabled!");
    }

    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    public SkriptAddon getAddonInstance() {
        return addon;
    }

    public static SkNebula getInstance() {
        return instance;
    }

}
