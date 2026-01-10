package net.gwaii.core.events;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.LightingChunk;
import net.minestom.server.instance.block.Block;
import net.minestom.server.world.biome.Biome;

import java.util.function.Consumer;

public class _AsyncPlayerConnectionEvent implements Consumer<AsyncPlayerConfigurationEvent> {

    private InstanceManager instanceManager;

    private InstanceContainer startingInstance;

    public _AsyncPlayerConnectionEvent() {
        this.instanceManager = MinecraftServer.getInstanceManager();

        startingInstance = instanceManager.createInstanceContainer();
        startingInstance.setChunkSupplier(LightingChunk::new);
        startingInstance.setGenerator(unit -> {
            unit.modifier().fillHeight(0, 64, Block.GRASS_BLOCK);
            unit.modifier().fillBiome(Biome.THE_VOID);
        });
    }

    @Override
    public void accept(AsyncPlayerConfigurationEvent event) {
        var player = event.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
        player.setRespawnPoint(new Pos(0, 64, 0));

        IO.println(player.getUsername());
        IO.println(player.getPlayerConnection());
        IO.println(player.getPlayerMeta());
        IO.println(player.getDisplayName());

        event.setSpawningInstance(startingInstance);
    }
}
