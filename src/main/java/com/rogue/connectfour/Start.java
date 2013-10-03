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

/**
 * Initial Starting class for ConnectFour instance
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class Start {
    
    private static ConnectFour instance;
    
    /**
     * Initial method for program start.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param args Command line arguments (Ignored). 
     */
    public static void main (String[] args) {
        instance = new ConnectFour();
    }
    
    /**
     * Returns the instance of the main {@link ConnectFour} class.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The main game instance
     */
    public static ConnectFour getInstance() {
        return instance;
    }

}
