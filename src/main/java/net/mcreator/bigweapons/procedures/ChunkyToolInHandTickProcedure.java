package net.mcreator.bigweapons.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bigweapons.BigWeaponsModElements;
import net.mcreator.bigweapons.BigWeaponsMod;

import java.util.Map;

@BigWeaponsModElements.ModElement.Tag
public class ChunkyToolInHandTickProcedure extends BigWeaponsModElements.ModElement {
	public ChunkyToolInHandTickProcedure(BigWeaponsModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BigWeaponsMod.LOGGER.warn("Failed to load dependency entity for procedure ChunkyToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 200, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 200, (int) 1));
	}
}
