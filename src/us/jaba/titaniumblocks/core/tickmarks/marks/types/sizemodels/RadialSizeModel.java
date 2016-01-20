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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.sizemodels;

/**
 *
 * @author tbeckett
 */
public class RadialSizeModel
{
    public static final float DEFAULT_MINOR_TICK_LENGTH_ADJUST = 0.0133333333f;
    public static final float DEFAULT_MEDIUM_TICK_LENGTH_ADJUST = 0.02f;
    public static final float DEFAULT_MAJOR_TICK_LENGTH_ADJUST = 0.03f;
    public static final float DEFAULT_MINOR_DIAMETER_ADJUST = 0.0093457944f;
    public static final float DEFAULT_TEXT_DISTANCE_ADJUST = 0.09f;
    public static final float DEFAULT_RADIUS_ADJUST = 0.98f;//0.85f;

    private float majorTickLengthAdj = DEFAULT_MAJOR_TICK_LENGTH_ADJUST;
    private float mediumTickLengthAdj = DEFAULT_MEDIUM_TICK_LENGTH_ADJUST;
    private float minorDiameterAdj = DEFAULT_MINOR_DIAMETER_ADJUST;
    private float minorTickLengthAdj = DEFAULT_MINOR_TICK_LENGTH_ADJUST;
    private float textDistanceAdj = DEFAULT_TEXT_DISTANCE_ADJUST;
    private float radiusAdj = DEFAULT_RADIUS_ADJUST;

    private int majorTickLength = 10;
    private int mediumTickLength = 6;
    private int minorDiameter = 10;
    private int minorTickLength = 2;
    private int textDistance = 1;
    private float radius = 10.0f;

    public RadialSizeModel()
    {

    }

    public void adjustUsing(float basis)
    {
        minorTickLength = (int) (minorTickLengthAdj * basis);
        mediumTickLength = (int) (mediumTickLengthAdj * basis);
        majorTickLength = (int) (majorTickLengthAdj * basis);
        minorDiameter = (int) (minorDiameterAdj * basis);
        textDistance = (int) (textDistanceAdj * basis);
        radius = (radiusAdj * basis / 2.0f);
    }

    public int getMajorTickLength()
    {
        return majorTickLength;
    }

    public void setMajorTickLength(int majorTickLength)
    {
        this.majorTickLength = majorTickLength;
    }

    public int getMediumTickLength()
    {
        return mediumTickLength;
    }

    public void setMediumTickLength(int mediumTickLength)
    {
        this.mediumTickLength = mediumTickLength;
    }

    public int getMinorDiameter()
    {
        return minorDiameter;
    }

    public void setMinorDiameter(int minorDiameter)
    {
        this.minorDiameter = minorDiameter;
    }

    public int getMinorTickLength()
    {
        return minorTickLength;
    }

    public void setMinorTickLength(int minorTickLength)
    {
        this.minorTickLength = minorTickLength;
    }

    public int getTextDistance()
    {
        return textDistance;
    }

    public void setTextDistance(int textDistance)
    {
        this.textDistance = textDistance;
    }

    public float getRadius()
    {
        return radius;
    }

    public void setRadius(float radius)
    {
        this.radius = radius;
    }

    public float getMajorTickLengthAdj()
    {
        return majorTickLengthAdj;
    }

    public void setMajorTickLengthAdj(float majorTickLengthAdj)
    {
        this.majorTickLengthAdj = majorTickLengthAdj;
    }

    public float getMediumTickLengthAdj()
    {
        return mediumTickLengthAdj;
    }

    public void setMediumTickLengthAdj(float mediumTickLengthAdj)
    {
        this.mediumTickLengthAdj = mediumTickLengthAdj;
    }

    public float getMinorDiameterAdj()
    {
        return minorDiameterAdj;
    }

    public void setMinorDiameterAdj(float minorDiameterAdj)
    {
        this.minorDiameterAdj = minorDiameterAdj;
    }

    public float getMinorTickLengthAdj()
    {
        return minorTickLengthAdj;
    }

    public void setMinorTickLengthAdj(float minorTickLengthAdj)
    {
        this.minorTickLengthAdj = minorTickLengthAdj;
    }

    public float getTextDistanceAdj()
    {
        return textDistanceAdj;
    }

    public void setTextDistanceAdj(float textDistanceAdj)
    {
        this.textDistanceAdj = textDistanceAdj;
    }

    public float getRadiusAdj()
    {
        return radiusAdj;
    }

    public void setRadiusAdj(float radiusAdj)
    {
        this.radiusAdj = radiusAdj;
    }

}
