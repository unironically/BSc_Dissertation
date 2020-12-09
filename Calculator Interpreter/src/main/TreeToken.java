package main;

/**
 * Class to represent the tokens of TreeNode objects of reduced syntax trees.
 */
public class TreeToken {

    /**
     * Enum representing the possible token values.
     */
    public static enum TokenType {
        IDENTIFIER, NUMBER, DIV, MUL, ADD, SUB, EQUALS;
    }

    /**
     * Object representing the value held by a token, either a Double of String representing an operation.
     */
    private Object value;

    /**
     * TokenType enumeration value defining the type of a token.
     */
    private TokenType type;

    /**
     * Constructor for TreeToken objects, initialising their value and type.
     * @param value String value from which we derive a token's type and value.
     */
    public TreeToken(String value) {
        try {
            this.value = Double.valueOf(value);
            this.type = TokenType.NUMBER;
        } catch (NumberFormatException e) {
            this.value = value;
            this.type = determineType(value);
        }
    }

    /**
     * Method to derive the type of a token based on the String value passed when creating the new token.
     * @param value String value to derive token type from.
     * @return TokenType enumeration value of the token's type.
     */
    private TokenType determineType(String value) {
        switch (value) {
            case "/": return TokenType.DIV;
            case "*": return TokenType.MUL;
            case "+": return TokenType.ADD;
            case "-": return TokenType.SUB;
            case "=": return TokenType.EQUALS;
            default: return TokenType.IDENTIFIER;
        }
    }

    /**
     * Method to get the type of a TreeToken object.
     * @return TokenType enumeration value representing the TreeToken's type.
     */
    public TokenType getType() {
        return type;
    }

    /**
     * Method to get a String representation of the token.
     * @return String representation of the TreeToken's value.
     */
    public String toString() {
        return String.valueOf(value);
    }

}
