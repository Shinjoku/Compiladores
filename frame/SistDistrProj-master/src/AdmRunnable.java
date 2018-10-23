import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdmRunnable implements Runnable {

	BlackboardStore store;
	private int count = 0;
	
	public AdmRunnable(BlackboardStore blackboard) {
		this.store = blackboard;
	}
    @Override
    public void run() {
    	int choice = 0;
    	int position;
    	
    	while(choice == 0) {
    		JFrame frame = new JFrame("Dados Adm");
            String id = JOptionPane.showInputDialog(frame, "id do Produto");
            String itemName = JOptionPane.showInputDialog(frame, "Nome do Produto");
            String quant = JOptionPane.showInputDialog(frame, "Quantidade do Produto");
            String price = JOptionPane.showInputDialog(frame, "Preço do Produto");
            String unitValor = JOptionPane.showInputDialog(frame, "Valor Unitario do Produto");
            
            Item item = new Item(Integer.valueOf(id), itemName, Integer.valueOf(quant), Float.valueOf(price), Float.valueOf(unitValor));
            count++;
            
            store.addList(item);
            
            choice = Integer.valueOf(JOptionPane.showConfirmDialog(frame, "Amazenar mais itens"));
    	}
        
        store.printList();
        System.out.println(store.list.get(1).getName());
        
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}
