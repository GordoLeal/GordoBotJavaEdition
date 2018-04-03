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
        Member author = event.getMessage().getMember();
        String[] text = event.getArgs().split(";<>stop<>;");
        String textReply = text[0];

        if(event.getArgs().isEmpty()){
            event.reply("Falarei qualquer coisa que você pedir \n exemplo: gordo fale eu sou lindo");
        }

        event.reply(author.getAsMention()+":\n"+textReply);

    }
}
