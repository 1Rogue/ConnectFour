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
package com.rogue.connectfour;

import com.rogue.connectfour.board.Board;
import com.rogue.connectfour.game.Game;
import com.rogue.connectfour.logger.GameLogger;
import com.rogue.connectfour.player.PlayerManager;

/**
 * Main class for game
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class ConnectFour {
    
    private final GameLogger logger;
    private final Board board;
    private final Game game;
    private final PlayerManager manager;
    
    /**
     * Game constructor. Initializes variables to be used from a global
     * perspective.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param xType Player type for X player
     * @param oType Player type for O player
     * @param rows Number of rows to play the game with
     * @param columns Number of columns to play the game with
     */
    public ConnectFour(String xType, String oType, int rows, int columns) {
        this.logger = new GameLogger(this);
        this.board = new Board(this, rows, columns);
        this.manager = new PlayerManager(this, xType, oType);
        this.game = new Game(this, rows * columns);
        System.out.println("Winner: " + this.game.start());
    }
    
    /**
     * Returns the logger utility for the game.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link GameLogger} module
     */
    public GameLogger getLogger() {
        return this.logger;
    }
    
    /**
     * Returns the board module for the project
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link Board} module
     */
    public Board getBoard() {
        return this.board;
    }
    
    /**
     * Gets the player manager for the project
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link PlayerManager} module
     */
    public PlayerManager getPlayerManager() {
        return this.manager;
    }
    
}
