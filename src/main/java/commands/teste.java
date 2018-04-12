package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.util.Random;
/*
    COMANDO TESTE, É APENAS UTILIZADO PARA TESTAR COMANDOS ANTES DE CRIAR A SUA EXTRURA

*/

public class teste extends Command {
    public teste(){
        this.name = "teste";
        this.arguments = "[teste1],[teste2]";
        this.cooldown = 0;
        this.ownerCommand = true;
    }

    @Override
    public void execute(CommandEvent event){
      /*
        String guildId = event.getGuild().getId();
        String authorId = event.getAuthor().getId();
        String readFileGiveResult;
        String finalPath = ("GeneralConfig\\coinSystem\\"+guildId+"\\"+authorId+"\\coinQuantity.txt");
        Path pathtxt = Paths.get(finalPath);
        try {
            readFileGiveResult = Files.readAllLines(pathtxt).get(0);
        } catch (IOException ignored) {
            event.reply(event.getAuthor().getAsMention()+" você ainda não criou uma conta no banco.\nDigite ``gordo banco`` para criar uma conta.");
            return;
        }

        int x = Integer.valueOf(readFileGiveResult);
        event.reply(event.getAuthor().getAsMention()+" você ganhou 100 pizzas, você pode ganhar mais amanhã! :pizza:");
        x = x + 100;
        String fileout = String.valueOf(x);
        try {
            Files.write(pathtxt, Collections.singleton(fileout));
        } catch (IOException ignored) { }
        return;
                channel.sendMessage("Ping!").queue( (message) ->
         message.editMessageFormat("Pong! - "+"Discord API Ping: "+event.getJDA().getPing()+"ms - Ping: %dms", System.currentTimeMillis() - time).queue());
}
    */
     // event.getChannel().sendMessage("pong!").queue(message -> message.editMessage("pong! "+event.getJDA().getPing()+" ms").queue());
    }

}
