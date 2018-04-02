package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class vamerda extends Command{
    public vamerda(){
        this.name ="vamerda";
        this.aliases = new String[]{"vaamerda","merda","váamerda!","váamerda","vámerda"};
        this.cooldown = 5;
    }

    @Override
    public void execute(CommandEvent event){

        if(event.getMessage().getMentionedMembers().isEmpty()){
           event.reply(event.getAuthor().getAsMention()+" você precisa mencionar alguem, colocar sem mencionar não vai executar o comando\n"+"exemplo: gordo vamerda "+event.getAuthor().getAsMention());
            return;
        }

        event.reply(event.getMessage().getMentionedMembers().get(0).getAsMention()+"\n VÁ A MERDA, bom dia.");

    }
}
