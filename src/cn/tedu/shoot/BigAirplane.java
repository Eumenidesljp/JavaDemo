package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** ��л�: �Ƿ����Ҳ�ǵ����ܵ÷� */
public class BigAirplane extends FlyingObject implements Enemy {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5]; //5��ͼƬ
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("bigplane"+i+".png");
		}
	}
	
	private int speed; //�ƶ��ٶ�
	/** ���췽�� */
	public BigAirplane(){
		super(69,99);
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
	}
	
	/** ��дgetScore()�÷� */
	public int getScore(){
		return 3; //�����л�����ҵ�3��
	}
	
}














