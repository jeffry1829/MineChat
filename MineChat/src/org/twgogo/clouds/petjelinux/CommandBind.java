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
	
<<<<<<< HEAD
	MineChat minechat;
	
	File bindfile=new File(minechat.getDataFolder() + "/bindfile.bind");
	
	
	public CommandBind(MineChat minechat) throws IOException{
		this.minechat=minechat;
=======
	File bindfile=new File("./plugins/MineChat/bindfile.bind");
	
	public CommandBind() throws IOException{
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
		
		if( !(bindfile.exists()) ){
			bindfile.getParentFile().mkdirs();
			bindfile.createNewFile();
		}
<<<<<<< HEAD
=======
		
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
	}
	
	@Override
	public String getName() {
<<<<<<< HEAD
		final String name="bind";
		return name;
=======
		return "bind";
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
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
<<<<<<< HEAD
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
=======
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
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
	}

}
