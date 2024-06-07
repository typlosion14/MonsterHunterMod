package com.pokepote.monsterhunter.monster;

import com.pokepote.monsterhunter.MonsterHunterMod;
import com.pokepote.monsterhunter.monster.entity.GrandJagras;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MonsterLoader {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MonsterHunterMod.MODID);
    public static final RegistryObject<EntityType<GrandJagras>> GRANDJAGRAS = ENTITY_TYPES.register("grandjagras",
            () -> EntityType.Builder.of(GrandJagras::new, MobCategory.CREATURE)
                    .sized(1F, 2F).build("grandjagras"));
}
