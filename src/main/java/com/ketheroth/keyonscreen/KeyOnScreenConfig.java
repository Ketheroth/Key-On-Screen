package com.ketheroth.keyonscreen;

import net.minecraftforge.common.ForgeConfigSpec;

public class KeyOnScreenConfig {

	public static final ForgeConfigSpec CONFIG;

	public static final ForgeConfigSpec.ConfigValue<Integer> X;
	public static final ForgeConfigSpec.ConfigValue<Integer> Y;
	public static final ForgeConfigSpec.ConfigValue<Integer> WIDTH;
	public static final ForgeConfigSpec.ConfigValue<Integer> HEIGHT;
	public static final ForgeConfigSpec.ConfigValue<Integer> BG_COLOR;
	public static final ForgeConfigSpec.ConfigValue<Integer> TEXT_COLOR;
	public static final ForgeConfigSpec.ConfigValue<Integer> DURATION;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISPLAY_FUNCTION_KEYS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISPLAY_MOUSE_BUTTONS;

	static {
		ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

		X = BUILDER.comment("Center x of the overlay as a percentage of the window width.").define("x", 50);
		Y = BUILDER.comment("Center y of the overlay as a percentage of the window height.").define("y", 4);
		WIDTH = BUILDER.comment("Width of the overlay as a percentage of the window width.").define("width", 100);
		HEIGHT = BUILDER.comment("Height of the overlay as a percentage of the window height.").define("height", 8);
		BG_COLOR = BUILDER.comment("Color of the background as an int (hexadecimal form is 0xaarrggbb).").define("bg_color", 0x80212121);
		TEXT_COLOR = BUILDER.comment("Color of the text as an int (hexadecimal form is 0xaarrggbb).").define("text_color", 0x00FFFFFF);
		DURATION = BUILDER.comment("Duration of the overlay. Increase the value to increase the duration.").define("duration", 100);
		DISPLAY_FUNCTION_KEYS = BUILDER.comment("Determine if the function keys are displayed.").define("display_function_keys", true);
		DISPLAY_MOUSE_BUTTONS = BUILDER.comment("Determine if the mouse button are displayed.").define("display_mouse_buttons", true);

		CONFIG = BUILDER.build();
	}
}
