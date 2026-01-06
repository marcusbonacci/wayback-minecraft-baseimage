package net.gwaii;

import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.anvil.AnvilLoader;

public class WorldLoader {

    public InstanceContainer loadInstance(String world_key) {
        var instanceManager = MinecraftServer.getInstanceManager();

        var instance = instanceManager.createInstanceContainer();
        instance.setChunkLoader(new AnvilLoader(world_key));
        instanceManager.registerInstance(instance);
        return instance;
    }
}
