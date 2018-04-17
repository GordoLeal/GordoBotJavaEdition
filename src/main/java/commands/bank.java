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
        this.aliases = new String[]{"banco","cofrinho","cofre","dindin","conta"};
        this.arguments = "<info>";
        this.guildOnly = true;
    }

    public void execute(CommandEvent event){
        if(event.getAuthor().isBot()){
            return;
        }

        String[] test = event.getArgs().split(" ");
        EmbedBuilder EB = new EmbedBuilder();
        if(test[0].equals("info")){
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
        String finalPath = ("GeneralConfig\\Data\\"+guildId+"\\"+authorId);
        String authorFile = ("coinQuantity.txt");
        Path pathtxt = Paths.get(finalPath + "\\" + authorFile);
        File file = new File(finalPath);

        file.mkdirs();
        String readFileGiveResult = "100";

        if(!event.getMessage().getMentionedMembers().isEmpty()){
            authorId = event.getMessage().getMentionedMembers().get(0).getUser().getId();
            finalPath = ("GeneralConfig\\Data\\"+guildId+"\\"+authorId);
            authorFile = ("coinQuantity.txt");
            pathtxt = Paths.get(finalPath + "\\" + authorFile);
            try {
                readFileGiveResult = Files.readAllLines(pathtxt).get(0);
            } catch (IOException ignored) {
                event.reply(event.getAuthor().getAsMention()+" este usuario não possui uma conta do banco");
                return;
            }
            EB.setAuthor("\uD83D\uDCB0 Bem vindo ao Banco");
            EB.setTitle(event.getMessage().getMentionedMembers().get(0).getEffectiveName()+" tem:");
            EB.setDescription(readFileGiveResult + " pizzas");
            EB.setColor(14395649);
            EB.addField("Info:","Para mais informações digite ``gordo banco info``",false);
            EB.setFooter("Comando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
            EB.setTimestamp(event.getMessage().getCreationTime());
            EB.setThumbnail(event.getMessage().getMentionedMembers().get(0).getUser().getEffectiveAvatarUrl());
            event.reply(EB.build());
            return;
        }


        try {
            readFileGiveResult = Files.readAllLines(pathtxt).get(0);
        } catch (IOException e) {
            event.reply(event.getAuthor().getAsMention()+" Parece que você não tem uma conta no banco, eu estou criando uma para você.");
            String freeCoins = "100";
            byte[] banknew = freeCoins.getBytes();
            try {
                Files.write(pathtxt, banknew);
                Files.createFile(Paths.get(finalPath + "\\" + authorFile));

            }catch (Exception ignored){

            }
            event.reply(event.getAuthor().getAsMention()+" pronto, agora você pode guardar suas pizzas no banco :yum: ");
        }

        EB.setAuthor("\uD83D\uDCB0 Bem vindo ao Banco");
        EB.setTitle("Você tem:");
        EB.setDescription(readFileGiveResult + " pizzas");
        EB.setColor(14395649);
        EB.addField("Info:","Para mais informações digite ``gordo banco info``",false);
        EB.setFooter("Comando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
        EB.setTimestamp(event.getMessage().getCreationTime());
        event.reply(EB.build());
    }
}
