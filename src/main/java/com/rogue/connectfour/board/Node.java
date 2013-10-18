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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @since @author 1Rogue
 * @version
 */
public class Node<E> {

    private E data;
    private final Map<Direction, Node<E>> neighbors;

    /**
     * Constructor for Node. Sets the data and initializes the neighbors map.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param data The data to set
     */
    public Node(E data) {
        this.data = data;
        this.neighbors = new ConcurrentHashMap();
    }
    
    /**
     * Sets the neighbors of the piece when given the provided board
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param board The board instance
     * @param curRow The current row of the piece
     * @param curCol The current column of the piece
     */
    public void setNeighbors(Board board, int curRow, int curCol) {
        final Node<E>[][] grid;
        synchronized (grid = (Node<E>[][])board.getGrid()) {
            for (Direction d : Direction.values()) {
                try {
                    this.neighbors.put(d, grid[d.getInstructions()[0] + curRow][d.getInstructions()[1] + curCol]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    // Do nothing, it's out of bounds
                }
            }
        }
    }

    /**
     * Returns the data associated with this node
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The data for the node
     */
    public E getData() {
        return this.data;
    }
    
    /**
     * Sets the value of the current data
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param data The data to set
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Returns the map of the neighbors for this node
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link ConcurrentHashMap} of the neighbors
     */
    public Map<Direction, Node<E>> getNeighbors() {
        return this.neighbors;
    }
    
    /**
     * Gets a particular neighbor from a direction
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param d The direction to look in
     * @return The neighbor in this location
     */
    public synchronized Node<E> getNeighbor(Direction d) {
        return this.neighbors.get(d);
    }

    /**
     * Sets a neighbor in a relevant direction
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param direction The direction to set
     * @param neighbor The neighbor node to set
     */
    public void setNeighbor(Direction direction, Node<E> neighbor) {
        this.neighbors.put(direction, neighbor);
    }

    /**
     * Returns whether or not there is a piece in the relevant direction
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param direction The direction to check
     * @return True if a peice exists, false otherwise
     */
    public boolean hasNeighbor(Direction direction) {
        return this.neighbors.get(direction).getData() != Piece.NULL;
    }

    /**
     * Returns whether or not there is a similar piece in the relevant direction.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param direction The direction to check
     * @param node The node containing the data to check
     * @return True if peice exists and is the same, false otherwise
     */
    public boolean hasNeighbor(Direction direction, Node<E> node) {
        return node.data.equals(this.neighbors.get(direction).data);
    }

    /**
     * Returns true if the two nodes are equal
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param node
     * @return 
     */
    public boolean equals(Node<E> node) {
        return this.data == node.data;
    }

    /**
     * Searches in a direction, and returns how many in a row there are of a
     * piece.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param d The direction to search in
     * @return 
     */
    public int search(Direction d) {
        Node<E> neigh = this.neighbors.get(d);
        if (neigh != null && this.hasNeighbor(d) && this.equals(neigh)) {
            return neigh.search(d) + 1;
        }
        return 1;
    }
}