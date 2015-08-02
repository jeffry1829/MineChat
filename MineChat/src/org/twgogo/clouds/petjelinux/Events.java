package org.twgogo.clouds.petjelinux;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Events implements Listener{
	
	MineChat minechat;
	
	public Events(MineChat minechat){
		this.minechat=minechat;
		
		Bukkit.getPluginManager().registerEvents(this , minechat);
	}
	
	@EventHandler
	public void asyncchat(AsyncPlayerChatEvent event){
System.out.println("At");
		String msg=event.getMessage();
		Player player=event.getPlayer();
System.out.println("" + minechat.arraylist + minechat.arraylist.size());
		for(ICommand el : minechat.arraylist){
			el.onTalk(msg , player);
System.out.println(el);
		}
	}
	
}
