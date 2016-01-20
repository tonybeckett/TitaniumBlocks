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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.rangemodels;

/**
 *
 * @author tbeckett
 */
public class LinearRangeModel
{

    private double startValue = 0.0;
    private double endValue = 100.0;
    private double tickSpacingByValue = 1.0; // by value

    private int startPosition;
    private double tickSpacingPixels;

    private double textDistance;
    private float textAngleAdjust = 0.0f;
    private double sizeInPixels;

    public LinearRangeModel()
    {

    }

    private void calc()
    {
        tickSpacingPixels = sizeInPixels / getNumberOfTicks();
    }

    public double getStartValue()
    {
        return startValue;
    }

    public void setStartValue(double startValue)
    {
        this.startValue = startValue;
    }

    public double getEndValue()
    {
        return endValue;
    }

    public void setEndValue(double endValue)
    {
        this.endValue = endValue;
    }

    public double getSizeInPixels()
    {
        return sizeInPixels;
    }

    public void setSizeInPixels(double sizeP)
    {
        this.sizeInPixels = sizeP;
        calc();
    }

    public int getStartPosition()
    {
        return startPosition;
    }

    public void setStartPosition(int startPosition)
    {
        this.startPosition = startPosition;
    }

    public void setTickSpacingPixel(double d)
    {
        this.tickSpacingPixels = d;
    }

    public double getTickSpacingPixels()
    {
        return tickSpacingPixels;
    }

    public double getTickSpacingByValue()
    {
        return tickSpacingByValue;
    }

    public void setTickSpacingByValue(double tickSpacing)
    {
        this.tickSpacingByValue = tickSpacing;
        calc();
    }

    public double getValuePerTick()
    {
        return (this.endValue - this.startValue) / getNumberOfTicks();
    }

    public int getNumberOfTicks()
    {
        return (int) ((endValue - startValue) / this.tickSpacingByValue);
    }

    public double getTextDistance()
    {
        return textDistance;
    }

    public void setTextDistance(double textDistance)
    {
        this.textDistance = textDistance;
    }

    public float getTextAngleAdjust()
    {
        return textAngleAdjust;
    }

    public void setTextAngleAdjust(float textAngleAdjust)
    {
        this.textAngleAdjust = textAngleAdjust;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {

    }

    int getYDelta()
    {
        return -1;
    }

}
