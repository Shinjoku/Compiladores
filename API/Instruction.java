import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Instruction {
    
    private int id;
    private String name;
    private String params;
    
    
    public Instruction(int id, String name, String params) {
        this.id = id;
        this.name = name;
        this.params = params;
    }
    
    
    // Métodos
    
    public int getId() {
        return this.id;
    }
    
    // Coleta nome da instrução
    public String getName() {
        return this.name;
    }
    
    // Formata e coleta os parâmetros da instrução
    public List<Integer> getParams() {
        
        if( this.params.length() == 0 ) return Collections.emptyList();
        
        String[] strParams = this.params.split(",");
        List<Integer> intParams = new ArrayList<Integer>();
        
        // Para instruções que tem mais de um parâmetro
        for(String param : strParams) {
            intParams.add(Integer.parseInt(param));
        }
        
        return intParams;
    }
    
    @Override
    public String toString() {
        return this.name + " " + getParams();
    }
    
    
}