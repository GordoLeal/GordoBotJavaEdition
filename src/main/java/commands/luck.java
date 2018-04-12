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

public class luck extends Command{
    public luck(){
        this.name = "luck";
        this.aliases = new String[]{"sorte","apostar","aposta"};
        this.arguments = "<quantity>";
        this.guildOnly = true;
        this.cooldown = 15;
    }
    @Override
    protected void execute(CommandEvent event) {

        if(event.getAuthor().isBot()){
            return;
        }

        //ler arquvio
        String readFileGiveResult = "1";
        String guildId = event.getGuild().getId();
        String authorId = event.getAuthor().getId();
        String finalPath = ("GeneralConfig\\coinSystem\\"+guildId+"\\"+authorId);
        String authorFile = ("coinQuantity.txt");
        Path pathtxt = Paths.get(finalPath + "\\" + authorFile);

        try {
            readFileGiveResult = Files.readAllLines(pathtxt).get(0);
        } catch (IOException ignored) {
            event.reply(event.getAuthor().getAsMention()+" você ainda não criou uma conta no banco.\nDigite ``gordo banco`` para criar uma conta.");
            return;
        }

        //Preparação para o comando
        int banco = Integer.parseInt(readFileGiveResult);
        int apostado = 2;
        int x;
        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();
        randomList.add(0);
        randomList.add(1);  //cria a lista e adiciona os valores dentro da lista
        randomList.add(2);
        randomList.add(3);
        Integer result1 = randomList.get(random.nextInt(randomList.size()));
        String output = "0";
        EmbedBuilder EB = new EmbedBuilder();

        if(event.getArgs().isEmpty()){
            event.reply(event.getAuthor().getAsMention()+" você precisa adicionar um valor para ser apostado valido\nExemplo: ``Gordo sorte 69``");
            return;
        }else {
            try {
                apostado = Integer.parseInt(event.getArgs());
            }catch (Exception ignored){
                event.reply(event.getAuthor().getAsMention()+ " O valor que você colocou é invalido");
                return;
            }
        }

        if(apostado <= 0){
            event.reply(event.getAuthor().getAsMention()+" você não pode apostar se não colocar dinheiro na aposta.");
        }

        if(banco < apostado){
            event.reply(event.getAuthor().getAsMention() + " você não tem "+ apostado +" no banco.");
            return;
        }

        EB.setAuthor("QUE COMECEM AS APOSTAS!");
        EB.setTitle("O SEU RESULTADO FOI:");
        EB.setFooter("Commando executado por: " + event.getAuthor().getName(), event.getAuthor().getEffectiveAvatarUrl());
        EB.setTimestamp(event.getMessage().getCreationTime());
        EB.setColor(3801567);

        switch (result1){
            case 0:// pizza (3x)
                EB.setDescription(":pizza: PIZZA! quem não gosta de pizza? ");
                x = apostado * 3;
                EB.addField("VOCÊ GANHOU:",apostado+"(3x) pizzas.",false);
                EB.addField("NO TOTAL:",x+" pizzas.", false);
                banco = banco + x;
                output = String.valueOf(banco);
                break;

            case 1://chocolate (2x)
                EB.setDescription(":chocolate_bar: CHOCOLATE! :yum:");
                x = apostado * 2;
                EB.addField("VOCÊ GANHOU:",apostado+"(2x) pizzas ",false);
                EB.addField("NO TOTAL:",x+" pizzas", false);
                banco = x + banco;
                output = String.valueOf(banco);
                break;

            case 2:// carrot (nothing)
                EB.setDescription(":carrot: CENOURA! hm.. ok..");
                EB.addField("QUE AZAR!","você perdeu o que apostou e não ganhou nada.",false);
                if(banco < apostado){
                    banco = banco - banco;
                }else {
                    banco = banco - apostado;
                }
                output = String.valueOf(banco);
                break;

            case 3:// salad (lost)
                EB.setDescription(":salad: SALADA! ninguém gosta de saladas.");
                x = apostado/2;
                EB.addField("QUE AZAR!","você perdeu o que apostou e mais "+x+" pizzas.",false);
                x = apostado + x;
                EB.addField("NO TOTAL:","você perdeu "+x+" pizzas",false);
                if(banco < x){
                    banco = banco - banco;
                }else {
                    banco = banco - x;
                }
                output = String.valueOf(banco);
                break;
        }

        event.reply(EB.build());
        try {
            Files.write(pathtxt, Collections.singleton(output));
        } catch (IOException ignored) { }
    }
}
