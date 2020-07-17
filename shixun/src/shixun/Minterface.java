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
				System.out.println("-------欢迎登陆人事信息管理系统-------");
				System.out.println("-------     1.管理员登录          -------");
				System.out.println("-------     2.员工用户登录       -------");
				System.out.println("-------请输入要执行的操作序列号 -------");
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
					System.out.println("您输入的操作不正确，请在0-3之间选择");
					break;
				}
			}
		}
	
	   
}

