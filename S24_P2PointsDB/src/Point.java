/**
 * This class holds the coordinates of a point.
 * 
 * @author CS Staff, Richard Martinez
 * 
 * @version 2024-01-22
 */
public class Point {
    // the x coordinate of the point
    private int x;
    // the y coordinate of the point
    private int y;

    /**
     * Creates an object with the values to the parameters given in the
     * xCoordinate, yCoordinate
     * 
     * @param x
     *            x-coordinate of the rectangle
     * @param y
     *            y-coordinate of the rectangle
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Getter for the x coordinate
     *
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }


    /**
     * Getter for the y coordinate
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }


    /**
     * Checks, if the invoking point has the same coordinates as pt.
     * 
     * @param pt
     *            the point parameter
     * @return true if the point has the same coordinates as pt, false if
     *         not
     */
    public boolean equals(Point pt) {
        // Need same x, same y
        boolean sameX = this.getX() == pt.getX();
        boolean sameY = this.getY() == pt.getY();

        return (sameX && sameY);
    }


    /**
     * Checks, if the invoking point has the same coordinates as pt.
     * 
     * @param pt
     *            the point parameter
     * @return true if the point has the same coordinates as pt, false if
     *         not
     */
    public boolean equals(Object pt) {
        return false;
    }


    /**
     * Outputs a human readable string with information about the rectangle
     * which includes the x and y coordinate and its height and width
     * 
     * @return a human readable string containing information about the
     *         rectangle
     */
    public String toString() {
        return String.format("%d, %d", x, y);
    }


    /**
     * Checks if the rectangle has invalid parameters
     * 
     * @return true if the rectangle has invalid parameters, false if not
     */
    public boolean isInvalid() {
        boolean xInside = insideWorldBox(x);
        boolean yInside = insideWorldBox(y);

        boolean valid = (xInside && yInside);

        return !valid;
    }

    /**
     * Return true if inside the world box
     * @param a
     * @return
     */
    private boolean insideWorldBox(int a) {
        return (a >= 0) && (a < 1024);
    }
    
    /**
     * Return true if this point is north of x, y
     * @param x
     * @param y
     * @return
     */
    public boolean isNorthOf(int x, int y) {
        return this.getY() < y;
    }
    
    /**
     * Return true if this point is west of x, y
     * @param x
     * @param y
     * @return
     */
    public boolean isWestOf(int x, int y) {
        return this.getX() < x;
    }
    
    /**
     * Returns the direction as a String from point x, y
     * @param x
     * @param y
     * @return direction as a string
     */
    public String getDirection(int x, int y) {
        boolean isNorth = this.isNorthOf(x, y);
        boolean isWest = this.isWestOf(x, y);
        
        // If statement for better mutation testing
        if (isNorth) {
            // North
            if (isWest) {
                // West
                return "nw";
            }
            else {
                // East
                return "ne";
            }
        }
        else {
            // South
            if (isWest) {
                // West
                return "sw";
                
            }
            else {
                // East
                return "se";
            }
        }
    }

}
