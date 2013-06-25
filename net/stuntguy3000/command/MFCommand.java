package net.stuntguy3000.command;
import net.stuntguy3000.MFPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MFCommand implements CommandExecutor {
	public MFPlugin plugin;
	
	public MFCommand (MFPlugin instance)
	{
		this.plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			
			if (args.length < 1)
			{
				String Authors = "";
				int Count = 0;
				
				for (String name : plugin.getDescription().getAuthors())
				{
					Count ++;
					
					if (Count == plugin.getDescription().getAuthors().size())
					{
						Authors = Authors + name;
					} else {
						Authors = Authors + name + "&7, &b";
					}
				}
				
				p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&6" + plugin.getDescription().getDescription()));
				p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&e" + plugin.getDescription().getWebsite()));
				p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&9Version: &b" + plugin.getDescription().getVersion()));
				p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&9Created by: &b" + Authors));
				p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&cFor commands: Type /mf help"));
				
				return true;
			}
			
			if (args.length == 1)
			{
				if (args[0].equalsIgnoreCase("help"))
				{
					p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&eThe help menu is seperated into sections."));
					p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&6/mf help arena &8-&e All arena related commands"));
					p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&6/mf help game &8-&e All game related commands"));
					p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&6/mf help other &8-&e All other commands"));
					return true;
				}
			}
			
			p.sendMessage(plugin.util.c(plugin.util.MessagePrefix + "&cInvalid command! Type /mf help for command help."));
			
		} else {
			// Comming soon.
		}
		
		return false;
	}

}
