package com.chailotl.pumpkin_pie;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

public class PumpkinPieBlock extends PieBlock
{
	public PumpkinPieBlock(Settings properties, Supplier<Item> pieSlice)
	{
		super(properties, pieSlice);
	}

	public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state)
	{
		return new ItemStack(Items.PUMPKIN_PIE);
	}
}