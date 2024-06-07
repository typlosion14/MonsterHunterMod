package com.pokepote.monsterhunter.item;

import com.pokepote.monsterhunter.MonsterHunterMod;
import com.pokepote.monsterhunter.monster.MonsterLoader;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemLoader {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MonsterHunterMod.MODID);
    public static final RegistryObject<Item> LOGO = ITEMS.register("logo",
            () -> new Item(new Item.Properties().stacksTo(1).durability(2032)));
    //EGGS
    public static final RegistryObject<Item> GRAND_JAGRAS_EGG = ITEMS.register("grand_jagras_egg",
            () -> new ForgeSpawnEggItem(MonsterLoader.GRANDJAGRAS,0x9C0000,1, new Item.Properties().stacksTo(64)));
}
