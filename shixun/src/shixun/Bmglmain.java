package shixun;

import java.util.Scanner;

public class Bmglmain {
	public static void bmmain(){
		end:
		while(true){
			System.out.println("-----------------------------------");
			System.out.println("-------     1.部门添加              -------");
			System.out.println("-------     2.部门修改              -------");
			System.out.println("-------     3.部门删除              -------");
			System.out.println("-------     4.部门查询              -------");
			System.out.println("-------     0.返回管理员界面           -------");
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
