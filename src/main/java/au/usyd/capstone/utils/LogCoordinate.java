package au.usyd.capstone.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogCoordinate {
	
	public static void log(String string) throws Exception{
		
		File file = new File("/Users/LYH/Documents/workspace/AccurateIndoorPositioning/src/main/resources/LogCoordinate/log");
		BufferedOutputStream bos = null;
		FileOutputStream fos;
		
		try {
			
			fos = new FileOutputStream(file, true);
			bos = new BufferedOutputStream(fos);
			bos.write((timeFormat()+" " + string+"\n").getBytes());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
            if (bos != null) { 
                try { 
                    bos.close(); 
                } catch (Exception e) { 
                    e.printStackTrace(); 
                } 
            }
		}
		
		
		
	}
	
	private static String timeFormat(){
		
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    long times = System.currentTimeMillis();  
//	    System.out.println(times);  
	    Date date = new Date(times);  
	    String time = sdf.format(date);  
//	    System.out.println(time); 
		
		return time;
		
	}
	
}
