package commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

import java.util.List;

/*
COMANDO PARA EXPULSÃO DE USUARIO
 */
public class kick extends Command {
    public kick(){
        this.name = "kick";
        this.aliases = new String[]{"expulse","expulsar","chutar","chute"};
        this.help = "expulsa a conta do servidor";
        this.arguments = "<person> <reason>";
    }

    @Override
    public void execute(CommandEvent event){
        Guild guild = event.getGuild();
        Member author = event.getMessage().getMember();
        List<Member> mentioned = event.getMessage().getMentionedMembers();

        String[] comd = event.getArgs().split(",");
        String reason = comd[1];

        if(!guild.getSelfMember().hasPermission(Permission.KICK_MEMBERS)){
            event.reply("Eu não tenho acesso a expulsar membros do servidor, fale com o adiministrador para me dar um cargo com acesso a **expulsar membros** ativado");
            return;
        }
        if(guild == null){
            event.reply("Posso ser gordo porem não sou burro, você precisa executar esse comando no servidor");
            return;
        }
        if(!author.hasPermission(Permission.KICK_MEMBERS)){
            event.reply("você não tem permissão para expulsar ninguém");
            return;
        }

        if(event.getMessage().getMentionedMembers().isEmpty()){
            event.reply(author.getEffectiveName()+" Não encontrei esta pessoa, tem certeza que mencionou o nome corretamente?");
            return;

        }

        event.reply("``" + author.getAsMention()+ "``" + "** expulsou o usuario: **" + "``" +mentioned.get(0).getAsMention() + "``,");
        event.reply("**usuario expulso com sucesso**");
        try{
            guild.getController().kick(mentioned.get(0),reason).queue();
        } catch (Exception e){
            event.reply((Message) e);
        }
        return;

    }
}
