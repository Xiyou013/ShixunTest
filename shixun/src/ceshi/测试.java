package ceshi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ���� {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	//System.out.println("������Ҫ����������û���Ϣ");
	//System.out.println("��������Ҫɾ�����û�����Ϣ");
	System.out.println("�������û�����");
	String name=input.nextLine();
	System.out.println("���������룺");
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
			System.out.println("����ɹ�");
		}
		else{
			System.out.println("����ʧ��");
		}
		/*if(in==1){
			System.out.println("�޸ĳɹ�");
		}
		else{
			System.out.println("�޸�ʧ��");
		}*/
		/*if(in==1){
			System.out.println("ɾ���ɹ�");
		}
		else{
			System.out.println("ɾ��ʧ��");
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
