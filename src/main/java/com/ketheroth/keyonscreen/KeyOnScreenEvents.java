package com.ketheroth.keyonscreen;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KeyOnScreen.MODID)
public class KeyOnScreenEvents {

	@SubscribeEvent
	public static void onKeyInput(InputEvent.KeyInputEvent event) {
		if (event.getKey() < 256 || KeyOnScreenConfig.DISPLAY_FUNCTION_KEYS.get()) {
			KeyOnScreenOverlay.INSTANCE.addKey(InputConstants.Type.KEYSYM.getOrCreate(event.getKey()));
		}

	}

	@SubscribeEvent
	public static void onMouseInput(InputEvent.MouseInputEvent event) {
		if (KeyOnScreenConfig.DISPLAY_MOUSE_BUTTONS.get()) {
			KeyOnScreenOverlay.INSTANCE.addKey(InputConstants.Type.MOUSE.getOrCreate(event.getButton()));
		}
	}

}
