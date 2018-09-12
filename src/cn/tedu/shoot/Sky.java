package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** 天空 */
public class Sky extends FlyingObject {
	private static BufferedImage image;
	static {
		image = loadImage("background.png");
	}
	
	private int speed; //移动速度
	private int y1;    //第二张图的y坐标
	/** 构造方法 */
	public Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}
	
	/** 重写step()移动 */
	public void step() {
		y+=speed;  //y+(向下)
		y1+=speed; //y1+(向下)
		if(y>=World.HEIGHT) { //当y>=窗口高时，意味着到最下面了
			y=-World.HEIGHT;  //则将y设置为负的窗口的高(挪到最上面的)
		}
		if(y1>=World.HEIGHT) { //当y1>=窗口高时，意味着到最下面了
			y1=-World.HEIGHT;  //则将y1设置为负的窗口的高(挪到最上面的)
		}
	}
	
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		return image; //直接返回image即可
	}
	
	/** 画对象  g:画笔 */
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
		g.drawImage(getImage(),x,y1,null);
	}
	
}






















