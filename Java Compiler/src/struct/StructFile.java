package struct;

import exception.CompileTimeError;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the file structure of an input program, containing all of the classes within.
 */
public class StructFile {

    /**
     * HashMap of String identifiers to StructClass classes
     */
    private HashMap<String, StructClass> other;

    /**
     * String identifier of the main public class of the file.
     */
    private String mainClassName;

    /**
     * Constructor taking an identifier of the main public class of the file.
     * @param mainClassName String main class identifier.
     */
    public StructFile(String mainClassName) {
        this.mainClassName = mainClassName;
        this.other = new HashMap<>();
    }

    /**
     * Method to add a class structure to the file.
     * @param newClass StructClass class to add to the file structure.
     */
    public void addClass(StructClass newClass) {
        String id = newClass.getIdentifier();
        if (other.containsKey(id)) throw new CompileTimeError("duplicate class: " + id);
        other.put(id, newClass);
    }

    /**
     * Method to get a class structure from its class identifier.
     * @param identifier String class identifier.
     * @return StructClass class referred to.
     */
    public StructClass getClass(String identifier) {
        return other.get(identifier);
    }

    /**
     * Method to get the main public class identifier for this file.
     * @return String main class identifier.
     */
    public String getMainClassName() {
        return mainClassName;
    }

    /**
     * Method to get an ArrayList of all of the classes of the program.
     * @return ArrayList of StructClass class structures.
     */
    public ArrayList<StructClass> getClassList() {
        ArrayList<StructClass> classList = new ArrayList<>();
        for (String s: other.keySet()) classList.add(other.get(s));
        return classList;
    }

}
