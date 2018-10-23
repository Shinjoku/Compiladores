import java.awt.List;
import java.util.ArrayList;

public class BlackboardStore {
	private static int size = 8;
	
	public ArrayList<Item> list = new ArrayList<Item>();
	
	
	public ArrayList<Item> getList(){
		return this.list;
	}
	
	public void setList(ArrayList<Item> list) {
		this.list = list;
	}
	
	public void printList() {
		for(int count = 0; count< list.size(); count++) {
			System.out.println(list.get(count).getId() + ":" + list.get(count).getName() + ":" + list.get(count).getValor() + ":" + list.get(count).getQuant());
		}
	}
	
	public boolean existInList(int id) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public int IndexList(int id) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;//not exist
	}
	
	public void removeList(int id) {
		list.remove(id);
	}
	
	public void addList(Item item) {
		list.add(item);
	}
}
