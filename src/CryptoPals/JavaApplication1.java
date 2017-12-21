/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CryptoPals;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.DatatypeConverter;
import sun.java2d.loops.XORComposite;


/**
 *
 * @author avald
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //SET 1 CHALLENGE 1
        /*
        String hexString = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
        challenge1(hexString);
        */
        
        //SET 1 CHALLENGE 2
        /*
        String s1 = "1c0111001f010100061a024b53535009181c";
        String s2 = "686974207468652062756c6c277320657965";
        challenge2(s1, s2);
        */
        
        //SET 1 CHALLENGE 3
        /*
        String s1 = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        challegne3(s1);
        */
        
        //SET 1 CHALLENGE 4
        /*
        challenge(4);
        */
        
        //SET 1 CHALLENGE 5
        /*
        String text = "Burning 'em, if you ain't quick and nimble I go crazy when I hear a cymbal";
        challenge5(text);
        */
        
        //SET 1 CHALLENGE 6
        String s1 = "this is a test";
        String s2 = "wokka wokka!!!";
        
        
        System.out.println(s1.getBytes().length);
        System.out.println(s2.getBytes().length);
        
        System.out.println(getHammingDistance(s2, s1));
        
    }
    
    public static void challenge1(String hexString){
        byte[] hex = DatatypeConverter.parseHexBinary(hexString);
        System.out.println(new String(hex));
        String base64 = Base64.getEncoder().encodeToString(hex);
        System.out.println(base64);
    }
    
    public static void challenge2(String s1, String s2){
        byte [] s1_b = DatatypeConverter.parseHexBinary(s1);
        byte [] s2_b = DatatypeConverter.parseHexBinary(s2);
        
        for(int i = 0; i < s1_b.length; i++){
            s1_b[i] = (byte) (s1_b[i] ^ s2_b[i]);
        }
        
        System.out.println(new String(s1_b));
        System.out.println(DatatypeConverter.printHexBinary(s1_b));
        
    }
    
    public static void challenge3(String s1){
        byte [] s1_b;
        String pattern = "(^[\\w]([\\w,'\"()]{1,}[\\s]{0,1})+$)";
        Pattern r = Pattern.compile(pattern);
        Matcher m;
        
        for(char a = 0; a < 128; a++){
            s1_b = DatatypeConverter.parseHexBinary(s1);
            for(int i = 0; i < s1_b.length; i++){
                s1_b[i] = (byte) (s1_b[i] ^ (byte) a);
            }
            String text = new String(s1_b);
            if(r.matcher(text).find())
                System.out.println(text + "  " + a);
        }
        
    }
    
    public static void challenge4() throws FileNotFoundException{
        Scanner scan = new Scanner(new File("/home/avald/NetBeansProjects/JavaApplication1/src/javaapplication1/4.txt"));
        
        while(scan.hasNext()){
            String s1 = scan.next();
            byte [] s1_b;
            String pattern = "(^[\\w]([\\w,'\"()]{1,}[\\s]{0,1})+$)";
            Pattern r = Pattern.compile(pattern);
            Matcher m;
            for(char a = 1; a < 128; a++){
                s1_b = DatatypeConverter.parseHexBinary(s1);
                for(int i = 0; i < s1_b.length; i++){
                    s1_b[i] = (byte) (s1_b[i] ^ (byte) a);
                }
                String text = new String(s1_b);
                if(r.matcher(text).find())
                    System.out.println(text);
            }
        }
        
    }
    
    public static void challenge5(String text){
        byte[] ICE = "ICE".getBytes(StandardCharsets.UTF_8);
        byte [] s1 = text.getBytes(StandardCharsets.UTF_8);
        //byte [] s1 = DatatypeConverter.parseHexBinary("Burning 'em, if you ain't quick and nimble I go crazy when I hear a cymbal");
        
        for(int i = 0; i < s1.length; i++){
            s1[i] = (byte) (s1[i] ^ ICE[i%ICE.length]);
        }
        System.out.println(DatatypeConverter.printHexBinary(s1));
        
    }
    
    public static void challenge6(){
    
    }
    
    public static int getHammingDistance(String sequence1, String sequence2) {
        char[] s1 = sequence1.toCharArray();
        char[] s2 = sequence2.toCharArray();

        int shorter = Math.min(s1.length, s2.length);
        int longest = Math.max(s1.length, s2.length);

        int result = 0;
        for (int i=0; i<shorter; i++) {
            if (s1[i] != s2[i]) result++;
        }

        result += longest - shorter;

        return result;
    }
    
}
