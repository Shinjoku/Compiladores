class MemoryManager {
	
	// Variáveis
	private int[] dataStack;
	private int[] varStack;
	private stackPointer;
	
	public MemoryManager() {
		this.stackPointer = 0;
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
	public void addData(){
		
	}
	
	public void addVar() {
		
	}
	
	public void incSP(){
		this.setSP(this.getSP() + 1);
	}
	
	public void decSP(){
		this.setSP(this.getSP() - 1);
	}
}