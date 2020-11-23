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
class MainCanvas extends Canvas implements Runnable
{
Thread thread;
Image currentImg;
Image bossImg;
Image heroImg[][]=new Image[4][3];
int x=110,y=240,i=0;
int bossX=0,bossY=0;
public MainCanvas(){
try
{
	for(int m=0;m<heroImg.length;m++){
		for(int n=0;n<heroImg[m].length;n++){
			heroImg[m][n]=Image.createImage("/sayo"+m+n+".png");
			}
}
     bossImg=Image.createImage("/sayoboss.png");
	 currentImg=heroImg[3][1];
	 thread=new Thread(this);
	 thread.start();
}
catch (IOException e)
{
	e.printStackTrace();
}
}
public void run(){
   while(true){
   try
   {
	Thread.sleep(200);
   }
   catch (InterruptedException e)
   {
	   e.printStackTrace();
   }
   if(bossX<x){
   bossX++;
   }
   else{
   bossX--;
   }
   if(bossY<y){
   bossY++;
   }
   else{
   bossY--;}
   repaint();
   }
   }
public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
        g.drawImage(bossImg,bossX,bossY,0);
	}
public void changePicAndDirect(int direction){
		if(i%2==0){
			currentImg=heroImg[direction][0];
			}
	    if(i%2!=0){
			currentImg=heroImg[direction][2];
			}
}
public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	if(action==LEFT){
		x=x-3;
		changePicAndDirect(0);
		System.out.println("向左转");		
	}
	if(action==RIGHT){
        x=x+3;
		changePicAndDirect(1);
		System.out.println("向右转");
		}
    if(action==UP){
		y=y-3;
		changePicAndDirect(2);
		System.out.println("向上转");
		}
	if(action==DOWN){
		y=y+3;
		changePicAndDirect(3);
		System.out.println("向下转");
	}
	i+=1;
}
}