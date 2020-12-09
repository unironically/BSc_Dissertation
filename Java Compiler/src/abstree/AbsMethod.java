package abstree;

import java.util.ArrayList;

/**
 * Represents the root of the abstract syntax tree containing all other statements within a method.
 */
public class AbsMethod {

    /**
     * ArrayList of statements within this syntax tree.
     */
    private ArrayList<AbsStatement> statements = new ArrayList<>();

    /**
     * Integer value representing the current byte count of the method as byte code is generated.
     */
    public static int byteCount;

    /**
     * Constructor for AbsMethod objects.
     */
    public AbsMethod() {
        byteCount = 0;
    }

    /**
     * Method to add a statement object to this method tree.
     * @param statement AbsStatement statement to add.
     */
    public void addStatement(AbsStatement statement) {
        statement.setCurrentMethod(this);
        statements.add(statement);
    }

    /**
     * Method to get the list of statements held by this method.
     * @return ArrayList of statements of this method.
     */
    public ArrayList<AbsStatement> getStatements() {
        return statements;
    }

    /**
     * Method to get the current statement count of this method tree.
     * @return Integer number of statements in tree.
     */
    public int getStatementCount() {
        return statements.size();
    }

}
