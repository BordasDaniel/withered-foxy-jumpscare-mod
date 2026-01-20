package com.bordas.withered_foxy_jumpscare;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitheredFoxyJumpscare implements ModInitializer {
    public static final String MOD_ID = "withered_foxy_jumpscare";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static final Identifier JUMPSCARE_SOUND_ID = Identifier.of(MOD_ID, "jumpscare");
    public static SoundEvent JUMPSCARE_SOUND_EVENT = SoundEvent.of(JUMPSCARE_SOUND_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Withered Foxy Jumpscare Mod");
        
        // Register sound event
        Registry.register(Registries.SOUND_EVENT, JUMPSCARE_SOUND_ID, JUMPSCARE_SOUND_EVENT);
        
        LOGGER.info("Withered Foxy Jumpscare Mod initialized successfully");
    }
}
