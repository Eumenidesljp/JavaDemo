package cn.tedu.shoot;
//Debugµ÷ÊÔ¹¤¾ß
public class DebugTest {
	public static void main(String[] args) {
		int m = 8;
		int n = 6;
		test();
		sum(m, n);
		
	}
	public static void sum(int a,int b){
		int c = a+b;
		if(c>5){
			System.out.println(c);
		}
	}
	public static void test(){
		System.out.println(111);
		int a = 5;
		System.out.println(222);
	}
}































