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
package com.rogue.connectfour.game;

import com.rogue.connectfour.ConnectFour;
import com.rogue.connectfour.board.Board;
import com.rogue.connectfour.board.Node;
import com.rogue.connectfour.board.Piece;
import com.rogue.connectfour.player.Player;
import com.rogue.connectfour.player.PlayerManager;

/**
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class Game {
    
    private final ConnectFour project;
    private char winner = ' ';
    private int turn = 0;
    
    public Game(ConnectFour project, int maxMoves) {
        this.project = project;
        this.turn = maxMoves;
    }
    
    /**
     * Starts a game
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The winner of the game
     */
    public char start() {
        while (this.turn != 0) {
            printBoard(this.project.getBoard());
            PlayerManager pm = this.project.getPlayerManager();
            Player current = pm.getPlayer();
            System.out.println(current.getType() + " player " + current.getIdent().toString() + " moving...");
            int i = current.nextMove();
            if (i == -1) {
                System.out.println(current.getIdent().toString() + " quits the game");
                System.exit(0);
            }
            if (this.project.getBoard().play(current.getIdent(), current.nextMove())) {
                this.printBoard(this.project.getBoard());
                return current.getIdent().toString().toCharArray()[0];
            }
            this.turn--;
        }
        return ' ';
    }
    
    /**
     * Prints the layout of the provided board
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param board The {@link Board} to print
     */
    private void printBoard(Board board) {
        System.out.println();
        final Node<Piece>[][] grid;
        synchronized (grid = board.getGrid()) {
            StringBuilder back = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder row = new StringBuilder("|");
                for (int w = 0; w < grid[i].length; w++) {
                    row.append(grid[i][w].getData().toString()).append("|");
                }
                back.append(row).append('\n');
            }
            StringBuilder bottom = new StringBuilder("+");
            for (int i = 0; i < grid[0].length; i++) {
                bottom.append("-+");
            }
            System.out.println(back.append(bottom.toString()).toString());
        }
        System.out.println();
    }
}
