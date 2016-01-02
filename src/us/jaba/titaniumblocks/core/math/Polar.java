/*
 * Copyright (c) 2015, Tony Beckett
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * The names of its contributors may not be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package us.jaba.titaniumblocks.core.math;

/**
 *
 * @author tbeckett
 */
public class Polar
{

    private double r;
    private double theta;

    
    
    public Polar(double r, double theta)
    {
        this.r = r;
        this.theta = theta;
    }

    
    /**
     * Get the value of r
     *
     * @return the value of r
     */
    public double getR()
    {
        return r;
    }

    /**
     * Set the value of r
     *
     * @param r new value of r
     */
    public void setR(double r)
    {
        this.r = r;
    }

    /**
     * Get the value of theta
     *
     * @return the value of theta
     */
    public double getTheta()
    {
        return theta;
    }

    /**
     * Set the value of theta
     *
     * @param theta new value of theta
     */
    public void setTheta(double theta)
    {
        this.theta = theta;
    }

    @Override
    public String toString()
    {
        return "Polar{" + "r=" + r + ", theta=" + theta + '}';
    }

   
    
}
