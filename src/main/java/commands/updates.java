package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

public class updates extends Command {
    public updates(){
        this.name = "update";
        this.cooldown = 10;
        this.guildOnly = false;
        this.aliases = new String[]{"mudanças","updates"};
    }

    @Override
    protected void execute(CommandEvent event) {
        EmbedBuilder EB = new EmbedBuilder();
        EB.setAuthor("MUDANÇAS NO BOT");
        EB.setTitle(":bell:");
        EB.setDescription("versão 2.2.3");
        EB.addField("mudanças:","-Conserto de bugs\n-nerf no comando ``apostar``\n  >Reduzido premio da pizza de ``3x`` para ``2x``\n  >reduzido premio do chocolate de ``2x`` para ``o valor apostado mais metade do valor apostado``\n-Adicionado o comando ``update``",false);
        EB.addField("versão 2.2.4 e 2.2.5","correção de mais bugs e uma pequena falha de digitação\nConserto do comando ``gordo pizza``",false);
        EB.setThumbnail(event.getSelfUser().getEffectiveAvatarUrl());
        EB.setColor(9046091);
        EB.setTimestamp(event.getMessage().getCreationTime());
        EB.setFooter("Comando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
        event.reply(EB.build());

    }


}
