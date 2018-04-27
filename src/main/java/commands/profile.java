package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
* Comando em desenvolvimento, não tem função
* */

public class profile extends Command {
    public profile(){
        this.name ="profile";
        this.guildOnly = false;
        this.cooldown = 0;
        this.aliases = new String[]{"perfil"};
        this.ownerCommand = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        String finalPath = ("GeneralConfig\\Data\\profiles\\"+event.getAuthor().getId());
        String txtFile = ("profile.txt");
        Path pathtxt = Paths.get(finalPath + "\\" + txtFile);
        String[] teste = event.getArgs().split(" ");
        File file = new File(finalPath);
        file.mkdirs();
        List<String> readfile;

      /*  try {
            readfile = Files.readAllLines(pathtxt);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        EmbedBuilder eB = new EmbedBuilder();
        eB.setTitle("perfil de: "+event.getAuthor().getName());
        eB.setDescription("nada por agora");//medalhas
        eB.addField("Nome da conta",event.getAuthor().getAsMention(),true);
        eB.addField("Conta criada em: ", String.valueOf(event.getAuthor().getCreationTime()),true);
        eB.setImage(event.getAuthor().getAvatarUrl());
        eB.addField("Banco:","em desenvolvimento",true);//pizzas
        eB.addField("Identidade",event.getAuthor().getId(),true);//informaçoes basicas, hora de criação, id, etc...
        eB.addField("mascote","em desenvolvimento",true);//mascote
        eB.addField("MEDALHAS","inserir medalhas aqui",true);
        event.reply(eB.build());


    }
}
