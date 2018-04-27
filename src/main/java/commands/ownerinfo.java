package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import java.awt.*;
import java.util.List;
/*
* informações do bot para o dono, somente a pessoa registrada como dono do bot pode acessar esse comando.
* Este comando apenas informa o nome do servidor e id em que o bot esta conectado, informações de conta como email, senha, id de contas, não são compartilhas como provado no codigo abaixo.
* */


public class ownerinfo extends Command {
    public ownerinfo(){
        this.name = "ownerinfo";
        this.guildOnly = false;
        this.ownerCommand = true;
        this.cooldown = 0;
        this.hidden = true;
    }
    @Override
    protected void execute(CommandEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        List<Guild> teste = event.getSelfUser().getMutualGuilds();
        int quantidadeDeServidores = event.getSelfUser().getMutualGuilds().size();
        eb.addField("nome atual",event.getSelfUser().getName(),true);
        eb.addField("id",event.getSelfUser().getId(),true);
        eb.addField("criado em:", String.valueOf(event.getSelfUser().getCreationTime()),true);
        eb.addField("status:",event.getSelfUser().getJDA().getStatus().name(),true);
        eb.addField("ping:", String.valueOf(event.getSelfUser().getJDA().getPing()),true);
        eb.setTitle("Quantidade de servidores");
        eb.setColor(Color.CYAN);
        eb.setDescription(String.valueOf(quantidadeDeServidores));
        eb.addField("nome dos servidores e Ids",String.valueOf(teste),false);
        event.replyInDm(eb.build());
    }
}
