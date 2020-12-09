package resource;

import struct.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Represents the current environment classes and methods use for storing classes/fields/local variables with scope.
 */
public class Environment {

    /**
     * Environment instance used by the classes and methods of the input program.
     */
    public static Environment INSTANCE = new Environment();

    /**
     * HashMap mapping String identifiers to StructClass class objects.
     */
    private HashMap<String, StructClass> visibleClassMap = new HashMap<>();

    /**
     * HashMap mapping String identifiers to StructLocal class objects.
     */
    private HashMap<String, StructLocal> visibleLocalMap = new HashMap<>();

    /**
     * HashMap mapping String identifiers to StructField class objects.
     */
    private HashMap<String, StructField> visibleFieldMap = new HashMap<>();

    /**
     * Constructor for Environment objects.
     */
    public Environment() {
        addDefaultClassListing();
    }

    /**
     * Method to add a visible class to the visible class map.
     * @param newClass StructClass class to add to the map.
     */
    public void addVisibleClass(StructClass newClass) {
        visibleClassMap.put(newClass.getIdentifier(), newClass);
    }

    /**
     * Method to get a class from the visible class map by a String identifier.
     * @param identifier String class identifier.
     * @return StructClass object referred to.
     */
    public StructClass getVisibleClass(String identifier) {
        return visibleClassMap.get(identifier);
    }

    /**
     * Method to add a local variable to the visible local map.
     * @param newLocal StructLocal local to add to the map.
     */
    public void addLocal(StructLocal newLocal) {
        visibleLocalMap.put(newLocal.getIdentifier(), newLocal);
    }

    /**
     * Method to get a local from the visible local map by a String identifier.
     * @param identifier String local variable identifier.
     * @return StructLocal object referred to.
     */
    public StructLocal getVisibleLocal(String identifier) {
        return visibleLocalMap.get(identifier);
    }

    /**
     * Method to clear the local variable map.
     */
    public void clearLocals() {
        visibleLocalMap = new HashMap<>();
    }

    /**
     * Method to add a field to the visible local map.
     * @param field StructField to add to the map.
     */
    public void addField(StructField field) {
        visibleFieldMap.put(field.getIdentifier(), field);
    }

    /**
     * Method to get a field from the visible field map by a String identifier.
     * @param identifier String field variable identifier.
     * @return StructField object referred to.
     */
    public StructField getVisibleField(String identifier) {
        return visibleFieldMap.get(identifier);
    }

    /**
     * Method to clear the visible field map.
     */
    public void clearFields() {
        visibleFieldMap = new HashMap<>();
    }

    /**
     * Method to add the default supported classes to the environment;
     * Object, System, PrintStream, String.
     */
    public void addDefaultClassListing() {
        // Default classes and constructors
        StructClass object = new StructClass("Object", "java.lang.Object",
                null, new ArrayList<>(Arrays.asList(Modifier.PUBLIC)));
        addVisibleClass(object);
        StructMethod objConstructor = new StructMethod("<init>",
                new ArrayList<>(Arrays.asList(Modifier.PUBLIC)), null);
        objConstructor.setParameters(new ArrayList<StructType>());
        object.addMethod(objConstructor);

        StructClass system = new StructClass("System", "java.lang.System",
                null, new ArrayList<>(Arrays.asList(Modifier.PUBLIC, Modifier.FINAL)));
        addVisibleClass(system);

        StructClass printStream = new StructClass("PrintStream", "java.io.PrintStream",
                null, new ArrayList<>(Arrays.asList(Modifier.PUBLIC)));
        addVisibleClass(printStream);

        StructClass string = new StructClass("String", "java.lang.String",
                null, new ArrayList<>(Arrays.asList(Modifier.PUBLIC, Modifier.FINAL)));
        addVisibleClass(string);

        // Default methods
        StructMethod printlnString = new StructMethod("println",
                new ArrayList<>(Arrays.asList(Modifier.PUBLIC)), null);
        printlnString.setParameters(new ArrayList<StructType>(Arrays.asList(string)));
        printStream.addMethod(printlnString);

        StructMethod printlnInt = new StructMethod("println",
                new ArrayList<>(Arrays.asList(Modifier.PUBLIC)), null);
        printlnInt.setParameters(new ArrayList<>(Arrays.asList(StructType.getTypeFromIdentifier("int"))));
        printStream.addMethod(printlnInt);

        StructMethod printlnBool = new StructMethod("println",
                new ArrayList<>(Arrays.asList(Modifier.PUBLIC)), null);
        printlnBool.setParameters(new ArrayList<>(Arrays.asList(StructType.getTypeFromIdentifier("boolean"))));
        printStream.addMethod(printlnBool);

        StructMethod stringConcat = new StructMethod("concat",
                new ArrayList<>(Arrays.asList(Modifier.PUBLIC)), string);
        stringConcat.setParameters(new ArrayList<StructType>(Arrays.asList(string)));
        string.addMethod(stringConcat);

        // Default fields
        StructField out = new StructField("out",
                new ArrayList<>(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), printStream);
        system.addField(out);

    }

    /**
     * Method to copy the current environment to a new environment instance.
     * @return Environment copy.
     */
    public Environment clone() {
        Environment cloneEnvironment = new Environment();
        for (String s: visibleClassMap.keySet()) cloneEnvironment.addVisibleClass(visibleClassMap.get(s));
        for (String s: visibleLocalMap.keySet()) cloneEnvironment.addLocal(visibleLocalMap.get(s));
        for (String s: visibleFieldMap.keySet()) cloneEnvironment.addField(visibleFieldMap.get(s));
        return cloneEnvironment;
    }

}
