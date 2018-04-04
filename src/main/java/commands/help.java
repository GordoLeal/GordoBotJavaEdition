package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class help extends Command {
    public help(){
        this.name = "help";
        this.aliases = new String[]{"socorro","comandos","commands","ajuda"};
        this.cooldown = 10;

    }

    @Override
    public void execute(CommandEvent event){


    }
}
