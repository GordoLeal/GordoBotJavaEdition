package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
/*
    Comando que demonstra todos os comandos disponiveis (EM DESENVOLVIMENTO)
*/
public class help extends Command {
    public help(){
        this.name = "help";
        this.aliases = new String[]{"socorro","comandos","commands","ajuda"};
        this.arguments = "[help]";
        this.cooldown = 4;
        this.guildOnly = false;
    }

    @Override
    public void execute(CommandEvent event){
        EmbedBuilder EB = new EmbedBuilder();
        String helparg = event.getArgs();

        EB.setTitle("Lista de comandos:");
        EB.setColor(65535);
        EB.setAuthor("Precisa de ajuda com alguma coisa?");
        EB.setThumbnail(event.getSelfUser().getAvatarUrl());
        EB.setFooter("Commando executado por: "+event.getAuthor().getName(),event.getAuthor().getEffectiveAvatarUrl());
        EB.setTimestamp(event.getMessage().getCreationTime());
        if(event.getArgs().isEmpty()){
            event.reply(event.getAuthor().getAsMention() + " mandei os comandos na mensagem direta.\nCaso não tenha recebido, vai em configurações de privacidade e permitir receber mensagens diretas :eyes:");
            EB.setDescription("DIGITE GORDO HELP [COMANDO] PARA MAIS INFORMAÇÕES");
            EB.addField("comandos: ","``expulse``\n``banir``\n``oi``\n``fale``\n``sobre``\n``banco``\n``caçaniquel``\n``pizzagratis``\n``apostar``\n``ping``",false);
            event.replyInDm(EB.build());
            return;
        }

        switch (helparg){
            case "oi":
                EB.setTitle("commando: oi");
                EB.setDescription("O bot responde!");
                event.replyInDm(EB.build());
                break;
            case "expulse":
                EB.setTitle("commando: expulsar (expulse/ kick / chutar)");
                EB.setDescription("O bot expulsa o usuario mencionado do servidor");
                EB.addField("exemplo","gordo expulse @gordo#0865",false);
                event.replyInDm(EB.build());
                break;
            case "banir":
                EB.setTitle("commando: banir (bane / banir / ban)");
                EB.setDescription("O usuario mencionado é banido do servidor");
                EB.addField("exemplo","gordo banir @gordo#0865",false);
                event.replyInDm(EB.build());
                break;
            case "fale":
                EB.setTitle("commando: Falar (say / fale / diga)");
                EB.setDescription("O bot fala o que estiver escrito após o comando");
                EB.addField("exemplo","gordo fale alguma coisa.",false);
                event.replyInDm(EB.build());
                break;
            case "sobre":
                EB.setTitle("commando: sobre (info / bot / about)");
                EB.setDescription("O bot realiza o banimento no usuario mencionado do servidor");
                EB.addField("exemplo","gordo info",false);
                event.replyInDm(EB.build());
                break;
            case "banco":
                EB.setTitle("commando: banco (bank / cofrinho / cofre / dindin)");
                EB.setDescription("Cria sua conta no banco e/ou informa quanto você ou a pessoa que você mencionou tem no banco");
                EB.addField("exemplo","``gordo banco`` ou ``gordo banco @gordo#0865``",false);
                event.replyInDm(EB.build());
                break;
            case "caçaniquel":
                EB.setTitle("commando: caçaniquel (slot / slot-machine / caça-niquel)");
                EB.setDescription("Gasta 15 pizzas para poder jogar no caça-niquel");
                EB.addField("exemplo","gordo caçaniquel",false);
                event.replyInDm(EB.build());
                break;
            case "pizzagratis":
                EB.setTitle("commando: pizzagratis (pizzasgratis / pizza )");
                EB.setDescription("Gasta 15 pizzas para poder jogar no caça-niquel");
                EB.addField("exemplo","gordo pizzagratis",false);
                event.replyInDm(EB.build());
                break;
            case "aposta":
                EB.setTitle("commando: aposta (apostar / luck / sorte)");
                EB.setDescription("Gasta 15 pizzas para poder jogar no caça-niquel");
                EB.addField("exemplo","gordo apostar 100",false);
                event.replyInDm(EB.build());
                break;
            case "ping":
                EB.setTitle("commando: ping");
                EB.setDescription("pong!");
                EB.addField("exemplo","gordo ping",false);
                event.replyInDm(EB.build());
                break;

        }
    }
}
