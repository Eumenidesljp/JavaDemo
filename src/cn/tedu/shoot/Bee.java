package cn.tedu.shoot;
import java.util.Random;
import java.awt.image.BufferedImage;
/** С�۷�: �Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award  {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5]; //5��ͼƬ
		for(int i=0;i<images.length;i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	
	private int xSpeed; //x�����ƶ��ٶ�
	private int ySpeed; //y�����ƶ��ٶ�
	private int awardType; //��������
	/** ���췽�� */
	public Bee(){
		super(60,50);
		xSpeed = 1;
		ySpeed = 2;
		Random rand = new Random();
		awardType = rand.nextInt(2); //0��1֮��������
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		x+=xSpeed; //x+(���������)
		y+=ySpeed; //y+(����)
		if(x<=0 || x>=World.WIDTH-this.width) { //��x<=0��x>=���ڿ�-�۷�����ʾ�����Ե�ˣ���Ҫ�л�����
			xSpeed*=-1; //�����������为(�л�����)
		}
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
	
	/** ��дgetAwardType()��ȡ�������� */
	public int getAwardType(){
		return awardType; //����awardType��������
	}
	
}























