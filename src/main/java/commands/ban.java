package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import java.util.List;

/*
 COMANDO PARA BANIMENTO DE USUARIO
*/
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
        String reason = "";
        String banned = comd[0];

        if(!author.hasPermission(Permission.BAN_MEMBERS)){

        event.reply("você não tem permissão para banir ninguém, contate o adiministrador do servidor");
        return;
        }

        if(event.getMessage().getMentionedMembers().isEmpty()){

            event.reply(author.getEffectiveName()+" Não encontrei essa pessoa, tem certeza que mencionou o nome corretamente?");
            return;

        }

        if(guild == null) {

            event.reply("Posso ser gordo porem não sou burro, você precisa executar esse comando no servidor");
            return;
        }


        try{

            reason = comd[1];


        }catch (Exception e){

            event.reply(event.getAuthor().getAsMention()+" você não colocou um motivo, banimento será realizado sem descrição");
            reason = (event.getAuthor() + " realizou o banimento sem colocar o motivo");
        }

        try{
            event.reply(author.getAsMention() + "** baniu o usuario: **" + mentioned.get(0).getAsMention()+" :white_check_mark:");
            guild.getController().ban(mentioned.get(0),7,(event.getAuthor().getName()+reason)).queue();
            System.out.println("Ban event in:" + event.getTextChannel().getName() + " , BY: " + event.getAuthor().getName()+" id: "+ event.getAuthor().getId()+" , Banned user: "+ banned);

        }catch (Exception e){
            event.reply("um erro aconteceu");
            return;
        }

        return;
    }


}
