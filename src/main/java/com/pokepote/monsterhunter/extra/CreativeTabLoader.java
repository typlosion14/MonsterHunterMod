package com.pokepote.monsterhunter.extra;

import com.pokepote.monsterhunter.MonsterHunterMod;
import com.pokepote.monsterhunter.item.ItemLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CreativeTabLoader {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MonsterHunterMod.MODID);

    public static final List<Supplier<? extends ItemLike>> EXAMPLE_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> MONSTER_HUNTER_ITEMS = TABS.register("monsterhunter_items",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.items"))
                    .icon(ItemLoader.LOGO.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            EXAMPLE_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .withSearchBar()
                    .build()
    );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        EXAMPLE_TAB_ITEMS.add(itemLike);
        return itemLike;
    }
}
