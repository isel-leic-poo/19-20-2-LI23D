package edu.isel.adeetc.animationdemo;

public class Vector {
    public float x, y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector velocity) {
        x += velocity.x;
        y += velocity.y;
        return this;
    }
}
