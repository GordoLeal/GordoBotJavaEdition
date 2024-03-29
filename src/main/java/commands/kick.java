package commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.client.JDAClient;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;

/*
COMANDO PARA EXPULSÃO DE USUARIO MENCIONADO
*/
public class kick extends Command {
    public kick(){
        this.name = "kick";
        this.aliases = new String[]{"expulse","expulsar","chutar","chute","expulsa","quica","kicka","kickar"};
        this.arguments = "<reason>";
        this.guildOnly = true;
    }

    @Override
    public void execute(CommandEvent event){

        if(event.getAuthor().isBot()){//por garantia de bugs, testar se foi um bot que executou o comando
            return;
        }

        //variavei necessarias
        Guild guild = event.getGuild();
        Member author = event.getMessage().getMember();
        String[] comd = event.getArgs().split(",");
        String EBR;
        String reason;
        EmbedBuilder EB = new EmbedBuilder();
        Member mentioned;

        if(!author.hasPermission(Permission.KICK_MEMBERS)){ // testar se a pessoa que executou o comando tem permissão para banir
            event.reply(event.getAuthor().getAsMention()+" você não tem permissão para expulsar ninguém");
            return;
        }

        try{// ao mesmo tempo que ele tenta colocar a pessoa mencionada na variavel ele testa se ele existe, assim poupando processamento.
            mentioned = event.getMessage().getMentionedMembers().get(0);
        }catch (IndexOutOfBoundsException e){
            event.reply(event.getAuthor().getAsMention()+" você não mencionou ninguém.\nUse: ``gordo expulsar @gordo#0865 , motivo(opcional)``");
            return;
        }

        if(event.getAuthor() == mentioned.getUser() || event.getMessage().getMentionedMembers().get(0).getUser().isBot()){//o bot não pode expulsar outros bots ou a pessoa que executou o comando
            EB.setAuthor("O usuario não foi expulso");
            EB.setTitle(":warning:");
            EB.setDescription("Eu não vou expulsar bots ou a pessoa que invocou o comando.\n \nEntre em contato com um administrador do servidor :face_palm: ");
            EB.setColor(16657966);
            EB.setFooter("Commando executado por: "+event.getAuthor().getName(),event.getAuthor().getAvatarUrl());
            EB.setTimestamp(event.getMessage().getCreationTime());
            event.reply(EB.build());
            return;

        }


        if(!guild.getSelfMember().hasPermission(Permission.KICK_MEMBERS)){//testar se o bot tem permissão para expulsar
            event.reply("Eu não tenho acesso a expulsar membros do servidor, fale com o adiministrador para me dar um cargo com acesso a **expulsar membros** ativado");
            return;
        }

        if(event.getMessage().getMentionedMembers().isEmpty()){
            event.reply(author.getEffectiveName()+" Não encontrei esta pessoa, tem certeza que mencionou o nome corretamente?");
            return;
        }

        try {
            reason = (event.getAuthor().getName()+" expulsou o usuario "+ mentioned.getEffectiveName()+", motivo: "+ comd[1]);
            EBR = (comd[1]);
        }catch(Exception e){
            reason = (event.getAuthor().getName()+" expulsou o usuario "+ mentioned.getEffectiveName());
            EBR = "Sem motivo";
        }

        try{

            System.out.println("Kick event in:" + event.getGuild().getName()+" , Channel: "+event.getTextChannel().getName()+"channel id: "+event.getGuild().getId()+ " , BY: " + event.getAuthor().getName()+" , id: "+ event.getAuthor().getId()+" , Banned user: "+ mentioned.getEffectiveName());
            EB.setAuthor("O usuario foi expulso");// montagem do embed
            EB.setTitle(":white_check_mark: "+ mentioned.getEffectiveName());
            EB.setThumbnail(mentioned.getUser().getEffectiveAvatarUrl());
            EB.setColor(16657966);
            EB.setFooter("Commando executado por: "+event.getAuthor().getName(),event.getAuthor().getAvatarUrl());
            EB.setTimestamp(event.getMessage().getCreationTime());
            EB.addField("Id:",mentioned.getUser().getId(),false);
            EB.addField("Motivo",EBR,false);
            EB.setThumbnail(mentioned.getUser().getAvatarUrl());
            event.reply(EB.build());
            event.getMessage().getMentionedMembers().get(0).getUser().openPrivateChannel().queue(privateChannel ->
            {//mandar uma mensagem no privado alertando a pessoa sobre a expulsão
                EmbedBuilder teste = new EmbedBuilder().setAuthor("teste author").setTitle("teste title").setDescription("teste description").setFooter("merda",event.getMessage().getMentionedMembers().get(0).getUser().getEffectiveAvatarUrl());
                privateChannel.sendMessage(teste.build()).queue();

            });
            Thread.sleep(2000);
            guild.getController().kick(mentioned, reason).queue();

        } catch (Exception e){

            EB.setAuthor("O usuario não foi expulso");
            EB.setTitle(":warning:");
            EB.setDescription("um error inesperado aconteceu, contate o criador do bot");
            EB.setColor(16657966);
            EB.setFooter("Commando executado por: "+event.getAuthor().getName(),event.getAuthor().getAvatarUrl());
            EB.setTimestamp(event.getMessage().getCreationTime());
            return;
        }

        return;

    }
}
