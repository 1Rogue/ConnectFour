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
    
    TOPLEFT(1),
    TOP(2),
    TOPRIGHT(3),
    LEFT(4),
    CENTER(5),
    RIGHT(6),
    BOTTOMLEFT(7),
    BOTTOM(8),
    BOTTOMRIGHT(9);
    private final int dir;
    private Direction(int dir) {
        this.dir = dir;
    }
    
    @Override
    public String toString() {
        return this.dir + "";
    }
    
}
