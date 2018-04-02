import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import commands.*;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.io.IOException;


public class Main extends ListenerAdapter{
    public static void main(String[] args) throws LoginException, IOException, IllegalArgumentException, RateLimitedException {

        fileConfig fc = new fileConfig();
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
                new desban(),
                new help()
                );
        client.setHelpWord(null);
        client.setGame(Game.playing("ONLINE"));

        try{

            new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .addEventListener(waiter)
                    .addEventListener(client.build())
                    .setGame(Game.playing("REINICIANDO"))
                    .setStatus(OnlineStatus.IDLE)
                    .buildAsync();

        }catch (Exception e){

            System.out.println(e);
            System.out.println("PROBLEMAS NA CONEXÃO // ERRO PROVAVEL NO TOKEN // VOCÊ COLOCOU O TOKEN CORRETAMENTE?"+"\n"+"Script encerrado");
            return;
        }

    }

}
