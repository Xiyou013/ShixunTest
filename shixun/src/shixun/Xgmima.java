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
	    	System.out.println("�������û�����");
	    	user.setUname(input.nextLine().trim());
	    	while(user.getUname().equals("")){
	    		System.err.println("������Ϊ�գ�����������");
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
					System.out.println("���ҳɹ�");
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