public class MainStore {

    public static void main(String[] args){
    	
    	//Criação e preenchimento da Blackboard
    	BlackboardStore store = new BlackboardStore();
    	
    	//criar uma tela
    	//botão cliente
        Thread client = new Thread(new ClientRunnable(store), "client1");
        Thread adm = new Thread(new AdmRunnable(store), "amd1");
        System.out.println("Starting Runnable threads");
        adm.start();
        client.start();
        System.out.println("MyThreads has been started");
        
    }
}
