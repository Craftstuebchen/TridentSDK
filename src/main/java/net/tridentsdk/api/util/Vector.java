/*
 * Copyright (c) 2014, The TridentSDK Team
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     1. Redistributions of source code must retain the above copyright
 *        notice, this list of conditions and the following disclaimer.
 *     2. Redistributions in binary form must reproduce the above copyright
 *        notice, this list of conditions and the following disclaimer in the
 *        documentation and/or other materials provided with the distribution.
 *     3. Neither the name of the The TridentSDK Team nor the
 *        names of its contributors may be used to endorse or promote products
 *        derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL The TridentSDK Team BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.tridentsdk.api.util;

import java.io.Serializable;

/**
 * Just like in math, a vector represents magnitude and direction, where magnitude is usually the speed of an entity.
 *
 * @author The TridentSDK Team
 */
public class Vector implements Serializable, Cloneable {
    private static final long serialVersionUID = -7634050835106851288L;

    private double x;
    private double y;
    private double z;

    /**
     * Creates a default vector with x, y, and z set to (0, 0, 0)
     */
    public Vector() {
        this(0, 0, 0);
    }

    /**
     * Creates a vector with the directional values set to the provided values
     *
     * @param x the x value of the vector
     * @param y the y value of the vector
     * @param z the z value of the vector
     */
    public Vector(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    /**
     * Creates a vector with the directional values set to the provided values
     *
     * @param x the x value of the vector
     * @param y the y value of the vector
     * @param z the z value of the vector
     */
    public Vector(int x, int y, int z) {
        this.setX((double) x);
        this.setY((double) y);
        this.setZ((double) z);
    }

    /**
     * Adds the vector x, y, and z to the current vector coordinates
     *
     * @param vector the vector to retrieve the values to be added
     * @return the current vector with updated coordinates
     */
    public Vector add(Vector vector) {
        return this.add(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Adds the coordinate values to the current vector's coordinates with double accuracy
     *
     * @param x the x value of the vector to add
     * @param y the y value of the vector to add
     * @param z the z value of the vector to add
     * @return the current vector with updated coordinates
     */
    public Vector add(double x, double y, double z) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
        this.setZ(this.getZ() + z);

        return this;
    }

    /**
     * Adds the coordinate values to the current vector's coordinates
     *
     * @param x the x value of the vector to add
     * @param y the y value of the vector to add
     * @param z the z value of the vector to add
     * @return the current vector with updated coordinates
     */
    public Vector add(int x, int y, int z) {
        return this.add((double) x, (double) y, (double) z);
        /* Implementation detail:
        DO NOT CREATE A NEW VECTOR HERE JUST BECAUSE (!)
        Doing so wastes memory and adds unnecessary object
        creation overhead, therefore, delegate to the
        setters instead of the previous implementation.
        Same with the other methods */
    }

    /**
     * Takes the current vector coordinates and subtract them with the vector x, y, and z
     *
     * @param vector the vector to retrieve the values to be subtracted
     * @return the current vector with updated coordinates
     */
    public Vector subtract(Vector vector) {
        return this.subtract(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Takes the the current vector's coordinates and subtracts them from the coordinate values with double accuracy
     *
     * @param x the x value of the vector to subtract
     * @param y the y value of the vector to subtract
     * @param z the z value of the vector to subtract
     * @return the current vector with updated coordinates
     */
    public Vector subtract(double x, double y, double z) {
        this.setX(this.getX() - x);
        this.setY(this.getY() - y);
        this.setZ(this.getZ() - z);

        return this;
    }

    /**
     * Takes the the current vector's coordinates and subtracts them from the coordinate values
     *
     * @param x the x value of the vector to subtract
     * @param y the y value of the vector to subtract
     * @param z the z value of the vector to subtract
     * @return the current vector with updated coordinates
     */
    public Vector subtract(int x, int y, int z) {
        return this.subtract((double) x, (double) y, (double) z);
    }

    /**
     * Multiplies the vector x, y, and z to the current vector coordinates
     *
     * @param vec the vector to retrieve the values to be multiplied
     * @return the current vector with updated coordinates
     */
    public Vector multiply(Vector vec) {
        return this.multiply(vec.getX(), vec.getY(), vec.getZ());
    }

    /**
     * Multiplies the magnitude of this vector by a double
     *
     * @param amount The amount to multiply by
     * @return This vector, with updated coordinates
     */
    public Vector multiply(double amount) {
        return multiply(amount, amount, amount);
    }

    /**
     * Multiplies the coordinate values to the current vector's coordinates with double accuracy
     *
     * @param x the x value of the vector to multiply
     * @param y the y value of the vector to multiply
     * @param z the z value of the vector to multiply
     * @return the current vector with updated coordinates
     */
    public Vector multiply(double x, double y, double z) {
        this.setX(this.getX() * x);
        this.setY(this.getY() * y);
        this.setZ(this.getZ() * z);

        return this;
    }

    /**
     * Multiplies the coordinate values to the current vector's coordinates
     *
     * @param x the x value of the vector to multiply
     * @param y the y value of the vector to multiply
     * @param z the z value of the vector to multiply
     * @return the current vector with updated coordinates
     */
    public Vector multiply(int x, int y, int z) {
        return this.multiply((double) x, (double) y, (double) z);
    }

    /**
     * Takes the current vector coordinates and divide them with the vector x, y, and z
     *
     * @param vec the vector to retrieve the values to be divided
     * @return the current vector with updated coordinates
     */
    public Vector divide(Vector vec) {
        return this.divide(vec.getX(), vec.getY(), vec.getZ());
    }

    /**
     * Divides the magnitude of this vector by a given amount.
     *
     * @param amount The amount to divide by
     * @return this vector
     */
    public Vector divide(double amount) {
        return divide(amount, amount, amount);
    }

    /**
     * Takes the the current vector's coordinates and divides them from the coordinate values with double accuracy
     *
     * @param x the x value of the vector to divide
     * @param y the y value of the vector to divide
     * @param z the z value of the vector to divide
     * @return the current vector with updated coordinates
     */
    public Vector divide(double x, double y, double z) {
        this.setX(this.getX() / x);
        this.setY(this.getY() / y);
        this.setZ(this.getZ() / z);

        return this;
    }

    /**
     * Takes the the current vector's coordinates and divides them from the coordinate values
     *
     * @param x the x value of the vector to divide
     * @param y the y value of the vector to divide
     * @param z the z value of the vector to divide
     * @return the current vector with updated coordinates
     */
    public Vector divide(int x, int y, int z) {
        return this.divide((double) x, (double) y, (double) z);
    }

    /**
     * Sets the current vector to the crossproduct between this vector and another one
     *
     * @param vector the vector to crossproduct with
     * @return this vector, updated with the crossproduct with the other vector
     */
    public Vector crossProduct(Vector vector) {
        double x = this.x;
        double y = this.y;
        double z = this.z;

        this.setX(y * vector.getZ() - vector.getY() * z);
        this.setY(z * vector.getX() - vector.getZ() - x);
        this.setZ(x * vector.getY() - vector.getX() * y);

        return this;
    }

    /**
     * Gets the square of the magnitude of this vector
     *
     * @return The magnitude of this vector, squared
     */
    public double magnitudeSquared() {
        return (x * x) + (y * y) + (z * z);
    }

    /**
     * Gets the magnitude for this vector
     *
     * Note that this is an expensive operation, and if possible, you should use magnitudeSquared() instead
     *
     * @return The magnitude of this vector
     */
    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    /**
     * Normalizes this vector (changes the magnitude to 1 without changing the direction)
     *
     * @return This vector
     */
    public Vector normalize() {
        return this.divide(this.magnitude());
    }
    
	/**
     * Calculates the dot product of this vector and another
     *
     * @param vec the other vector
     * @return dot product of the two vectors
     */
    public double dotProduct(Vector vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }

    /**
     * Gets the x directional-magnitude value
     *
     * @return the vector x value
     */
    public double getX() {
        return this.x;
    }

    /**
     * Sets this vector's x value
     *
     * @param x the x value to set this vector
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the y directional-magnitude value
     *
     * @return the vector y value
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets this vector's y value
     *
     * @param y the y value to set this vector
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets the z directional-magnitude value
     *
     * @return the vector z value
     */
    public double getZ() {
        return this.z;
    }

    /**
     * Sets this vector's z value
     *
     * @param z the z value to set this vector
     */
    public void setZ(double z) {
        this.z = z;
    }
}
