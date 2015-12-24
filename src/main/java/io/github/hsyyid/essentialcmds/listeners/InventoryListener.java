/*
 * This file is part of EssentialCmds, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015 - 2015 HassanS6000
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.github.hsyyid.essentialcmds.listeners;

import io.github.hsyyid.essentialcmds.utils.Utils;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.item.inventory.transaction.SlotTransaction;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

public class InventoryListener
{
	@Listener
	public void onChangeHeldItem(ChangeInventoryEvent.Held event)
	{
		if (event.getCause().first(Player.class).isPresent())
		{
			Player player = event.getCause().first(Player.class).get();
			
			for (SlotTransaction transaction : event.getTransactions())
			{
				if (Utils.getBlacklistItems().contains(transaction.getFinal().createStack().getItem().getId()))
				{
					player.sendMessage(Texts.of(TextColors.RED, "The item ", TextColors.GRAY, transaction.getFinal().createStack().getItem().getId(), TextColors.RED, " has been confiscated as it is blacklisted."));
				}
			}
		}
	}
	
	@Listener
	public void onChangeEquipment(ChangeInventoryEvent.Equipment event)
	{
		if (event.getCause().first(Player.class).isPresent())
		{
			Player player = event.getCause().first(Player.class).get();
			
			for (SlotTransaction transaction : event.getTransactions())
			{
				if (Utils.getBlacklistItems().contains(transaction.getFinal().createStack().getItem().getId()))
				{
					player.sendMessage(Texts.of(TextColors.RED, "The item ", TextColors.GRAY, transaction.getFinal().createStack().getItem().getId(), TextColors.RED, " has been confiscated as it is blacklisted."));
				}
			}
		}
	}
}
