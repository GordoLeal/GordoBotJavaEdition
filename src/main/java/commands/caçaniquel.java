package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class caçaniquel extends Command {
    public caçaniquel(){
        this.name = "caça niquel";
        this.aliases = new String[]{"caçaniquel","caça-niquel","slotmachine","slot"};
        this.cooldown = 15;
        this.guildOnly = true;
    }

    @Override
    public void execute(CommandEvent event){        EmbedBuilder EB = new EmbedBuilder();
        Random random = new Random();
        List<String> randomList = new ArrayList<>();
        randomList.add(":pizza:");
        randomList.add(":chocolate_bar:");
        randomList.add(":hotdog:");
        randomList.add(":salad:");
        String result1 = randomList.get(random.nextInt(randomList.size()));
        String result2 = randomList.get(random.nextInt(randomList.size()));
        String result3 = randomList.get(random.nextInt(randomList.size()));
        String guildId = event.getGuild().getId();
        String authorId = event.getAuthor().getId();
        String finalPath = ("GeneralConfig\\coinSystem\\"+guildId+"\\"+authorId);
        String authorFile = (authorId+".txt");
        Path pathtxt = Paths.get(finalPath + "\\" + authorFile);
        String readFileGiveResult;


        try {
            readFileGiveResult = Files.readAllLines(pathtxt).get(0);
        } catch (IOException ignored) {
            event.reply(event.getAuthor().getAsMention()+" você ainda não criou uma conta no banco.\nDigite ``gordo banco`` para criar uma conta.");
            return;
        }

        int x = Integer.valueOf(readFileGiveResult);
        EB.setAuthor("CAÇA-NIQUEL");
        EB.setTitle("O RESULTADO É:");
        EB.setColor(14395649);
        EB.setFooter("Comando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
        EB.setTimestamp(event.getMessage().getCreationTime());

        EB.setDescription("["+result1+"]"+"["+result2+"]"+"["+result3+"]");
        if(result1 == result2 && result2 == result3){
            if(result2 == ":pizza:"){
                x = x + 100;
                EB.addField("VOCÊ GANHOU: ","100 pizzas",false);
                String fileout = String.valueOf(x);
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }

            if(result2 == ":chocolate_bar:"){
                x = x + 50;
                EB.addField("VOCÊ GANHOU: ","50 pizzas",false);
                String fileout = String.valueOf(x);
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }

            if(result2 == ":hotdog:"){
                x = x + 25;
                EB.addField("VOCÊ GANHOU: ","25 pizzas",false);
                String fileout = String.valueOf(x);
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }

            if(result2 == ":salad:"){
                EB.addField("Você ganhou:","nada... ninguem gosta de saladas",false);
                event.reply(EB.build());
                return;
            }
            return;
        }

        if (result1 == result2 || result2 == result3 || result1 == result3){
            if((result2 == ":pizza:" && result1 ==":pizza:")||(result2 == ":pizza:" && result3 == ":pizza:")||(result1 == ":pizza:" && result3 == ":pizza:")){
                x = x + 50;
                EB.addField("VOCÊ GANHOU: ","50 pizzas",false);
                String fileout = String.valueOf(x);
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }

            if((result2 == ":chocolate_bar:" && result1 ==":chocolate_bar:")||(result2 == ":chocolate_bar:" && result3 == ":chocolate_bar:")||(result1 == ":chocolate_bar:" && result3 == ":chocolate_bar:")){
                x = x + 25;
                EB.addField("VOCÊ GANHOU: ","25 pizzas",false);
                String fileout = String.valueOf(x);
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }

            if((result2 == ":hotdog:" && result1 ==":hotdog:")||(result2 == ":hotdog:" && result3 == ":hotdog:")||(result1 == ":hotdog:" && result3 == ":hotdog:")){
                x = x + 15;
                EB.addField("VOCÊ GANHOU: ","15 pizzas",false);
                String fileout = String.valueOf(x);
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }

            if((result2 == ":salad:" && result1 ==":salad:")||(result2 == ":salad:" && result3 == ":salad:")||(result1 == ":salad:" && result3 == ":salad:")){
                EB.addField("Você ganhou:","nada... ninguem gosta de saladas",false);
                event.reply(EB.build());
                return;
            }
        }
        EB.addField("uma pena!","tente novamente",false);
        event.reply(EB.build());
        return;

    }
}
