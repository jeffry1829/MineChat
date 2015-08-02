package org.twgogo.clouds.petjelinux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBind implements ICommand{
	
	MineChat minechat;
	
	File bindfile=new File(minechat.getDataFolder() + "/bindfile.bind");
	
	
	public CommandBind(MineChat minechat) throws IOException{
		this.minechat=minechat;
		
		if( !(bindfile.exists()) ){
			bindfile.getParentFile().mkdirs();
			bindfile.createNewFile();
		}
	}
	
	@Override
	public String getName() {
		final String name="bind";
		return name;
	}

	@Override
	public void Execute(CommandSender sender , String[] strar) {
		
		if(strar.length!=2){
			System.out.println(ColorCodes.RED + "/bind <sendMsg> <reciveMsg>  sender:" + sender.getName() + ColorCodes.RESET);
			if( (sender instanceof Player) ){
				sender.sendMessage(ChatColor.RED + "/bind <sendMsg> <reciveMsg>");
			}
			return;
		}
		
		strar[0].replaceAll("_|", " ");
		strar[1].replaceAll("_|", " ");
		
		try {
			FileWriter fw=new FileWriter(bindfile,true);
			fw.write(strar[0]+"|"+strar[1]+"\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {}
		
	}

	@Override
	public void onTalk(String msg , Player player) {
	try {
		BufferedReader br = new BufferedReader(new FileReader(bindfile));
System.out.println(msg);
		String line;
		while ( (line = br.readLine()) != null ){
			String[] pair = line.split("|");
			if (pair[0].equalsIgnoreCase(msg)) {
				player.sendMessage(pair[1]);
			}
		}
		br.close();
	}catch (Exception e) {}
	}

}
