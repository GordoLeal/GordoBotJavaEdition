package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
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
        if(event.getAuthor().isBot()){
            return;
        }

        if(!event.getMessage().getMember().hasPermission(Permission.BAN_MEMBERS)){//testar se a pessoa que executou o comando tem permissão de banir membros
            event.reply(event.getAuthor().getAsMention()+" você não tem permissão para banir");
            return;
        }

        if(!event.getGuild().getSelfMember().hasPermission(Permission.BAN_MEMBERS)){ //testar se o bot tem permissão para banir
            event.reply(event.getAuthor().getAsMention()+" eu não tenho permissão para banir");
            return;
        }

        //a partir dessa linha vai testar se usuario mencionado esta presente
        Member mentioned;

        try{//testar se foi mencionado algum usuario
            mentioned = event.getMessage().getMentionedMembers().get(0);
        }catch (Exception e){
            event.reply(event.getMessage().getMember().getEffectiveName()+" Não encontrei essa pessoa, tem certeza que mencionou o nome corretamente?\nEm caso de duvida você pode ver exemplos digitando gordo socorro");
            //porque não testar com if? por que futuramente pretendo adicionar uma função que procure por nome ou id
            return;
        }

        //variaveis e etc...
        Guild guild = event.getGuild();
        Member messageAuthor = event.getMessage().getMember();
        String[] comd = event.getArgs().split(",");
        String reason;
        String banned = comd[0];
        EmbedBuilder EB = new EmbedBuilder();

        try{// se a pessoa não colocar um motivo, um motivo default será gerado
            reason = (messageAuthor.getEffectiveName()+"Baniu este usuario com o motivo: "+comd[1]);
        }catch (Exception e){
            event.reply(event.getAuthor().getAsMention()+" você não colocou um motivo, um modelo default entrara no lugar");
            reason = (messageAuthor.getEffectiveName() + " baniu este usuario e o motivo não foi adicionado");
        }

        try{//tentar relizar banimento e reponder
            EB.setAuthor("O usuario foi banido");
            EB.setTitle(":white_check_mark: "+ mentioned.getEffectiveName());
            EB.setThumbnail(mentioned.getUser().getEffectiveAvatarUrl());
            EB.setColor(16657966);
            EB.addField("Id:",mentioned.getUser().getId(),false);
            EB.addField("Motivo",reason,false);
            EB.setThumbnail(mentioned.getUser().getAvatarUrl());
            EB.setFooter("Commando executado por: "+event.getAuthor().getName(),event.getAuthor().getAvatarUrl());
            EB.setTimestamp(event.getMessage().getCreationTime());
            event.reply(EB.build());
            System.out.println("Ban event in:" + event.getTextChannel().getName() + " , BY: " + event.getAuthor().getName()+" id: "+ event.getAuthor().getId()+" , Banned user: "+ banned);
            guild.getController().ban(mentioned,7,(event.getAuthor().getName()+reason)).queue();
        }catch (Exception e){
            event.reply("um erro aconteceu");
            return;
        }
        return;
    }
}
