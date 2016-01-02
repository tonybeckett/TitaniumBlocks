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
package us.jaba.titaniumblocks.core.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

/**
 *
 * @author KC Wong
 */
public class SevenSegmentDisplay extends JPanel
{

    private int x;
    private int y;

    private Polygon[] segments;
    private int[] number;

    /* Constants */
    private final static int SEGMENT_NUMBER = 7;
    private final static int A = 0;
    private final static int B = 1;
    private final static int C = 2;
    private final static int D = 3;
    private final static int E = 4;
    private final static int F = 5;
    private final static int G = 6;

    private final static int OFF = 0;
    private final static int ON = 1;

    private final static int zero[] =
    {
        ON, ON, ON, ON, ON, ON, OFF
    };
    private final static int one[] =
    {
        OFF, ON, ON, OFF, OFF, OFF, OFF
    };
    private final static int two[] =
    {
        ON, ON, OFF, ON, ON, OFF, ON
    };
    private final static int three[] =
    {
        ON, ON, ON, ON, OFF, OFF, ON
    };
    private final static int four[] =
    {
        OFF, ON, ON, OFF, OFF, ON, ON
    };
    private final static int five[] =
    {
        ON, OFF, ON, ON, OFF, ON, ON
    };
    private final static int six[] =
    {
        ON, OFF, ON, ON, ON, ON, ON
    };
    private final static int seven[] =
    {
        ON, ON, ON, OFF, OFF, OFF, OFF
    };
    private final static int eight[] =
    {
        ON, ON, ON, ON, ON, ON, ON
    };
    private final static int nine[] =
    {
        ON, ON, ON, ON, OFF, ON, ON
    };

    private final static Color off = Color.green.darker().darker().darker().darker();
    private final static Color on = Color.green.brighter().brighter().brighter().brighter().brighter();

    public SevenSegmentDisplay()
    {
        Dimension size = new Dimension(110, 180);
        setPreferredSize(size);

        setOpaque(true);
        setBackground(Color.black);

        x = 0;
        y = 0;

        number = zero;

        createSegments();

        number = zero;
    }

    public void writeNumber(int n)
    {
        switch (n)
        {
            case 0:
                number = zero;
                break;
            case 1:
                number = one;
                break;
            case 2:
                number = two;
                break;
            case 3:
                number = three;
                break;
            case 4:
                number = four;
                break;
            case 5:
                number = five;
                break;
            case 6:
                number = six;
                break;
            case 7:
                number = seven;
                break;
            case 8:
                number = eight;
                break;
            case 9:
                number = nine;
                break;
            default: /* other number */

                number = zero;
                break;
        }
    }

    public void doCountUp()
    {
        int i = 0;

        do
        {
            writeNumber(i);

            //paintComponent(getGraphics());
            repaint();

            i++;

            try
            {
                Thread.sleep(300);
            } catch (InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }

            // if (i == 10) i = 0; // reset to 0
        } while (i != 10);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        // System.out.printf("paintComponent\n");

        super.paintComponent(g); // this is needed to set the background color
//        Graphics2D g2 = (Graphics2D) g;
//       
//        AffineTransform orig = g2.getTransform();
//        AffineTransform af = new AffineTransform ();
//        af.rotate(0.025);
//        g2.setTransform(af);       
        for (int i = 0; i < SEGMENT_NUMBER; i++)
        {
            setSegmentState(g, segments[i], number[i]);
        }

        // g2.setTransform(orig);
    }

    private void createSegments()
    {
        segments = new Polygon[SEGMENT_NUMBER];

        segments[A] = new Polygon();
        segments[A].addPoint(x + 20, y + 8);
        segments[A].addPoint(x + 90, y + 8);
        segments[A].addPoint(x + 98, y + 15);
        segments[A].addPoint(x + 90, y + 22);
        segments[A].addPoint(x + 20, y + 22);
        segments[A].addPoint(x + 12, y + 15);

        segments[B] = new Polygon();
        segments[B].addPoint(x + 91, y + 23);
        segments[B].addPoint(x + 98, y + 18);
        segments[B].addPoint(x + 105, y + 23);
        segments[B].addPoint(x + 105, y + 81);
        segments[B].addPoint(x + 98, y + 89);
        segments[B].addPoint(x + 91, y + 81);

        segments[C] = new Polygon();
        segments[C].addPoint(x + 91, y + 97);
        segments[C].addPoint(x + 98, y + 89);
        segments[C].addPoint(x + 105, y + 97);
        segments[C].addPoint(x + 105, y + 154);
        segments[C].addPoint(x + 98, y + 159);
        segments[C].addPoint(x + 91, y + 154);

        segments[D] = new Polygon();
        segments[D].addPoint(x + 20, y + 155);
        segments[D].addPoint(x + 90, y + 155);
        segments[D].addPoint(x + 98, y + 162);
        segments[D].addPoint(x + 90, y + 169);
        segments[D].addPoint(x + 20, y + 169);
        segments[D].addPoint(x + 12, y + 162);

        segments[E] = new Polygon();
        segments[E].addPoint(x + 5, y + 97);
        segments[E].addPoint(x + 12, y + 89);
        segments[E].addPoint(x + 19, y + 97);
        segments[E].addPoint(x + 19, y + 154);
        segments[E].addPoint(x + 12, y + 159);
        segments[E].addPoint(x + 5, y + 154);

        segments[F] = new Polygon();
        segments[F].addPoint(x + 5, y + 23);
        segments[F].addPoint(x + 12, y + 18);
        segments[F].addPoint(x + 19, y + 23);
        segments[F].addPoint(x + 19, y + 81);
        segments[F].addPoint(x + 12, y + 89);
        segments[F].addPoint(x + 5, y + 81);

        segments[G] = new Polygon();
        segments[G].addPoint(x + 20, y + 82);
        segments[G].addPoint(x + 90, y + 82);
        segments[G].addPoint(x + 95, y + 89);
        segments[G].addPoint(x + 90, y + 96);
        segments[G].addPoint(x + 20, y + 96);
        segments[G].addPoint(x + 15, y + 89);
    }

    private void setSegmentState(Graphics graphics, Polygon segment, int state)
    {
        if (state == OFF)
        {
            graphics.setColor(off);
        } else
        {
            graphics.setColor(on);
        }

        graphics.fillPolygon(segment);
        graphics.drawPolygon(segment);
    }

}
