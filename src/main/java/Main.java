import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import commands.*;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main extends ListenerAdapter{
    public static void main(String[] args) throws LoginException, IOException, IllegalArgumentException, RateLimitedException {

        String configpath = "config.txt"; //AINDA EM DESENVOLVIMENTO, SÓ JOGAR A TOKEN KEY DENTRO DA PASTA E SALVAR
        String token = ""; //DEVE SER DEIXADO EM BRANCO POR MOTIVOS DE BUGS (?) [A SER ANALISADO]
        try{
            Files.createFile(Paths.get(configpath));
        }catch (Exception e){
            System.out.print("config.txt já existe, pulando criação");
        }

        token = new String(Files.readAllBytes(Paths.get(configpath)));

        EventWaiter waiter = new EventWaiter();
        CommandClientBuilder client = new CommandClientBuilder();
        client.setPrefix("gordo ");
        client.setOwnerId(""); //ADICIONAR FUNÇÃO DE PROCURAR PELA OWNERID NA CONFIG.TXT, POR AGORA TO COM PREGUIÇA
        client.addCommands(
                new HelloWorld(),
                new kick(),
                new ban(),
                new teste(),
                new desban()
                );
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

            System.out.println("PROBLEMAS NA CONEXÃO// ERRO PROVAVEL NO TOKEN // VOCÊ COLOCOU O TOKEN CORRETAMENTE?");
            System.in.read();

        }

    }

}
