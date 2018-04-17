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
    public void execute(CommandEvent event){//preparação do comando
        String guildId = event.getGuild().getId();
        String authorId = event.getAuthor().getId();
        String readFileGiveResult;
        String finalPath = ("GeneralConfig\\Data\\"+guildId+"\\"+authorId);
        String authorFile = ("coinQuantity.txt");
        Path pathtxt = Paths.get(finalPath + "\\" + authorFile);
        //Ler arquivo e verificar se ele existe
        try {
            readFileGiveResult = Files.readAllLines(pathtxt).get(0);
        } catch (IOException ignored) {
            event.reply(event.getAuthor().getAsMention()+" você ainda não criou uma conta no banco.\nDigite ``gordo banco`` para criar uma conta.");
            return;
        }
        //transferir valor de string para integer e verificar se possui a quantidade necessaria
        int x = Integer.valueOf(readFileGiveResult);
        if(x <= 25){
            event.reply(event.getAuthor().getAsMention()+" você não possui pizzas suficientes para usar o caça-niquel\nExperimente pegar suas pizzas gratuitas, digite: ``gordo pizzasgratis``");
            return;
        }


        EmbedBuilder EB = new EmbedBuilder();
        Random random = new Random();
        List<String> randomList = new ArrayList<>();
        randomList.add(":pizza:");
        randomList.add(":chocolate_bar:");  //cria a lista e adiciona os valores dentro da lista
        randomList.add(":hotdog:");
        randomList.add(":salad:");
        String result1 = randomList.get(random.nextInt(randomList.size()));
        String result2 = randomList.get(random.nextInt(randomList.size()));// nome aleatorio pego da lista sera colocado dentro dessas variaveis
        String result3 = randomList.get(random.nextInt(randomList.size()));
        EB.setAuthor("CAÇA-NIQUEL");
        EB.setTitle("O RESULTADO É:");
        EB.setColor(3801567);
        EB.setFooter("Comando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
        EB.setTimestamp(event.getMessage().getCreationTime());
        EB.addField("VOCÊ COMPROU UM TICKET","você gastou 15 pizzas para jogar",false);
        x = x - 15; //vai remover 15 pizzas do banco

        EB.setDescription("["+result1+"]"+"["+result2+"]"+"["+result3+"]");//criar um display do embed para mostrar os valores
        if(result1 == result2 && result2 == result3){//verificar se todos os resultados aleatorios são iguais
            if(result2 == ":pizza:"){//verificar o valor
                x = x + 100; //somar o valor
                EB.addField("VOCÊ GANHOU: ","100 pizzas",false);//adicionar um paragrafo no embed falando que ganhou e a quantidade
                String fileout = String.valueOf(x);//transformar valor de volta em string
                if(x <= (-1)){
                    EB.addField(":warning: ALERTA!:warning: ","VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!",false);
                    x = 2147483647;
                    fileout = String.valueOf(x);
                }
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));//colocar o valor dentro do arquivo
                } catch (IOException ignored) { }
                event.reply(EB.build()); //contruir o embed e responder no chat que o comando foi chamado
                return;
            }

            if(result2 == ":chocolate_bar:"){
                x = x + 50;
                EB.addField("VOCÊ GANHOU: ","50 pizzas",false);
                String fileout = String.valueOf(x);
                if(x <= (-1)){
                    EB.addField(":warning: ALERTA!:warning: ","VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!",false);
                    x = 2147483647;
                    fileout = String.valueOf(x);
                }
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }

            if(result2 == ":hotdog:"){
                x = x + 30;
                EB.addField("VOCÊ GANHOU: ","30 pizzas",false);
                String fileout = String.valueOf(x);
                if(x <= (-1)){
                    EB.addField(":warning: ALERTA!:warning: ","VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!",false);
                    x = 2147483647;
                    fileout = String.valueOf(x);
                }
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }
            //no caso das saladas, não será adicionado valor, e assim nada sera feito na quantidade, apenas construir embed e responder
            if(result2 == ":salad:"){
                EB.addField("VOCÊ GANHOU:","nada... ninguem gosta de saladas",false);
                event.reply(EB.build());
                String fileout = String.valueOf(x);
                if(x <= (-1)){
                    EB.addField(":warning: ALERTA!:warning: ","VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!",false);
                    x = 2147483647;
                    fileout = String.valueOf(x);
                }
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
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
                if(x <= (-1)){
                    EB.addField(":warning: ALERTA!:warning: ","VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!",false);
                    x = 2147483647;
                    fileout = String.valueOf(x);
                }
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
                if(x <= (-1)){
                    EB.addField(":warning: ALERTA!:warning: ","VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!",false);
                    x = 2147483647;
                    fileout = String.valueOf(x);
                }
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
                if(x <= (-1)){
                    EB.addField(":warning: ALERTA!:warning: ","VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!",false);
                    x = 2147483647;
                    fileout = String.valueOf(x);
                }
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }

            if((result2 == ":salad:" && result1 ==":salad:")||(result2 == ":salad:" && result3 == ":salad:")||(result1 == ":salad:" && result3 == ":salad:")){
                EB.addField("VOCÊ GANHOU:","nada... ninguem gosta de saladas",false);
                String fileout = String.valueOf(x);
                if(x <= (-1)){
                    EB.addField(":warning: ALERTA!:warning: ","VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!",false);
                    x = 2147483647;
                    fileout = String.valueOf(x);
                }
                try {
                    Files.write(pathtxt, Collections.singleton(fileout));
                } catch (IOException ignored) { }
                event.reply(EB.build());
                return;
            }
        }



        String fileout = String.valueOf(x);
        try {
            Files.write(pathtxt, Collections.singleton(fileout));
        } catch (IOException ignored) { }
        EB.addField("uma pena!","tente novamente",false);
        event.reply(EB.build());
        return;
    }
}
