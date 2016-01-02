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
package us.jaba.titaniumblocks.core.time;

/**
 *
 * @author tbeckett
 */
public class TimeModel
{
    public static final long DEFAULT_MIN_TIME_TO_VALUE = 250;
    public static final long DEFAULT_MAX_TIME_TO_VALUE = 5000;
    public static final long DEFAULT_TIME_TO_VALUE = 800;
    public static final long DEFAULT_AUTO_RETURN_TIME_TO_VALUE = 800;
    public static final long DEFAULT_AUTO_RETURN_TIME_TO_ZERO = 1200;
    
    private long timeToValue;
    private long autoReturnTimeToValue;
    private long autoReturnTimeToZero;

    public TimeModel()
    {
        timeToValue = DEFAULT_TIME_TO_VALUE;
        autoReturnTimeToValue = DEFAULT_AUTO_RETURN_TIME_TO_VALUE;
        autoReturnTimeToZero = DEFAULT_AUTO_RETURN_TIME_TO_ZERO;
    }

    private long getSetValue(long value, long low, long high)
    {
        long answer = value;
        if ( value < low)
        {
            answer = low;
        }
        if( value > high)
        {
            answer = high;
        }
        
        return answer;
    }
    /**
     * Get the value of autoReturnTimeToZero
     *
     * @return the value of autoReturnTimeToZero
     */
    public long getAutoReturnTimeToZero()
    {
        return autoReturnTimeToZero;
    }

    /**
     * Set the value of autoReturnTimeToZero
     *
     * @param autoReturnTimeToZero new value of autoReturnTimeToZero
     */
    public void setAutoReturnTimeToZero(long autoReturnTimeToZero)
    {
        this.autoReturnTimeToZero = getSetValue( autoReturnTimeToZero, DEFAULT_MIN_TIME_TO_VALUE, DEFAULT_MAX_TIME_TO_VALUE);
    }

    /**
     * Get the value of autoReturnTimeToValue
     *
     * @return the value of autoReturnTimeToValue
     */
    public long getAutoReturnTimeToValue()
    {
        return autoReturnTimeToValue;
    }

    /**
     * Set the value of autoReturnTimeToValue
     *
     * @param autoReturnTimeToValue new value of autoReturnTimeToValue
     */
    public void setAutoReturnTimeToValue(long autoReturnTimeToValue)
    {
        this.autoReturnTimeToValue = getSetValue( autoReturnTimeToValue, DEFAULT_MIN_TIME_TO_VALUE, DEFAULT_MAX_TIME_TO_VALUE);
    }

    /**
     * Get the value of timeToValue
     *
     * @return the value of timeToValue
     */
    public long getTimeToValue()
    {
        return timeToValue;
    }

    /**
     * Set the value of timeToValue
     *
     * @param timeToValue new value of timeToValue
     */
    public void setTimeToValue(long timeToValue)
    {
        this.timeToValue = getSetValue( timeToValue, DEFAULT_MIN_TIME_TO_VALUE, DEFAULT_MAX_TIME_TO_VALUE);
    }

}
