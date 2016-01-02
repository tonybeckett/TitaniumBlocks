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
package us.jaba.titaniumblocks.core.tickmarks.marks.models.sizemodels;

/**
 *
 * @author tbeckett
 */
public class LinearSizeModel
{

    public static final float DEFAULT_MINOR_DIAMETER_ADJUST = 0.0186915888f;
    public static final float DEFAULT_MAJOR_DIAMETER_ADJUST = 0.0280373832f;

    protected float majorTickStartAdj = 1.0f;
    protected float majorTickStopAdj = 1.0f;
    protected float mediumTickStartAdj = 1.0f;
    protected float mediumTickStopAdj = 1.0f;
    protected float minorTickStartAdj = 1.0f;
    protected float minorTickStopAdj = 1.0f;

    private float minorDiameterAdj = DEFAULT_MINOR_DIAMETER_ADJUST;
//    private float mediumDiameterAdj = DEFAULT_MEDIUM_DIAMETER_ADJUST;
    private float majorDiameterAdj = DEFAULT_MAJOR_DIAMETER_ADJUST;
//    private float minorTickLengthAdj = 1.0f;
//    private float textDistanceAdj = DEFAULT_TEXT_DISTANCE_ADJUST;
//   
//
//   
    private int minorDiameter = 10;
//    private int mediumDiameter = 10;
    private int majorDiameter = 10;
//    private int minorTickLength = 2;
//    private int textDistance = 1;

    private int majorTickStart = 0;
    private int majorTickStop = 0;
    private int mediumTickStart = 0;
    private int mediumTickStop = 0;
    private int minorTickStart = 0;
    private int minorTickStop = 0;
    private int tickStart = 0;
    private int tickStop = 0;
    
    public LinearSizeModel()
    {

    }

    public void adjustUsing(float basis)
    {
        majorTickStart = (int) (majorTickStartAdj * basis);
        majorTickStop = (int) (majorTickStopAdj * basis);
        mediumTickStart = (int) (mediumTickStartAdj * basis);
        mediumTickStop = (int) (mediumTickStopAdj * basis);
        minorTickStart = (int) (minorTickStartAdj * basis);
        minorTickStop = (int) (minorTickStopAdj * basis);
        minorDiameter = (int) (minorDiameterAdj * basis);
        majorDiameter = (int) (majorDiameterAdj * basis);

        
        
    }

    public float getMajorTickStartAdj()
    {
        return majorTickStartAdj;
    }

    public void setMajorTickStartAdj(float majorTickStartAdj)
    {
        this.majorTickStartAdj = majorTickStartAdj;
    }

    public float getMajorTickStopAdj()
    {
        return majorTickStopAdj;
    }

    public void setMajorTickStopAdj(float majorTickStopAdj)
    {
        this.majorTickStopAdj = majorTickStopAdj;
    }

    public float getMediunmTickStartAdj()
    {
        return mediumTickStartAdj;
    }

    public void setMediunmTickStartAdj(float mediunmTickStartAdj)
    {
        this.mediumTickStartAdj = mediunmTickStartAdj;
    }

    public float getMediumTickStopAdj()
    {
        return mediumTickStopAdj;
    }

    public void setMediumTickStopAdj(float mediumTickStopAdj)
    {
        this.mediumTickStopAdj = mediumTickStopAdj;
    }

    public float getMinorTickStartAdj()
    {
        return minorTickStartAdj;
    }

    public void setMinorTickStartAdj(float minorTickStartAdj)
    {
        this.minorTickStartAdj = minorTickStartAdj;
    }

    public float getMinorTickStopAdj()
    {
        return minorTickStopAdj;
    }

    public void setMinorTickStopAdj(float minorTickStopAdj)
    {
        this.minorTickStopAdj = minorTickStopAdj;
    }

    public int getMajorDiameter()
    {
        return majorDiameter;
    }

    public void setMajorDiameter(int majorDiameter)
    {
        this.majorDiameter = majorDiameter;
    }

    public float getMinorDiameterAdj()
    {
        return minorDiameterAdj;
    }

    public void setMinorDiameterAdj(float minorDiameterAdj)
    {
        this.minorDiameterAdj = minorDiameterAdj;
    }

    public float getMajorDiameterAdj()
    {
        return majorDiameterAdj;
    }

    public void setMajorDiameterAdj(float majorDiameterAdj)
    {
        this.majorDiameterAdj = majorDiameterAdj;
    }

    public int getMinorDiameter()
    {
        return minorDiameter;
    }

    public void setMinorDiameter(int minorDiameter)
    {
        this.minorDiameter = minorDiameter;
    }

    public int getMajorTickStart()
    {
        return majorTickStart;
    }

    public void setMajorTickStart(int majorTickStart)
    {
        this.majorTickStart = majorTickStart;
    }

    public int getMajorTickStop()
    {
        return majorTickStop;
    }

    public void setMajorTickStop(int majorTickStop)
    {
        this.majorTickStop = majorTickStop;
    }

    public int getMediunmTickStart()
    {
        return mediumTickStart;
    }

    public void setMediunmTickStart(int mediunmTickStart)
    {
        this.mediumTickStart = mediunmTickStart;
    }

    public int getMediumTickStop()
    {
        return mediumTickStop;
    }

    public void setMediumTickStop(int mediumTickStop)
    {
        this.mediumTickStop = mediumTickStop;
    }

    public int getMinorTickStart()
    {
        return minorTickStart;
    }

    public void setMinorTickStart(int minorTickStart)
    {
        this.minorTickStart = minorTickStart;
    }

    public int getMinorTickStop()
    {
        return minorTickStop;
    }

    public void setMinorTickStop(int minorTickStop)
    {
        this.minorTickStop = minorTickStop;
    }

    public float getMediumTickStartAdj()
    {
        return mediumTickStartAdj;
    }

    public void setMediumTickStartAdj(float mediumTickStartAdj)
    {
        this.mediumTickStartAdj = mediumTickStartAdj;
    }

    public int getMediumTickStart()
    {
        return mediumTickStart;
    }

    public void setMediumTickStart(int mediumTickStart)
    {
        this.mediumTickStart = mediumTickStart;
    }

    public int getTickStart()
    {
        return tickStart;
    }

    public void setTickStart(int tickStart)
    {
        this.tickStart = tickStart;
    }

    public int getTickStop()
    {
        return tickStop;
    }

    public void setTickStop(int tickStop)
    {
        this.tickStop = tickStop;
    }

}
