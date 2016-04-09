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
package us.jaba.titaniumblocks.core.lcd.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreBean;
import us.jaba.titaniumblocks.core.lcd.SixteenSegmentCharImageFactory;

/**
 *
 * @author tbeckett
 */
public class SixteenSegmentDisplay extends CoreBean
{

    private final int numberOfCharacters;
    private final List<SixteenSegmentCharImageFactory> segments = new ArrayList();
    
    
    public SixteenSegmentDisplay(int numOfChar)
    {
        numberOfCharacters = numOfChar;

        for (int i = 0; i < numberOfCharacters; i++)
        {
            SixteenSegmentCharacter ssc = new SixteenSegmentCharacter();
            SixteenSegmentCharImageFactory ssci = new SixteenSegmentCharImageFactory(ssc);
            segments.add(ssci);
        }
    }

    public void setSegmentColor(Color textColor)
    {
         Iterator<SixteenSegmentCharImageFactory> i = segments.iterator();
//        int count = 0;
        while (i.hasNext())
        {
            SixteenSegmentCharImageFactory ssci = i.next();
            ssci.getPainter().setSegmentColor(textColor);
        }
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        Dimension segmentDimension = new Dimension( (int)((double)dimensions.getWidth() / (double) numberOfCharacters), (int) dimensions.getHeight());
        Iterator<SixteenSegmentCharImageFactory> i = segments.iterator();
        int count = 0;
        while (i.hasNext())
        {
            SixteenSegmentCharImageFactory ssci = i.next();
            int startX = (int) ((float) count * dimensions.getWidth() / (float) numberOfCharacters);
            BufferedImage image = ssci.build(segmentDimension);
            graphics.drawImage(image, startX, 0, null);
            count++;
        }

    }

    public int getNumberOfCharacters()
    {
        return numberOfCharacters;
    }

    public void setStringValue(String value)
    {
        
        int len = value.length();
        for( int i = 0; i < len; i++)
        {
            byte c = value.getBytes()[i];
            segments.get(i).getPainter().setCharacter((char) c);
        }
    }

    
    
}
