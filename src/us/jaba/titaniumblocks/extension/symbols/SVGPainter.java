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
package us.jaba.titaniumblocks.extension.symbols;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.net.URL;
import org.apache.batik.gvt.GraphicsNode;
import us.jaba.titaniumblocks.core.symbols.Symbol;

/**
 *
 * @author tbeckett
 */
public class SVGPainter extends Symbol
{

    private final GraphicsNode svg;
    URL url;

    public SVGPainter(URL url)
    {
        this.url = url;
        svg = getSvgIcon(url);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        graphics.setColor(this.getPaintColor());

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

        SVGPainter.paintSvgIcon(graphics, svg, imageWidth / 3, imageHeight / 3, 10.0, 10.0);
    }

    @Override
    protected void paintSymbol(GeneralPath path, Dimension dimensions)
    {

    }

    /**
     * Method to fetch the SVG icon from a url
     *
     * @param url the url from which to fetch the SVG icon
     *
     * @return a graphics node object that can be used for painting
     */
    public static org.apache.batik.gvt.GraphicsNode getSvgIcon(java.net.URL url)
    {
        org.apache.batik.gvt.GraphicsNode svgIcon = null;
        try
        {
            String xmlParser = org.apache.batik.util.XMLResourceDescriptor.getXMLParserClassName();
            org.apache.batik.dom.svg.SAXSVGDocumentFactory df = new org.apache.batik.dom.svg.SAXSVGDocumentFactory(xmlParser);
            org.w3c.dom.svg.SVGDocument doc = df.createSVGDocument(url.toString());
            org.apache.batik.bridge.UserAgent userAgent = new org.apache.batik.bridge.UserAgentAdapter();
            org.apache.batik.bridge.DocumentLoader loader = new org.apache.batik.bridge.DocumentLoader(userAgent);
            org.apache.batik.bridge.BridgeContext ctx = new org.apache.batik.bridge.BridgeContext(userAgent, loader);
            ctx.setDynamicState(org.apache.batik.bridge.BridgeContext.DYNAMIC);
            org.apache.batik.bridge.GVTBuilder builder = new org.apache.batik.bridge.GVTBuilder();
            svgIcon = builder.build(ctx, doc);
        } catch (Exception excp)
        {
            svgIcon = null;
            excp.printStackTrace();
        }
        return svgIcon;
    }

    /**
     * Method to paint the icon using Graphics2D. Note that the scaling factors
     * have nothing to do with the zoom operation, the scaling factors set the
     * size your icon relative to the other objects on your canvas.
     *
     * @param g the graphics context used for drawing
     *
     * @param svgIcon the graphics node object that contains the SVG icon
     * information
     *
     * @param x the X coordinate of the top left corner of the icon
     *
     * @param y the Y coordinate of the top left corner of the icon
     *
     * @param scaleX the X scaling to be applied to the icon before drawing
     *
     * @param scaleY the Y scaling to be applied to the icon before drawing
     */
    public static void paintSvgIcon(java.awt.Graphics2D g, org.apache.batik.gvt.GraphicsNode svgIcon, int x, int y, double scaleX, double scaleY)
    {
        java.awt.geom.AffineTransform transform = new java.awt.geom.AffineTransform(scaleX, 0.0, 0.0, scaleY, x, y);
        svgIcon.setTransform(transform);

        svgIcon.paint(g);
    }

}
