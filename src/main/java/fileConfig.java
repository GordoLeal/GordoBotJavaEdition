import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 Arquivos criados em metodos diferentes para que cada retorno seja validado e criação de arquivo testada
 */

public class fileConfig {
    public String generalConfig(){
        Path pathConfig = Paths.get("GeneralConfig");
        System.out.println("OLHA EU AQUI");
        File file = new File(String.valueOf(pathConfig));

        try{
            file.mkdir();
            Files.createFile(pathConfig);
            System.out.println("Arquivo Principal criado\n");
        }catch (Exception ignored){
            System.out.println("Arquivo principal já existe\n");
        }
        return null;
    }
    public String fileConfig() throws IOException {
        String configpath = ("GeneralConfig\\token.txt"); //AINDA EM DESENVOLVIMENTO, SÓ JOGAR A TOKEN KEY DENTRO DA PASTA E SALVAR

        try{
            Files.createFile(Paths.get(configpath));
        }catch (Exception e){
            System.out.print("token.txt já existe pulando criação\n");
        }

        String token = new String(Files.readAllBytes(Paths.get(configpath)));
        return token;

    }

    public String ownerId() throws IOException{
        String configpath = ("GeneralConfig\\ownerId.txt");
        try{
            Files.createFile(Paths.get(configpath));
        }catch (Exception e){
            System.out.println("ownerid.txt já existe, pulando criação\n");
        }

        String ownerid = new String(Files.readAllBytes(Paths.get(configpath)));
        return ownerid;
    }
}
