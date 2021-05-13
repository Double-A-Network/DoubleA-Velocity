package com.andrew121410.mc.doubleavelocity;

import com.andrew121410.mc.doubleavelocity.commands.HubCMD;
import com.andrew121410.mc.doubleavelocity.listeners.OnServerConnectedEvent;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(
        id = "doubleavelocity",
        name = "Double-A-Velocity",
        version = "1.0",
        description = "Network plugin for our server",
        authors = {"Andrew121410"}
)
public class DoubleAVelocity {

    private static DoubleAVelocity plugin;

    private ProxyServer proxyServer;
    private Logger logger;

    @Inject
    public DoubleAVelocity(ProxyServer proxyServer, Logger logger) {
        plugin = this;
        this.proxyServer = proxyServer;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        registerEvents();
        registerCommands();
    }

    private void registerEvents() {
        new OnServerConnectedEvent(this);
    }

    private void registerCommands() {
        new HubCMD(this);
    }

    public ProxyServer getProxyServer() {
        return proxyServer;
    }

    public Logger getLogger() {
        return logger;
    }

    public static DoubleAVelocity getInstance() {
        return plugin;
    }
}
