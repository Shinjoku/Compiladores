import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Interpreter {
    
    // Variáveis
    private String fileName = "in.txt";
    
    
    // Métodos
    
    // Extrai o comando contido em uma linha, criando um novo objeto Command;
    //  Parâmetros: Linha coletada do arquivo.
    //  Retorno: Objeto do tipo Command
    private Instruction extractCommand(String line){
        
        int i = 0;
        int lineLen = line.length();
        String name = "";
        String param = "";
        
        while(i < lineLen && line.charAt(i) == ' ')
            i++;
        
        // Acha nome do comando
        while(i < lineLen && line.charAt(i) != ' ' && line.charAt(i) != '\n'){
            name += line.charAt(i);
            i++;
        }
        
        // Se houver parâmetro
        if( i < (lineLen - 1) ){
            
            // Pula espaço em branco
            i++;
            
            // Acha o parâmetro;
            while(i < lineLen && line.charAt(i) != '\n') {
                param += line.charAt(i);
                i++;
            }
        }
        
        return new Instruction(name, param);
    }
    
    public List<String> getFileLines() {
        
        List<String> lines = new ArrayList<String>();
        
        try{
            // Abre o arquivo para leitura
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            
            // Coleta linhas
            while( (line = bufferedReader.readLine()) != null ) {
                if(line.charAt(0) != '#')
                    lines.add(line.toLowerCase());
            }
            
            // Fecha o arquivo
            bufferedReader.close();
            
            return lines;
            
        } catch(FileNotFoundException err) {
            System.out.println("Arquivo não encontrado.");
        } catch(IOException err) {
            System.out.println("Houve um erro ao ler o arquivo.");
        }
        
        return null;
    }
    
    // cria os comandos com base nas linhas coletadas.
    //  Parâmetros: Nula
    //  Retorno: 1 para sucesso, 0 para falha.
    public List<Instruction> createCommands() {
        
        List<Instruction> commands = new ArrayList<Instruction>();
        List<String> lines = getFileLines();
        
        for(String line : lines) {
            commands.add( extractCommand(line) );
        }
        
        return commands;
    }
}