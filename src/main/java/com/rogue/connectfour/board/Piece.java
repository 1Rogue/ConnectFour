/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rogue.connectfour.board;

/**
 *
 * @author Spencer Alderman
 */
public enum Piece {
    
    NULL(" "),
    X("X"),
    O("O");
    private final String name;
    
    private Piece(String name) {
        this.name = name;
    }
    
    public Piece getPiece(String type) {
        for (Piece p : Piece.values()) {
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
    
    public boolean equals(Piece type) {
        return this.name.equals(type.name);
    }
    
}
