package org.twgogo.clouds.petjelinux;

<<<<<<< HEAD
import org.bukkit.Bukkit;
=======
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Events implements Listener{
	
<<<<<<< HEAD
	MineChat minechat;
	
	public Events(MineChat minechat){
		this.minechat=minechat;
		
		Bukkit.getPluginManager().registerEvents(this , minechat);
	}
	
=======
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
	@EventHandler
	public void asyncchat(AsyncPlayerChatEvent event){
System.out.println("At");
		String msg=event.getMessage();
		Player player=event.getPlayer();
<<<<<<< HEAD
System.out.println("" + minechat.arraylist + minechat.arraylist.size());
		for(ICommand el : minechat.arraylist){
			el.onTalk(msg , player);
System.out.println(el);
=======
		for(ICommand el : MineChat.arraylist){
			el.onTalk(msg , player);
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
		}
	}
	
}
