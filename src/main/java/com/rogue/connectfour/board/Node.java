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
 * @since 
 * @author 1Rogue
 * @version 
 */
public class Node<E> {
    
    private final E data;
    private final Map<Direction, Node<E>> neighbors;
    
    public Node(E data) {
        this.data = data;
        this.neighbors = new ConcurrentHashMap();
        for (Direction d : Direction.values()) {
            this.neighbors.put(d, null);
        }
    }
    
    public Map<Direction, Node<E>> getNeighbors() {
        return this.neighbors;
    }
    
    public void setNeighbor(Direction direction, Node<E> neighbor) {
        this.neighbors.put(direction, neighbor);
    }
    
    public boolean hasNeighbor(Direction direction) {
        return this.neighbors.get(direction) != null;
    }
    
    public boolean hasNeighbor(Direction direction, Node<E> node) {
        return node.equals(this.neighbors.get(direction));
    }
    
    public boolean equals(Node<E> node) {
        return this.data == node.data;
    }
    
    public int search(Direction d) {
        Node<E> neigh = this.neighbors.get(d);
        if (neigh != null && neigh.equals(this)) {
            return neigh.search(d) + 1;
        }
        return 0;
    }

}