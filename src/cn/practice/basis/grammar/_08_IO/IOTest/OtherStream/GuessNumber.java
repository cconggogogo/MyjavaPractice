package cn.practice.basis.grammar._08_IO.IOTest.OtherStream;
/**
 * 这是猜数字小游戏
 * @author 胡阳阳
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
			System.out.println("请输入你猜的数据:");
			int guessNumber=sc.nextInt();
			count++;
			if(guessNumber>number){
				System.out.println("你猜的数据大了.");
			}else if(guessNumber<number){
				System.out.println("你猜的数据小了.");
			}else{
				System.out.println("恭喜你，在猜了"+count+"次就猜中了.");
				break;
			}
		}
	}
}
