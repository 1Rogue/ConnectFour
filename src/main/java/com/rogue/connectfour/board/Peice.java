/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rogue.connectfour.board;

/**
 *
 * @author Spencer Alderman
 */
public enum Peice {
    
    X("X"),
    O("O"),
    NULL(" ");
    private final String name;
    
    private Peice(String name) {
        this.name = name;
    }
    
    public Peice getPeice(String type) {
        for (Peice p : Peice.values()) {
            if (p.name().equals(type.toLowerCase())) {
                return p;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
