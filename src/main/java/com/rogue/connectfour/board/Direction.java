/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rogue.connectfour.board;

/**
 *
 * @author Rogue
 */
public enum Direction {
    
    TOPLEFT(1) {
        @Override public int[] getInstructions() { return new int[]{-1, -1}; }
    },
    TOP(2) {
        @Override public int[] getInstructions() { return new int[]{-1, 0}; }
    },
    TOPRIGHT(3) {
        @Override public int[] getInstructions() { return new int[]{-1, 1}; }
    },
    LEFT(4) {
        @Override public int[] getInstructions() { return new int[]{0, -1}; }
    },
    CENTER(5) {
        @Override public int[] getInstructions() { return new int[]{0, 0}; }
    },
    RIGHT(6) {
        @Override public int[] getInstructions() { return new int[]{0, 1}; }
    },
    BOTTOMLEFT(7) {
        @Override public int[] getInstructions() { return new int[]{1, -1}; }
    },
    BOTTOM(8) {
        @Override public int[] getInstructions() { return new int[]{1, 0}; }
    },
    BOTTOMRIGHT(9) {
        @Override public int[] getInstructions() { return new int[]{1, 1}; }
    };
    
    private final int dir;
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
    
    @Override
    public String toString() {
        return this.dir + "";
    }
    
    public int getValue() {
        return this.dir;
    }
    
}
