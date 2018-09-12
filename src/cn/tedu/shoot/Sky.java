package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** ��� */
public class Sky extends FlyingObject {
	private static BufferedImage image;
	static {
		image = loadImage("background.png");
	}
	
	private int speed; //�ƶ��ٶ�
	private int y1;    //�ڶ���ͼ��y����
	/** ���췽�� */
	public Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		y+=speed;  //y+(����)
		y1+=speed; //y1+(����)
		if(y>=World.HEIGHT) { //��y>=���ڸ�ʱ����ζ�ŵ���������
			y=-World.HEIGHT;  //��y����Ϊ���Ĵ��ڵĸ�(Ų���������)
		}
		if(y1>=World.HEIGHT) { //��y1>=���ڸ�ʱ����ζ�ŵ���������
			y1=-World.HEIGHT;  //��y1����Ϊ���Ĵ��ڵĸ�(Ų���������)
		}
	}
	
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage() {
		return image; //ֱ�ӷ���image����
	}
	
	/** ������  g:���� */
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
		g.drawImage(getImage(),x,y1,null);
	}
	
}






















