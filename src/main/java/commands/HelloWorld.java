package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
/*
* eae mano, beleza?
* */

public class HelloWorld extends Command {

    public HelloWorld(){
        this.name ="oi";
        this.aliases = new String[]{"iai","eae","opa","beleza","blz?","blz","beleza?","coé","coe"};
        this.help ="responde com oi";
    }

    @Override
    public void execute(CommandEvent event){
        event.reply("oi o/"+event.getAuthor().getAsMention()+"\nTudo bem com você? eu vou bem");
    }

}
