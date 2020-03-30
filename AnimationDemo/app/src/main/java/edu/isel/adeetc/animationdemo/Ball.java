package edu.isel.adeetc.animationdemo;

public class Ball {

    private Vector center;
    private float radius;
    private Vector velocity;

    private Vector bounds;

    public Ball(Vector center, float radius) {
        this.center = center;
        this.radius = radius;
        velocity = new Vector(0, 0);
        this.bounds = null;
    }

    public void setBounds(Vector bounds) {
        this.bounds = bounds;
    }

    public Vector getCenter() {
        return center;
    }

    public void setCenter(Vector newCenter) {
        center = newCenter;
    }

    public float getRadius() {
        return radius;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void move() {
        if (bounds == null)
            return;

        if (center.x - radius <= 0 || center.x + radius >= bounds.x) {
            velocity = new Vector(velocity.x * -1, velocity.y);
        } else if (center.y - radius <= 0 || center.y + radius >= bounds.y) {
            velocity = new Vector(velocity.x, velocity.y * -1);
        }
        center = center.add(velocity);
    }
}
