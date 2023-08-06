package OSIMacro;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

class JprogressBar extends JFrame implements ActionListener, Runnable{
	Container container = getContentPane();
	JLabel label = new JLabel("진행상황");
	JButton b1 = new JButton("시작");
	JButton b2 = new JButton("종료");
	JPanel panel = new JPanel();	// Button
	JProgressBar progressBar ;
	SeleniumMain sa  ;
	JTextArea txtLog = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(txtLog);
	
	
	 
	boolean progress = true;
	int num = 1; 
	int max;
	
	public JprogressBar(int a ) {
		//SeleniumTest sa = s;
		setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(JprogressBar.class.getResource("ryan.png")));
		this.max= a;
		progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, a);
		setTitle("진행상황");
		setSize(900, 150);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
		setResizable(false);
		
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("East", progressBar);//center
		container.add("West", progressBar);
		container.add("South", panel);
		this.add(scrollPane);
		
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//panel.add(b1);
		panel.add(b2);
		
		// set ProgressBar
		progressBar.setStringPainted(true);
		progressBar.setString("0%");
		
	}
	
	public SeleniumMain seleni(SeleniumMain s) {
		sa =s;
		return s;
	}
	void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//b1.addActionListener(this);
		new Thread(this).start();
		b2.addActionListener(this);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			progress = true;
			new Thread(this).start();
			b1.setEnabled(false); 
			b2.setEnabled(true);
		} else if (e.getSource() == b2) {
			//progress = false;
			//b1.setEnabled(true);
			//b2.setEnabled(false);
			
			System.exit(0);
		}
	}
	public void run() {
		if(num == max) {
			num = 0;
		}
		
		JOptionPane.showMessageDialog(null, "홈페이지의 데이터 갯수는 "+max + "개 입니다. 엑셀의 데이터 갯수를 확인하고 확인 버튼을 눌러주세요.","확인 해주세요",JOptionPane.QUESTION_MESSAGE );
		
		for(int i = num; i <= max; i++) {
			//if(!progress) break;
			try {
				Thread.sleep(1000);
				//System.out.println("1");
				try {
					
					
					txtLog.append(sa.insert(i)+"\n");
					txtLog.setCaretPosition(txtLog.getDocument().getLength());

				} catch (EncryptedDocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"엑셀파일을 못찾거나 읽지못하거나 기타 error입니다.");
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Format error 입니다.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"html tag를 못찾거나 , 기타 error 입니다.");
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "에러입니다.");
				
			}
			float a = (float) ((float) i /  max * 100.0);
			//System.out.println(a);
			progressBar.setValue(i);
			progressBar.setString(a + "%");
			
			if(i==max){
				JOptionPane.showMessageDialog(null, "완료했습니다.");
			}
		}
		//b1.setEnabled(true);
		b2.setEnabled(true); 
		
	}
	
	
}
