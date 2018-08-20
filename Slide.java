import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; 
import java.io.*;

public class Slide
{
  public Picture pic;
  public Sound sound;
/////////constructor//////////
  public Slide(){
    this.pic = null;
    this.sound = null;
  }
  
  public Slide(Picture inPic, Sound inSound){
    this.pic = inPic;
    this.sound = inSound;
  }
  
//////////muator method//////////
  public void changePic(Picture inPic){
    this.pic = inPic;
  }
  
  public void changeSound(Sound inSound){
    this.sound = inSound;
  }
//////////method///////////  
 public void showSlide(boolean flipHorizontal){
    if ( pic == null){
      System.out.println("Error pic is null");
    }
    else if (sound == null){
      System.out.println("Error sound is null");
    }
    else {
      Picture copy = new Picture (this.pic);
    if (flipHorizontal == true){
      copy.flipHorizontal();
    }
    else {
      copy.flipVertical();
    } 
      copy.show();
      sound.blockingPlay();
      copy.hide();
    }
  } 
}