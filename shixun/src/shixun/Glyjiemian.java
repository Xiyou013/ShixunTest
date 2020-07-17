package shixun;

import java.util.Scanner;

public class Glyjiemian {
	public static void glyjm(){
		end:
		while(true){
			System.out.println("-------   欢迎登陆管理员系统     -------");
			System.out.println("-------     1.部门管理              -------");
			System.out.println("-------     2.员工管理              -------");
			System.out.println("-------     3.薪资管理              -------");
			System.out.println("-------     4.考勤管理              -------");
			System.out.println("-------     5.找回密码              -------");
			System.out.println("-------     0.返回主界面           -------");
			System.out.println("-------请输入要执行的操作序列号 -------");
			Scanner input=new Scanner(System.in);
			int x=input.nextInt();
			switch(x){
			case 1:
				Bmglmain bm=new Bmglmain();
				bm.bmmain();
				break;
			case 2:
				Ygglmain yg=new Ygglmain();
				yg.ygmain();
				break;
			case 3:
				Xzglmain xz=new Xzglmain();
				xz.xzmain();
				break;
			case 4:
				Kqglmain kq=new Kqglmain();
				kq.kqmain();
				break;
			case 5:
				Xgmima xg=new Xgmima();
				xg.zhmima();
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
