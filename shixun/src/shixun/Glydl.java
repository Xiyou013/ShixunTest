package shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Glydl {
	public static void glydl(){
		
		try{
			Scanner input=new Scanner(System.in);
			System.out.println("�������û�����");
			User user=new User();
			user.setUname(input.nextLine().trim());
			while(user.getUname().equals("")){
	    		System.err.println("������Ϊ�գ�����������");
	    		user.setUname(input.nextLine().trim());
	    	}
			System.out.println("���������룺");
			user.setUpass(input.nextLine().trim());
	    	Mimacy gl=new Mimacy();
	    	int glnum=gl.glmima(user.getUpass().trim());
	    	while(glnum==0||glnum==1||glnum==2){
	    		if(glnum==0){
	    			System.err.println("�����������Ϊ�գ�����������");
	    			user.setUpass(input.nextLine().trim());
	    			glnum=gl.glmima(user.getUpass().trim());
	    		}
	    		else if(glnum==1){
	    			System.err.println("����������벻���Ϲ���6-16λ���֡�Ӣ�ġ��ַ�,�Ҳ������ո�");
	    			user.setUpass(input.nextLine().trim());
	    			glnum=gl.glmima(user.getUpass().trim());
	    		}
	    		else if(glnum==2){
	    			break;
	    		}
	    	}
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/rsxxgl","root","root");
			Statement st=con.createStatement();
			String sql="SELECT * FROM USER WHERE uname='"+user.getUname()+"' AND upass='"+user.getUpass()+"';";
			ResultSet in=st.executeQuery(sql);
			if(in.next()){
				System.out.println("��¼�ɹ�");
				Glyjiemian gljm=new Glyjiemian();
				gljm.glyjm();
			}
			else{
				System.err.println("�û������벻��ȷ������������");
			}
			if(in!=null){in.close();}
			if(st!=null){st.close();}
			if(con!=null){con.close();}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
