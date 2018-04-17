package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.IOException;

public class restart extends Command {
    public restart(){
        this.name = "restart";
        this.cooldown = 0;
        this.ownerCommand = true;

        this.aliases = new String[]{"emergencia","reiniciar","reiniciaragora"};
    }
    @Override
    protected void execute(CommandEvent event) {
        int RESTART_FROM_COMMAND = 11;
        try {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -jar gordobot.jar\"");
            event.reply("REINICIANDO... POR FAVOR AGUARDE...");

            System.exit(RESTART_FROM_COMMAND);
        } catch (IOException e) {
            event.reply("teste falhou");
            e.printStackTrace();
        }
    }
}
