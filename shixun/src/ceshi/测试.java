package ceshi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class 测试 {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	//System.out.println("请输入要更改密码的用户信息");
	//System.out.println("请输入你要删除的用户名信息");
	System.out.println("请输入用户名：");
	String name=input.nextLine();
	System.out.println("请输入密码：");
	String pass=input.nextLine();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql:"
				+ "//localhost:3306/rsxxgl","root","root");
		String sql="INSERT INTO USER(uname,upass) VALUE('"+name+"','"+pass+"')";
		//String sql="UPDATE USER SET upass='"+pass+"' WHERE uname='"+name+"';";
		//String sql="DELETE FROM USER WHERE uname='"+name+"';";
		System.out.println(sql);
		Statement st=con.createStatement();
		int in=st.executeUpdate(sql);
		if(in==1){
			System.out.println("插入成功");
		}
		else{
			System.out.println("插入失败");
		}
		/*if(in==1){
			System.out.println("修改成功");
		}
		else{
			System.out.println("修改失败");
		}*/
		/*if(in==1){
			System.out.println("删除成功");
		}
		else{
			System.out.println("删除失败");
		}*/
		String sql1="SELECT * FROM USER;";
		System.out.println(sql1);
		ResultSet in1=st.executeQuery(sql1);
		
		System.out.println("uname\t|\tupass");
		while(in1.next()){
			
			//System.out.println(in1.getString(1)+"\t\t"+in1.getString(2));
			String uname=in1.getString("uname");
			String upass=in1.getString("upass");
			System.out.println(uname+"\t|\t"+upass);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
