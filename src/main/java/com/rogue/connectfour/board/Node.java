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
 * {@link Node} class for storing game {@link Piece} objects
 *
 * @since 1.0.0
 * @author Spencer Alderman
 * @version 1.0.0
 */
public class Node<E> {

    private E data;
    private final int column;
    private final Map<Direction, Node<E>> neighbors;

    /**
     * Constructor for {@link Node}. Sets the data and initializes the neighbors map.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param data The data to set
     * @param column The column this {@link Node} resides in
     */
    public Node(E data, int column) {
        this.data = data;
        this.column = column;
        this.neighbors = new ConcurrentHashMap();
    }
    
    /**
     * Sets the neighbors of the {@link Piece} when given the provided board
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param board The {@link Board} instance
     * @param curRow The current row of the {@link Piece}
     * @param curCol The current column of the {@link Piece}
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
     * Returns the {@link ConcurrentHashMap} of the neighbors for this node
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
     * Gets a particular neighbor from a {@link Direction}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param d The {@link Direction} to look in
     * @return The neighbor in this location
     */
    public synchronized Node<E> getNeighbor(Direction d) {
        return this.neighbors.get(d);
    }

    /**
     * Sets a neighbor in a relevant {@link Direction}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param direction The {@link Direction} to set
     * @param neighbor The neighbor {@link Node} to set
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
     * @param direction The {@link Direction} to check
     * @return True if a {@link Piece} exists, false otherwise
     */
    public boolean hasNeighbor(Direction direction) {
        return this.neighbors.get(direction).getData() != Piece.NULL;
    }

    /**
     * Returns whether or not there is a similar piece in the relevant {@link Direction}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param direction The {@link Direction} to check
     * @param node The {@link Node} containing the data to check
     * @return True if the {@link Piece} exists and is the same, false otherwise
     */
    public boolean hasNeighbor(Direction direction, Node<E> node) {
        return node.equals(this.neighbors.get(direction));
    }

    /**
     * Returns true if the two {@link Node} classes are equal
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param node The {@link Node} to compare
     * @return True if equal, false otherwise
     */
    public boolean equals(Node<E> node) {
        return this.data == node.data;
    }

    /**
     * Searches in a {@link Direction}, and returns how many in a row there are
     * of a {@link Piece}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param d The {@link Direction} to search in
     * @return The number of matching {@link Piece} objects in a given {@link Direction}
     */
    public int search(Direction d) {
        Node<E> neigh = this.neighbors.get(d);
        if (neigh != null && this.hasNeighbor(d) && this.equals(neigh)) {
            return neigh.search(d) + 1;
        }
        return 1;
    }
    
    /**
     * Returns the column in which this {@link Node} resides
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The column this {@link Node} resides in
     */
    public int getColumn() {
        return this.column;
    }
}