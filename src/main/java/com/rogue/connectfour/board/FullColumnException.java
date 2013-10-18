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
package com.rogue.connectfour.board;

/**
 * Exception thrown when a {@link Piece} is attempted to be inserted into a full column
 *
 * @since 1.0.0
 * @author Spencer Alderman
 * @version 1.0.0
 */
public class FullColumnException extends Exception {
    
    /**
     * Passes the {@link Exception} up to a general exception
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    public FullColumnException() {
        super();
    }
}
