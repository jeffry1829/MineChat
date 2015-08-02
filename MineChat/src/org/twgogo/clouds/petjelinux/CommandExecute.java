package org.twgogo.clouds.petjelinux;

<<<<<<< HEAD
import java.io.IOException;

=======
>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExecute implements ICommand{

<<<<<<< HEAD
	MineChat minechat;
	
	@Override
	public String getName() {
		final String name="execute";
		return name;
	}

	public CommandExecute(MineChat minechat) throws IOException{
		this.minechat=minechat;
	}
	
=======
	@Override
	public String getName() {
		return "execute";
	}

>>>>>>> ebdf1f1510643ecbb0a0c11c9514a28bac312620
	@Override
	public void Execute(CommandSender sender , String[] strar) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTalk(String msg , Player player) {
		// TODO Auto-generated method stub
		
	}

}
