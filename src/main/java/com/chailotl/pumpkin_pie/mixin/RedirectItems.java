package com.chailotl.pumpkin_pie.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public class RedirectItems
{
	@Redirect(
		slice = @Slice(
			from = @At(
				value = "CONSTANT",
				args = {
					"stringValue=pumpkin_pie"
				},
				ordinal = 0
			)
		),
		at = @At(
			value = "NEW",
			target = "Lnet/minecraft/item/Item;*",
			ordinal = 0
		),
		method = "<clinit>")
	private static Item pumpkinPie(Item.Settings settings)
	{
		// Just to remove the food component
		return new Item(new Item.Settings());
	}
}