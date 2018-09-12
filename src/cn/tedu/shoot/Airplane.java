package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 小敌机: 是飞行物，也是敌人能得分 */
public class Airplane extends FlyingObject implements Enemy {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5]; //5张图片
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("airplane"+i+".png");
		}
	}
	
	private int speed; //移动速度
	/** 构造方法 */
	public Airplane(){
		super(49,36);
		speed = 2;
	}
	
	/** 重写step()移动 */
	public void step() {
		y+=speed; //y+(向下)
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
		/*
		 *                   index=1
		 * 10M img=images[1] index=2                 返回images[1]
		 * 20M img=images[2] index=3                 返回images[2]
		 * 30M img=images[3] index=4                 返回images[3]
		 * 40M img=images[4] index=5(REMOVE) 返回images[4]
		 * 50M 返回null
		 */
	}
	
	/** 重写getScore()得分 */
	public int getScore(){
		return 1; //打掉小敌机，玩家得1分
	}
	
}






















