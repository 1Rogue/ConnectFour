/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rogue.connectfour.board;

/**
 * Piece enum used for the {@link Board}
 * 
 * @since 1.0.0
 * @author Spencer Alderman
 * @since 1.0.0
 */
public enum Piece {
    
    NULL(" "),
    X("X"),
    O("O");
    private final String name;
    
    /**
     * Constructor for {@link Piece}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param name The name in use
     */
    private Piece(String name) {
        this.name = name;
    }
    
    /**
     * Gets a {@link Piece} based on string value
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param type The {@link Piece} value to find
     * @return The new {@link Piece} value, or null if no value exists
     */
    public Piece getPiece(String type) {
        for (Piece p : Piece.values()) {
            if (p.name().equals(type.toLowerCase())) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Converts the enum to a string
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The string name of the enum in use
     */
    @Override
    public String toString() {
        return this.name;
    }
    
    /**
     * Compares two {@link Piece} enums
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param type The {@link Piece} to compare
     * @return True if equal, false otherwise
     */
    public boolean equals(Piece type) {
        return this.name.equals(type.name);
    }
    
}
