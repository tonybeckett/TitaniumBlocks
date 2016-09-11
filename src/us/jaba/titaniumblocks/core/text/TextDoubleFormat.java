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
package us.jaba.titaniumblocks.core.text;

import java.text.DecimalFormatSymbols;

/**
 *
 * @author tbeckett
 */
public class TextDoubleFormat
{

    private boolean scientificFormat = false;
    private int numOfDecimals = 2;
    private final DecimalFormatSymbols dfs = new DecimalFormatSymbols(java.util.Locale.US);
    
    public String format(final double value)
    {
        
        final StringBuilder buffer = new StringBuilder(16);
        buffer.append("0");

        if (getNumOfDecimals()  > 0)
        {
            buffer.append(".");
        }

        for (int i = 0; i < getNumOfDecimals(); i++)
        {
            buffer.append("0");
        }

        if ( isScientificFormat())
        {
            buffer.append("E0");
        }
        buffer.trimToSize();
        final java.text.DecimalFormat format = new java.text.DecimalFormat(buffer.toString(), dfs);

        return format.format(value);
    }

    public boolean isScientificFormat()
    {
        return scientificFormat;
    }

    public void setScientificFormat(boolean scientificFormat)
    {
        this.scientificFormat = scientificFormat;
    }

    public int getNumOfDecimals()
    {
        return numOfDecimals;
    }

    public void setNumOfDecimals(int numOfDecimals)
    {
        this.numOfDecimals = numOfDecimals;
    }
    
    
}
