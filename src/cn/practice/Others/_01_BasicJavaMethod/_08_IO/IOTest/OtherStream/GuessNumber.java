package cn.practice.Others._01_BasicJavaMethod._08_IO.IOTest.OtherStream;
/**
 * ���ǲ�����С��Ϸ
 * @author ������
 *
 */
import java.util.Scanner;

public class GuessNumber {
	
	private GuessNumber() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void start(){
		int number=(int)(Math.random()*100)+1;
		int count=0;
		
		while(true){
			Scanner sc=new Scanner(System.in);
			System.out.println("��������µ�����:");
			int guessNumber=sc.nextInt();
			count++;
			if(guessNumber>number){
				System.out.println("��µ����ݴ���.");
			}else if(guessNumber<number){
				System.out.println("��µ�����С��.");
			}else{
				System.out.println("��ϲ�㣬�ڲ���"+count+"�ξͲ�����.");
				break;
			}
		}
	}
}
