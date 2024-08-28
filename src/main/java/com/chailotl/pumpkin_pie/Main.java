package com.chailotl.pumpkin_pie;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;
import vectorwing.farmersdelight.common.registry.ModItems;

import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class Main implements ModInitializer
{
	public static final Item PUMPKIN_PIE_SLICE;
	public static final Block PUMPKIN_PIE;
	public static final Item PUMPKIN_PIE_ITEM;

	static
	{
		PUMPKIN_PIE_SLICE = Registry.register(Registries.ITEM, Identifier.of(FarmersDelight.MODID, "pumpkin_pie_slice"), new Item(foodItem(FoodValues.PIE_SLICE)));
		PUMPKIN_PIE = Registry.register(Registries.BLOCK, Identifier.of(FarmersDelight.MODID, "pumpkin_pie"), new PumpkinPieBlock(AbstractBlock.Settings.copy(Blocks.CAKE), () -> PUMPKIN_PIE_SLICE));
		PUMPKIN_PIE_ITEM = Registry.register(Registries.ITEM, Identifier.of(FarmersDelight.MODID, "pumpkin_pie"), new BlockItem(PUMPKIN_PIE, basicItem()));
	}

	@Override
	public void onInitialize() {
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PUMPKIN_PIE_SLICE, 0.85F);

		ServerLifecycleEvents.SERVER_STARTING.register(server -> {
			var key = Registries.ITEM_GROUP.getKey(ModCreativeTabs.TAB_FARMERS_DELIGHT.get()).get();

			ItemGroupEvents.modifyEntriesEvent(key).register(content -> {
				content.addAfter(ModItems.CAKE_SLICE.get(), PUMPKIN_PIE_SLICE);
			});
		});
	}
}