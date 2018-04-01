package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import java.util.List;
import java.util.Scanner;

public class ban extends Command{
    public ban(){
        this.name = "ban";
        this.aliases = new String[]{"banir", "bane"};
        this.help = "Banir usuario do servidor";
        this.arguments = "<person> <reason>";

    }

    @Override
    public void execute(CommandEvent event){

        Guild guild = event.getGuild();
        Member author = event.getMessage().getMember();
        List<Member> mentioned = event.getMessage().getMentionedMembers();
        String[] comd = event.getArgs().split(",");
        String reason = " ";
        String banned = comd[0];

        try{

            reason = comd[1];

        }catch (Exception e){

            event.reply(event.getAuthor().getAsMention()+" você não colocou um motivo");

        }


        if(guild == null){

            event.reply("Posso ser gordo porem não sou burro, você precisa executar esse comando no servidor");
            return;

        }
        if(!author.hasPermission(Permission.KICK_MEMBERS)){

            event.reply("você não tem permissão para banir ninguém, contate o adiministrador do servidor");
            return;

        }

        if(event.getMessage().getMentionedMembers().isEmpty()){

            event.reply(author.getEffectiveName()+" Não encontrei essa pessoa, tem certeza que mencionou o nome corretamente?");
            return;

        }



        try{
            event.reply(author.getAsMention() + "** baniu o usuario: **" + mentioned.get(0).getAsMention());

            guild.getController().ban(event.getMessage().getMentionedMembers().get(0),30);

            System.out.println("Ban event in:" + event.getTextChannel().getName() + " , BY: " + event.getAuthor().getName()+" id: "+ event.getAuthor().getId()+" , Banned user: "+ banned);

        }catch (Exception e){
            event.reply("um erro aconteceu");
        }

        return;
    }


}
