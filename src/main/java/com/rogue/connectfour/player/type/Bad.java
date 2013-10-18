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
 *
 * @since 
 * @author 1Rogue
 * @version 
 */
public class Bad implements Player {
    
    private final ConnectFour project;
    private Piece ident = Piece.NULL;
    private int counter = 0;
    
    public Bad(ConnectFour project) {
        this.project = project;
    }

    @Override
    public int nextMove() {
        if (this.project.getBoard().getFullColumns().contains(this.counter)) {
            this.counter++;
        }
        return this.counter;
    }
    
    @Override
    public String getType() {
        return "bad";
    }
    
    @Override
    public void setIdent(Piece ident) {
        this.ident = ident;
    }
    
    @Override
    public Piece getIdent() {
        return this.ident;
    }

}
