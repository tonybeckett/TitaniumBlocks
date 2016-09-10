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

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tbeckett
 */
public class BeanIO<T>
{

    public void storeToFile(T obj, String s) throws FileNotFoundException
    {
        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(s)));

        encoder.writeObject(obj);

        encoder.close();
    }

    public  T loadFromFile(String s)
    {
        FileInputStream fis = null;
        T obj = null;
        try
        {
            fis = new FileInputStream(s);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            obj = (T) xmlDecoder.readObject();

        } catch (FileNotFoundException ex)
        {
          //  Logger.getLogger(BeanIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                if (fis != null)
                {
                    fis.close();
                }
            } catch (IOException ex)
            {
                Logger.getLogger(BeanIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return obj;
    }

   
}
