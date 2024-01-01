package com.shape;

import com.shape.*;

public class circle extends shape {
    circle(int dim1) {
        super(dim1, -1);
    }

    public double area() {
        return Math.PI * this.dim1 * this.dim1;
    }

    public double volume() {
        return (4 / 3) * Math.PI * this.dim1 * this.dim1 * this.dim1;
    }
}
