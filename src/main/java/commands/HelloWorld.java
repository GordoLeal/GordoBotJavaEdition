package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class HelloWorld extends Command {

    public HelloWorld(){
        this.name ="oi";
        this.help ="responde com oi";
    }

    @Override
    public void execute(CommandEvent event){
        event.reply("oi o/ tudo bem com você? eu vou bem");
    }

}
