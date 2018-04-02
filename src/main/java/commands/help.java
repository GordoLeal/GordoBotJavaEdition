package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandBuilder;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.command.CommandEvent;

/**
 * Created by pedro on 02/04/2018.
 */
public class help extends Command {
    public help(){
        this.name = "help";
        this.aliases = new String[]{"socorro","comandos","commands","ajuda"};

    }

    @Override
    public void execute(CommandEvent event){
        event.reply("aaaaa");

    }
}
