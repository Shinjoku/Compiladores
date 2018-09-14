import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        
        // Cria um interpretador e uma máquina virtual
        Interpreter interpreter = new Interpreter();
        //MemoryManager memoryManager = new MemoryManager();
        // Coleta informações interpretadas
        List<Instruction> programCounter = interpreter.createCommands();
        for(Instruction inst : programCounter)
            System.out.println(inst);
        
        // Executa os comandos
        if( run(programCounter) )
            System.out.println("Máquina encerrada com sucesso.");
        else
            System.out.println("Máquina encerrada a força.");
    }
    
    public static boolean run(List<Instruction> programCounter) {
        
        int i;
        int pcSize = programCounter.size();
        boolean fin = false;
        Scanner in = new Scanner(System.in);
        MemoryManager memoryManager = new MemoryManager();
        
        for( i = 0; i < pcSize; i++) {
            System.out.println("Executando linha " + programCounter.get(i).getId() + ". Comando: " + programCounter.get(i).getName() + ". Valor SP: " + memoryManager.getSP());
            memoryManager.printState();
            try {
                switch( programCounter.get(i).getName() ) {
                    case "start":
                        memoryManager.start();
                        break;
                        
                    case "ldc":
                        memoryManager.ldc( programCounter.get(i).getParams() );
                        break;
                        
                    case "ldv": 
                        memoryManager.ldv( programCounter.get(i).getParams() );
                        break;
                        
                    case "str":
                        memoryManager.str( programCounter.get(i).getParams() );
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
                        
                    case "cme":
                        memoryManager.cme();
                        break;
                        
                    case "cma":
                        memoryManager.cma();
                        break;
                        
                    case "ceq":
                        memoryManager.ceq();
                        break;
                        
                    case "cdif":
                        memoryManager.cdif();
                        break;
                        
                    case "cmeq":
                        memoryManager.cmeq();
                        break;
                        
                    case "cmaq":
                        memoryManager.cmaq();
                        break;
                        
                    case "hlt":
                        fin = true;
                        break;
                        
                    case "jmp":
                        i = memoryManager.jmp(programCounter.get(i).getParams());
                        break;
                    
                    case "jmpf":
                        i = memoryManager.jmpf(programCounter.get(i).getParams(), i);
                        break;
                        
                    case "null":
                        break;
                    
                    case "rd":
                        memoryManager.rd(in.nextInt());
                        break;
                        
                    case "prn":
                        memoryManager.prn();
                        break;
                    
                    case "alloc":
                        memoryManager.alloc(programCounter.get(i).getParams());
                        break;
                        
                    case "dalloc":
                        memoryManager.dalloc(programCounter.get(i).getParams());
                        break;
                    
                    case "call":
                        i = memoryManager.call(programCounter.get(i).getParams(), i);
                        break;
                        
                    case "return":
                        i = memoryManager.retrn();
                        break;
                }
            } catch(Exception e) {
                System.out.println("Line " + programCounter.get(i).getId() + ": " + e);
            }
        }
        if(fin) return true;
        return false;
    }
}