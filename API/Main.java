import java.util.List;

public class Main {
    public static void main (String[] args) {
        
        // Cria um interpretador e uma máquina virtual
        Interpreter interpreter = new Interpreter();
        //MemoryManager memoryManager = new MemoryManager();
        // Coleta informações interpretadas
        List<Instruction> PC = interpreter.createCommands();
        for(Instruction inst : PC)
            System.out.println(inst);
        
        // Executa os comandos
        //run(PC);
    }
    
    public static void run(List<Instruction> PC) {
        
        for(Instruction command : PC){
            switch( command.getName() ){
                case "ADD":
                    break;
            }
        }
        
    }
}