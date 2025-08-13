package net.ruddez.vapemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.ruddez.vapemod.VapeMod;
import org.spongepowered.include.com.google.common.base.Function;

public class ModItems {
    public static final Item VAPE = registerItem("vape", Vape::new, new Vape.Settings());
    public static final Item BIG_VAPE = registerItem("big_vape", BigVape::new, new BigVape.Settings());
    public static final Item BIO_VAPE = registerItem("bio_vape", BioVape::new, new BioVape.Settings());

    public static Item registerItem(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("vapemod", path));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        VapeMod.LOGGER.info("Registering Mod Items for " + VapeMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(VAPE);
            entries.add(BIG_VAPE);
            entries.add(BIO_VAPE);
        });
    }
}
