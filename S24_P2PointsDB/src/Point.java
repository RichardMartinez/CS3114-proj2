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
     * 
     * @param a
     * @return
     */
    private boolean insideWorldBox(int a) {
        return (a >= 0) && (a < 1024);
    }


    /**
     * Return true if this point is north of x1, y1
     * 
     * @param x1
     *            x coordinate
     * @param y1
     *            y coordinate
     * @return true if north
     */
    public boolean isNorthOf(int x1, int y1) {
        return this.getY() < y1;
    }


    /**
     * Return true if this point is west of x1, y1
     * 
     * @param x1
     *            x coordinate
     * @param y1
     *            y coordinate
     * @return true if west
     */
    public boolean isWestOf(int x1, int y1) {
        return this.getX() < x1;
    }


    /**
     * Returns the direction as a String from point x1, y1
     * 
     * @param x1
     *            x coordinate
     * @param y1
     *            y coordinate
     * @return direction as a string
     */
    public String getDirection(int x1, int y1) {
        boolean isNorth = this.isNorthOf(x1, y1);
        boolean isWest = this.isWestOf(x1, y1);

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


    /**
     * Returns true if the point intersects the region
     * 
     * @param regionX
     *            x coordinate of region
     * @param regionY
     *            y coordinate of region
     * @param regionW
     *            width of region
     * @param regionH
     *            height of region
     * @return true if intersect
     */
    public boolean intersectsRegion(
        int regionX,
        int regionY,
        int regionW,
        int regionH) {
        int regionLeft = regionX;
        int regionRight = regionX + regionW;
        int regionTop = regionY;
        int regionBottom = regionY + regionH;

        // Point is too far left
        if (this.getX() <= regionLeft) {
            return false;
        }

        // Point it too far right
        if (this.getX() >= regionRight) {
            return false;
        }

        // Point is too far down
        if (this.getY() >= regionBottom) {
            return false;
        }

        // Point is too far up
        return !(this.getY() <= regionTop);
    }

}
