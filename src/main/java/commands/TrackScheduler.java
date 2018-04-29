package commands;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;


public class TrackScheduler extends AudioEventAdapter {
    private final AudioPlayer player;


    public TrackScheduler(AudioPlayer audioPlayer) {
        this.player = audioPlayer;
    }

    @Override
    public void onPlayerPause(AudioPlayer player) {
        player.setPaused(true);// se o player for pausado
        return;
    }

    @Override
    public void onPlayerResume(AudioPlayer player) {
        player.setPaused(false);
        // Player was player perdeu o pause
        return;
    }

    @Override
    public void onTrackStart(AudioPlayer player, AudioTrack track) {
        // Uma musica começou a tocar
        return;
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        // Quando uma musica acabar
        if (endReason.mayStartNext) {
        }else {
        }
        return;

        // endReason == FINISHED: Se a musica acabou ou ouve um erro (mayStartNext = true).
        // endReason == LOAD_FAILED: se a musica deu problema para carregar (mayStartNext = true).
        // endReason == STOPPED: Se o tocador parou de tocar
        // endReason == REPLACED: outra musica começou a tocar enquanto essa ainda não acabou
        // endReason == CLEANUP: Player hasn't been queried for a while, if you want you can put a
        //                       clone of this back to your queue
    }

    @Override
    public void onTrackException(AudioPlayer player, AudioTrack track, FriendlyException exception) {
        // An already playing track threw an exception (track end event will still be received separately)
    }

    @Override
    public void onTrackStuck(AudioPlayer player, AudioTrack track, long thresholdMs) {
        // Audio track has been unable to provide us any audio, might want to just start a new track
    }
}
