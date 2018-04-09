package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/*
 COMANDO PARA TESTE DE ARGUMENTOS E ETC... NÃO POSSUI OBJETIVO, APENAS PARA TESTES

*/

public class teste extends Command {
    public teste(){
        this.name = "teste";
        this.arguments = "<teste1> , <teste2>";
        this.cooldown = 0;
        this.ownerCommand = true;
    }

    @Override
    public void execute(CommandEvent event){


    }
}
