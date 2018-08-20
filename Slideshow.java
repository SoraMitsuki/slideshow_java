import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; 
import java.io.*;
import java.util.Random;

public class Slideshow
{
  private Slide[] slides;
  private double probFlip;

//////////constructors//////////
  
  public Slideshow(){
    slides = new Slide[0];
    probFlip = 0.5;
  }
  
  public Slideshow(double inProb){
    this.probFlip = inProb;
    slides = new Slide[0];
  }

///////// mutator method/////////

  public void changeProbFlip(double inProb){
  if (inProb > 0 || inProb < 1){
  this.probFlip = inProb;
  }
  else {
  System.out.println("Inappropriate value for probFlip");
  }
  }

//////////method//////////
  public void addSlide(Slide inSlide){
      Slide[] slides1 = new Slide[this.slides.length + 1];
    for (int i = 0; i < this.slides.length; i++){
      slides1[i] = this.slides[i];
    }
    slides1[slides1.length - 1] = inSlide;
    this.slides = slides1;
    }
  
  
  public void changeSlide(Slide inSlide, int slideToChange){
    if (slideToChange > this.slides.length){
    System.out.println("Error! out of Bound!");
    }
    else {
      for (int i = 0; i < this.slides.length; i++){
        if (i == (slideToChange - 1)){
        this.slides[i] = inSlide;
        }
        }
      }
    }

  public void show(){
    if (this.slides == null || this.slides.length == 0){
    System.out.println("Error! slide show is empty");
    }
    else {
      if (this.probFlip > 0 || this.probFlip < 1){
      Random numGen = new Random();
      for (int i = 0; i < this.slides.length; i++){
        double test = numGen.nextDouble();
        boolean flipHorV;
        if (test < probFlip){
        flipHorV = true;
        }
        else{
        flipHorV = false;
        }
        slides[i].showSlide(flipHorV);
      }
      }
    }
  
  }


  public static void main(String [] args){
  Slideshow slideS = new Slideshow(0.7);
  
  Picture pic1 = new Picture(FileChooser.getMediaPath("pic1.jpg"));
  Picture pic2 = new Picture(FileChooser.getMediaPath("pic2.jpg"));
  Picture pic3 = new Picture(FileChooser.getMediaPath("pic3.jpg"));
  Picture pic4 = new Picture(FileChooser.getMediaPath("pic4.jpg"));
  Picture pic5 = new Picture(FileChooser.getMediaPath("pic5.jpg"));
  Picture pic6 = new Picture(FileChooser.getMediaPath("pic6.jpg"));
  
  Sound sound1 = new Sound (FileChooser.getMediaPath("sound1.wav"));
  Sound sound2 = new Sound (FileChooser.getMediaPath("sound2.wav"));
  Sound sound3 = new Sound (FileChooser.getMediaPath("sound3.wav"));
  Sound sound4 = new Sound (FileChooser.getMediaPath("sound4.wav"));
  Sound sound5 = new Sound (FileChooser.getMediaPath("sound5.wav"));
  
  Slide slide1 = new Slide(pic1, sound1);
  Slide slide2 = new Slide(pic2, sound2);
  Slide slide3 = new Slide(pic3, sound3);
  Slide slide4 = new Slide(pic4, sound4);
  Slide slide5 = new Slide(pic5, sound5);
  Slide slide6 = new Slide(pic6, sound2);
  
  slideS.addSlide(slide1);
  slideS.addSlide(slide2);
  slideS.addSlide(slide3);
  slideS.addSlide(slide4);
  slideS.addSlide(slide5);
 
  slideS.changeSlide(slide6,2);  
  slideS.show();
  }












}