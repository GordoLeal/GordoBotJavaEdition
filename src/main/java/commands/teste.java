package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

/*
    COMANDO TESTE, É APENAS UTILIZADO PARA TESTAR COMANDOS ANTES DE CRIAR A SUA ESTRURA

*/

public class teste extends Command{
    public teste(){
        this.name = "teste";
        this.arguments = "[teste1]";
        this.cooldown = 0;
        this.ownerCommand = true;
        this.guildOnly = false;
    }

    @Override
    public void execute(CommandEvent event){

    }
}
