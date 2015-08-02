package org.twgogo.clouds.petjelinux;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface ICommand {
	String getName();
	void Execute(CommandSender sender , String[] strar);
	void onTalk(String msg , Player player);
}
