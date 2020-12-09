package main;

import java.util.HashMap;

/**
 * Class to hold the initialised variables created by the user through the console input.
 */
public class SymbolTable {

    /**
     * HashMap of String keys and Double values representing variable identifiers and values.
     */
    private HashMap<String, Double> symbolTable;

    /**
     * Constructor for SymbolTable objects, initialising the symbol table HashMap.
     */
    public SymbolTable() {
        this.symbolTable = new HashMap<>();
    }

    /**
     * Method to add new variables to the symbol table.
     * @param name String name of the new variable.
     * @param result Double value of the new variable.
     */
    public void addIdentifier(String name, Double result) {
        symbolTable.put(name, result);
    }

    /**
     * Method to get the value corresponding to a variable name.
     * @param name String name of the variable whose value we get.
     * @return Double value of the variable.
     */
    public Double getIdentifierValue(String name) {
        return symbolTable.get(name);
    }

}
