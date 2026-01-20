package com.bordas.withered_foxy_jumpscare;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class JumpscareScreen extends Screen {
    private static final Identifier JUMPSCARE_TEXTURE = Identifier.of(WitheredFoxyJumpscare.MOD_ID, "textures/gui/jumpscare.png");
    private static final int DISPLAY_DURATION = 80; // 4 seconds (80 ticks at 20 tps)
    
    private int ticksDisplayed = 0;
    private boolean soundPlayed = false;
    
    public JumpscareScreen() {
        super(Text.literal("Jumpscare"));
    }
    
    @Override
    protected void init() {
        super.init();
        
        // Play jumpscare sound when screen is opened
        if (!soundPlayed) {
            MinecraftClient client = MinecraftClient.getInstance();
            client.getSoundManager().play(
                PositionedSoundInstance.master(
                    WitheredFoxyJumpscare.JUMPSCARE_SOUND_EVENT,
                    1.0F,
                    1.0F
                )
            );
            soundPlayed = true;
            WitheredFoxyJumpscare.LOGGER.info("Playing jumpscare sound");
        }
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Render black background
        context.fill(0, 0, this.width, this.height, 0xFF000000);
        
        // Render jumpscare texture fullscreen
        try {
            context.drawTexture(JUMPSCARE_TEXTURE, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } catch (Exception e) {
            // If texture fails to load, just show black screen
            WitheredFoxyJumpscare.LOGGER.warn("Failed to render jumpscare texture: " + e.getMessage());
        }
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    @Override
    public void tick() {
        super.tick();
        ticksDisplayed++;
        
        // Auto-close after duration
        if (ticksDisplayed >= DISPLAY_DURATION) {
            close();
        }
    }
    
    @Override
    public void close() {
        WitheredFoxyJumpscare.LOGGER.info("Closing jumpscare screen");
        super.close();
    }
    
    @Override
    public boolean shouldPause() {
        // Don't pause the game while showing jumpscare
        return false;
    }
    
    @Override
    public boolean shouldCloseOnEsc() {
        // Allow closing with ESC key
        return true;
    }
}
