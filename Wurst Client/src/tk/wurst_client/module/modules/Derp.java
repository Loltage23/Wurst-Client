/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C03PacketPlayer;
import tk.wurst_client.module.Category;
import tk.wurst_client.module.Module;

public class Derp extends Module
{
	public Derp()
	{
		super(
			"Derp",
			"While this is active, other people will think you are\n"
				+ "derping around.",
			Category.FUN);
	}
	
	@Override
	public void onUpdate()
	{
		if(!getToggled())
			return;
		float yaw =
			Minecraft.getMinecraft().thePlayer.rotationYaw
				+ (float)(Math.random() * 360 - 180);
		float pitch = (float)(Math.random() * 180 - 90);
		Minecraft.getMinecraft().thePlayer.sendQueue
			.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook
			(
				yaw,
				pitch,
				Minecraft.getMinecraft().thePlayer.onGround
			));
	}
}
