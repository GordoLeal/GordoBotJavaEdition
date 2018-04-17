package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

/*
    COMANDO TESTE, É APENAS UTILIZADO PARA TESTAR COMANDOS ANTES DE CRIAR A SUA EXTRURA

*/

public class teste extends Command {
    public teste(){
        this.name = "teste";
        this.arguments = "[teste1],[teste2]";
        this.cooldown = 0;
        this.ownerCommand = true;
    }

    @Override
    public void execute(CommandEvent event){

    }

}
