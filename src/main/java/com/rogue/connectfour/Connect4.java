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
public class Connect4 {
    
    private static ConnectFour instance;
    private static int DEFAULT_ROWS, DEFAULT_COLUMNS = 4;
    
    /**
     * Initial method for program start.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param args Command line arguments. Accepts two or four arguments:
     *             X_Player_Type O_Player_Type Number_Rows Number_Columns
     *             Player types are: Random, Bad, Good, and Human.
     */
    public static void main (String[] args) {
        switch (args.length) {
            case 4:
                if (validateArgument(args[0]) && validateArgument(args[1])) {
                    instance = new ConnectFour(args[0],
                                               args[1],
                                               Integer.parseInt(args[2]),
                                               Integer.parseInt(args[3]));
                } else {
                    System.err.println("Invalid player type supplied");
                    System.exit(1);
                }
                break;
            case 2:
                if (validateArgument(args[0]) && validateArgument(args[1])) {
                    instance = new ConnectFour(args[0],
                                               args[1],
                                               DEFAULT_ROWS,
                                               DEFAULT_COLUMNS);
                } else {
                    System.err.println("Invalid player type supplied");
                    System.exit(1);
                }
                break;
            default:
                System.err.println("Error: Invalid command line arguemnts.");
                System.exit(1);
                break;
        }
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
    
    /**
     * Validates if an argument is a valid option.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param argument The argument to check
     * @return True if valid argument, false otherwise.
     */
    private static boolean validateArgument(String argument) {
        argument = argument.toLowerCase();
        return ("random".equals(argument)
                || "bad".equals(argument)
                || "good".equals(argument)
                || "human".equals(argument));
    }

}
