package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;


/*
 COMANDO PARA TESTE DE ARGUMENTOS E ETC... NÃO POSSUI OBJETIVO, APENAS PARA TESTES

*/

public class teste extends Command {
    public teste(){
        this.name = "teste";
        this.arguments = "<teste1> , <teste2>";
        this.cooldown = 3;
        this.ownerCommand = true;
    }

    @Override
    public void execute(CommandEvent event){
        String guildid = event.getGuild().getId();
        String authorid = event.getAuthor().getId();
        String testePath = ("coinsystem"+"\\"+guildid+"\\"+authorid);
        String authorFile = (authorid+".txt");
        Path pathtxt = Paths.get(testePath + "\\" + authorFile);
        File file = new File(testePath);
        String str = "0";
        byte[] strToBytes = str.getBytes();
        try {
            file.mkdirs();
            Files.createFile(Paths.get(testePath + "\\" + authorFile));
            event.reply("Arquivo criado");
            Files.write(Paths.get(testePath + "\\" + authorFile), strToBytes);

        }catch (Exception ignoredException){
            event.reply("erro arquivo já criado");
        }

        try {
            String readfiletxt = Files.readAllLines(pathtxt).get(0);
            int teste1 = Integer.parseInt(readfiletxt);
            event.reply("entrada:"+teste1);
            teste1 = teste1 - 100;
            String teste2 = String.valueOf(teste1);
            event.reply("saida:"+teste2);
            Files.write(pathtxt, Collections.singleton(teste2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
