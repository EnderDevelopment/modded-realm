package com.example.servertoolkit;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public final class ServerToolkit implements ModInitializer {
    public static final String MOD_ID = "server_toolkit";

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                SpawnCommands.register(dispatcher));
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
                handler.player.sendMessage(Text.literal("Welcome to the server! Use /spawn to return to spawn."), false));
    }
}
