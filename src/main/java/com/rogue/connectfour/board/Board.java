/*
 * Copyright (C) 2013 Spencer Alderman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rogue.connectfour.board;

import com.rogue.connectfour.ConnectFour;

/**
 *
 * @since 
 * @author 1Rogue
 * @version 
 */
public class Board {
    
    private ConnectFour project;
    private Node<Piece>[][] grid;
    
    /**
     * Constructor for Board. Initializes the grid and then sets the neighbors
     * for the nodes
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param project The main project instance
     * @param rows The number of rows
     * @param columns The number of columns
     */
    public Board(ConnectFour project, int rows, int columns) {
        this.project = project;
        this.grid = new Node[rows][columns];
        for (int i = 0; i < grid.length; i++) {
            for (int w = 0; w < grid[i].length; w++) {
                grid[i][w] = new Node<Piece>(Piece.NULL);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int w = 0; w < grid[i].length; w++) {
                grid[i][w].setNeighbors(this, i, w);
            }
        }
    }
    
    /**
     * Plays a piece on the board
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param type The type of piece to play
     * @param column The column to play in1
     */
    public void play(Piece type, int column) {
        for (int i = grid.length - 1; i >= 0; i--) {
            if (!grid[i][column].getData().equals(Piece.NULL)) {
                continue;
            }
            grid[i][column].setData(type);
        }
    }
    
    /**
     * Returns the grid. Should be used in a synchronized block for safety.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The board grid
     */
    public synchronized Node<Piece>[][] getGrid() {
        return this.grid;
    }

}
