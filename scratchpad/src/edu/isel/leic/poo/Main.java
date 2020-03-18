package edu.isel.leic.poo;

interface Drawable {
    void draw();
}

class Point implements Drawable {
    final int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y +")";
    }

    @Override
    public void draw() {
        System.out.println(toString());
    }
}

class Point3D extends Point {
    final int z;

    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

class PsychedelicKitten implements Drawable {

    @Override
    public void draw() {
        System.out.println("WOOOOOOOOOWOWOWOWOWOWOWOWOW");
    }
}


public class Main {

    private static void drawAll(Drawable[] drawables) {
        for (Drawable d : drawables) {
            d.draw();
        }
    }

    public static void main(String[] args) {

        Point3D p = new Point3D(4, 5, 6);
        p.draw();

        final Drawable[] drawables = {
                new PsychedelicKitten(), new Point(4, 6), new Point3D(12, 35, 6), new PsychedelicKitten()
        };

        drawAll(drawables);
    }
}
