package com.shape;

import com.shape.*;

public class sphere extends shape {
    sphere(int dim1) {
        super(dim1, -1);
    }

    public double area() {
        return 4 * Math.PI * this.dim1 * this.dim1;
    }

    public double volume() {
        return (4 / 3) * Math.PI * this.dim1 * this.dim1 * this.dim1;
    }
}
