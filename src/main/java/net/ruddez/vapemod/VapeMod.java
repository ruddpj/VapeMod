package net.ruddez.vapemod;

import net.fabricmc.api.ModInitializer;

import net.ruddez.vapemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VapeMod implements ModInitializer {
	public static final String MOD_ID = "vapemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}