package shixun;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Minterface {

		public static void main(String[] args) {
			zmuen();
		}
		public static void zmuen(){
			
			while(true){
				System.out.println("-------��ӭ��½������Ϣ����ϵͳ-------");
				System.out.println("-------     1.����Ա��¼          -------");
				System.out.println("-------     2.Ա���û���¼       -------");
				System.out.println("-------������Ҫִ�еĲ������к� -------");
				Scanner input=new Scanner(System.in);
				int x=input.nextInt();
				switch(x){
				case 1:
					Glydl dl=new Glydl();
					dl.glydl();
					break;
				case 2:
					Ygdl yg=new Ygdl();
					yg.ygdl();
					break;
				default:
					System.out.println("������Ĳ�������ȷ������0-3֮��ѡ��");
					break;
				}
			}
		}
	
	   
}

