package OSIMacro;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static javax.swing.JOptionPane.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumMain {

	//WebDriver
	private WebDriver driver; 
	
	private WebElement WebElement;
	
	private JframeFields item;
	
	
	private String id;
	private String pw;
	private String years;
	private String month;
	private String rfq;
	private String gnum;
	private String fileadr;
	private String exelfileadr;
	private String siteno;
	private String siteurl;
	private String srfqN;
	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH ="";//"C:\\Users\\my140225\\Downloads\\chromedriver_win32\\chromedriver.exe";//"C:\\Users\\momo\\Desktop\\chromedriver.exe"; 
	//"C:\\Users\\my140225\\Downloads\\chromedriver_win32\\chromedriver.exe.";
	
	static WebDriverWait wait;
	//크롤링 할 URL
	private String base_url;
	
	ExcelMnr excelMnr= new ExcelMnr();

	List<ExcelDto> listEx;
	

	public SeleniumMain() {
	}
	 
	public SeleniumMain(JframeFields itemS) throws EncryptedDocumentException, InvalidFormatException, IOException {
	/*	item.setId(idtext.getText().trim()); //아이디
    	item.setPw(passtext.getText().trim()); //패스워드
    	item.setYear_DT(years.getText().trim()); //년도
    	item.setMonth_DT(month.getText().trim());//월
    	item.setRfq(rfqno.getText().trim()); 
    	item.setGroupnum(groupcode.getText().trim());
    	item.setFileAddres(jfc.getSelectedFile().toString().trim()); //exe 파일 주소
    	item.setExelfileAddres(exelfc.getSelectedFile().toString().trim()); //엑셀 파일주소
    	item.setSiteno(siteno.getText().trim()); //사이트 
    	item.setSiteurl(siteurl.getText().trim()); //url */
		// this.getClass().getClassLoader().getResource("test.txt");
		this.item = itemS;
		SeleniumMain.WEB_DRIVER_PATH = item.getFileAddres();
		this.id = item.getId();
		this.pw = item.getPw();
		this.years = item.getYear_DT(); 
		this.month = item.getMonth_DT();
		this.rfq = item.getRfq();
		this.gnum = item.getGroupnum();
		this.fileadr = item.getFileAddres();
		this.exelfileadr = item.getExelfileAddres();
		this.siteno = item.getSiteno();
		this.siteurl = item.getSiteurl();
		this.srfqN = item.getSrfq();
		listEx	= excelMnr.getProductList(item.getExelfileAddres());
		
		//super();
		
	    //System Property SetUp
	    System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	    //System.out.println("aa="+WEB_DRIVER_PATH);
	    //Driver SetUp
	    driver = new ChromeDriver();
	    base_url = item.getSiteurl();//"C:\\Users\\my140225\\Desktop\\소피텔도 올림\\상세 등록하기.html";//"http://www.hotelencore.co.kr";
	    
	}
	
	
	public JframeFields items(JframeFields itemS) {
		
		this.item = itemS;
		
		return item;
	}
	
	
	@SuppressWarnings("deprecation")
	public void crawl() {
		
	    try {
	    	//WebDriverWait wait2 = new WebDriverWait(driver,30); 
	    	//WebElement = driver.findElement(
	    	//WebElement = driver.findElement(By.cssSelector(""));
	    	
	    	//String text = WebElement.getText();
	    	//System.out.println(text);
		        //
		        
		        //webElement = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/fieldset/p[2]/input"));
		        //webElement = driver.findElement(By.id(""));
		        //String PWD ="7155";
		        //webElement.sendKeys(PWD);
		        
		        //webElement = driver.findElement(By.id("btnLogin"));
		        //webElement.submit();
	        //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
	    	
	    	/*------------------------  로그인 페이지 --------------------------------------------*/
	        
	    	driver.get(base_url);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	       
	        System.out.println("years="+ years);
	        
	        WebElement = driver.findElement(By.xpath("//*[@id=\"frmContent\"]/div[1]/div/fieldset/p[1]/input"));
	        String LOGIN_ID = id ; //"10264";
	        WebElement.sendKeys(LOGIN_ID);
	        
	        WebElement = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/fieldset/p[2]/input"));
	        String PWD = pw; //"7155";
		     WebElement.sendKeys(PWD);
		        
		        WebElement = driver.findElement(By.id("btnLogin"));
		        WebElement.submit();
		       
		        /*------------------------  견적 요청 페이지 --------------------------------------------*/
		      
	    	//driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/div/ul/li[4]/dl/dd/a[1]")).click();
		        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      //  JavascriptExecutor exe = (JavascriptExecutor)driver;
			//exe.executeScript("$.fn_gMenu(\"/admin/ja/j1/0100/getInitPage.do\", \"menu0051\")");
		    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/div/ul/li[4]/dl/dt/a")));
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/div/ul/li[4]/dl/dt/a")).click();
			
	       // System.out.println(driver.getPageSource());
	        
			String zero = Integer.parseInt(month) == 10 || Integer.parseInt(month) == 11 || Integer.parseInt(month) == 12 ? "" : "0";
			String zero1=zero+month;
			System.out.println(zero1);
			if(siteno.equals("1")) {//몬드리안 소피텔
				
				Select syear =new Select( driver.findElement(By.id("S_REG_YEAR_DT")));
				
				syear.selectByValue(years);
				
				Select smonth =new Select( driver.findElement(By.id("S_REG_MONTH_DT")));
				
				smonth.selectByValue(zero1.trim());
				
				Select srfq =new Select( driver.findElement(By.id("S_RFQSTATUS")));
				
				System.out.println("견적상태: " +srfqN);
				srfq.selectByValue(srfqN);  //견적상태 고정
				WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div[1]/section/div[2]/a")));
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div[1]/section/div[2]/a")).click();//검색 누름
				
			}else { //이비스 
				
				Select syear =new Select( driver.findElement(By.id("S_CONT_YEAR_DT")));
				
				syear.selectByValue(years);
				
				Select smonth =new Select( driver.findElement(By.id("S_CONT_MONTH_DT")));
				
				
				smonth.selectByValue(zero1.trim());
				
				
				Select srfq =new Select( driver.findElement(By.id("S_RFQSTATUS")));
		
				////////////////////////////////////
				
				System.out.println("견적상태: " +srfqN);
				srfq.selectByValue(srfqN);  //견적상태 고정
				
				
				////////////////////////////////////
				
				
				WebDriverWait Wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
				Wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div[1]/section/div[2]/a")));
				
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div[1]/section/div[2]/a")).click();
				 
			}
	        
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			 
			
			// 견적서요청건 >> RFQ NO을 선택해야함 
			
			String rfqno = rfq;
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div[2]/div[1]/table/tbody/tr["+rfqno+"]/td[2]/a")).click(); //견적서요청건 누름
									//	/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/a
		
			
			
			String groupnum= gnum;
			
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[2]/table/tbody/tr["+groupnum+"]/td[2]/a")).click();//그룹코드 
		
			WebDriverWait Wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			 
			 if(siteno.equals("1")) { 
				 if(id.trim().equals("F0022")) {
					 Wait3.until(	//소피텔 
					            ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"subListA_data\"]/table/tbody/tr[1]/td[6]/input[2]"))
					            //cssSelector로 선택한 부분이 존재할때까지 기다려라
					 );
				 }else {// 페어몬트
					 Wait3.until(	
					            ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"subListA_data\"]/table/tbody/tr[1]/td[7]/input[2]"))
					            //cssSelector로 선택한 부분이 존재할때까지 기다려라
					            
					 );
				 }
				 
			 }else { // 이비스
				 Wait3.until(	
				            ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"subListA_data\"]/table/tbody/tr[1]/td[6]/input[2]"))
				            //cssSelector로 선택한 부분이 존재할때까지 기다려라
				            
				 );
				 
			 }
			//*[@id="subListA_data"]/table/tbody/tr[1]/td[7]/input[2]
			 
			//findElements 여러개  findElement 단일
			
		/*
			for(int i=1 ; i<=elements.size();i++) {
			
			 WebElement= driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr["+i+"]/td[6]/input[2]"));
			 WebElement.clear();
			 WebElement.sendKeys("1");
			 //System.out.println(progress(i,elements.size())+""+item.getId());
			 
			 Thread.sleep(1000);
			
			 
			}
		 */
					 //System.out.println();
			// driver.findElement(By.xpath("//*[@id=\\\"subListA_data\\\"]/table/tbody/tr[2]/td[6]/input[2]")).
	        
	   } catch (Exception e) {
	    	
	       e.printStackTrace();
		   showMessageDialog(null,"html tag를 못찾거나 , 기타 error 입니다.");
		   driver.close();
		   System.exit(0);
	    } finally {
	
	        //driver.close(); //크롬 종료
	    }
	}
	public int sizes() {
		
		List<WebElement> elements = (List<WebElement>) driver.findElements(By.cssSelector("#subListA_data > table > tbody > tr"));
		// for (WebElement ele : elements) {      
			// System.out.println(ele.getText());      
		 //}
		
		return elements.size();
	}
	
	public String insert(int i) throws EncryptedDocumentException, IOException, InvalidFormatException{
		
	
		 //ExcelMnr excelMnr= new ExcelMnr();

		 //List<ExcelDto> listEx	= excelMnr.getProductList();
		//System.out.println(listEx.get(2).getProduct_name() );
		
		
		//System.out.println(i);
		WebElement= driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr["+i+"]/td[2]/span"));
		
		///html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr[1]/td[2]/span
		///html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr[2]/td[2]/span
		//System.out.println(WebElement.getText());
		System.out.println(listEx.get(i-1).getProduct_name().trim().equals(WebElement.getText().trim()));
		
		String pdt1 = listEx.get(i-1).getProduct_name().trim();
		String pdt2 = WebElement.getText().trim();
		
		boolean q = listEx.get(i-1).getProduct_name().trim().equals(WebElement.getText().trim());
		
		if(q) {  //제품이름 엑셀이랑 같은지 확인하고 같으면 넣고 안같으면 넘긴다.
			
			if(siteno.equals("1")) {//페어몬트,소피텔  1 true ,다른거면 0 false;
		
				if(id.trim().equals("F0022")) { //소피텔
					WebElement= driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr["+i+"]/td[6]/input[2]"));
				}else { //페어몬트
					
					WebElement= driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr["+i+"]/td[7]/input[2]"));
					
				}
			}else {
			
				WebElement= driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr["+i+"]/td[6]/input[2]"));
			}
			
			//WebElement= driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr["+i+"]/td[6]/input[2]"));
			WebElement.clear();
			System.out.println(listEx.get(i).getMoney());
			String moneys=(String.valueOf(listEx.get(i-1).getMoney()));
			WebElement.sendKeys(moneys); 
			System.out.println(listEx.get(i).getProduct_name() + "  true");
		}
		return " 엑셀 : "+pdt1 +", 참조페이지 :"+ pdt2 + ", 비교 = "+q ;
		
		
		/*
		System.out.println(listEx.get(2+i).getProduct_name() +" " +WebElement.getText() +"="+listEx.get(i).getProduct_name().equals(WebElement.getText()) );
	
		WebElement= driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/form[1]/div/div/div[4]/table/tbody/tr["+i+"]/td[6]/input[2]"));
		WebElement.clear();
		WebElement.sendKeys("1");
		*/
	}
}
