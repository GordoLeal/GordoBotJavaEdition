package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class teste extends Command {
    public teste(){
        this.name = "teste";
        this.help = "testar comandos";
        this.arguments = "<teste1> , <teste2>";

    }

    @Override
    public void execute(CommandEvent event){
        String[] teste = event.getArgs().split(",");
        if(event.getArgs().isEmpty()){
            event.reply("erro, argumento invalido");
            return;
        }
        String teste1 = teste[0];
        String teste2 = teste[1];


        event.reply(teste1);
        event.reply(teste2);
    }
}
