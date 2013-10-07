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

import com.rogue.connectfour.logger.GameLogger;

/**
 * Main class for game
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class ConnectFour {
    
    private final GameLogger logger;
    private final String xType;
    private final String oType;
    private final int rows;
    private final int columns;
    //Global extension variables
    
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
        this.xType = xType;
        this.oType = oType;
        this.rows = rows;
        this.columns = columns;
        this.logger = new GameLogger(this);
        //Init global extension variables
    }
    
    /**
     * Returns the logger utility for the game.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The game's logger utility
     */
    public GameLogger getLogger() {
        return this.logger;
    }
    
}
