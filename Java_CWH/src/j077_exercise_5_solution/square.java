package com.shape;

import com.shape.*;

public class square extends shape {
    square(int dim1) {
        super(dim1, -1); // -1 not exist
    }

    public double area() {
        return this.dim1 * this.dim2;
    }
}
