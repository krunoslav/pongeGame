/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ponge.cubis;

import com.jme3.math.Line;
import com.jme3.math.Vector3f;
import java.text.Format;
import java.util.Formatter;

/**
 *
 * @author kruno
 */
public class PlainTest {
    
     public static void main(String[] args) {
    long a= 1;
         Formatter formatter = new Formatter();
         Formatter f = formatter.format("%02d:%02d",5,2);
     String b=   f.toString();
    
     
      System.out.println(b);
     }
    
}
