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
			FileWriter fw=new FileWriter(bindfile,true);
			fw.write(strar[0]+"|"+strar[1]+"\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {}
		
	}

	@Override
	public void onTalk(String msg , Player player) {
System.out.println("In0");
		try {
			BufferedReader br=new BufferedReader(new FileReader(bindfile));
			
			String strNum;
			StringBuffer sb = new StringBuffer();
			while ((strNum=br.readLine())!=null){
			  sb.append(strNum);
			}
			
			String[] a1 = sb.toString().split("\n");
			for(String l1 : a1){	
				String[] get=l1.split("|");
System.out.println("In1 " + a1 + " " + get[0] + "|");
				if( msg.indexOf(get[0])!=-1 ){
System.out.println("In2");
					player.sendMessage(get[1]);
				}
			}
			br.close();
		} catch (Exception e) {}
	}

}
