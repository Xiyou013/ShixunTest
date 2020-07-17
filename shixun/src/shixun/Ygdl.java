package shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ygdl {
public static void ygdl(){
		
		try{
			Scanner input=new Scanner(System.in);
			System.out.println("请输入员工姓名：");
			Staff staff=new Staff();
			staff.setSname(input.nextLine().trim());
			while(staff.getSname().equals("")){
	    		System.err.println("你输入为空，请重新输入");
	    		staff.setSname(input.nextLine().trim());
	    	}
			System.out.println("请输入员工号：");
			staff.setSno(input.nextLine().trim());
	    	Mimacy gl=new Mimacy();
	    	int glnum=gl.glmima(staff.getSno().trim());
	    	while(glnum==0||glnum==1||glnum==2){
	    		if(glnum==0){
	    			System.err.println("您输入的密码为空，请重新输入");
	    			staff.setSno(input.nextLine().trim());
	    			glnum=gl.glmima(staff.getSno().trim());
	    		}
	    		else if(glnum==1){
	    			System.err.println("您输入的密码不符合规则（6-16位数字、英文、字符,且不包含空格）");
	    			staff.setSno(input.nextLine().trim());
	    			glnum=gl.glmima(staff.getSno().trim());
	    		}
	    		else if(glnum==2){
	    			break;
	    		}
	    	}
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/rsxxgl","root","root");
			Statement st=con.createStatement();
			String sql="SELECT * FROM staff WHERE sname='"+staff.getSname()+"' AND sno='"+staff.getSno()+"';";
			ResultSet in=st.executeQuery(sql);
			if(in.next()){
				System.out.println("登录成功");
				Ygjiemian yg=new Ygjiemian();
				yg.ygjm();
			}
			else{
				System.err.println("用户或密码不正确，请重新输入");
			}
			if(in!=null){in.close();}
			if(st!=null){st.close();}
			if(con!=null){con.close();}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
