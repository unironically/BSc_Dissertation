package struct;

import exception.CompileTimeError;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representing structure of classes used within the input program.
 */
public class StructClass extends StructType {

    /**
     * String name of the class.
     */
    private String identifier;

    /**
     * String path of the class.
     */
    private String path;

    /**
     * StructMethod superclass structure.
     */
    private StructClass superClass;

    /**
     * ArrayList of class modifiers.
     */
    private ArrayList<Modifier> modifiers;

    /**
     * HashMap of String identifiers to StructField class fields.
     */
    private HashMap<String, StructField> fields;

    /**
     * HashMap of String identifiers to StructMethod class methods.
     */
    private HashMap<String, ArrayList<StructMethod>> methods;

    /**
     * Constructor taking a class name, path, superclass structure and list of modifiers.
     * @param identifier String class name.
     * @param path String class path.
     * @param superClass StructMethod superclass.
     * @param modifiers ArrayList of class modifiers.
     */
    public StructClass(String identifier, String path, StructClass superClass, ArrayList<Modifier> modifiers) {
        this.identifier = identifier;
        this.path = path;
        this.superClass = superClass;
        this.modifiers = modifiers;
        this.fields = new HashMap<>();
        this.methods = new HashMap<>();
    }

    /**
     * Method to get the class name identifier.
     * @return
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Method to get this class' superclass structure.
     * @return StructClass superclass structure.
     */
    public StructClass getSuperClass() {
        return superClass;
    }

    /**
     * Method to get the path of this class.
     * @return String class path.
     */
    public String getPath() {
        return path.replace(".", "/");
    }

    /**
     * Method to add a field to this class.
     * @param field StructField field to add to the class.
     */
    public void addField(StructField field) {
        fields.put(field.getIdentifier(), field);
    }

    /**
     * Method to get a field belonging to the class by its identifier.
     * @param identifier String identifier to get a field by.
     * @return StructField field represented by identifier.
     */
    public StructField getField(String identifier) {
        return fields.get(identifier);
    }

    /**
     * Method to get the HashMap of class fields.
     * @return HashMap of String identifiers to StructField fields.
     */
    public HashMap<String, StructField> getFields() {
        return fields;
    }

    /**
     * Method to add a new method to the class.
     * @param newMethod StructMethod to add.
     */
    public void addMethod(StructMethod newMethod) {
        if (!methods.containsKey(newMethod.getIdentifier())) {
            ArrayList<StructMethod> newMethods = new ArrayList<>();
            newMethods.add(newMethod);
            methods.put(newMethod.getIdentifier(), newMethods);
            return;
        }
        ArrayList<StructMethod> methodList = methods.get(newMethod.getIdentifier());
        for (StructMethod meth: methodList) {
            if (meth.getParameters().equals(newMethod.getParameters()))
                throw new CompileTimeError("method " + newMethod.getIdentifier() + ":" + newMethod.getSignature() + " already exists");
        }
        methods.get(newMethod.getIdentifier()).add(newMethod);
    }

    /**
     * Method to get a method belonging to the class by its identifier and arguments.
     * @param identifier String method identifier.
     * @param passedParams ArrayList of StructType arguments.
     * @return StructMethod method matching the identifier and argument types.
     */
    public StructMethod getMethod(String identifier, ArrayList<StructType> passedParams) {
        ArrayList<StructMethod> matches = methods.get(identifier);
        if (matches == null) throw new CompileTimeError("method " + identifier + " with given parameters does not exist");
        outer:
        for (StructMethod m: matches) {
            ArrayList<StructType> methodParams = m.getParameters();
            if (methodParams.size() != passedParams.size()) continue;
            for (int i = 0; i < m.getParameters().size(); i++) {
                if (!((passedParams.get(i) == null && methodParams.get(i) instanceof StructClass)
                    || (passedParams.get(i) != null && passedParams.get(i).equals(methodParams.get(i)))))
                    continue outer;
            }
            return m;
        }
        throw new CompileTimeError("method " + identifier + " with given parameters does not exist");
    }

    /**
     * Method to get the HashMap of methods belonging to a class.
     * @return HashMap of String identifiers to StructMethod methods.
     */
    public HashMap<String, ArrayList<StructMethod>> getMethods() {
        return methods;
    }

    /**
     * Method to get the ArrayList of modifiers held by the class.
     * @return ArrayList of Modifiers.
     */
    public ArrayList<Modifier> getModifiers() {
        return modifiers;
    }

}
