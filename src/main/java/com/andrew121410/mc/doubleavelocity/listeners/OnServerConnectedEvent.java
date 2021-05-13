package com.andrew121410.mc.doubleavelocity.listeners;

import com.andrew121410.mc.doubleavelocity.DoubleAVelocity;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerConnectedEvent;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class OnServerConnectedEvent {

    private DoubleAVelocity plugin;

    public OnServerConnectedEvent(DoubleAVelocity plugin) {
        this.plugin = plugin;
        this.plugin.getProxyServer().getEventManager().register(this.plugin, this);
    }

    @Subscribe
    public void onServerConnected(ServerConnectedEvent event) {
        Player player = event.getPlayer();
        player.sendActionBar(LegacyComponentSerializer.legacyAmpersand().deserialize("&2You have joined the " + event.getServer().getServerInfo().getName() + " server!"));
    }
}
