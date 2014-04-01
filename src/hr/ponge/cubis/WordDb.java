/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ponge.cubis;

import java.util.Random;

/**
 *
 * @author kruno
 */
public class WordDb {
    
    public static String[] data=new String[]{"ANA"
    ,"GOL"
    ,"ŽAO"
    ,"NOGA"
    ,"PERO"
    };
    public static String getRandomWord(){
        int seed=data.length;
        int rnd = randInt(0, seed-1);
        return data[rnd];
        
    }
    
    
    public static int randInt(int min, int max) {

    // Usually this can be a field rather than a method variable
        Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
    
    
    public static String convertForScreen(String in){
        in=in.replaceAll("Č", "[");
        in=in.replaceAll("Ć", "]");
        in=in.replaceAll("Ž", "@");
        in=in.replaceAll("Š", "{");
        in=in.replaceAll("Đ", "}");
       
        return in;
    }
    
    public static String convertBackFromScreen(String in){
        in=in.replaceAll( "\\[","Č");
        in=in.replaceAll( "]","Ć");
        in=in.replaceAll( "@","Ž");
        in=in.replaceAll( "\\{","Š");
        in=in.replaceAll( "\\}","Đ");
       
        return in;
    }
    
}
