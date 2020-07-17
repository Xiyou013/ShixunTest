package shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Xgmima {
	 public static void zhmima(){
	    	Scanner input=new Scanner(System.in);
	    	User user=new User();
	    	System.out.println("请输入用户名：");
	    	user.setUname(input.nextLine().trim());
	    	while(user.getUname().equals("")){
	    		System.err.println("你输入为空，请重新输入");
	    		user.setUname(input.nextLine().trim());
	    	}
	    	try{
	    		Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql:"
						+ "//localhost:3306/rsxxgl","root","root");
				Statement st=con.createStatement();
				String sql="SELECT * FROM USER WHERE uname='"+user.getUname()+"';";
				ResultSet sel=st.executeQuery(sql);
				if(sel.next()){
					System.out.println("查找成功");
					System.out.println("请输入密码：");
			    	user.setUpass(input.nextLine().trim());
			    	Mimacy gl=new Mimacy();
			    	int glnum=gl.glmima(user.getUpass().trim());
			    	while(glnum==0||glnum==1||glnum==2){
			    		if(glnum==0){
			    			System.err.println("您输入的密码为空，请重新输入");
			    			user.setUpass(input.nextLine().trim());
			    			glnum=gl.glmima(user.getUpass().trim());
			    		}
			    		else if(glnum==1){
			    			System.err.println("您输入的密码不符合规则（6-16位数字、英文、字符,且不包含空格）");
			    			user.setUpass(input.nextLine().trim());
			    			glnum=gl.glmima(user.getUpass().trim());
			    		}
			    		else if(glnum==2){
			    			break;
			    		}
			    	}
			    	System.out.println("请再一次输入密码：");
			    	String xupass=input.nextLine().trim();
			    	if(xupass.equals(user.getUpass())){
			    		String sql1="UPDATE USER SET upass='"+xupass+"' WHERE uname='"+user.getUname()+"';";
				    	int up=st.executeUpdate(sql1);
						if(up==1){
							System.out.println("修改成功");
						}
						else{
							System.err.println("修改失败");
						}
			    	}
					else{
						System.err.println("密码与第一次不正确,请重新输入你的信息");
						zhmima();
						
					}
				}
				else{
					
					System.err.println("用户名不正确，请重新输入");
					zhmima();
				}
				
				if(sel!=null){sel.close();}
				if(st!=null){st.close();}
				if(con!=null){con.close();}
				
		}catch(Exception e){
			e.printStackTrace();
		}
	    }
	
}
