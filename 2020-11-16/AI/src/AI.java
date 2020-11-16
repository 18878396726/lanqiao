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
int x=110,y=240;
public MainCanvas(){
try
{
     img=Image.createImage("/sayo10.png");
     leftImg=Image.createImage("/sayo12.png");
	 rightImg=Image.createImage("/sayo06.png");
	 upImg=Image.createImage("/sayo04.png");
	 downImg=Image.createImage("/sayo20.png");
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
	if(action==LEFT){
		currentImg=leftImg;
		x=x-1;
		
		System.out.println("向左转");		
	}
	if(action==RIGHT){
		currentImg=rightImg;
        x=x+1;
		
		System.out.println("向右转");
		}
    if(action==UP){
		currentImg=upImg;
        
		y=y-1;
		System.out.println("向上转");
		}
	if(action==DOWN){
		currentImg=downImg;
        
		y=y+1;
		System.out.println("向下转");
		
	}
	repaint();
}
}