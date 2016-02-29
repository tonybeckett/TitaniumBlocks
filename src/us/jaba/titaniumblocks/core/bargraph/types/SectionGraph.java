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
package us.jaba.titaniumblocks.core.bargraph.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import us.jaba.titaniumblocks.core.bargraph.AbstractBargraph;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.sections.ColorSection;
import us.jaba.titaniumblocks.core.sections.types.LinearSection;

/**
 *
 * @author tbeckett
 */
public class SectionGraph extends AbstractBargraph
{

    private int activeSegments = 20;

    private List<Shape> bargraph = new ArrayList();
    private Color color = ColorPalette.BLACK;
    private double value = 0.0;
    private boolean plainBargraphSegments = false;
    private List<LinearSection> sections = new ArrayList();

    public int getActiveSegments()
    {
        return activeSegments;
    }

    public void setActiveSegments(int activeSegments)
    {
        this.activeSegments = activeSegments;
    }

    public List<Shape> getBargraph()
    {
        return bargraph;
    }

    public void setBargraph(List<Shape> bargraph)
    {
        this.bargraph = bargraph;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public boolean isPlainBargraphSegments()
    {
        return plainBargraphSegments;
    }

    public void setPlainBargraphSegments(boolean plainBargraphSegments)
    {
        this.plainBargraphSegments = plainBargraphSegments;
    }

    public List<LinearSection> getSections()
    {
        return sections;
    }

    public void setSections(List<LinearSection> sections)
    {
        this.sections = sections;
    }

    @Override
    protected void paintBargraph(Graphics2D graphics, Dimension dimensions)
    {
        final int IMAGE_WIDTH = (int) dimensions.getWidth();
        final int IMAGE_HEIGHT = (int) dimensions.getHeight();

        double x = 0.1171875 * IMAGE_WIDTH;
        double y = 0.8125 * IMAGE_HEIGHT;
        double w = 0.0234375 * IMAGE_WIDTH;
        double h = 0.125 * IMAGE_HEIGHT;

        final Rectangle2D SEG1 = new Rectangle2D.Double(x, y, w, h);
        x = x + 0.0390625;

        final Rectangle2D SEgraphics = new Rectangle2D.Double( x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG3 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG4 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG5 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG6 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG7 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG8 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG9 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG10 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG11 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG12 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG13 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG14 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;
        final Rectangle2D SEG15 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG16 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG17 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG18 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEG19 = new Rectangle2D.Double(x, y, w, h);
         x = x + 0.0390625;

        final Rectangle2D SEgraphics0 = new Rectangle2D.Double(x, y, w, h);
        

        bargraph.clear();
        bargraph.add(SEG1);
        bargraph.add(SEgraphics);
        bargraph.add(SEG3);
        bargraph.add(SEG4);
        bargraph.add(SEG5);
        bargraph.add(SEG6);
        bargraph.add(SEG7);
        bargraph.add(SEG8);
        bargraph.add(SEG9);
        bargraph.add(SEG10);
        bargraph.add(SEG11);
        bargraph.add(SEG12);
        bargraph.add(SEG13);
        bargraph.add(SEG14);
        bargraph.add(SEG15);
        bargraph.add(SEG16);
        bargraph.add(SEG17);
        bargraph.add(SEG18);
        bargraph.add(SEG19);
        bargraph.add(SEgraphics0);

        for (int i = 0; i < 20; i++)
        {
            if (i < activeSegments)
            {
                if (!sections.isEmpty())
                {
                    for (int j = 0; j < sections.size(); j++)
                    {
                        if (Double.compare(value, sections.get(j).getStart()) >= 0 && Double.compare(value, sections.get(j).getStop()) <= 0)
                        {
                            Paint fill;
                            if (plainBargraphSegments)
                            {
                                fill = sections.get(j).getColor();
                            } else
                            {
                                fill = new RadialGradientPaint((float) bargraph.get(i).getBounds2D().getCenterX(), (float) bargraph.get(i).getBounds2D().getCenterY(), (float) bargraph.get(i).getBounds2D().getWidth() / 2, new float[]
                                {
                                    0.0f, 1.0f
                                }, new Color[]
                                {
                                    sections.get(j).getColor().brighter(), sections.get(j).getColor().darker()
                                });
                            }
                            graphics.setPaint(fill);
                            break;
                        } else
                        {
                            graphics.setPaint(color);
                        }
                    }
                } else
                {
                    graphics.setPaint(color);
                }
                graphics.fill(bargraph.get(i));
            }
        }

    }

}
