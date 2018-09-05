import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
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
	public int getSP(){
		return this.stackPointer;
	}
	
	private List getDataStack(){
		return this.dataStack;
	}
	
	
	// Setters
	private void setSP(int value){
		this.stackPointer = value;
	}
	
	
	// Métodos

	// Tenta substituir valor. Se não houver posição, cria uma.
	private void addData(int index, int k) {
		try {
			this.dataStack.set(index, k);
		} catch(IndexOutOfBoundsException e) {
			this.dataStack.add(index, k);
		}
	}
	
	private void incSP(){
		this.setSP(this.getSP() + 1);
	}
	
	private void decSP(){
		this.setSP(this.getSP() - 1);
	}
	
	public void printState() {
		System.out.println("Pilha de dados: --------------------");
		for(int value : this.dataStack)
			System.out.print(value + " ");
		System.out.println("\n------------------------------------");
	}
	
	
	// Instruções
	
	// S:= s - 1
	public void start() {
		decSP();
	}
	
	// S = s + 1, M[s] = k
	public void ldc(List<Integer> k) {
		incSP();
		addData( getSP(), k.get(0) );
	}
	
	// S = s + 1, M[s] = M[n]
	public void ldv(List<Integer> n) {
		
		incSP();
		int value = this.dataStack.get( n.get(0) );
		addData( getSP() , value );
	}
	
	// M[s - 1] = M[s - 1] + M[s], S = s - 1
	public void add() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		addData( getSP() - 1, previousValue + actualValue );
		decSP();
	}
	
	// M[s - 1] = M[s - 1] - M[s], S = s - 1
	public void sub() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		addData( getSP() - 1, previousValue - actualValue );
		decSP();
	}
	
	// M[s - 1] = M[s - 1] * M[s], S = s - 1
	public void mult() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		addData( getSP() - 1, previousValue * actualValue );
		decSP();
	}
	
	// M[s - 1] = M[s - 1] / M[s], S = s - 1
	public void divi() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		addData( getSP() - 1, previousValue / actualValue );
		decSP();
	}
	
	// M[s] = -M[s]
	public void inv() {
		int actualValue = this.dataStack.get( getSP() );
		addData( getSP(), actualValue * (-1) );
	}
	
	// se M [s-1] = 1 e M[s] = 1  então M[s-1]:=1  senão M[s-1]:=0;  s:=s - 1 
	public void and() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue == 1 && actualValue == 1)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	// se M[s-1] = 1  ou M[s] = 1  então M[s-1] =1  senão M[s-1] =0; s =s - 1 
	public void or() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue == 1 || actualValue == 1)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	//  M[s]:=1 - M[s] 
	public void neg() {
		int actualValue = this.dataStack.get( getSP() );
		addData( getSP(), 1 - actualValue );
	}
	
	// se M[s-1] < M[s]  então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1 
	public void cme() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue < actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	// se M[s-1] > M[s]  então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1 
	public void cma() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue > actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	// se M[s-1] = M[s]  então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1 
	public void ceq() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue == actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	// se M[s-1] != M[s]  então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1 
	public void cdif() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue != actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}

	// se M[s-1] <= M[s]  então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1 
	public void cmeq() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue <= actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}
	
	// se M[s-1] >= M[s]  então M[s-1]:=1 senão M[s-1]:=0; s:=s - 1 
	public void cmaq() {
		int previousValue = this.dataStack.get( getSP() - 1 );
		int actualValue = this.dataStack.get( getSP() );
		
		if(previousValue >= actualValue)
			addData( getSP() - 1, 1 );
		else
			addData( getSP() - 1, 0 );
			
		decSP();
	}

	// M[n]:= M[s]; s:= s-1 
	public void str(List<Integer> n) {
		int actualValue = this.dataStack.get( getSP() );
		
		addData(n.get(0), actualValue);
		decSP();
	}
	
	// i = t
	public int jmp(List<Integer> t) {
		return t.get(0) - 1;	// Cancela o incremento implícito
	}
	
	// se M[s] = 0 então i:=t senão i:=i + 1; s:=s-1 
	public int jmpf(List<Integer> t, int i) {
		int actualValue = this.dataStack.get( getSP() );
		
		decSP();
		if (actualValue == 0)
			return t.get(0) - 1;
		else
			return i;	// Cancela o incremento implícito
	}

	// S:=s + 1; M[s]:= “próximo valor de entrada”. 	
	public void rd(int value) {
		incSP();
		addData(getSP(), value);
	}
	
	//  “Imprimir M[s]”; s:=s-1
	public void prn() {
		System.out.println( this.dataStack.get(getSP()) );
		decSP();
	}
	
	// Para k:=0 até n-1 faça {s:=s + 1; M[s]:=M[m+k]} 
	public void alloc(List<Integer> params) {
		int k;
		int m = params.get(0);
		int n = params.get(1);
		int value;

		for(k = 0; k <= (n - 1); k++) {
			incSP();
			// Caso seja a primeira locação de memória
			try {
				value = this.dataStack.get(m + k);
			} catch(IndexOutOfBoundsException e) {
				value = 0;
			}
			addData(getSP(), value);
		}
	}
	
	// Para k:=n-1 até 0 faça {M[m+k]:=M[s]; s:=s - 1} 
	public void dalloc(List<Integer> params) {
		int k;
		int actualValue;
		int m = params.get(0);
		int n = params.get(1);
		
		for (k = (n-1); k >= 0; k--) {
			actualValue = this.dataStack.get(getSP());
			addData(m+k, actualValue);
			decSP();
		}
	}
	
	// S:=s + 1; M[s]:= i+ 1; i:=t 
	public int call(List<Integer> t, int i) {
		incSP();
		addData(getSP(), i + 1);
		return t.get(0);
	}
	
	// i:=M[s]; s:=s - 1 
	public int retrn() {
		int actualValue = this.dataStack.get( getSP() );
		decSP();
		return actualValue;
	}
}