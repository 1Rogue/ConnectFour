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
    private Node<Peice>[][] grid;
    
    public Board(ConnectFour project, int rows, int columns) {
        this.project = project;
        this.grid = new Node[rows][columns];
        for (int i = 0; i < grid.length; i++) {
            for (int w = 0; w < grid[i].length; w++) {
                grid[i][w] = new Node<Peice>(Peice.NULL);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int w = 0; w < grid[i].length; w++) {
                grid[i][w].setNeighbors(this);
            }
        }
    }
    
    /**
     * Plays a peice on the board
     * 
     * @param type The type of peice to play
     * @param column The column to play in1
     */
    public void play(Peice type, int column) {
        
    }
    
    /**
     * Converts an array-based y to space-oriented y
     * @param rawY The y argument
     * @return The y relevant to the array
     */
    private int toY(int rawY) {
        return 0;
    }
    
    public Node<Peice>[][] getGrid() {
        return this.grid;
    }

}
