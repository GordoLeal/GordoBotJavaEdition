package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageReaction;
import net.dv8tion.jda.core.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.core.requests.Route;

/*
 COMANDO PARA TESTE DE ARGUMENTOS E ETC... NÃO POSSUI OBJETIVO, APENAS PARA TESTES

*/

public class teste extends Command {
    public teste(){
        this.name = "teste";
        this.help = "testar comandos";
        this.arguments = "<teste1> , <teste2>";
        this.cooldown = 3;
    }

    @Override
    public void execute(CommandEvent event){
        String[] teste = event.getArgs().split(",");
        Guild guild = event.getGuild();
        if(event.getArgs().isEmpty()){
            event.reply("erro, argumento invalido");
            return;
        }
        String teste1 = teste[0];
        String teste2 = teste[1];

        //event.getMessage().addReaction("U+2705").queue();
        event.reply(teste1);
        event.reply(teste2);
    }
}
