import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import commands.*;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import sun.audio.AudioPlayer;

import javax.security.auth.login.LoginException;
import java.io.IOException;


public class Main extends ListenerAdapter{
    public static void main(String[] args) throws LoginException, IOException, IllegalArgumentException, RateLimitedException {
        fileConfig fc = new fileConfig();
        fc.generalConfig();
        String token = fc.fileConfig();
        String ownerId = fc.ownerId();

        EventWaiter waiter = new EventWaiter();
        CommandClientBuilder client = new CommandClientBuilder();
        client.setPrefix("gordo ");
        client.setOwnerId(ownerId); //ADICIONAR FUNÇÃO DE PROCURAR PELA OWNERID NA CONFIG.TXT, POR AGORA TO COM PREGUIÇA
        client.addCommands(
                new HelloWorld(),
                new kick(),
                new ban(),
                new teste(),
                new help(),
                new say(),
                new sobre(),
                new bank(),
                new caçaniquel(),
                new daily()
                );
        client.useHelpBuilder(false);
        client.setGame(Game.playing("e comendo pizza"));

        try{

            new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .addEventListener(waiter)
                    .addEventListener(client.build())
                    .setGame(Game.playing("REINICIANDO"))
                    .setStatus(OnlineStatus.IDLE)
                    .buildAsync();

        }catch (Exception e){ //caso a pasta token.txt esteja vazia, será exibido um error
            System.out.println("PROBLEMAS NA CONEXÃO // ERRO PROVAVEL NO TOKEN // VOCÊ COLOCOU O TOKEN CORRETAMENTE?"+"\n"+"Script encerrado");
            return;
        }
    }

}
