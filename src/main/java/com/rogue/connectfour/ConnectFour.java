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
    //Global extension variables
    
    /**
     * Game constructor. Initializes variables to be used from a global
     * perspective.
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    public ConnectFour() {
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
