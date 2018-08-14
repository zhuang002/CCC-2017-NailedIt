/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nailedit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author zhuan
 */
public class NailedIt {

    static Map<Integer,Integer> heights=new HashMap();
    static Map<Integer,Integer> fenceHeights=new HashMap();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            String[] tokens=line.split(" ");
            for (String token:tokens) {
                int height=Integer.parseInt(token);
                if (!heights.containsKey(height)) {
                    heights.put(height, 1);
                } else {
                    heights.put(height, heights.get(height)+1);
                }
            }
            
            int size=heights.keySet().size();
            Object[] heightArray=heights.keySet().toArray();
            
            for (int i=0;i<size;i++) {
                int height1=(int)heightArray[i];
                for (int j=i;j<size;j++) {
                    int height2=(int)heightArray[j];
                    int fenceHeight=height1+height2;
                    int length;
                    if (height1==height2) {
                        length=heights.get(height1)/2;
                    } else {
                        length=Math.min(heights.get(height1),heights.get(height2));
                    }
                    if (fenceHeights.containsKey(fenceHeight)) {
                        fenceHeights.put(fenceHeight, fenceHeights.get(fenceHeight)+length);
                    } else {
                        fenceHeights.put(fenceHeight, length);
                    }
                }
            }
            int maxLength=0;
            int options=0;
            for (Integer key:fenceHeights.keySet()) {
                int length=fenceHeights.get(key);
                if (maxLength<length) {
                    maxLength=length;
                    options=1;
                } else if (maxLength==length) {
                    options++;
                }
            }
            
            System.out.println(maxLength+" "+options);
        } catch (Exception e) {
            System.out.println("Input Error.");
        }
    }
    
}
