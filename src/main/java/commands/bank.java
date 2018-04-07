package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
COMANDO PARA VER QUANTO TEM DE PIZZAS NA CONTA
 */

public class bank extends Command {
    public bank(){
        this.name = "bank";
        this.aliases = new String[]{"banco","cofrinho","cofre","dindin"};
        this.arguments = "<arguments>";
        this.guildOnly = true;
    }

    public void execute(CommandEvent event){
        if(event.getAuthor().isBot()){
            return;
        }

        if(event.getArgs().isEmpty()){

        }
        EmbedBuilder EB = new EmbedBuilder();
        if(event.getArgs().split(",").equals("sobre")){
            EB.setAuthor("O QUE É PIZZAS?");
            EB.setTitle(":pizza:");
            EB.setColor(14395649);
            EB.setDescription("Pizzas é uma moeda que pode ser usada para comandos aleatorios (EM DESENVOLVIMENTO)");
            EB.setFooter("Comando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
            EB.setTimestamp(event.getMessage().getCreationTime());
            event.reply(EB.build());
            return;
        }

        String guildId = event.getGuild().getId();
        String authorId = event.getAuthor().getId();
        String finalPath = ("GeneralConfig"+"\\"+guildId+"\\"+authorId);
        String authorFile = (authorId+".txt");
        Path pathtxt = Paths.get(finalPath + "\\" + authorFile);
        File file = new File(finalPath);
;
        file.mkdirs();
        String readFileGiveResult = "0";
        try {
            readFileGiveResult = Files.readAllLines(pathtxt).get(0);
        } catch (IOException e) {
            String zero = "0";
            byte[] banknew = zero.getBytes();
            try {
                Files.write(pathtxt, banknew);
                Files.createFile(Paths.get(finalPath + "\\" + authorFile));
            }catch (Exception ignored){

            }
        }
        EB.setAuthor("Bem vindo ao Banco");
        EB.setTitle("Você tem:");
        EB.setDescription(readFileGiveResult + " pizzas");
        EB.setColor(14395649);
        EB.addField("Info:","Para mais informações digite ``gordo banco sobre``",false);
        EB.setFooter("Comando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
        EB.setTimestamp(event.getMessage().getCreationTime());
        event.reply(EB.build());
    }
}
