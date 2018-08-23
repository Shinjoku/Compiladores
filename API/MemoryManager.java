import java.util.List;
import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

class MemoryManager {
	
	// Variáveis
	private List<Integer> dataStack;
	private int stackPointer;

	public MemoryManager() {
		this.dataStack = new ArrayList<Integer>();
		this.stackPointer = 0;
	}
	
	
	// Getters
	private int getSP(){
		return this.stackPointer;
	}
	
	private List getDataStack(){
		return this.dataStack;
	}
	
	
	// Setters
	private void setSP(int value){
		this.stackPointer = value;
	}
	
	// private void setDataStackValue(int pos, int value){
	// 	this.dataStack[pos] = value;
	// }
	
	// private void setVarStackValue(int pos, int value){
	// 	this.varStack[pos] = value;
	// }
	
	
	// Métodos

	private void addData(int index, int k) {
		try {
			this.dataStack.set(index, k);
			System.out.println(this.dataStack.get(index));
		} catch(IndexOutOfBoundsException e) {
			this.dataStack.add(index, k);
			System.out.println(this.dataStack.get(index));
		}
	}
	
	private void incSP(){
		this.setSP(this.getSP() + 1);
	}
	
	private void decSP(){
		this.setSP(this.getSP() - 1);
	}
	
	
	// Instruções
	
	public void start() {
		decSP();
	}
	
	public void ldc(List<Integer> k) {
		incSP();
		addData( this.stackPointer, k.get(0) );
	}
	
	public void ldv(List<Integer> n) {
		int actualValue = this.dataStack.get( getSP() );
		
		incSP();
		addData( this.stackPointer, actualValue );
	}
	
	public void add() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		addData( getSP() - 1, previousValue + actualValue );
		decSP();
	}
	
	public void sub() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		addData( getSP() - 1, previousValue - actualValue );
		decSP();
	}
	
	public void mult() {
		
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		
		addData( getSP() - 1, previousValue * actualValue );
		decSP();
	}
	
	public void divi() {
		
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		
		addData( getSP() - 1, previousValue / actualValue );
		decSP();
	}
	
	public void inv() {
		int actualValue = this.dataStack.get( getSP() );
		addData( getSP(), actualValue * (-1) );
	}
	
	public void and() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue == 1 && actualValue == 1)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	public void or() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue == 1 || actualValue == 1)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	public void neg() {
		int actualValue = this.dataStack.get( getSP() );
		addData( getSP(), 1 - actualValue );
	}
	
	public void cme() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue < actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	public void cma() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue > actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	public void ceq() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue == actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	public void cdif() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue != actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	public void cmeq() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue <= actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	public void cmaq() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue >= actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}

}