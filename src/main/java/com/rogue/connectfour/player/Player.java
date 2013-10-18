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
package com.rogue.connectfour.player;

import com.rogue.connectfour.board.Piece;

/**
 * Player interface for {@link ConnectFour}
 *
 * @since 1.0.0
 * @author Spencer Alderman
 * @version 1.0.0
 */
public interface Player {
    
    /**
     * Gets the next move relative to the {@link Player} at hand
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return int representing the column to play the piece in
     */
    public int nextMove();
    
    /**
     * Returns the type of the {@link Player} in string form
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The string form of the {@link Player}
     */
    public String getType();
    
    /**
     * Gets the {@link Piece} in use by the {@link Player}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link Piece} in use by the {@link Player}
     */
    public Piece getIdent();

}
