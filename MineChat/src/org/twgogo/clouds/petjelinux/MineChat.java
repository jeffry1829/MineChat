package org.twgogo.clouds.petjelinux;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MineChat extends JavaPlugin{
	
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
		getLogger().info(ColorCodes.RED+"MineChat Enable"+ColorCodes.RESET);
	}
	public void onDisable(){}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		while( it.hasNext() ){
			ICommand el=it.next();
			if( el.getName().equalsIgnoreCase(label) ){
				el.Execute(sender , args);
					return true;
			}
		}
			return false;
	}
}
