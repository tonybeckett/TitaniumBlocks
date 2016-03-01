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
package us.jaba.titaniumblocks.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.Images;
import us.jaba.titaniumblocks.core.color.ColorPalette;

/**
 *
 * @author tbeckett
 */
public class BasicVerticalViewer extends javax.swing.JFrame
{
    protected Color backgroundColor = ColorPalette.BLACK;
    protected Color foregroundColor = ColorPalette.WHITE;
    protected JScrollPane jScrollPane1 = new JScrollPane();
    protected JPanel list = new JPanel();
    protected GridLayout gl = new GridLayout();

    protected Dimension imageDim;

    public BasicVerticalViewer()
    {
        imageDim = new Dimension(200, 200);
    }

    protected BufferedImage getImageFromInstance(Object next, Dimension iDim)
    {
        return null;
    }

    protected String getClassNameFromInstance(Object o)
    {
        return "";
    }

    protected JPanel buildPanel(Object o)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel jlabel = new JLabel();

        try
        {
            jlabel.setText(getClassNameFromInstance(o));
            jlabel.setVerticalTextPosition(JLabel.BOTTOM);
            jlabel.setHorizontalTextPosition(JLabel.CENTER);
            jlabel.setIcon(new ImageIcon(getImageFromInstance(o, imageDim)));

            jlabel.setForeground(foregroundColor);
            jlabel.setBackground(ColorPalette.GRAY.brighter());

            panel.setBackground(backgroundColor);
            panel.add(jlabel, BorderLayout.CENTER);
            panel.setBorder(new LineBorder(Color.BLACK));
        } catch (Exception exp)
        {
        }
        return panel;
    }

    protected void init(String title, Dimension dim, List instances)
    {

        imageDim = dim;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(CoreInfoSupport.TITANIUM_BLOCKS + " - " + title);
        list.setLayout(gl);
        this.setLayout(new BorderLayout());

        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        int len = instances.size();

        gl.setRows(len);

        Iterator i = instances.iterator();

        while (i.hasNext())
        {
            Object o = i.next();
            list.add(buildPanel(o));

        }

        jScrollPane1.setViewportView(list);

        add(jScrollPane1, BorderLayout.CENTER);

        this.setSize(
                new Dimension(400, 800));

        this.setIconImage(Images.titaniumblocks16x16);
    }

}
