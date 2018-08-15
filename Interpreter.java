import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Interpreter {
    
    // Variáveis
    private String fileName = "in.txt";
    private List<String> commands = new ArrayList<String>();
    
    
    // Métodos
    public String getNextCommand() {
        return this.commands.remove(0);
    }
    
    public List<String> getCommands() {
        try{
            // Abre o arquivo para leitura
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            
            // Coleta comandos
            while( (line = bufferedReader.readLine()) != null ) {
                if(line.charAt(0) != '#')
                    this.commands.add(line);
            }
            
            // Fechando o arquivo
            bufferedReader.close();
            
            return this.commands;
            
        } catch(FileNotFoundException err) {
            System.out.println("Arquivo não encontrado.");
        } catch(IOException err) {
            System.out.println("Houve um erro ao ler o arquivo.");
        }
        
        return null;
    }
}