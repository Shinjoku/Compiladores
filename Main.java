import java.util.List;

public class Main {
    public static void main (String[] args) {
        
        // Cria um interpretador e uma máquina virtual
        Interpreter interpreter = new Interpreter();
        //MemoryManager memoryManager = new MemoryManager();
        // Coleta informações interpretadas
        List<String> PC = interpreter.getCommands();
        for(String command : PC)
            System.out.println(command);
        
        // Executa os comandos
        run(PC);
    }
    
    public static void run(List<String> PC) {
        
        for(String command : PC){
            switch(command){
                case "ADD":
                    break;
            }
        }
        
    }
}