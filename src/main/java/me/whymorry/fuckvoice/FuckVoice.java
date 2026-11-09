package me.whymorry.fuckvoice;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FuckVoice implements ClientModInitializer {

    public static final String MOD_ID = "fuckvoice";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("[FuckVoice] Loaded. PlasmoVoice IP restriction bypass active.");
    }
}
