package design;

public class RectangleOverlap {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(2, 1, 5, 3);
        Rectangle rect2 = new Rectangle(5, 2, 3, 5);

        Rectangle result = new RectangleOverlap().findRectangularOverlap(rect1, rect2);
        System.out.println("X: " + result.leftX + " Y: " + result.bottomY + " Width: " + result.width + " Height: " + result.height);
    }

    class Overlap {
        int startPoint;
        int length;

        Overlap(int startPoint, int length) {
            this.startPoint = startPoint;
            this.length = length;
        }
    }

    static class Rectangle {
        int leftX;
        int bottomY;
        int width;
        int height;

        Rectangle() {}

        Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width = width;
            this.height = height;
        }
    }

    private Overlap findOverlap(int point1, int point2, int length1, int length2) {
        int highestStartingPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

        if (highestStartingPoint >= lowestEndPoint) {
            return new Overlap(0, 0);
        }

        return new Overlap(highestStartingPoint, lowestEndPoint - highestStartingPoint);
    }

    private Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {
        Overlap xOlp = findOverlap(rect1.leftX, rect2.leftX, rect1.width, rect2.width);
        Overlap yOlp = findOverlap(rect1.bottomY, rect2.bottomY, rect1.height, rect2.height);

        if (xOlp.length == 0 || yOlp.length == 0) {
            return new Rectangle();
        }

        return new Rectangle(xOlp.startPoint, yOlp.startPoint, xOlp.length, yOlp.length);
    }
}
