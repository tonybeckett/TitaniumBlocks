/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.font;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author tbeckett
 */
public class FontSupport
{

    private static final Font STANDARD_FONT = new Font("Verdana", 1, 24);
    private static Font digitalFont = null;

    /**
     * Returns the seven segment font "lcd.ttf" if it is available. Usualy it
     * should be no problem because it will be delivered in the package but if
     * there is a problem it will return the standard font which is verdana.
     *
     * @return Font with fontface from lcd.ttf (if available)
     */
    public static Font getDigitalFont()
    {
        if (digitalFont == null)
        {
            digitalFont = STANDARD_FONT;
        }
        return digitalFont.deriveFont(24).deriveFont(Font.PLAIN);
    }

    /**
     * Returns the standard font which is verdana.
     *
     * @return Font that is defined as standard
     */
    public static Font getStandardFont()
    {
        return STANDARD_FONT;
    }

    public static void main(String[] args)
    {
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (int i = 0; i < fonts.length; i++)
        {
            System.out.println(fonts[i]);
        }
    }

}
