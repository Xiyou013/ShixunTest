package shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ������ {
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
			System.out.println("-------��ӭ��½������Ϣ����ϵͳ-------");
			System.out.println("-------     1.����Ա��¼          -------");
			System.out.println("-------     2.Ա���û���¼       -------");
			System.out.println("-------     3.�һ�����              -------");
			System.out.println("-------     0.�˳�ϵͳ              -------");
			System.out.println("-------������Ҫִ�еĲ������к� -------");
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
				System.out.println("������Ĳ�������ȷ������0-3֮��ѡ��");
				break;
			}
		}
	}
	public static void glydl(){
		Scanner input=new Scanner(System.in);
		System.out.println("�������û�����");
		//String uname=input.nextLine();
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
		/*System.out.println("���������룺");
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
				System.out.println("��¼�ɹ�");
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
	
    public static void zhmima(){
    	/*Scanner input=new Scanner(System.in);
    	User user=new User();
    	System.out.println("�������û�����");
    	user.setUname(input.nextLine().trim());
    	while(user.getUname().equals("")){
    		System.err.println("������Ϊ�գ�����������");
    		user.setUname(input.nextLine().trim());
    	}*/
    	
    	//String uname=input.nextLine();
    	//System.out.println("���������룺");
    	//String upass=input.nextLine();
    	//String name = null;
    	//String pass = null;
    	try{
    		Scanner input=new Scanner(System.in);
        	User user=new User();
        	System.out.println("�������û�����");
        	user.setUname(input.nextLine().trim());
        	while(user.getUname().equals("")){
        		System.err.println("������Ϊ�գ�����������");
        		user.setUname(input.nextLine().trim());
        	}
    		Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/rsxxgl","root","root");
			Statement st=con.createStatement();
			String sql="SELECT * FROM USER WHERE uname='"+user.getUname()+"';";
			ResultSet sel=st.executeQuery(sql);
			if(sel.next()){
				System.out.println("���ҳɹ�");
				//Glmima glm=new Glmima();
				//glm.glmima();
				System.out.println("���������룺");
		    	//String upass=input.nextLine();
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
		    			System.err.println("����������벻���Ϲ���6-16λ���֡�Ӣ�ġ��ַ���");
		    			user.setUpass(input.nextLine().trim());
		    			glnum=gl.glmima(user.getUpass().trim());
		    		}
		    		else if(glnum==2){
		    			break;
		    		}
		    	}
		    	/*while(user.getUpass().equals("")){
		    		while(user.getUpass().length()<=5||user.getUpass().length()>=17){
			    		System.out.println("������������ʽ����ȷ(6-16λ)");
			    		user.setUpass(input.nextLine().trim());
			    	}
		    	}*/
		    	/*if(upass.length()<=5||upass.length()>=17){
		    		System.out.println("������������ʽ����ȷ");7
		    	}*/
		    	System.out.println("����һ���������룺");
		    	String xupass=input.nextLine().trim();
		    	if(xupass.equals(user.getUpass())){
		    		String sql1="UPDATE USER SET upass='"+xupass+"' WHERE uname='"+user.getUname()+"';";
			    	int up=st.executeUpdate(sql1);
					if(up==1){
						System.out.println("�޸ĳɹ�");
					}
					else{
						System.err.println("�޸�ʧ��");
					}
		    	}
				else{
					System.err.println("�������һ�β���ȷ,���������������Ϣ");
					zhmima();
					
				}
			}
			else{
				
				System.err.println("�û�������ȷ������������");
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