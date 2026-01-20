package com.bordas.withered_foxy_jumpscare;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import java.util.Random;

public class WitheredFoxyJumpscareClient implements ClientModInitializer {
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final int JUMPSCARE_CHANCE = 1000; // 1 in 1000 chance
    private static int tickCounter = 0;
    private static final int CHECK_INTERVAL = 20; // Check every second (20 ticks)
    
    @Override
    public void onInitializeClient() {
        WitheredFoxyJumpscare.LOGGER.info("Initializing Withered Foxy Jumpscare Client");
        
        // Register client tick event for random jumpscare trigger
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Only trigger when in-game and not paused
            if (client.world != null && client.player != null && !client.isPaused()) {
                tickCounter++;
                
                // Check for jumpscare trigger every CHECK_INTERVAL ticks
                if (tickCounter >= CHECK_INTERVAL) {
                    tickCounter = 0;
                    
                    // 1 in 1000 chance to trigger jumpscare
                    if (RANDOM.nextInt(JUMPSCARE_CHANCE) == 0) {
                        triggerJumpscare(client);
                    }
                }
            }
        });
        
        WitheredFoxyJumpscare.LOGGER.info("Withered Foxy Jumpscare Client initialized successfully");
    }
    
    private void triggerJumpscare(MinecraftClient client) {
        WitheredFoxyJumpscare.LOGGER.info("Triggering Withered Foxy jumpscare!");
        
        // Open jumpscare screen
        client.execute(() -> {
            client.setScreen(new JumpscareScreen());
        });
    }
}
