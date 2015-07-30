package org.twgogo.clouds.petjelinux;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Events implements Listener{
	
	@EventHandler
	public void asyncchat(AsyncPlayerChatEvent event){
		String msg=event.getMessage();
		Player player=event.getPlayer();
		while( MineChat.it.hasNext() ){
			MineChat.it.next().onTalk(msg , player);
		}
	}
	
}
