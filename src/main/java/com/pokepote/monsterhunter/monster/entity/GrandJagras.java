package com.pokepote.monsterhunter.monster.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class GrandJagras extends PathfinderMob {
    public GrandJagras(EntityType<GrandJagras> entityType, Level world) {
        super(entityType, world);
    }
    @Override
    public void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        //this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier setAttributes(){
        return Mob.createMobAttributes().add(Attributes.KNOCKBACK_RESISTANCE, 4.0D).add(Attributes.FOLLOW_RANGE,1).add(Attributes.ATTACK_DAMAGE,1).build();
    }

    public static boolean canSpawn(EntityType<GrandJagras> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random ){
        return true;
    }
}