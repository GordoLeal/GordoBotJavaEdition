package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.entities.Member;

public class say extends Command {
    public say(){
        this.name ="say";
        this.aliases = new String[]{"fale","falar","diga"};
        this.arguments = "<text>";
        this.cooldown = 5;
    }


    @Override
    public void execute(CommandEvent event){
        if(event.getAuthor().isBot()){
            return;
        }

        Member author = event.getMessage().getMember();
        String[] text = event.getArgs().split(";<>stop<>;");
        String textReply = text[0];

        if(event.getArgs().isEmpty()){
            event.reply("Falarei qualquer coisa que você pedir \n exemplo: gordo fale eu sou lindo");
            return;
        }

        event.reply(textReply+"\n \n" + author.getAsMention());

    }
}
