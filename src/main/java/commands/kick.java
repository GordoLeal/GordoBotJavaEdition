package commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
/*
COMANDO PARA EXPULSÃO DE USUARIO

*/
public class kick extends Command {
    public kick(){
        this.name = "kick";
        this.aliases = new String[]{"expulse","expulsar","chutar","chute"};
        this.help = "expulsa a conta do servidor";
        this.arguments = "<person> <reason>";
        this.guildOnly = true;
    }

    @Override
    public void execute(CommandEvent event){
        Guild guild = event.getGuild();
        Member author = event.getMessage().getMember();
        Member mentioned = event.getMessage().getMentionedMembers().get(0);
        String[] comd = event.getArgs().split(",");
        String reason = "";
        try {
            reason = comd[1];
        }catch(Exception e){
            reason = (event.getAuthor().getAsMention()+" expulsou o usuario "+mentioned);
        }

        if(!author.hasPermission(Permission.KICK_MEMBERS) && !guild.getSelfMember().hasPermission(Permission.KICK_MEMBERS) && event.getMessage().getMentionedMembers().isEmpty()){
            event.reply("Digite gordo banir "+event.getAuthor().getAsMention()+", [motivo(opcional)]");
        }

        if(!author.hasPermission(Permission.KICK_MEMBERS)){
            event.reply("você não tem permissão para expulsar ninguém");
            return;
        }

        if(!guild.getSelfMember().hasPermission(Permission.KICK_MEMBERS)){
            event.reply("Eu não tenho acesso a expulsar membros do servidor, fale com o adiministrador para me dar um cargo com acesso a **expulsar membros** ativado");
            return;
        }

        if(event.getMessage().getMentionedMembers().isEmpty()){
            event.reply(author.getEffectiveName()+" Não encontrei esta pessoa, tem certeza que mencionou o nome corretamente?");
            return;
        }

        try{
            event.reply(author.getAsMention() + "** expulsou o usuario: **" + mentioned.getAsMention() + ":white_check_mark:"+"\n"+":red_circle: **usuario expulso com sucesso** :white_check_mark:");
            guild.getController().kick(mentioned,(event.getAuthor().getAsMention()+reason)).queue();
            System.out.println("Kick event in:" + event.getGuild().getName()+" Channel: "+event.getTextChannel().getName() + " , BY: " + event.getAuthor().getName()+" id: "+ event.getAuthor().getId()+" , Banned user: "+ mentioned);


        } catch (Exception e){
            event.reply("erro, verificar console");
            event.reply((Message) e);
            return;
        }
        return;

    }
}
