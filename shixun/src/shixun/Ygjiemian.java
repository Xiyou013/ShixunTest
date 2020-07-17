package shixun;

import java.util.Scanner;

public class Ygjiemian {
	public static void ygjm(){
		end:
		while(true){
			System.out.println("-------   欢迎登陆员工系统        -------");
			System.out.println("-------     1.部门查询              -------");
			System.out.println("-------     2.个人信息查询       -------");
			System.out.println("-------     3.薪资查询              -------");
			System.out.println("-------     4.考勤查询              -------");
			System.out.println("-------     5.打卡                     -------");
			System.out.println("-------     6.请假                     -------");
			System.out.println("-------     7.找回密码              -------");
			System.out.println("-------     0.返回主界面           -------");
			System.out.println("-------请输入要执行的操作序列号 -------");
			Scanner input=new Scanner(System.in);
			int x=input.nextInt();
			switch(x){
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
	
				break;
			case 0:
				Minterface mface=new Minterface();
				mface.zmuen();
				break end;
			default:
				System.out.println("您输入的操作不正确，请在0-5之间选择");
				break;
			}
		}
	}
}
