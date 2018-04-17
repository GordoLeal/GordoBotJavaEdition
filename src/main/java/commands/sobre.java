package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import sun.misc.Version;

public class sobre extends Command {
    public sobre(){
        this.name = "sobre";
        this.aliases = new String[]{"info","bot","about"};
        this.cooldown = 5;
        this.guildOnly = false;
    }

    @Override
    public void execute(CommandEvent event){
        EmbedBuilder BD = new EmbedBuilder();

        if(event.getAuthor().isBot()){
            return;
        }
        BD.setAuthor("OI! tudo bem?");
        BD.setTitle("Eu sou o GordoBot","https://discord.gg/ZeUPCFU");
        BD.setDescription("Bot desenvolvido por Gordo#0865");
        BD.addField("Sobre","Eu fui desenvolvido para o meu criador praticar a linguagem de programação em JAVA\n",false);
        BD.addField("API","Eu sou programado com uma api chamada JDA(Java Discord API)\n",false);
        BD.addField("Criador","O meu criador é um completo retardado que não entende quase nada de Java, estou surpreso pelo fato dele não ter pego fogo até hoje. \n",false);
        BD.addField("Versão", "2.2.0",false);
        BD.setThumbnail(event.getSelfUser().getAvatarUrl());
        BD.setTimestamp(event.getMessage().getCreationTime());
        BD.setFooter("Comando executado por: "+event.getAuthor().getName(),event.getAuthor().getAvatarUrl());
        BD.setColor(9046091);
        event.reply(BD.build());





    }
}
