/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.text;

/**
 *
 * @author tbeckett
 */
public class StringSupport
{

    public static String valueToScientificText(final String UNIT, final int PRECISION, final double VALUE)
    {
        int precision = PRECISION < 0 ? 0 : PRECISION;
        String format = "%." + precision + "f";
        String formatAlt = "%." + precision + "e";
        double divisor[] =
        {
            100, 10, 1000, 100, 10
        }; // (-2 -- +2)
        final String PREFIX[] =
        {
            " y", " y", " y", " z", " z", " z", " a",
            " a", " a", " t", "  t", " t", " f", " f", " f", " n", " n",
            " n", " µ", " µ", " µ", " m", " m", " m", " ", " ", " ", " k",
            " k", " k", " M", " M", " M", " G", " G", " G", " T", " T",
            " T", " P", " P", " P", " E", " E", " E", " Z", " Z", " Z",
            " Y", " Y", " Y"
        };
        int deca;
        int decade;
        double m;
        double y;
        double mantisse;
        String formatedResult;

        if (VALUE != 0)
        {
            if (VALUE < 0)
            {
                y = Math.log10(-VALUE);
            } else
            {
                y = Math.log10(VALUE);
            }
            decade = (int) Math.round(y);
            m = y - decade;
            mantisse = 1000 * Math.pow(10, m);
            deca = decade % 3 + 2;
            mantisse /= divisor[deca];
            if (decade >= -24 && decade <= 24)
            {
                formatedResult = String.format(format, mantisse) + PREFIX[decade + 24] + UNIT;
            } else
            {
                formatedResult = String.format(formatAlt, mantisse);
            }
        } else
        {
            formatedResult = "0" + UNIT;
        }
        if (VALUE < 0)
        {
            formatedResult = '-' + formatedResult;
        }

        return formatedResult;
    }
}
