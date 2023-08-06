package OSIMacro;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.NumberFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.sun.media.sound.Toolkit;





@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener{
    
	
	

	JframeFields item= new JframeFields();
	
	
	public String fileAddress =""; //chromedriver파일주소
	public String exelAddress =""; //엑셀 파일주소
	
	
	
	
    private JFileChooser jfc = new JFileChooser();
    private JFileChooser exelfc = new JFileChooser();
    public JTextArea ta;	//텍스트에리어
    private JScrollPane sc; //스크롤
    private JButton jbt_open;	//크롬 파일 경로창	
    private JButton exel_open;
    private JButton start;	//시작버튼
    //private JRadioButton radio[] = new JRadioButton[3];
  
    //private Container con;
    //private BorderLayout bl = new BorderLayout();
    
    
    
    private JTextField idtext;
    private JPasswordField passtext;
    private JTextField years;
    private JFormattedTextField month;
    private JTextField groupcode;
    private JTextField rfqno;
    private JTextField srfq; //견적상태
    
    private JFormattedTextField siteno;
    private JTextField siteurl;
    static Image image;
    // private JButton jbt_save = new JButton("저장");
    private JLabel jlb ;
    private JLabel jlb1 ;
    private JLabel jlb2 ;
    private JLabel jlb3 ;
    private JLabel jlb4 ;
    private JLabel jlb5 ;
    private JLabel jlb6 ;
    private JLabel jlb7 ;
    private JLabel jlb8 ;
    private JLabel jlb9 ;
    private JLabel jlb10 ;
    private JLabel jlb11 ;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7; 
    private JPanel panel8;
    private JPanel panel9 ;
    
    ImageIcon icon;
    
   
    public MainFrame(){
    	
            super("OSI 매크로");
            setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("ryan.png")));
            
            
    		this.init();
            this.start();
            this.setSize(1000,500);
            
            //화면 보이게..
            this.setVisible(true);
            
    }
     
    public MainFrame(int a) {
    	
    }
    
  
	public void init(){ 
    		
    	
    		
  
    	 
    		getContentPane().setLayout(null);//레이아웃 고정은 setLayout(new FlowLayout()) 레이아웃 고정이 아닐때 setLayout(null);
            //getContentPane().setBackground(Color.WHITE);
          
           
            
            jlb = new JLabel("파일설정 : ");
            jlb.setForeground(Color.BLACK);
            jlb.setBounds(160,15, 500, 40);
            jbt_open = new JButton("열기");
            jbt_open.setBounds(20,20, 80, 30);
            start = new JButton("시작");
    		start.setBounds(20,400, 80, 30);
        
            panel1 = new JPanel();
            panel1.setBackground(Color.PINK);
            panel1.setBounds(20, 60, 200, 30);
            add(panel1);
            panel1.setLayout(new BorderLayout());
            
            jlb1 = new JLabel("아이디 : ");
            idtext = new JTextField();//
            panel1.add(jlb1,BorderLayout.WEST);
            panel1.add(idtext,BorderLayout.CENTER) ;
            
            panel2 = new JPanel();
            panel2.setBackground(Color.YELLOW);
            panel2.setBounds(250, 60, 200, 30);
            add(panel2);
            panel2.setLayout(new BorderLayout());
            
            jlb2 = new JLabel("비밀번호 : ");
            passtext = new JPasswordField();
            panel2.add(jlb2,BorderLayout.WEST);
            panel2.add(passtext,BorderLayout.CENTER) ;
             
            panel3 = new JPanel();
            panel3.setBackground(Color.CYAN);
            panel3.setBounds(20, 110, 100, 30);
            add(panel3);
            panel3.setLayout(new BorderLayout());
            
            jlb3 = new JLabel("년도 : ");
            years = new JTextField(1);
           // years = new JTextField(4);
            panel3.add(jlb3,BorderLayout.WEST);
            panel3.add(years,BorderLayout.CENTER) ;
            
            panel4 = new JPanel();
            panel4.setBackground(Color.CYAN);
            panel4.setBounds(130, 110, 50, 30);
            add(panel4);
            panel4.setLayout(new BorderLayout());
            
            jlb4 = new JLabel("월 : ");
            NumberFormatter monthlimit = new NumberFormatter();
            monthlimit.setValueClass(Integer.class);
            monthlimit.setMinimum(new Integer(1));
            monthlimit.setMaximum(new Integer(12));
            month = new JFormattedTextField(monthlimit);
            month.setColumns(13); 
            //month = new JTextField(1);
            panel4.add(jlb4,BorderLayout.WEST);
            panel4.add(month,BorderLayout.CENTER);
            
            panel9 = new JPanel();
            panel9.setBackground(Color.CYAN);
            panel9.setBounds(190, 110, 100, 30);
            add(panel9);
            panel9.setLayout(new BorderLayout());
            
            jlb11 = new JLabel("견적상태: ");
            srfq = new JTextField(1);
            panel9.add(jlb11,BorderLayout.WEST);
            panel9.add(srfq,BorderLayout.CENTER);
            
            
            
            
            
            
            panel5 = new JPanel();
            panel5.setBackground(Color.CYAN);
            panel5.setBounds(410, 110, 150, 30);
            add(panel5);
            panel5.setLayout(new BorderLayout());
            
            jlb5 = new JLabel("그룹코드의 몇번째: ");
            groupcode = new JTextField(1);
            panel5.add(jlb5,BorderLayout.WEST);
            panel5.add(groupcode,BorderLayout.CENTER);
            
            panel6 = new JPanel();
            panel6.setBackground(Color.red);
            panel6.setBounds(310, 110, 80, 30);
            add(panel6);
            panel6.setLayout(new BorderLayout());
            
            jlb6 = new JLabel("RFQ no: ");
            rfqno = new JTextField(1);
            panel6.add(jlb6,BorderLayout.WEST);
            panel6.add(rfqno,BorderLayout.CENTER); 
            
            
            
            
            jlb7 = new JLabel("파일설정 : ");
            jlb7.setForeground(Color.BLACK);
            jlb7.setBounds(160,144, 500, 40);
            add(jlb7); 
            
            jlb8  = new JLabel("version:0.0.3 beta -K");
            jlb8.setBounds(20,430, 200, 40);
            add(jlb8);
            
            panel7 = new JPanel();
            panel7.setBackground(Color.green);
            panel7.setBounds(20, 200, 210, 30);
            add(panel7);
            panel7.setLayout(new BorderLayout());
            
            jlb9 = new JLabel("(페어몬트,소피텔)=1,(이비스)=0 : ");
            NumberFormatter sitenolimit = new NumberFormatter();
            sitenolimit.setValueClass(Integer.class);
            sitenolimit.setMinimum(new Integer(0));
            sitenolimit.setMaximum(new Integer(1));
            siteno = new JFormattedTextField(sitenolimit);
            siteno.setColumns(2);
            //siteno = new JTextField(1);
            panel7.add(jlb9,BorderLayout.WEST);
            panel7.add(siteno,BorderLayout.CENTER); 
            
            panel8 = new JPanel();
            panel8.setBackground(Color.orange);
            panel8.setBounds(20, 240, 450, 30);
            add(panel8);
            panel8.setLayout(new BorderLayout());
            
            jlb10 = new JLabel("해당사이트url : <http:// 포함> ");
            siteurl = new JTextField(1);
            panel8.add(jlb10,BorderLayout.WEST);
            panel8.add(siteurl,BorderLayout.CENTER); 
            
            
            
            
            
            
            
            exel_open = new JButton("엑셀파일열기");
            exel_open.setBounds(20,150, 130, 30);
            add(exel_open);
            
            
            
            
            String tx="****chrome version 103.0.5060.53 유지 중요***** \n"
            		+ "1. 열기 버튼을 눌러 1이라는 폴더 안에 test.exe를 열어주세요. \n"
            		+ "2. 아이디와 비밀번호를 입력해주세요 \n"
            		+ "3. 견적 요청 페이지에 해당 년도, 월 ,을 설정해주세요.(견적상태 값은 고정으로 되어 있습니다) \n"
            		+ "3.5 견적상태<이비스:견적요청=3, 페어몬트:견적요청=3,재견적요청=5, 소피텔:견적요청=3 , 재견적요청=5> \n"
            		+ "4. RFQ NO 위에서부터 1부터 시작합니다. \n"
            		+ "5. 그룹번호가 위에서부터 1부터 시작합니다. \n"
            		+ "6. 해당 사이트 주소를 입력해주세요 .예)http://naver.com  \n"
            		+ "7. 엑셀 파일(엑셀표준)을 찾아서 올려주세요.  그리고 시작을 눌러주세요. \n"
            		+ "<이 프로그램은 영리 목적으로 쓸수 없으며  무단 배포 및 불법으로 사용을 금지합니다.>";
    		ta = new JTextArea(300,300); 
            ta.setBounds(650, 120, 0, 0);
            sc = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ta.setText(tx);//꽉차면 다음줄로 가게 해줌.
            ta.setLineWrap(true);
          //sc.setBorder(null); 
            sc.setBounds(650, 120, 300, 300);
            ta.setEditable(false);
            add(sc); 
            add(jlb); 
            add(jbt_open); 
            add(start);
            setResizable(false);
            
           //panel.setLayout(new FlowLayout(FlowLayout.RIGHT));//글자수 나오는칸 오른쪽으로 가게 해줌.
           //add(sc, BorderLayout.CENTER);
           //this.add(panel, BorderLayout.SOUTH);
           //sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//수평 스크롤 안쓰게함.
           //sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
           //pack();
           //add(jbt_save);
            
            
          
    }
   
  

	public void start(){
    	
            jbt_open.addActionListener(this);

            jfc.setFileFilter(new FileNameExtensionFilter("exe", "exe"));
            
            // 파일 필터
            jfc.setMultiSelectionEnabled(false);//다중 선택 불가
            
           // idtext.addActionListener(this);
            
            
            exel_open.addActionListener(this);
            exelfc.setFileFilter(new FileNameExtensionFilter("xlsx", "xlsx"));
            exelfc.setMultiSelectionEnabled(false);
            
            start.addActionListener(this);
    }

    
    
    public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            if(arg0.getSource() == jbt_open){
                    if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                            // showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
                            
                            fileAddress =  jfc.getSelectedFile().toString();
                            File f = new File(fileAddress);
                            
                            if(!f.getName().equals("test.exe")) {
                            	fileAddress = "";
                            	jlb.setText("열기 경로 : ");
                            	showMessageDialog(null,"1이라는 폴더 안에 test.exe파일을 다시 열어주세요");
                            	
                            }else {
                            	jlb.setText("열기 경로 : " + jfc.getSelectedFile().toString());
                            }
                          
                            System.out.println("파일열기:"+fileAddress);
                    }
            }
            
            if(arg0.getSource() == exel_open) {
            		if(exelfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            			jlb7.setText("열기 경로 : " + exelfc.getSelectedFile().toString());
            			exelAddress =  exelfc.getSelectedFile().toString();
            			
            			System.out.println(exelAddress);
            		}
            }
             
            
            
            
            else if (arg0.getSource() == start){//스위치
            	
            	if(nullCheck(idtext.getText().trim())) showMessageDialog(null,"아이디를 입력해주세요.");
            	if(nullCheck(passtext.getText().trim())) showMessageDialog(null,"비밀번호를 입력해주세요");
            	if(nullCheck(years.getText().trim())) showMessageDialog(null,"년도 입력해주세요");
            	if(nullCheck(month.getText().trim())) showMessageDialog(null,"월을 입력해주세요");
            	if(nullCheck(srfq.getText().trim())) showMessageDialog(null,"견적상태 입력해주세요.");
            	if(nullCheck(rfqno.getText().trim())) showMessageDialog(null,"RFQ no 입력해주세요.");
            	if(nullCheck(groupcode.getText().trim())) showMessageDialog(null,"그룹코드 입력해주세요");
            	if(nullCheck(siteno.getText().trim())) showMessageDialog(null,"사이트 number를 입력해주세요");
            	if(nullCheck(siteurl.getText().trim())) showMessageDialog(null,"사이트 주소를 입력해주세요");
            	if(jfc.getSelectedFile()==null) showMessageDialog(null,"Test.exe를 파일찾지 못했습니다.");
            	if(exelfc.getSelectedFile()==null) showMessageDialog(null,"엑셀파일을 찾지 못했습니다.");
            	
            	
            	if(!nullCheck(idtext.getText().trim()) &&
            	 !nullCheck(passtext.getText().trim()) &&
            	 !nullCheck(years.getText().trim())&&
            	 !nullCheck(month.getText().trim())&&
            	 !nullCheck(rfqno.getText().trim())&&
            	 !nullCheck(srfq.getText().trim())&&
            	 !nullCheck(groupcode.getText().trim())&&
            	 !(jfc.getSelectedFile() == null) &&
            	 !(exelfc.getSelectedFile()== null)&&
            	 !nullCheck(siteno.getText().trim())&&
            	 !nullCheck(siteurl.getText().trim())
            	) {
            	
	            	
	             	item.setId(idtext.getText().trim()); //아이디
	            	item.setPw(passtext.getText().trim()); //패스워드
	            	item.setYear_DT(years.getText().trim()); //년도
	            	item.setMonth_DT(month.getText().trim());//월
	            	item.setSrfq(srfq.getText().trim()); //견적상태
	            	item.setRfq(rfqno.getText().trim());  //rfqno
	            	item.setGroupnum(groupcode.getText().trim()); //그룹코드
	            	item.setFileAddres(jfc.getSelectedFile().toString().trim()); //exe 파일 주소
	            	item.setExelfileAddres(exelfc.getSelectedFile().toString().trim()); //엑셀 파일주소
	            	item.setSiteno(siteno.getText().trim()); //사이트 
	            	item.setSiteurl(siteurl.getText().trim()); //url
	            	
	            	
	            	int s = 1; 
	            	
	            	if(s == 1) {
		            	SeleniumMain selTest = null;
						try {
							selTest = new SeleniumMain(item);
							//selTest.items(item);
			     	        selTest.crawl();
			     	        System.out.println(selTest.sizes());
			     	        JprogressBar pro = new JprogressBar(selTest.sizes());
			     	        pro.seleni(selTest);
		     	        
			     	        //new Thread(pro).start();
						}catch (EncryptedDocumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							showMessageDialog(null,"엑셀파일을 못찾거나 읽지못하거나 기타 error입니다.");
						} catch (InvalidFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							showMessageDialog(null,"Format error 입니다.");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							showMessageDialog(null,"html tag를 못찾거나 , 기타 error 입니다.");
						} catch(NumberFormatException e) {
						
							showMessageDialog(null,"엑셀 값에 특수문자가 있습니다! 없애주세요.");
	            		}
		     	        ++s; 
	            	}
	            	 
            	}
            	
            }       	
   }
            
    public boolean nullCheck(String param) {
    	if (param == null || param.length() == 0 || param == "" ||param.equals("")) {
    			return true;
    		} else {
    			return false;
    		}


    }
            
            
            /*else if(arg0.getSource() == jbt_save){
                    if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                            // showSaveDialog 저장 창을 열고 확인 버튼을 눌렀는지 확인
                            jlb.setText("저장 경로 : " + jfc.getSelectedFile().toString() + "." + jfc.getFileFilter().getDescription());
                    }
             }*/
            
           // if(arg0.getSource() == jbtradio) {
            	
            //}
}