package struct;

import abstree.AbsMethod;
import abstree.AbsReturn;
import abstree.AbsStatement;

import java.util.ArrayList;

/**
 * Represents the structure of methods used within classes of the input program.
 */
public class StructMethod extends StructClassMember{

    /**
     * ArrayList of StructType method parameters.
     */
    private ArrayList<StructType> parameters;

    /**
     * AbsMethod root of the abstract syntax tree for this method.
     */
    private AbsMethod methodTree;

    /**
     * Boolean indicating whether this method has an outer return statement.
     */
    private boolean hasOuterReturn;

    /**
     * Integer count of locals contained within this method.
     */
    private int innerLocalCount;

    /**
     * Constructor taking a method identifier, list of modifiers and type.
     * @param identifier String method identifier.
     * @param modifiers ArrayList of method Modifiers.
     * @param type StructType method type.
     */
    public StructMethod(String identifier, ArrayList<Modifier> modifiers, StructType type) {
        super(identifier, modifiers, type);
        if (!modifiers.contains(Modifier.STATIC)) innerLocalCount++;
        parameters = new ArrayList<>();
        methodTree = new AbsMethod();
    }

    /**
     * Method to increment the count of locals held within this method.
     */
    public void incrementLocalCount() {
        this.innerLocalCount++;
    }

    /**
     * Method to set the parameters of this method.
     * @param parameters ArrayList of StructType types of parameters.
     */
    public void setParameters(ArrayList<StructType> parameters) {
        this.parameters = parameters;
    }

    /**
     * Method to get the parameters of a method.
     * @return ArrayList of StructType parameter types.
     */
    public ArrayList<StructType> getParameters() {
        return parameters;
    }

    /**
     * Method to add a statement to this method.
     * @param statement AbsStatement statement to add.
     */
    public void addStatement(AbsStatement statement) {
        methodTree.addStatement(statement);
        if (!hasOuterReturn && statement.getClass().equals(AbsReturn.class)) hasOuterReturn = true;
    }

    /**
     * Method to get the root of the abstract syntax tree contained within this method.
     * @return AbsMethod abstract syntax tree root.
     */
    public AbsMethod getMethodTree() {
        return methodTree;
    }

    /**
     * Method to get the count of locals contained within this method.
     * @return
     */
    public int getLocalCount() {
        return innerLocalCount + parameters.size();
    }

    /**
     * Method to get the maximum stack size needed by this method within the class file.
     * @return Integer maximum necessary stack size.
     */
    public int getMaxStackSize() {
        int max = 0;
        for (AbsStatement stmt: methodTree.getStatements()) {
            int maxInner = stmt.getMaxStackSize(max);
            if (maxInner > max) max = maxInner;
        }
        return max;
    }

    /**
     * Method to get the method signature descriptor of this method for use in the constant pool.
     * @return String method descriptor.
     */
    public String getSignature() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (StructType type: getParameters()) builder.append(type.getPathAsType());
        builder.append(")");
        if (getType() == null) builder.append("V");
        else builder.append(getType().getPathAsType());
        return builder.toString();
    }

    /**
     * Method to derive whether the current program method has an outer return statement.
     * @return Boolean indicating presence of outer return statement.
     */
    public boolean hasOuterReturn() {
        return hasOuterReturn;
    }

}
