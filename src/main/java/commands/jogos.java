package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageReaction;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class jogos extends Command {
    public jogos(){
        this.name = "jogos";
        this.arguments = "<jogo> <12313>";

    }

    public void execute(CommandEvent event){
        Guild guild = event.getGuild();
        String coinPathName = ("GeneralConfig"+"\\"+event.getGuild().getId()+"\\"+event.getAuthor().getId());
        File file = new File(String.valueOf(coinPathName));
        EmbedBuilder EB = new EmbedBuilder();
        String[] comd = event.getArgs().split(" ");



        if(comd[0].equals("moeda")||comd[0].equals("moedas")){
            List<String> list = new ArrayList<>();
            list.add("cara");
            list.add("coroa");
            Random randomizer = new Random();
            String random = list.get(randomizer.nextInt(list.size()));
            event.reply(random);
            event.getChannel().sendMessage("").queue();

            if(!comd[1].equals(" ")) {
                if (comd[1].equals(random)) {
                    event.reply("você ganhou");
                } else {
                    event.reply("perdeu");
                }
                return;
            }
        }


    }
}
