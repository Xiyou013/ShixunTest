package shixun;

import java.util.Scanner;

public class Ygjiemian {
	public static void ygjm(){
		end:
		while(true){
			System.out.println("-------   ��ӭ��½Ա��ϵͳ        -------");
			System.out.println("-------     1.���Ų�ѯ              -------");
			System.out.println("-------     2.������Ϣ��ѯ       -------");
			System.out.println("-------     3.н�ʲ�ѯ              -------");
			System.out.println("-------     4.���ڲ�ѯ              -------");
			System.out.println("-------     5.��                     -------");
			System.out.println("-------     6.���                     -------");
			System.out.println("-------     7.�һ�����              -------");
			System.out.println("-------     0.����������           -------");
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
				System.out.println("������Ĳ�������ȷ������0-5֮��ѡ��");
				break;
			}
		}
	}
}
