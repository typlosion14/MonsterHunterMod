package com.pokepote.monsterhunter;

import com.mojang.logging.LogUtils;
import com.pokepote.monsterhunter.extra.CreativeTabLoader;
import com.pokepote.monsterhunter.item.ItemLoader;
import com.pokepote.monsterhunter.monster.MonsterLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MonsterHunterMod.MODID)
public class MonsterHunterMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "monsterhunter";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public MonsterHunterMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        ItemLoader.ITEMS.register(modEventBus);
        MonsterLoader.ENTITY_TYPES.register(modEventBus);
        CreativeTabLoader.TABS.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ItemLoader.GRAND_JAGRAS_EGG);
        }
        if(event.getTab() == CreativeTabLoader.MONSTER_HUNTER_ITEMS.get()){
            event.accept(ItemLoader.GRAND_JAGRAS_EGG);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //EntityRenderers.register(ModelEntity.SHADOW.get(), ShadowRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
            //event.registerLayerDefinition(ModelLayers.PIXIE_LAYER, PixieModel::createBodyLayer);
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class OverallModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            //event.put(ModelEntity.ARSENE.get(), Arsene.setAttributes());
        }


    }
}
