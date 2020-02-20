
public class  cal_test implements testing {
	public int add(int x,int y) {
		
		return x+y;
    }

     public float divide(int x,int y)   {
		if(y==0) {
			throw new ArithmeticException("divide by zero is invalid");
		}
		
		return (float) x/ (float)y;
	
	}

}
