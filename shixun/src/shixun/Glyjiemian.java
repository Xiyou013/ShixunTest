package shixun;

import java.util.Scanner;

public class Glyjiemian {
	public static void glyjm(){
		end:
		while(true){
			System.out.println("-------   ��ӭ��½����Աϵͳ     -------");
			System.out.println("-------     1.���Ź���              -------");
			System.out.println("-------     2.Ա������              -------");
			System.out.println("-------     3.н�ʹ���              -------");
			System.out.println("-------     4.���ڹ���              -------");
			System.out.println("-------     5.�һ�����              -------");
			System.out.println("-------     0.����������           -------");
			System.out.println("-------������Ҫִ�еĲ������к� -------");
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
				System.out.println("������Ĳ�������ȷ������0-5֮��ѡ��");
				break;
			}
		}
	}
}
