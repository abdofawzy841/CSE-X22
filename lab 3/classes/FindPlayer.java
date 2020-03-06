package eg.edu.alexu.csd.datastructure.iceHockey.cs23;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FindPlayer implements IPlayersFinder {

public Point[] result;
 


public boolean [][] setarray(String[] photo, int team ) {

	boolean [][] arr_test=new boolean [photo.length][photo[0].length()];
	for (int i=0;i<photo.length;i++) {
		for (int j=0;j<photo[0].length();j++) {
			char c = photo[i].charAt(j);
			int x = Character.getNumericValue(c);
			if (Character.isDigit(c) && x == team) {
				arr_test[i][j]=true;	
			}
			else {arr_test[i][j]=false;}
		
		}
	}	
  return arr_test;
  }




public void check (int i,int j,boolean [][] arr_test,int [] arr_inf) {
	arr_test[i][j]=false;
	arr_inf[0]++;
	check_right(i,j+1,arr_test,arr_inf);
	check_left(i,j-1,arr_test,arr_inf);
	check_dwon(i+1,j,arr_test,arr_inf);
    check_up(i-1,j,arr_test,arr_inf);
   }
public void check_right(int i,int j,boolean [][]arr_test,int []arr_inf) {
	
	if(j-1<arr_test[0].length -1 && arr_test[i][j]) {
		if(j>arr_inf[1]) {arr_inf[1]=j;}
		check(i,j,arr_test,arr_inf);
	}
	
}


public void check_left(int i,int j,boolean [][]arr_test,int []arr_inf) {
	
	if(j+1>0 && arr_test[i][j]) {
		if(j<arr_inf[2]) { arr_inf[2]=j;}
		check(i,j,arr_test,arr_inf);
	}
	
}
public void check_up(int i,int j,boolean [][]arr_test,int []arr_inf) {
	
	if(i+1>0 && arr_test[i][j]) {
		if(i<arr_inf[4]) {arr_inf[4]=i;}
		check(i,j,arr_test,arr_inf);
	}
	
}

public void check_dwon(int i,int j,boolean [][]arr_test,int []arr_inf) {
	
	if(i-1<arr_test.length-1 && arr_test[i][j]) {
		if(i>arr_inf[3]) {arr_inf[3]=i;}
		check(i,j,arr_test,arr_inf);
	}

 }




public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
	if (photo==null || photo.length == 0 ) return null;
	
	boolean [][] arr_test=new boolean [photo.length][photo[0].length()];
	int [] arr_inf = new int [5];
	ArrayList<Point> resultList = new ArrayList<Point>();
	arr_test=setarray( photo , team);
	for (int i=0;i<photo.length;i++) {
			for (int j=0;j<photo[0].length();j++) {
				/*arr_inf[0] for num of boxes ,arr_inf[1] for xmax ,arr_inf[2] for xmin
			        arr_inf[3] for ymax, arr_inf[4] for ymin
				*/  
			arr_inf[0]=0 ;arr_inf[1]=j;arr_inf[2]=j;arr_inf[3]=i;arr_inf[4]=i;
			if (arr_test[i][j]) {
				check(i,j,arr_test,arr_inf);
				int area=arr_inf[0]*4;
				if(area<threshold)
					continue;
				else {
					int x=arr_inf[1]+arr_inf[2]+1;
					int y=arr_inf[3]+arr_inf[4]+1;
					resultList.add(new Point(x,y));
				}
			}
	      }
       }
	 Point [] points = new Point [resultList.size()];
		listToSortedArray(resultList,points);

return points;    
}

public void listToSortedArray (ArrayList<Point> list , Point [] pts){
    for (int i = 0; i < list.size(); i++) { 
    	pts[i] = list.get(i); 
    } 	 
 
	// Sorting The array Using Arrays.Sort But With a new comparator for X then Y
	Arrays.sort(pts, new Comparator<Point>() {
	    public int compare(Point a, Point b) {
	        int xComp = Integer.compare(a.x, b.x);
	        if(xComp == 0)
	            return Integer.compare(a.y, b.y);
	        else
	            return xComp;
	    }
	});
}

}
