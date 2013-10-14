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
import com.rogue.connectfour.player.type.*;

/**
 *
 * @since 
 * @author 1Rogue
 * @version 
 */
public class PlayerManager {
    
    private final ConnectFour project;
    private final Player one;
    private final Player two;
    
    public PlayerManager(ConnectFour project, String oneType, String twoType) {
        this.project = project;
        this.one = this.getPlayerFromType(oneType);
        this.two = this.getPlayerFromType(twoType);
    }
    
    private Player getPlayerFromType(String type) {
        if (type.equalsIgnoreCase("human")) {
            return new Human();
        } else if (type.equalsIgnoreCase("random")) {
            return new Random();
        } else if (type.equalsIgnoreCase("bad")) {
            return new Bad();
        }
        return new Good();
    }

}
