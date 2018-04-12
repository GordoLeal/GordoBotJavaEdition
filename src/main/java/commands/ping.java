package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ping extends Command {
    public ping(){
        this.name = "ping";
        this.cooldown = 10;
        this.aliases = new String[]{"ping!"};
        this.guildOnly = true;

    }

    public void execute(CommandEvent event){
        if (event.getAuthor().isBot()){
            return;
        }
        event.getChannel().sendMessage(":ping_pong: pong!").queue(message -> message.editMessage(":ping_pong: pong! ``"+event.getJDA().getPing()+" ms``\nping normal: 260 ~ 0 ms").queue());
    }
}
