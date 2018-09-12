package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** С�л�: �Ƿ����Ҳ�ǵ����ܵ÷� */
public class Airplane extends FlyingObject implements Enemy {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5]; //5��ͼƬ
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("airplane"+i+".png");
		}
	}
	
	private int speed; //�ƶ��ٶ�
	/** ���췽�� */
	public Airplane(){
		super(49,36);
		speed = 2;
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		y+=speed; //y+(����)
	}
	
	int index = 1; //�±�
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage() { //ÿ10������һ��
		if(isLife()) { //������
			return images[0]; //ֱ�ӷ���images[0]
		}else if(isDead()) { //���˵�
			BufferedImage img = images[index++]; //�ӵڶ���ͼ��ʼ�ֻ�
			if(index==images.length) { //���ֻ������һ��ͼƬ��
				state = REMOVE; //�򽫵�ǰ״̬�޸�ΪREMOVE
			}
			return img; //���ر���ͼƬ
		}
		return null; //ɾ��״̬ʱ����null
		/*
		 *                   index=1
		 * 10M img=images[1] index=2                 ����images[1]
		 * 20M img=images[2] index=3                 ����images[2]
		 * 30M img=images[3] index=4                 ����images[3]
		 * 40M img=images[4] index=5(REMOVE) ����images[4]
		 * 50M ����null
		 */
	}
	
	/** ��дgetScore()�÷� */
	public int getScore(){
		return 1; //���С�л�����ҵ�1��
	}
	
}






















