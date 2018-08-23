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
        run(PC);
    }
    
    public static void run(List<Instruction> PC) {
        
        MemoryManager memoryManager = new MemoryManager();
        
        for(Instruction command : PC){
            try{
                switch( command.getName() ){
                    case "start":
                        memoryManager.start();
                        break;
                    case "ldc":
                        memoryManager.ldc( command.getParams() );
                        break;
                    case "ldv": 
                        memoryManager.ldv( command.getParams() );
                        break;
                    case "add":
                        memoryManager.add();
                        break;
                    case "sub":
                        memoryManager.sub();
                        break;
                    case "mult":
                        memoryManager.mult();
                        break;
                    case "divi":
                        memoryManager.divi();
                        break;
                    case "inv":
                        memoryManager.inv();
                        break;
                    case "and":
                        memoryManager.and();
                        break;
                    case "or":
                        memoryManager.or();
                        break;
                    case "neg":
                        memoryManager.neg();
                        break;
                }
            } catch(Exception e) {
                System.out.println("Line " + command.getId() + ": " + e);
            }
        }
        
    }
}