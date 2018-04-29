package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.managers.AudioManager;

public class stopmusic extends Command {
    public stopmusic(){
        this.name = "stopmusic";
        this.aliases = new String[]{"djpare","djstop","pare","calaboca","stop","caleaboca","shutup"};
    }
    @Override
    protected void execute(CommandEvent event) {
        Guild guild = event.getGuild();
        AudioManager audioManager = guild.getAudioManager();
        try{event.getMember().getVoiceState().getChannel().getId().isEmpty();}catch (Exception ignored){
            event.reply(event.getAuthor().getAsMention()+" Hm... você deveria esta em um chat de voz para executar este comando.");
            return;
        }

        if(event.getMember().getVoiceState().getChannel() == event.getSelfMember().getVoiceState().getChannel()){
            event.reply(event.getAuthor().getAsMention()+" tá bom, eu fico calado :cry:");
            audioManager.closeAudioConnection();
            return;
        }else {
            try {
                event.getSelfMember().getVoiceState().getChannel();
                event.reply(event.getAuthor().getAsMention()+ " parece que eu não estou em nenhum canal de voz :thinking:");
                return;
            }catch (Exception ignored){
                event.getMember().getVoiceState().getChannel();
                event.reply(event.getAuthor().getAsMention()+" parece que você não esta em nenhum canal de voz :thinking:");
                return;
            }

        }


    }
}
