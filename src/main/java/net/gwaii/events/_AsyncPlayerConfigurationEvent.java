package net.gwaii.events;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.InstanceContainer;

import java.util.function.Consumer;

public class _AsyncPlayerConfigurationEvent implements Consumer<AsyncPlayerConfigurationEvent> {

    private InstanceContainer instance;

    public _AsyncPlayerConfigurationEvent(InstanceContainer instance) {
        this.instance = instance;
    }

    @Override
    public void accept(AsyncPlayerConfigurationEvent event) {
        var player = event.getPlayer();
        player.setRespawnPoint(new Pos(0, 64, 0));
        player.setGameMode(GameMode.ADVENTURE);

        event.setSpawningInstance(instance);
    }
}
