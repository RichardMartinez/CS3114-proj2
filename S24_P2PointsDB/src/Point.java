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
        // Need same x, same y, same w, same h
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


    private boolean insideWorldBox(int a) {
        return (a >= 0) && (a <= 1024);
    }

}