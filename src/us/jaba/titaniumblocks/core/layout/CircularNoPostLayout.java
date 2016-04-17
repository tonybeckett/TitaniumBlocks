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
package us.jaba.titaniumblocks.core.layout;

import us.jaba.titaniumblocks.core.math.CoordinateDefs.Direction;

/**
 *
 * @author tbeckett
 */
public class CircularNoPostLayout implements CircularLayout
{

    private int endPostAngle;

    private int startAngle;
    private int endAngle;
    private Direction direction;
    private int startPostAngle;
    private float postRadius;

    public CircularNoPostLayout( Direction dir, float radius)
    {
        this.startAngle = 0;
        this.endAngle = 360;
        this.direction = dir;
        this.postRadius = radius;
        this.startPostAngle = 0;
        this.endPostAngle = 0;

    }

    @Override
    public Direction getDirection()
    {
        return direction;
    }

    @Override
    public int getEndPostAngle()
    {
        return endPostAngle;
    }

    @Override
    public int getStartPostAngle()
    {
        return startPostAngle;
    }

    /**
     * Get the value of endAngle
     *
     * @return the value of endAngle
     */
    @Override
    public int getEndAngle()
    {
        return endAngle;
    }

   

    /**
     * Set the value of endAngle
     *
     * @param endAngle new value of endAngle
     */
    public void setEndAngle(int endAngle)
    {
        this.endAngle = endAngle;
    }

   

    @Override
    public int getStartAngle()
    {
       return startAngle;
    }

    /**
     * Set the value of startAngle
     *
     * @param startAngle new value of startAngle
     */
    public void setStartAngle(int startAngle)
    {
        this.startAngle = startAngle;
    }

    

   

    public void setEndPostAngle(int endPostAngle)
    {
        this.endPostAngle = endPostAngle;
    }

    public void setStartPostAngle(int startPostAngle)
    {
        this.startPostAngle = startPostAngle;
    }

    public void setPostRadius(float radius)
    {
        this.postRadius = radius;
    }

}
