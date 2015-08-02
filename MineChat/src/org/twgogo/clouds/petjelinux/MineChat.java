package org.twgogo.clouds.petjelinux;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MineChat extends JavaPlugin{
	
	ArrayList<ICommand> arraylist=new ArrayList<ICommand>();
	Iterator<ICommand> it=arraylist.listIterator();
		

	public void onEnable(){
		
		try{
			arraylist.add( (ICommand)new CommandBind(this) );
			arraylist.add( (ICommand)new CommandExecute(this) );
getLogger().info("\\INIT/");
		}catch(Exception e1est){
			e1est.printStackTrace();
		}
		
		getCommand("bind").setExecutor(this);
		new Events(this);
		getLogger().info(ColorCodes.RED+"MineChat Enable"+ColorCodes.RESET);
	}
	public void onDisable(){}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		for(ICommand el : arraylist){
			if( el.getName().equalsIgnoreCase(label) ){
				el.Execute(sender , args);
					return true;
			}
		}
			return false;
	}
}
