package shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class 主界面 {
	public static void main(String[] args) {
		zmuen();
	}
	public static void lianjie(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/rsxxgl","root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void zmuen(){
		while(true){
			System.out.println("-------欢迎登陆人事信息管理系统-------");
			System.out.println("-------     1.管理员登录          -------");
			System.out.println("-------     2.员工用户登录       -------");
			System.out.println("-------     3.找回密码              -------");
			System.out.println("-------     0.退出系统              -------");
			System.out.println("-------请输入要执行的操作序列号 -------");
			Scanner input=new Scanner(System.in);
			int x=input.nextInt();
			switch(x){
			case 1:
				glydl();
				break;
			case 2:
				
				break;
			case 3:
				zhmima();
				break;
			case 0:
				break;
			default:
				System.out.println("您输入的操作不正确，请在0-3之间选择");
				break;
			}
		}
	}
	public static void glydl(){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入用户名：");
		//String uname=input.nextLine();
		User user=new User();
		user.setUname(input.nextLine().trim());
		while(user.getUname().equals("")){
    		System.err.println("你输入为空，请重新输入");
    		user.setUname(input.nextLine().trim());
    	}
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
		/*System.out.println("请输入密码：");
		String upass=input.nextLine();
		String name = null;
		String pass = null;*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/rsxxgl","root","root");
			Statement st=con.createStatement();
			String sql="SELECT * FROM USER WHERE uname='"+user.getUname()+"' AND upass='"+user.getUpass()+"';";
			ResultSet in=st.executeQuery(sql);
			if(in.next()){
				System.out.println("登录成功");
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
	
    public static void zhmima(){
    	/*Scanner input=new Scanner(System.in);
    	User user=new User();
    	System.out.println("请输入用户名：");
    	user.setUname(input.nextLine().trim());
    	while(user.getUname().equals("")){
    		System.err.println("你输入为空，请重新输入");
    		user.setUname(input.nextLine().trim());
    	}*/
    	
    	//String uname=input.nextLine();
    	//System.out.println("请输入密码：");
    	//String upass=input.nextLine();
    	//String name = null;
    	//String pass = null;
    	try{
    		Scanner input=new Scanner(System.in);
        	User user=new User();
        	System.out.println("请输入用户名：");
        	user.setUname(input.nextLine().trim());
        	while(user.getUname().equals("")){
        		System.err.println("你输入为空，请重新输入");
        		user.setUname(input.nextLine().trim());
        	}
    		Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/rsxxgl","root","root");
			Statement st=con.createStatement();
			String sql="SELECT * FROM USER WHERE uname='"+user.getUname()+"';";
			ResultSet sel=st.executeQuery(sql);
			if(sel.next()){
				System.out.println("查找成功");
				//Glmima glm=new Glmima();
				//glm.glmima();
				System.out.println("请输入密码：");
		    	//String upass=input.nextLine();
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
		    			System.err.println("您输入的密码不符合规则（6-16位数字、英文、字符）");
		    			user.setUpass(input.nextLine().trim());
		    			glnum=gl.glmima(user.getUpass().trim());
		    		}
		    		else if(glnum==2){
		    			break;
		    		}
		    	}
		    	/*while(user.getUpass().equals("")){
		    		while(user.getUpass().length()<=5||user.getUpass().length()>=17){
			    		System.out.println("您输入的密码格式不正确(6-16位)");
			    		user.setUpass(input.nextLine().trim());
			    	}
		    	}*/
		    	/*if(upass.length()<=5||upass.length()>=17){
		    		System.out.println("您输入的密码格式不正确");7
		    	}*/
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