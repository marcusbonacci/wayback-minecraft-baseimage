package net.gwaii;

import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.LightingChunk;
import net.minestom.server.instance.block.Block;
import net.minestom.server.world.biome.Biome;

public class WorldLoader {

    public InstanceContainer loadInstance(String world_key) {
        var instanceManager = MinecraftServer.getInstanceManager();

        var instance = instanceManager.createInstanceContainer();
        instance.setGenerator(unit -> {
            unit.modifier().fillBiome(Biome.THE_VOID);
            unit.modifier().fillHeight(0, 64, Block.GRASS_BLOCK);
        });
        instance.setChunkSupplier(LightingChunk::new);
        instanceManager.registerInstance(instance);
        return instance;
    }
}
