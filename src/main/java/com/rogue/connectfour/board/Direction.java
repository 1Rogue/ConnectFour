/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rogue.connectfour.board;

/**
 * {@link Direction} enum, used for spacial reasoning in a grid
 * 
 * @since 1.0.0
 * @author Spencer Alderman
 * @version 1.0.0
 */
public enum Direction {
    
    /**
     * The O in respect to X
     * <br>
     * <br>|O| | |
     * <br>| |X| |
     * <br>| | | |
     */
    TOPLEFT(1) {
        @Override public int[] getInstructions() { return new int[]{-1, -1}; }
    },
    /**
     * The O in respect to X
     * <br>
     * <br>| |O| |
     * <br>| |X| |
     * <br>| | | |
     */
    TOP(2) {
        @Override public int[] getInstructions() { return new int[]{-1, 0}; }
    },
    /**
     * The O in respect to X
     * <br>
     * <br>| | |O|
     * <br>| |X| |
     * <br>| | | |
     */
    TOPRIGHT(3) {
        @Override public int[] getInstructions() { return new int[]{-1, 1}; }
    },
    /**
     * The O in respect to X
     * <br>
     * <br>| | | |
     * <br>|O|X| |
     * <br>| | | |
     */
    LEFT(4) {
        @Override public int[] getInstructions() { return new int[]{0, -1}; }
    },
    /**
     * The O in respect to X
     * <br>
     * <br>| | | |
     * <br>| |X|O|
     * <br>| | | |
     */
    RIGHT(6) {
        @Override public int[] getInstructions() { return new int[]{0, 1}; }
    },
    /**
     * The O in respect to X
     * <br>
     * <br>| | | |
     * <br>| |X| |
     * <br>|O| | |
     */
    BOTTOMLEFT(7) {
        @Override public int[] getInstructions() { return new int[]{1, -1}; }
    },
    /**
     * The O in respect to X
     * <br>
     * <br>| | | |
     * <br>| |X| |
     * <br>| |O| |
     */
    BOTTOM(8) {
        @Override public int[] getInstructions() { return new int[]{1, 0}; }
    },
    /**
     * The O in respect to X
     * <br>
     * <br>| | | |
     * <br>| |X| |
     * <br>| | |O|
     */
    BOTTOMRIGHT(9) {
        @Override public int[] getInstructions() { return new int[]{1, 1}; }
    };
    
    private final int dir;
    /**
     * Constructs a new enum object based on int value of the enum {@link Direction}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param dir The int value of the enum type to returm
     */
    private Direction(int dir) {
        this.dir = dir;
    }
    
    /**
     * Returns an int array with instructions for moving through to grid to
     * arrive to the corresponding location.
     * 
     * [0] = Movement in first dimension - up/down
     * [1] = Movement in second dimension - left/right
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return An int array for traversing a grid
     */
    public abstract int[] getInstructions();
    
    /**
     * Returns the enum value in string form.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The string-form of the enum
     */
    @Override
    public String toString() {
        return this.dir + "";
    }
    
    /**
     * Returns the int value of the enum
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The enum's int value
     */
    public int getValue() {
        return this.dir;
    }
    
    /**
     * Checks if two {@link Direction} objects are equal
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param dir The {@link Direction} to check
     * @return True if equal, false otherwise
     */
    public boolean equals(Direction dir) {
        return this.dir == dir.dir;
    }
    
}
