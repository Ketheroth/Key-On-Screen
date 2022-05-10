package com.ketheroth.keyonscreen;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;

public class KeyOnScreenOverlay implements IIngameOverlay {

	public final static KeyOnScreenOverlay INSTANCE = new KeyOnScreenOverlay();

	private Component key = new TranslatableComponent("");
	private int time = 0;
	private boolean display = false;

	private KeyOnScreenOverlay() {
	}

	@Override
	public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTick, int width, int height) {
		if (this.time > KeyOnScreenConfig.DURATION.get()) {
			this.display = false;
		}
		if (this.display) {
			this.time++;
			Font font = Minecraft.getInstance().font;
			int cx = (int) (KeyOnScreenConfig.X.get() / 100.0F * width);
			int cy = (int) (KeyOnScreenConfig.Y.get() / 100.0F * height);
			int w = (int) (KeyOnScreenConfig.WIDTH.get() / 100.0F * width);
			int h = (int) (KeyOnScreenConfig.HEIGHT.get() / 100.0F * height);
			int x = cx - w / 2;
			int y = cy - h / 2;
			GuiComponent.fill(poseStack, x, y, x + w, y + h, KeyOnScreenConfig.BG_COLOR.get());
			GuiComponent.drawCenteredString(poseStack, font, this.key.getString(), cx, cy - font.lineHeight / 2, KeyOnScreenConfig.TEXT_COLOR.get());
		}
	}

	public void addKey(InputConstants.Key key) {
		this.key = key.getDisplayName();
		this.time = 0;
		this.display = true;
	}

}
