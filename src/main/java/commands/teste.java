package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.JDAInfo;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.managers.AudioManager;
import net.dv8tion.jda.core.utils.JDALogger;

/*
    COMANDO TESTE, É APENAS UTILIZADO PARA TESTAR COMANDOS ANTES DE CRIAR A SUA ESTRURA

*/

public class teste extends Command{
    public teste(){
        this.name = "teste";
        this.arguments = "[teste1]";
        this.cooldown = 0;
        this.ownerCommand = true;
        this.guildOnly = false;
    }

    @Override
    public void execute(CommandEvent event){
        /*Guild guild = event.getGuild();//variavel
        VoiceChannel voiceChannel = guild.getVoiceChannelById(event.getMember().getVoiceState().getChannel().getId());//vai pegar o canal de voz que a pessoa que executou o comando esta
        AudioManager audioManager = guild.getAudioManager(); // vai pegar o controlador de audio do discord para poder ver os chats de voz
        audioManager.openAudioConnection(voiceChannel);// vai se conectar ao chat de voz
        //Sending audio to an open Audio connection
        //1° já feito
        AudioPlayerManager audioPlayerManager = new DefaultAudioPlayerManager();
        AudioPlayer audioPlayer = audioPlayerManager.createPlayer();
        guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(audioPlayer));

        //por fora
        EmbedBuilder EB = new EmbedBuilder();
        EB.setAuthor("tocando:");
        EB.setColor(Color.CYAN);
        EB.setTimestamp(event.getMessage().getCreationTime());
        EB.setFooter("Comando executador por: "+event.getAuthor().getName(),event.getAuthor().getAvatarUrl());
        AudioSourceManagers.registerRemoteSources(audioPlayerManager);
        TrackScheduler trackScheduler = new TrackScheduler(audioPlayer);
        audioPlayer.addListener(trackScheduler);
        String[] args = event.getArgs().split(",");

        if(args[0] == "pular"){
            if(event.getMember().getVoiceState().getChannel().getId() == event.getSelfMember().getVoiceState().getChannel().getId()){
                audioPlayer.stopTrack();
                event.reply("musica parada");
            }else {
                event.reply("você não esta no canal de voz.");
                return;
            }
        }


        audioPlayerManager.loadItem(args[0], new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                audioPlayer.startTrack(track,true);
                EB.setDescription(audioPlayer.getPlayingTrack().getInfo().title);
                EB.addField("Autor: ",audioPlayer.getPlayingTrack().getInfo().author,true);
                EB.addField("link: ",audioPlayer.getPlayingTrack().getInfo().uri,true);
                EB.addField(":warning: AVISO :warning: ",":warning: Esta função esta em ALPHA, contem MUITOS bugs! :warning: ",false);
                event.reply(EB.build());
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                event.reply("playlist");
            }

            @Override
            public void noMatches() {
                event.reply("error");
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                event.reply(String.valueOf(exception));
            }
        });
        audioPlayer.setVolume(50);
        event.getMessage().delete().queue();
    */
        Guild guild = event.getGuild();
        AudioManager audioManager = guild.getAudioManager();
        //VoiceChannel channel = event.getMember().getVoiceState().getChannel();
        audioManager.closeAudioConnection();

    }
}