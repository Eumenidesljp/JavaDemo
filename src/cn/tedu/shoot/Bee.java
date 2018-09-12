package cn.tedu.shoot;
import java.util.Random;
import java.awt.image.BufferedImage;
/** 小蜜蜂: 是飞行物，也是奖励 */
public class Bee extends FlyingObject implements Award  {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5]; //5张图片
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	
	private int xSpeed; //x坐标移动速度
	private int ySpeed; //y坐标移动速度
	private int awardType; //奖励类型
	/** 构造方法 */
	public Bee(){
		super(60,50);
		xSpeed = 1;
		ySpeed = 2;
		Random rand = new Random();
		awardType = rand.nextInt(2); //0到1之间的随机数
	}
	
	/** 重写step()移动 */
	public void step() {
		x+=xSpeed; //x+(向左或向右)
		y+=ySpeed; //y+(向下)
		if(x<=0 || x>=World.WIDTH-this.width) { //若x<=0或x>=窗口宽-蜜蜂宽，则表示到最边缘了，需要切换方向
			xSpeed*=-1; //负变正，正变负(切换方向)
		}
	}
	
	int index = 1; //下标
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() { //每10毫秒走一次
		if(isLife()) { //活着呢
			return images[0]; //直接返回images[0]
		}else if(isDead()) { //死了的
			BufferedImage img = images[index++]; //从第二张图开始轮换
			if(index==images.length) { //若轮换到最后一张图片了
				state = REMOVE; //则将当前状态修改为REMOVE
			}
			return img; //返回爆破图片
		}
		return null; //删除状态时返回null
	}
	
	/** 重写getAwardType()获取奖励类型 */
	public int getAwardType(){
		return awardType; //返回awardType奖励类型
	}
	
}























