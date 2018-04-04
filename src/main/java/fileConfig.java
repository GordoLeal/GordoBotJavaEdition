import jdk.net.SocketFlow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 Arquivos criados em metodos diferentes para que cada retorno seja validado e criação de arquivo testada
 */

public class fileConfig {
    public String fileConfig() throws IOException {
        String configpath = ("token.txt"); //AINDA EM DESENVOLVIMENTO, SÓ JOGAR A TOKEN KEY DENTRO DA PASTA E SALVAR

        try{
            Files.createFile(Paths.get(configpath));
        }catch (Exception e){
            System.out.print("token.txt já existe ou ocorreu um erro, pulando criação"+"\n");
        }

        String token = new String(Files.readAllBytes(Paths.get(configpath)));
        return token;

    }

    public String ownerId() throws IOException{
        String configpath = ("ownerId.txt");
        try{
            Files.createFile(Paths.get(configpath));
        }catch (Exception e){
            System.out.println("ownerid.txt já existe, pulando criação"+"\n");
        }

        String ownerid = new String(Files.readAllBytes(Paths.get(configpath)));
        return ownerid;
    }
}
