class Main {
    public static String minimal = "";
	public static boolean found = false;
    public static void main(String[] args) {
        // reference values
        // 0 is empty spot "_"
        // 1 is player "Y"
        // 2 is finish line "F"
        // 3 is barrier "*"
        // 4 is ladder up ↑ "U"
        // 5 is ladder down ↓ "D"
        int[][] map = createMap();
        System.out.println("Lab #9 (Maps and Maze Game)");
        System.out.println("\ncreateMap(int rows, int columns): \n" + mapToString(createMap(10, 10)));
        System.out.println("\ncreateMap(): \n" + mapToString(createMap()));
        System.out.println("\ncreateMap(int walls): \n" + mapToString(createMap(5)));
        System.out.println("\ngetSymbol(int value): \n" + getSymbol(0));
        System.out.println("\nprintMap(int[][] map): \n");
        printMap(map);
        System.out.println("\nmapToString(int[][] map): \n" + mapToString(map));
        int[][] findArray = {{0,0,3}, {3,3,2}, {1,3,0}};
        int[] findRV = find(findArray, 1);
        System.out.println("\nfind(int[][] map, int value): \n{" + findRV[0] + ", " + findRV[1] + "}");
        System.out.println("\ncanGoN(int[][] map): \n" + canGoN(map));
        System.out.println("\ncanGoS(int[][] map): \n" + canGoS(map));
        System.out.println("\ncanGoE(int[][] map): \n" + canGoE(map));
        System.out.println("\ncanGoW(int[][] map): \n" + canGoW(map));
        System.out.println("\nminimalPath(int[][] map): \n" + minimalPath(map));
        System.out.println("\ncreate3DMap(int rows, int columns, int floors): \n" + mapToString(create3DMap(5, 5, 5)));
        System.out.println("\ncreate3DMap(): \n" + create3DMap());
        System.out.println("\ncreate3DMap(int floors): \n" + create3DMap(5));
        System.out.println("\ncanGoU(int[][][] map): \n" + canGoU(create3DMap()));
        System.out.println("\ncanGoD(int[][][] map): \n" + canGoD(create3DMap()));
        System.out.println("\nmapToString(int[][][] map): \n" + mapToString(create3DMap(5, 5, 5)));
    }

    public static int[][] createMap(int rows, int columns) {
        return new int[rows][columns];
    }

    public static int[][] createMap() {
        int[][] map = {{1, 3, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 3, 0, 3, 0, 3, 0, 3, 3, 0}, {0, 0, 0, 3, 0, 0, 0, 3, 0, 0}, {3, 0, 3, 0, 3, 3, 3, 0, 0, 3}, {0, 0, 0, 0, 0, 0, 3, 0, 3, 0}, {0, 3, 3, 3, 0, 0, 0, 3, 0, 0}, {0, 0, 0, 0, 3, 3, 0, 0, 0, 3}, {0, 3, 0, 0, 3, 0, 3, 0, 3, 0}, {0, 0, 0, 3, 0, 0, 0, 0, 0, 0}, {0, 3, 0, 0, 3, 0, 0, 3, 0, 2}};
        return map;
    }

    public static int[][] createMap(int walls) {
        int[][] rv = createMap(10, 10);
        for (int i = 1; i <= walls; i++) {
            rv[(int)(Math.random() * 10)][(int)(Math.random() * 10)] = 3;
        }
        rv[0][0] = 1;
        rv[9][9] = 2;
        return rv;
    }

    public static String getSymbol(int value) {
        String[] symbol = {"_", "Y", "F", "*"};
        return symbol[value];
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(getSymbol(map[i][j]));
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static String mapToString(int[][] map) {
        String rv = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                rv += getSymbol(map[i][j]);
                rv += "  ";
            }
            rv += "\n";
        }
        return rv;
    }

    public static int[] find(int[][] map, int value) {
        int[] rv = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == value) {
                    rv[0] = i;
                    rv[1] = j;
                    return rv;
                }
            }
        }
        return null;
    }

    public static boolean canGoN(int[][] map) {
        int[] position = find(map, 1);
        if (position[0] > 0 && map[position[0] - 1][position[1]] == 0)
            return true;
        else
            return false;
    }
    
    public static boolean canGoS(int[][] map) {
        int[] position = find(map, 1);
        if (position[0] < map.length - 1 && map[position[0] + 1][position[1]] == 0)
            return true;
        else
            return false;
    }

    public static boolean canGoE(int[][] map) {
        int[] position = find(map, 1);
        if (position[1] < map[0].length - 1 && map[position[0]][position[1] + 1] == 0)
            return true;
        else
            return false;
    }

    public static boolean canGoW(int[][] map) {
        int[] position = find(map, 1);
        if (position[1] > 0 && map[position[0]][position[1] - 1] == 0)
            return true;
        else
            return false;
    }

    public static String minimalPath(int[][] map) {
        // String minimal = "";
        // boolean found = false;

        int[] currentPosition = find(map, 1);
        boolean canMove = false;
        
        // checks if it can go east
        if (canGoE(map)) {
            canMove = true;
            minimal += "R";
            map[currentPosition[0]][currentPosition[1]] = 3;
            if (map[currentPosition[0]][currentPosition[1] + 1] == 2) {
                found = true;
                return minimal;
            }
            map[currentPosition[0]][currentPosition[1] + 1] = 1;
        }
        
        // checks if it can go south
        else if (canGoS(map)) {
            canMove = true;
            minimal += "D";
            map[currentPosition[0]][currentPosition[1]] = 3;
            if (map[currentPosition[0] + 1][currentPosition[1]] == 2) {
                found = true;
                return minimal;
            }
            map[currentPosition[0] + 1][currentPosition[1]] = 1;
        }

        // checks if it can go north
        else if (canGoN(map)) {
            canMove = true;
            minimal += "U";
            map[currentPosition[0]][currentPosition[1]] = 3;
            if(map[currentPosition[0] - 1][currentPosition[1]] == 2) {
                found = true;
                return minimal;
            }
            map[currentPosition[0] - 1][currentPosition[1]] = 1;
        }
        
        // checks if it can go west
        else if (canGoW(map)) {
            canMove = true;
            minimal += "L";
            map[currentPosition[0]][currentPosition[1]] = 3;
            if(map[currentPosition[0]][currentPosition[1]-1] == 2) {
                found = true;
                return minimal;
            }
            map[currentPosition[0]][currentPosition[1] - 1] = 1;
        }
        
        // returns null at every runtime
        if (!canMove) {
            return "";
        }
        
        // if not found it runs the function
        if (!found)
            minimalPath(map);
        return minimal;
    }

    public static int[][][] create3DMap(int rows, int columns, int floors) {
        return new int[floors][rows][columns];
    }

    public static int[][][] create3DMap() {
        int[][][] rv = {{{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}, {{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}}, {{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 0, 0, 4, 0, 4, 0, 0, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 0, 0, 4, 0, 4, 0, 0, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}}, {{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}}};
        return rv;
    }

    public static int[][][] create3DMap(int floors) {
        int[][][] rv = create3DMap(5, 5 , floors);
        // sets the top left corner of the initial floor to the starting point
        rv[0][0][0] = 1;
        int j, k;
        for (int i = 0; i < floors - 1; i++) {
            // returns a value from 0 - 4
            j = (int)(Math.random()*4);
            k = (int)(Math.random()*4);
            rv[i][j][k] = 4;
            // builds the next floor but with the same coordinates as last one
            rv[i + 1][j][k] = 5;
        }
        return rv;
    }

    public static boolean canGoU(int[][][] map) {
        int[] position = new int[2];
        for (int i = 0; i < map[0][0].length; i++) {
            // finds the position of the specified floor
            position = find(map[i], 1);
            // checks if the position was found or not
            if (position != null) {
                // checking if it is the top floor, since then it would be out of bounds
                if (i == map[0][0].length - 1)
                    return false;
                // checking if the position a floor above is blocked by a barrier or not
                else {
                    if (map[position[0]][position[1]][i + 1] != 3)
                        return true;
                    else
                        return false;
                }
            }
            else
                return false;
        }
        return false;
    }

    public static boolean canGoD(int[][][] map) {
        int[] position = new int[2];
        for (int i = 0; i < map[0][0].length; i++) {
            // finds the position of the specified floor
            position = find(map[i], 1);
            // checks if the position was found or not
            if (position != null) {
                // checking if it is the top floor, since then it would be out of bounds
                if (i == 0)
                    return false;
                // checking if the position a floor above is blocked by a barrier or not
                else {
                    if (map[position[0]][position[1]][i - 1] != 3)
                        return true;
                    else
                        return false;
                }
            }
            else
                return false;
        }
        return false;
    }

    public static String mapToString(int[][][] map) {
        String rv = "";
        for (int i = 0; i < map.length; i++) {
            rv += "Level " + (i + 1) + ": \n";
            rv += mapToString(map[i]);
            if (i != 0)
                rv += "\n";
        }
        return rv;
    }
}