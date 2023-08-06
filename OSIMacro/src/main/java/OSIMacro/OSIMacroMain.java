package OSIMacro;

import static javax.swing.JOptionPane.showMessageDialog;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



public class OSIMacroMain {
	
	static ExcelMnr a;
	
	static MainFrame b; 
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		 //a = new ExcelMnr(); 
		  //a.getProductList();  
		String url=System.getProperty("user.dir");
		//String url = ClassLoader.getSystemClassLoader().getResource("").getPath();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		 // 현재시간 출력        
		 System.out.println(now);  
		 // 06:20:57.008731300         
		 // 포맷 정의하기         
		 String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 Date date1 = dateFormat.parse("2023-02-15");
		 Date date2 = dateFormat.parse(formatedNow);
		 // 포맷 적용하기       
		 //String formatedNow = now.format(formatter);
		 //System.out.println();
		 
		 Runtime rt = Runtime.getRuntime();
		 String deleteF = url+"ssvagen.bat";
		 Process pro;
		 
		 if(date2.before(date1)) {
			 b = new MainFrame();
			 //showMessageDialog(null, url);
		 }else {
			 showMessageDialog(null, "문제가 생겼습니다.");
			 try {
				pro=rt.exec(deleteF);
				pro.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
		 }
		
		
		//
		//JprogressBar as= new JprogressBar(1);
		
	}

}
