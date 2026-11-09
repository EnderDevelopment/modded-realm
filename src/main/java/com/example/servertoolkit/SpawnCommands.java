package com.example.servertoolkit;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.server.command.CommandManager.literal;

public final class SpawnCommands {
    private SpawnCommands() {
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("spawn")
                .executes(context -> teleportToSpawn(context.getSource())));
        dispatcher.register(literal("setspawn")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> setSpawn(context.getSource())));
    }

    private static int teleportToSpawn(ServerCommandSource source) {
        ServerPlayerEntity player = source.getPlayerOrThrow();
        ServerWorld overworld = source.getServer().getOverworld();
        BlockPos spawn = overworld.getSpawnPos();
        player.teleport(overworld, spawn.getX() + 0.5D, spawn.getY(), spawn.getZ() + 0.5D,
                player.getYaw(), player.getPitch());
        source.sendFeedback(() -> Text.literal("Teleported to spawn."), false);
        return 1;
    }

    private static int setSpawn(ServerCommandSource source) {
        ServerPlayerEntity player = source.getPlayerOrThrow();
        ServerWorld overworld = source.getServer().getOverworld();
        BlockPos position = player.getBlockPos();
        overworld.setSpawnPoint(overworld.getRegistryKey(), position, player.getYaw(), true);
        source.sendFeedback(() -> Text.literal("Spawn set to " + position.toShortString() + "."), true);
        return 1;
    }
}
