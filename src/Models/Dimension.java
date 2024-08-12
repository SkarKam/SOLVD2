package Models;

public class Dimension {
    private int width;
    private int length;

    public Dimension(int width, int length) {
        this.width = width;
        this.length = length;
    }
    public Dimension(){
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Dimension width must be greater than 0");
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if(length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Dimension length must be greater than 0");
        }
    }

    public int getSurface(){
        return width * length;
    }

    @Override
    public String toString() {
        return "\nDimension{" +
                "width=" + width +
                "length=" + length +
                '}';
    }
}
