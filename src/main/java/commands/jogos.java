package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.entities.Guild;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class jogos extends Command {
    public jogos(){
        this.name = "jogos";
        this.arguments = "<jogo>";

    }

    public void execute(CommandEvent event){
        Guild guild = event.getGuild();
        String coinPathName = ("GeneralConfig"+"\\"+event.getGuild().getId()+"\\"+event.getAuthor().getId());
        File file = new File(String.valueOf(coinPathName));

    }
}
