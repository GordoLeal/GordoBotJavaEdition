package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/*
    EM PLANEJAMENTO.
 */

public class log extends Command {
    public log(){
        this.cooldown = 1;
        this.name = "log";
    }
    @Override
    protected void execute(CommandEvent event) {
        if(event.getAuthor().isBot()){
            return;
        }

        String guildId = event.getGuild().getId();
        String modLogDirPath = ("GeneralConfig\\"+guildId);
        String modLogTXTPath = ("modlog.txt");
        Path pathtxt = Paths.get(modLogTXTPath);
        File file = new File(modLogDirPath);
        file.mkdir();
        try {
            Files.createFile(Paths.get(modLogDirPath+"\\"+modLogTXTPath));
            //Files.write();
        } catch (IOException ignored) { }


    }
}
