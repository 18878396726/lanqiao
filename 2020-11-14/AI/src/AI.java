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
Image img,img1,img2,img3,img4,currentImg;
public MainCanvas(){
try
{
     img=Image.createImage("/sayo10.png");
     img1=Image.createImage("/sayo12.png");
	 img2=Image.createImage("/sayo06.png");
	 img3=Image.createImage("/sayo04.png");
	 img4=Image.createImage("/sayo20.png");
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
		g.drawImage(currentImg,110,240,0);
		
	}
public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	if(action==LEFT){
		currentImg=img1;
		System.out.println("向左转");
		repaint();			
	}
	if(action==RIGHT){
		currentImg=img2;
		System.out.println("向右转");
		repaint();
		}
    if(action==UP){
		currentImg=img3;
		System.out.println("向上转");
		repaint();
		}
	if(action==DOWN){
		currentImg=img4;
		System.out.println("向下转");
		repaint();
	}
}
}