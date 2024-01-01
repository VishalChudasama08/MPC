package com.shape;

import com.shape.*;

public class rectangle extends shape {
    rectangle(int dim1, int dim2) {
        super(dim1, dim2);
    }

    public double area() {
        return this.dim1 * this.dim2;
    }
}
