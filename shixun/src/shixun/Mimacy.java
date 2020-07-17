package shixun;

public class Mimacy {
	public static int glmima(String pass){
		if(pass.equals("")){
			return 0;
	    	}
		else if(pass.length()<=5||pass.length()>=17){
				return 1;
    	}else{
    		return 2;
    	}
	}
}
