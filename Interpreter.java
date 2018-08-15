class Interpreter {
    
    private List<String> nextCommands = new ArrayList<String>();
    
    
    // Methods
    public String getNextCommand() {
        return this.nextCommands.remove(0);
    }
    
    public void runInstruction(){
        switch( this.getNextCommand() ) {
            case "ADD":
                break;
        }
    }
}