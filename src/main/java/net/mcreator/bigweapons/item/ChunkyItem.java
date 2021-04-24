
package net.mcreator.bigweapons.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.Blocks;

import net.mcreator.bigweapons.procedures.ChunkyToolInHandTickProcedure;
import net.mcreator.bigweapons.procedures.ChunkySmackProcedure;
import net.mcreator.bigweapons.BigWeaponsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@BigWeaponsModElements.ModElement.Tag
public class ChunkyItem extends BigWeaponsModElements.ModElement {
	@ObjectHolder("big_weapons:chunky")
	public static final Item block = null;
	public ChunkyItem(BigWeaponsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.PINK_BED, (int) (1)), new ItemStack(Blocks.WHITE_BED, (int) (1)),
						new ItemStack(Blocks.ORANGE_BED, (int) (1)), new ItemStack(Blocks.MAGENTA_BED, (int) (1)),
						new ItemStack(Blocks.LIGHT_BLUE_BED, (int) (1)), new ItemStack(Blocks.YELLOW_BED, (int) (1)),
						new ItemStack(Blocks.LIME_BED, (int) (1)), new ItemStack(Blocks.PINK_BED, (int) (1)),
						new ItemStack(Blocks.GRAY_BED, (int) (1)), new ItemStack(Blocks.LIGHT_GRAY_BED, (int) (1)),
						new ItemStack(Blocks.CYAN_BED, (int) (1)), new ItemStack(Blocks.PURPLE_BED, (int) (1)),
						new ItemStack(Blocks.BLUE_BED, (int) (1)), new ItemStack(Blocks.BROWN_BED, (int) (1)),
						new ItemStack(Blocks.GREEN_BED, (int) (1)), new ItemStack(Blocks.RED_BED, (int) (1)),
						new ItemStack(Blocks.BLACK_BED, (int) (1)));
			}
		}, 3, -2.8f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("the sowrf"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ChunkySmackProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ChunkyToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("chunky"));
	}
}
