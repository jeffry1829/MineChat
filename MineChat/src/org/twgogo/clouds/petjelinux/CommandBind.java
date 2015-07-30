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
	
	File bindfile=new File("./plugins/MineChat/bindfile.bind");
	
	public CommandBind() throws IOException{
		
		if( !(bindfile.exists()) ){
			bindfile.getParentFile().mkdirs();
			bindfile.createNewFile();
		}
		
	}
	
	@Override
	public String getName() {
		return "bind";
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
			FileWriter fw=new FileWriter(bindfile);
			fw.write(strar[0]+"|"+strar[1]);
			fw.flush();
			fw.close();
		} catch (IOException e) {}
		
	}

	@Override
	public void onTalk(String msg , Player player) {
		try {
			BufferedReader br=new BufferedReader(new FileReader(bindfile));
			while( br.readLine()!=null ){
				String[] strresult=br.readLine().split("|");
				if( msg.indexOf(strresult[0])!=-1 ){
					player.sendMessage(strresult[1]);
				}
			}
			br.close();
		} catch (Exception e) {}
	}

}
