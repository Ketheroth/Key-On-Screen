package com.ketheroth.keyonscreen;

import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(KeyOnScreen.MODID)
public class KeyOnScreen {

	public static final String MODID = "keyonscreen";

	public KeyOnScreen() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, KeyOnScreenConfig.CONFIG);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void setup(final FMLCommonSetupEvent event) {
		OverlayRegistry.registerOverlayTop("KeyOnScreen Overlay", KeyOnScreenOverlay.INSTANCE);
	}

}
