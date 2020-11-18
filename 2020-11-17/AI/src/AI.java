import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
Image img,downImg,leftImg,rightImg,upImg,currentImg;
Image downImg1,leftImg1,rightImg1,upImg1;
int x=110,y=240;
public MainCanvas(){
try
{
     img=Image.createImage("/sayo10.png");
     leftImg=Image.createImage("/sayo02.png");
	 leftImg1=Image.createImage("/sayo22.png");
	 rightImg=Image.createImage("/sayo06.png");
	 rightImg1=Image.createImage("/sayo26.png");
	 upImg=Image.createImage("/sayo04.png");
	 upImg1=Image.createImage("/sayo24.png");
	 downImg=Image.createImage("/sayo00.png");
	 downImg1=Image.createImage("/sayo20.png");
	 currentImg=img;
}

catch (IOException e)
{
	e.printStackTrace();
}
}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
		
	}
public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	int i=0;
	if(action==LEFT){
		x=x-1;
		i+=1;
		if(i%2==0){
			currentImg=leftImg;
		}
	    if(i%2!=0){
			currentImg=leftImg1;
		}
		System.out.println("向左转");		
	}
	if(action==RIGHT){
        x=x+1;
		i+=1;
		if(i%2==0){
			currentImg=rightImg;
		}
	    if(i%2!=0){
			currentImg=rightImg1;
		}
		System.out.println("向右转");
		}
    if(action==UP){
		y=y-1;
		i+=1;
		if(i%2==0){
			currentImg=upImg;
		}
	    if(i%2!=0){
			currentImg=upImg1;
		}
		System.out.println("向上转");
		}
	if(action==DOWN){
		y=y+1;
		i+=1;
		if(i%2==0){
			currentImg=downImg;
		}
	    if(i%2!=0){
			currentImg=downImg1;
		}
		System.out.println("向下转");
		
	}
	repaint();
}
}