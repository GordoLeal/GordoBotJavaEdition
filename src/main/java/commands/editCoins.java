package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class editCoins extends Command {
    public editCoins(){
        this.name = "editCoins";
        this.cooldown = 10;
        this.aliases = new String[]{"editarpizzas","editarpizza","editarconta","editarbanco","editarcofre"};
        this.arguments = "[Quantity]";
    }
    @Override
    protected void execute(CommandEvent event) {
        if(event.getAuthor().isBot()){
            return;
        }

        if (!event.getMessage().getMember().hasPermission(Permission.MANAGE_PERMISSIONS)){
            event.getMessage().addReaction("\uD83D\uDEAB").queue();
            event.reply(event.getAuthor().getAsMention()+" você não tem permissão para editar o valor do banco.");
            return;
        }

        String readFileGiveResult;
        String guildId = event.getGuild().getId();
        String mentionedId;
        try {
            mentionedId = event.getMessage().getMentionedMembers().get(0).getUser().getId();
        }catch (Exception ignored){
            event.reply(event.getAuthor().getAsMention()+" você não mencionou uma pessoa valida");
            return;
        }
        String finalPath = ("GeneralConfig\\Data\\"+guildId+"\\"+mentionedId);
        String txtFile = ("coinQuantity.txt");
        Path pathtxt = Paths.get(finalPath + "\\" + txtFile);
        String[] teste = event.getArgs().split(" ");
        int quantity;
        int x;
        int before;


        try {
            quantity = Integer.parseInt(teste[1]);
        }catch (Exception e){
            event.reply(event.getAuthor().getAsMention()+" O valor que vc colocou passa do limite maximo ou é invalido");
            return;
        }

        if (quantity > Integer.MAX_VALUE){
            event.reply(event.getAuthor().getAsMention()+" O limite maximo para editar a conta é "+ Integer.MAX_VALUE +" pizzas");
            return;
        }else if (quantity < 0){
            event.reply(event.getAuthor().getAsMention()+ " você só pode adicionar valores acima de 0");
            return;
        }

        try {
            readFileGiveResult = Files.readAllLines(pathtxt).get(0);
        } catch (IOException ignored) {
            event.reply(event.getAuthor().getAsMention()+" este usuario não possui uma conta no banco.");
            return;
        }

        before = Integer.parseInt(readFileGiveResult);
        x = quantity;
        String output = String.valueOf(x);
        EmbedBuilder EB = new EmbedBuilder();


        try {
            Files.write(pathtxt, Collections.singleton(output));
        } catch (IOException e) {
            EB.setAuthor("CONTA NÃO EDITADA");
            EB.setTitle(":warning:");
            EB.setDescription("O valor não pode ser editado por conta de um erro desconhecido.");
            return;
        }

        EB.setAuthor("\uD83E\uDD11 | CONTA EDITADA");
        EB.setTitle(":white_check_mark: "+ event.getMessage().getMentionedMembers().get(0).getEffectiveName());
        EB.setColor(Color.GREEN);
        EB.setDescription("valor alterado de: "+before+" pizzas para: "+output+" pizzas.");
        EB.setTimestamp(event.getMessage().getCreationTime());
        EB.setFooter("comando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
        event.reply(EB.build());
    }
}
