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

import com.rogue.connectfour.ConnectFour;
import com.rogue.connectfour.board.Piece;
import com.rogue.connectfour.player.type.*;

/**
 * Player Manager for {@link ConnectFour}. Holds the player instances.
 *
 * @since 1.0.0
 * @author Spencer Alderman
 * @version 1.0.0
 */
public class PlayerManager {
    
    private final ConnectFour project;
    private boolean secondTurn = true;
    private final Player one;
    private final Player two;
    
    /**
     * PlayerManager Constructor. Creates two new players for the game.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param project The main project instance
     * @param oneType The type to use for player one
     * @param twoType The type to use for player two
     */
    public PlayerManager(ConnectFour project, String oneType, String twoType) {
        this.project = project;
        this.one = this.getPlayerFromType(oneType, Piece.X);
        this.two = this.getPlayerFromType(twoType, Piece.O);
    }
    
    /**
     * Gets a player based on the string type
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param type The type of player to get
     * @param piece The piece for the player to use
     * @return The new player object
     */
    private Player getPlayerFromType(String type, Piece piece) {
        if (type.equalsIgnoreCase("human")) {
            return new Human(this.project, piece);
        } else if (type.equalsIgnoreCase("random")) {
            return new Random(this.project, piece);
        } else if (type.equalsIgnoreCase("bad")) {
            return new Bad(this.project, piece);
        }
        return new Good(this.project, piece);
    }
    
    /**
     * Gets the player based on the current turn within the game. This method is
     * based internally on the number of times it has been called, so if it is
     * called other than by the main game method it will break the game. (It
     * will not finish)
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The player for the appropriate turn
     */
    public Player getPlayer() {
        this.secondTurn = !this.secondTurn;
        if (!this.secondTurn) {
            return this.one;
        } else {
            return this.two;
        }
    }

}
