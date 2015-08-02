package org.twgogo.clouds.petjelinux;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MineChat extends JavaPlugin{
	
<<<<<<< HEAD
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
=======
	static ArrayList<ICommand> arraylist=new ArrayList<ICommand>();
	static Iterator<ICommand> it=arraylist.listIterator();
	static{
		try{
		arraylist.add( (ICommand)new CommandBind() );
		arraylist.add( (ICommand)new CommandExecute() );
		}catch(Exception e1est){}
	}

	public void onEnable(){
		getCommand("bind").setExecutor(this);
		getServer().getPluginManager().registerEvents(new Events() , this);
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
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
