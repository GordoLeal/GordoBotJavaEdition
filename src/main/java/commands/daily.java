package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class daily extends Command {
    public daily(){
        this.name = "daily";
        this.aliases = new String[]{"pizzas","pizzagratis","pizza","pizzasgratis"}; //apesar do nome daily as pizzas podem ser resgatadas a cada 2 horas
        this.cooldown = 7200;
        this.guildOnly = true;

    }

    public void execute(CommandEvent event){
        String guildId = event.getGuild().getId();
        String authorId = event.getAuthor().getId();
        String readFileGiveResult;//pegar o caminho e adicionar ao path
        String finalPath = ("GeneralConfig\\Data\\"+guildId+"\\"+authorId+"\\coinQuantity.txt");
        Path pathtxt = Paths.get(finalPath);
        try {
            readFileGiveResult = Files.readAllLines(pathtxt).get(0);
            cooldown = 7200;
            //verificar se a pessoa tem uma conta no banco (se o arquivo foi criado)
        } catch (IOException ignored) {
            event.reply(event.getAuthor().getAsMention()+" você ainda não criou uma conta no banco.\nDigite ``gordo banco`` para criar uma conta.");
            cooldown = 0; //Cooldown resetado a 0 para evitar que a pessoa que não tem uma conta no banco acabe sendo afetada pelo cooldown mesmo sem receber pizzas
            return;
        }
        //pegar valor adicionar ao integer para poder ser modificavel
        int x = Integer.valueOf(readFileGiveResult);
        String fileout = String.valueOf(x);
        x = x + 100;
        if(x <= (-1)){
            event.reply(event.getAuthor().getAsMention()+" :warning: ALERTA!:warning: VOCÊ PASSOU DO LIMITE MAXIMO DA CONTA E TEVE QUE PAGAR IMPOSTOS!");
            x = 2147483647;
            fileout = String.valueOf(x);
            try {
                Files.write(pathtxt, Collections.singleton(fileout));
            } catch (IOException ignored) { }
            return;
        }
        event.reply(event.getAuthor().getAsMention()+" você ganhou 100 pizzas, você pode ganhar mais daqui a 2 horas. :pizza:");

        try {
            Files.write(pathtxt, Collections.singleton(fileout));
        } catch (IOException ignored) { }
        return;

    }
}
