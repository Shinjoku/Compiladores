import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Instruction {
    
    private String name;
    private String params;
    
    
    public Instruction(String name, String params) {
        this.name = name;
        this.params = params;
    }
    
    
    // Métodos
    
    // Coleta nome da instrução
    public String getName() {
        return name;
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