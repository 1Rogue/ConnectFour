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
import com.rogue.connectfour.board.Piece;
import com.rogue.connectfour.player.Player;

/**
 * Random AI for {@link ConnectFour}. Moves are selected randomly
 *
 * @since 1.0.0
 * @author Spencer Alderman
 * @version 1.0.0
 */
public class Random implements Player {
    
    private final ConnectFour project;
    private final Piece ident;
    
    /**
     * Constructor for {@link Random}. Sets the {@link ConnectFour} instance and 
     * the {@link Piece} to use
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param project The {@link ConnectFour} instance
     * @param ident The {@link Piece} for this {@link Player} to use.
     */
    public Random(ConnectFour project, Piece ident) {
        this.project = project;
        this.ident = ident;
    }

    /**
     * Selects a random column, and plays it.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The next move to play
     */
    @Override
    public int nextMove() {
        java.util.Random rand = new java.util.Random();
        return rand.nextInt(this.project.getBoard().maxWidth);
    }
    
    /**
     * Returns "random", or the {@link Player} type.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link Player} type
     */
    @Override
    public String getType() {
        return "random";
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
