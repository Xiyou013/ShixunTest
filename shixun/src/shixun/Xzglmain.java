package shixun;

import java.util.Scanner;

public class Xzglmain {
	public static void xzmain(){
		end:
			while(true){
				System.out.println("-----------------------------------");
				System.out.println("-------     1.薪资修改              -------");
				System.out.println("-------     2.薪资查询              -------");
				System.out.println("-------     0.返回管理员界面           -------");
				System.out.println("-------请输入要执行的操作序列号 -------");
				Scanner input=new Scanner(System.in);
				int x=input.nextInt();
				switch(x){
				case 1:
					
					break;
				case 2:
					
					break;
				case 0:
					Glyjiemian gl=new Glyjiemian();
					gl.glyjm();
					break end;
				default:
					System.out.println("您输入的操作不正确，请在0-5之间选择");
					break;
				}
			}
		}
}
