package struct;

import exception.CompileTimeError;

/**
 * Represents the modifiers which can be used by classes/fields/methods.
 */
public enum Modifier {

    /**
     * Public class/field/method modifier.
     */
    PUBLIC((short) 1),

    /**
     * Static field/method modifier.
     */
    STATIC((short) 8),

    /**
     * Super class modifier.
     */
    SUPER((short) 32),

    /**
     * Final field/method modifier.
     */
    FINAL((short) 16);

    /**
     * Short decimal value of the modifier.
     */
    private short decimalValue;

    /**
     * Constructor taking a short decimal modifier value.
     * @param decimalValue Short modifier value.
     */
    Modifier(short decimalValue){
        this.decimalValue = decimalValue;
    }

    /**
     * Method to select a class modifier based on some input text.
     * @param text String text to derive a modifier from.
     * @return Modifier selected by method.
     */
    public static Modifier selectClassModifier(String text) {
        switch (text) {
            case "public" : return Modifier.PUBLIC;
            default: throw new CompileTimeError("modifier " + text + " not allowed here");
        }
    }

    /**
     * Method to select a method modifier based on some input text.
     * @param text String text to derive a modifier from.
     * @return Modifier selected by method.
     */
    public static Modifier selectMemberModifier(String text) {
        switch (text) {
            case "public" : return Modifier.PUBLIC;
            case "static" : return Modifier.STATIC;
            default: throw new CompileTimeError("modifier " + text + " not allowed here");
        }
    }

    /**
     * Method to get the decimal value of a modifier.
     * @return Short modifier value.
     */
    public short getDecimalValue(){
        return this.decimalValue;
    }

}