package commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.entities.Game;

/*

COMANDO ABANDONADO, ARQUIVO GUARDADO PARA HISTORICO

*/
public class mudarstatus extends Command {
    public mudarstatus(){
        this.name = "mudarstatus";
        this.arguments = "<status>";

    }

    @Override
    public void execute(CommandEvent commandEvent){
        commandEvent.reply(":red_circle:em desenvolvimento aguarde..");
        if(commandEvent.getArgs().isEmpty()){
            commandEvent.reply("nenhum argumento encontrado");

        }
        else{
            String statusalterado = commandEvent.getArgs().toString();

            CommandClientBuilder client = new CommandClientBuilder();
            client.setGame(Game.playing(statusalterado));
            System.out.println("Status alterado para " + statusalterado + commandEvent.getAuthor() + commandEvent.getChannel() + commandEvent.getTextChannel());
            commandEvent.reply("Status alterado para " + statusalterado);
        }


    }
}
