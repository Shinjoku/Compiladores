import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClientRunnable implements Runnable {
	
	BlackboardStore store;
	public ClientRunnable(BlackboardStore blackboard) {
		this.store = blackboard;
	}

    @Override
    public void run() {
    	
    	try {
			while(store.getList().isEmpty()) {
				Thread.sleep(10000);
			}
			JFrame frame = new JFrame("Dados Adm");
	        String id = JOptionPane.showInputDialog(frame, "id do Client");
	        String quant = JOptionPane.showInputDialog(frame, "Quantidade cliente");
	        
	        int location = store.IndexList(Integer.valueOf(id));
	        System.out.println(store.existInList(Integer.valueOf(id)));
	        System.out.println(store.list.get(location).getName());
	        

	        /*if( ) {
	        	Item item = store.consultList(Integer.valueOf(id));
	        	if(item.getQuant() <= 0) {
	        		System.out.println("Estoque indisponivel");
	        	}
	        	else {
	        		int salePrice = (int) (item.getValor() * Integer.valueOf(quant));
	        		System.out.println("Valor da compra:" + salePrice);
	        	}
	        }
	        else {
	        	System.out.println("Produto Inexistente");
	        }*/
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }

}
