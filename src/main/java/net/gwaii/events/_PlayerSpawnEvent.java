package net.gwaii.events;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.instance.InstanceContainer;

import java.awt.*;
import java.util.function.Consumer;

public class _PlayerSpawnEvent implements Consumer<PlayerSpawnEvent> {

    private InstanceContainer instance;

    public _PlayerSpawnEvent(InstanceContainer instance) {
        this.instance = instance;
    }

    @Override
    public void accept(PlayerSpawnEvent event) {
        var player = event.getPlayer();

        player.setAllowFlying(true);

        if (event.isFirstSpawn()) {
            var joinMessage = Component.text("[+] ")
                .color(TextColor.color(120, 255, 120))
                .append(
                    Component.text(player.getUsername(), TextColor.color(199, 199, 199))
                );
            instance.sendMessage(joinMessage);
        }
    }
}
