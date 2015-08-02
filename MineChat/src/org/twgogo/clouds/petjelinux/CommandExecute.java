package org.twgogo.clouds.petjelinux;

import java.io.IOException;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExecute implements ICommand{

	MineChat minechat;
	
	@Override
	public String getName() {
		final String name="execute";
		return name;
	}

	public CommandExecute(MineChat minechat) throws IOException{
		this.minechat=minechat;
	}
	
	@Override
	public void Execute(CommandSender sender , String[] strar) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTalk(String msg , Player player) {
		// TODO Auto-generated method stub
		
	}

}
