package shixun;

import java.util.Scanner;

public class Kqglmain {
	public static void kqmain(){
		end:
			while(true){
				System.out.println("-----------------------------------");
				System.out.println("-------     1.��������              -------");
				System.out.println("-------     2.�����޸�              -------");
				System.out.println("-------     3.���ڲ�ѯ              -------");
				System.out.println("-------     0.���ع���Ա����           -------");
				System.out.println("-------������Ҫִ�еĲ������к� -------");
				Scanner input=new Scanner(System.in);
				int x=input.nextInt();
				switch(x){
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 0:
					Glyjiemian gl=new Glyjiemian();
					gl.glyjm();
					break end;
				default:
					System.out.println("������Ĳ�������ȷ������0-5֮��ѡ��");
					break;
				}
			}
		}
	
}