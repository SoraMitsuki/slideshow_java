/* Filename: Picture.java 
 * 
 * Created by:  Zinuo Xie, cs8afbfa and Jiaqi Fan, cs8afbct
 * 
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
/**
 * 
 * A class that represents a picture.  This class inherits from 
 * 
 * SimplePicture and allows the student to add functionality to
 * 
 * the Picture class.  
 * 
 * 
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * 
 */
public class Picture extends SimplePicture   
{  
  ///////////////////// constructors //////////////////////////////////  
  /**
   * 
   * Constructor that takes no arguments 
   * 
   */  
  public Picture ()    
  {    
    /* not needed but use it to show students the implicit call to super()
     * 
     * child constructors always call a parent constructor 
     * 
     */    
    super();     
  }
  /**
   * 
   * Constructor that takes a file name and creates the picture 
   * 
   * @param fileName the name of the file to create the picture from
   * 
   */  
  public Picture(String fileName)    
  {    
    // let the parent class handle this fileName    
    super(fileName);    
  }  
  /**
   * 
   * Constructor that takes the width and height
   * 
   * @param width the width of the desired picture
   * 
   * @param height the height of the desired picture
   * 
   */
  public Picture(int width, int height)    
  {    
    // let the parent class handle this width and height    
    super(width,height);    
  }
 /**
   * 
   * Constructor that takes a picture and creates a 
   * 
   * copy of that picture
   * 
   */  
  public Picture(Picture copyPicture)    
  {    
    // let the parent class do the copy    
    super(copyPicture);    
  }
  /**
   * 
   * Constructor that takes a buffered image
   * 
   * @param image the buffered image to use
   * 
   */ 
  public Picture(BufferedImage image)   
  {    
    super(image);    
  }
///////////////////// methods ///////////////////////////////////////
  /**
   * 
   * Method to return a string with information about this picture.
   * 
   * @return a string with information about the picture such as fileName,
   * 
   * height and width.
   * 
   */
  public String toString()   
  {   
    String output = "Picture, filename " + getFileName() +      
      " height " + getHeight()     
      + " width " + getWidth();   
    return output;  
  }  
  /**
   * 
   * Horizontal flip method
   * 
   * In this method, I've given you the basic structure of how things will look.  There are a few incomplete assignments inside of the method.  It is your job to figure out how to complete those assignments!
   * 
   * This method works almost like the horizontal mirroring method you saw in your text book (pg 135), but instead of mirroring on the middle of the image, we want to flip it all the way.
   * 
   * Hint: Why do we need tempColor in this case?  I encourage you to reflect on this question if you find your method not working the way it should!**/ 
  public void flipHorizontal()    
  {    
    Color tempColor;    
    Color tempColor2;
    int limit1 = this.getHeight();    
    int limit2 = this.getWidth();    
    Pixel pix1 = null;    
    Pixel pix2 = null;   
    for(int i = 0; i < limit1; i++)      
    {      
      for(int j = 0; j < limit2/2; j++) //divide picture into half and copy paste pixel on 2 sides        
      {        
        pix1 = getPixel(j,i);        
        tempColor = pix1.getColor(); //get the beginning pixel color and set to the end        
        pix2 = getPixel(limit2-1-j,i);        
        tempColor2 = pix2.getColor(); //get the ending pixel color and set to the beginning       
        pix1.setColor(tempColor2);        
        pix2.setColor(tempColor);        
      }      
    }   
    //After you store away your pixel colors...call setColor() here on the appropriate pixels and flip the picture!    
  }  
  /**
   * 
   * Vertical flip method
   * 
   **/  
  public void flipVertical()    
  {    
    Color tempColor;    
    Color tempColor2;    
    int limit1 = this.getHeight();    
    int limit2 = this.getWidth();    
    Pixel pix1 = null;    
    Pixel pix2 = null;    
    for(int j = 0; j < limit2; j++)      
    {      
      for(int i = 0; i < limit1/2; i++)        
      {
        pix1 = getPixel(j,i);        
        tempColor = pix1.getColor();        
        pix2 = getPixel(j,limit1-1-i);        
        tempColor2 = pix2.getColor();        
        pix1.setColor(tempColor2);        
        pix2.setColor(tempColor);        
      }      
    }    
  }  
  /**
   * 
   * Grayscale method **/  
  public void grayscale()    
  {
    int limit1 = this.getHeight();    
    int limit2 = this.getWidth();   
    Pixel pixel = null;   
    int value;   
    for(int i = 0; i < limit1; i++)     
    {    
      for(int j = 0; j < limit2; j++)        
      {       
        pixel = getPixel(j,i);       
        value = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3; //get addtion of RGB color value and /3 to get gray         
        pixel.setRed(value);       
        pixel.setGreen(value);       
        pixel.setBlue(value);        
      }      
    }    
  }
  /**The collage method
    * 
    * This method will create the collage of your modified pictures.  
    * 
    * Hint 1: Inside of the for loop here will be another 2 nested for loops, giving you a grand total of 3 nested for loops in this method
    * 
    * Hint 2: If you're clever about the way you decide to draw your pixels onto the canvas, you may only have to write ONE LINE OF CODE inside the inner-most for loop to achieve the desired collage effect!
    * 
    * However, more than one line inside of the nested for loops is perfectly fine, of course! **/
  
  public void collage(Picture [] pictures)   
  {  
    int height = pictures[0].getHeight();   
    int width = pictures[0].getWidth();   
    Pixel pixel, origin;    
    for(int i = 0; i < pictures.length; i++)     
    {      
      for(int j = 0; j < height; j++) {        
        for(int k = 0; k < width; k++) {
          pixel = getPixel( k + i * width, j);         
          origin = pictures[i].getPixel(k, j);         
          pixel.setColor(origin.getColor());          
        }        
      }      
    }   
  }
  public void flipVerticalSquare(int x, int y, int length)
  {
    Color tempColor;    
    Color tempColor2;    
    Pixel topPixel, botPixel = null;     
    for(int i = x; i < x + length; i++)
    {
      int n = 0;
      for(int j = y; j > y - (length / 2); j--)
      {
        botPixel = this.getPixel(i, j);//get the bottom half pixels
        tempColor = botPixel.getColor();
        topPixel = this.getPixel(i, j - length + (n * 2));//get the top half pixels
        tempColor2 = topPixel.getColor();
        botPixel.setColor(tempColor2);
        topPixel.setColor(tempColor);
        n++;
      }
    }
  }  
  public void flipHorizontalSquare(int x, int y, int length)
  {
    Color tempColor;    
    Color tempColor2;    
    Pixel leftPixel, rightPixel = null; 
    
    for(int i = y; i > y - length; i--)
    {
      int n = 0;
      for(int j = x; j < x + (length / 2); j++)
      {
        leftPixel = this.getPixel(j, i);
        tempColor = leftPixel.getColor();
        rightPixel = this.getPixel(j + length - (n * 2), i);
        tempColor2 = rightPixel.getColor();
        leftPixel.setColor(tempColor2);
        rightPixel.setColor(tempColor);
        n++;
      }
    }
  }
}





// this } is the end of class Picture, put all new methods before this



