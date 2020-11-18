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
Image currentImg;
Image heroLeftImg[]=new Image[3];
Image heroRightImg[]=new Image[3];
Image heroUpImg[]=new Image[3];
Image heroDownImg[]=new Image[3];
int x=110,y=240,i=0;
public MainCanvas(){
try
{
     
	 //向左
	 for(int m=0;m<heroLeftImg.length;m++){
		 heroLeftImg[m]=Image.createImage("/sayo"+m+"2.png");
	 }
	 /*
     leftImg=Image.createImage("/sayo02.png");
	 leftImg1=Image.createImage("/sayo22.png");
	 leftImg2=Image.createImage("/sayo12.png");
	 */

     //向右
	 for(int m=0;m<heroRightImg.length;m++){
		 heroRightImg[m]=Image.createImage("/sayo"+m+"6.png");
	 }
	 /*
	 rightImg=Image.createImage("/sayo06.png");
	 rightImg1=Image.createImage("/sayo26.png");
	 rightImg2=Image.createImage("/sayo16.png");
	 */

	 //向上
	 for(int m=0;m<heroUpImg.length;m++){
		 heroUpImg[m]=Image.createImage("/sayo"+m+"4.png");
	 }
	 /*
	 upImg=Image.createImage("/sayo04.png");
	 upImg1=Image.createImage("/sayo24.png");
	 upImg2=Image.createImage("/sayo14.png");
	 */
     
	 //向下
	 for(int m=0;m<heroDownImg.length;m++){
		 heroDownImg[m]=Image.createImage("/sayo"+m+"0.png");
	 }
	 /*
	 downImg=Image.createImage("/sayo00.png");
	 downImg1=Image.createImage("/sayo20.png");
	 downImg2=Image.createImage("/sayo10.png");
	 */
	 currentImg=heroDownImg[1];
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
		x=x-1;
		if(i%2==0){
			currentImg=heroLeftImg[0];
			}
	    if(i%2!=0){
			currentImg=heroLeftImg[2];
			}
		System.out.println("向左转");		
	}
	if(action==RIGHT){
        x=x+1;
		if(i%2==0){
			currentImg= heroRightImg[0];
		}
	    if(i%2!=0){
			currentImg= heroRightImg[2];
		}
		System.out.println("向右转");
		}
    if(action==UP){
		y=y-1;
		if(i%2==0){
			currentImg=heroUpImg[0];
		}
	    if(i%2!=0){
			currentImg=heroUpImg[2];
		}
		System.out.println("向上转");
		}
	if(action==DOWN){
		y=y+1;
		if(i%2==0){
			currentImg=heroDownImg[0];
		}
	    if(i%2!=0){
			currentImg=heroDownImg[2];
		}
		System.out.println("向下转");
		
	}
	i+=1;
	repaint();
}
}