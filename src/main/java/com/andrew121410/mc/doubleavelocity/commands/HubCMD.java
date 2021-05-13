package com.andrew121410.mc.doubleavelocity.commands;

import com.andrew121410.mc.doubleavelocity.DoubleAVelocity;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;

public class HubCMD implements SimpleCommand {

    private DoubleAVelocity plugin;

    public HubCMD(DoubleAVelocity plugin) {
        this.plugin = plugin;
        this.plugin.getProxyServer().getCommandManager().register(
                this.plugin.getProxyServer().getCommandManager().metaBuilder("hub").aliases("lobby").build()
                , this);
    }

    @Override
    public void execute(final Invocation invocation) {
        CommandSource source = invocation.source();
        if (!(source instanceof Player)) return;
        Player player = (Player) source;
        this.plugin.getProxyServer().getServer("hub").ifPresent(registeredServer -> player.createConnectionRequest(registeredServer).fireAndForget());
    }

    @Override
    public boolean hasPermission(final Invocation invocation) {
        return true;
    }
}
