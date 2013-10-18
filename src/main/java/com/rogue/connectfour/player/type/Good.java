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
package com.rogue.connectfour.player.type;

import com.rogue.connectfour.ConnectFour;
import com.rogue.connectfour.board.Board;
import com.rogue.connectfour.board.Direction;
import com.rogue.connectfour.board.Node;
import com.rogue.connectfour.board.Piece;
import com.rogue.connectfour.player.Player;
import java.util.List;

/**
 * Good AI for {@link ConnectFour}.
 *
 * @since 1.0.0
 * @author Spencer Alderman
 * @version 1.0.0
 */
public class Good implements Player {
    
    private final ConnectFour project;
    private final Piece ident;
    
    /**
     * Constructor for {@link Good}. Sets the {@link ConnectFour} instance and 
     * the {@link Piece} to use
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param project
     * @param ident The {@link Piece} for this {@link Player} to use.
     */
    public Good(ConnectFour project, Piece ident) {
        this.project = project;
        this.ident = ident;
    }

    /**
     * Checks through available moves, then calculates which move would be best
     * based on the priority of:
     * 
     * Win game -> Stop Opponent from winning -> Block Opponent -> Progress Self
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The next move to play
     */
    @Override
    public int nextMove() {
        Board board = this.project.getBoard();
        // Get open nodes for both sides
        List<Node<Piece>> opponentMoves = board.getOpenNodes(ident.inverse());
        List<Node<Piece>> myMoves = board.getOpenNodes(ident);
        // Eval for winning move
        int moves = evalMove(myMoves, 3);
        if (moves != -1) {
            return moves;
        }
        // Check for opponent winning moves, or strategic moves
        for (int opponent = -1, i = 3; i > 1; i--) {
            if (opponent != -1) {
                return opponent;
            } else {
                opponent = evalMove(opponentMoves, i);
            }
        }
        // Check for own beneficial moves
        for (int i = 2; i > 0; i--) {
            if (moves != -1) {
                return moves;
            } else {
                moves = evalMove(myMoves, i);
            }
        }
        // Finally if there's just no good move, go wherever.
        java.util.Random rand = new java.util.Random();
        return rand.nextInt(board.maxWidth);
    }
    
    /**
     * Evaluates if there is any way to block or add to a move when given a set
     * of available moves that form a chain as long as the provided length.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param nodes The nodes to check
     * @param length The length to test against
     * 
     * @deprecated Awful, very intensive
     * 
     * @return The column to move in, -1 if there are no good moves
     */
    private int evalMove(List<Node<Piece>> nodes, int length) {
        for (Node<Piece> node : nodes) {
            for (Direction d : Direction.values()) {
                if (node.search(d) == length) {
                    Node<Piece> temp = node.getNeighbor(d.inverse());
                    if (temp != null && temp.getData().equals(Piece.NULL)) {
                        //Checking the front of the length
                        //Check to make sure it's not empty beneath
                        temp = temp.getNeighbor(Direction.BOTTOM);
                        if (temp != null && !temp.getData().equals(Piece.NULL)) {
                            return temp.getColumn();
                        }
                    } else {
                        //Checking the opposite side of the length
                        temp = node;
                        for (int i = length - 1; i > 0; i--) {
                            temp = temp.getNeighbor(d);
                        }
                        //Check if block/add is possible
                        if (temp.getNeighbor(d) != null && temp.getNeighbor(d).getData().equals(Piece.NULL)) {
                            temp = temp.getNeighbor(d);
                            //Check to make sure it's not empty beneath
                            if (temp.getNeighbor(Direction.BOTTOM) != null) {
                                temp = temp.getNeighbor(Direction.BOTTOM);
                                if (!temp.getData().equals(Piece.NULL)) {
                                    return temp.getColumn();
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    /**
     * Returns "good", or the {@link Player} type.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link Player} type
     */
    @Override
    public String getType() {
        return "good";
    }
    
    /**
     * Returns the {@link Piece} in use by this {@link Player}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link Piece} in use
     */
    @Override
    public Piece getIdent() {
        return this.ident;
    }

}