package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.exceptions.ErrorResponseException;

public class help extends Command {
    public help(){
        this.name = "help";
        this.aliases = new String[]{"socorro","comandos","commands","ajuda"};
        this.cooldown = 4;
    }

    @Override
    public void execute(CommandEvent event){
        EmbedBuilder EB = new EmbedBuilder();
        EB.setAuthor("Precisa de ajuda com alguma coisa?");
        EB.setTitle("Lista de comandos:");
        EB.setDescription("``help``\n"+
                "``expulse:   gordo expulse @gordo#0865 , motivo(opcional)``\n"+
                "``banir:   gordo banir @gordo#0865 , motivo (opcional)``\n"+
                "``oi:   gordo oi``\n"+
                "``fale:   gordo fale alguma coisa``\n"+
                "``sobre:   gordo sobre``\n"+
                "``sobre:   gordo ``\n");
        EB.setColor(65535);
        EB.setThumbnail(event.getSelfUser().getAvatarUrl());
        event.reply(event.getAuthor().getAsMention()+" mandei os comandos na mensagem direta.");
        event.replyInDm(EB.build());
        event.replyError(event.getAuthor().getAsMention()+" eu não posso mandar mensagens diretas para você, talvez você precise liberar esta opção nas configurações de privacidade :eyes:");
    }
}
