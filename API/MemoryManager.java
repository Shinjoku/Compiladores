import java.util.List;


class MemoryManager {
	
	// Variáveis
	private List<int> dataStack;
	private List<int> varStack;
	private stackPointer;
	
	public MemoryManager() {
		this.dataStack = new ArrayList<int>();
		this.varStack = new ArrayList<int>();
		this.stackPointer = -1;
	}
	
	
	// Getters
	private int getSP(){
		return this.stackPointer;
	}
	
	private int getDataStack(){
		return this.dataStack;
	}
	
	private int getVarStack(){
		return this.varStack;
	}
	
	
	// Setters
	private void setSP(int value){
		this.stackPointer = value;
	}
	
	private void setDataStackValue(int pos, int value){
		this.dataStack[pos] = value;
	}
	
	private void setVarStackValue(int pos, int value){
		this.varStack[pos] = value;
	}
	
	
	// Métodos
	private void addData(){
		
	}
	
	private void addVar() {
		
	}
	
	private void incSP(){
		this.setSP(this.getSP() + 1);
	}
	
	private void decSP(){
		this.setSP(this.getSP() - 1);
	}
	
	
	// Instruções
	
	public void add(){
		incSP();
		
	}
}