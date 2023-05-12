package frame01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame{
	//현재 열려있는 File 객체의 참조값을 저장할 필드
	File openedFile;
	JTextArea ta;
	
	public MyFrame2(String title) {
		super(title);

		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//메뉴바
		JMenuBar mb = new JMenuBar();
		//메뉴
		JMenu menu = new JMenu("File");
		//메뉴 아이템
		JMenuItem newItem = new JMenuItem("New");		
		JMenuItem openItem = new JMenuItem("Open");		
		JMenuItem saveItem = new JMenuItem("Save");		
		JMenuItem saveAsItem = new JMenuItem("Save As");		
		
		//메뉴에 메뉴 아이템 순서대로 추가
		menu.add(newItem);
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(saveAsItem);
		
		//메뉴를 메뉴바에 추가
		mb.add(menu);
		//프레임의 메소드를 이용해서 메뉴바 추가
		setJMenuBar(mb);
		
		//JTextArea 
		ta = new JTextArea();
		add(ta, BorderLayout.CENTER);
		
		//Open을 눌렀을 때 실행할 리스너 등록
		openItem.addActionListener((e2)->{
			//파일 선택 객체
			JFileChooser fc = new JFileChooser("C:\\Users\\repla\\Desktop\\에이콘\\acorn202304\\myFolder\\diary.txt");
			int op = fc.showOpenDialog(this);
			if(op == JFileChooser.APPROVE_OPTION) {
				//선택한 파일을 제어할 수 있는 File 객체가 리턴 (필드에 저장)
				openedFile = fc.getSelectedFile();
				//선택한 파일의 경로
				String path = openedFile.getAbsolutePath();
				//프레임의 제목에 선택한 파일의 경로 출력
				this.setTitle(path);
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(openedFile);
					br = new BufferedReader(fr);
					
					while(true) {
						String line = br.readLine();
						
						if(line == null) {break;}
						ta.append(line);	
						ta.append("\r\n");	
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if(br != null) {br.close();}
						if(fr != null) {fr.close();}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		//Save를 눌렀을 때 실행할 리스너 등록
		saveItem.addActionListener((e2)->{
			//만약 열려진 파일이 없다면
			if(openedFile == null) {
				JOptionPane.showMessageDialog(this, "파일을 선택해주세요");
				return;	//여기서 메소드 종료
			}
			//입력한 내용을 파일에 저장하기
			saveToFile();
		});
		
		//Save As를 눌렀을 때 실행할 리스너 등록
		saveAsItem.addActionListener((e2)->{
			JFileChooser fc = new JFileChooser("C:\\Users\\repla\\Desktop\\에이콘\\acorn202304\\myFolder\\diary.txt");
			int result = fc.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION) {
				//선택한 File 객체의 참조값을 얻어내서 필드에 저장
				openedFile = fc.getSelectedFile();
				//title 출력
				setTitle(openedFile.getAbsolutePath());
				//새로운 파일 생성
				try {
					openedFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//파일에 문자열 저장하기
				saveToFile();
			}
		});
		
		setVisible(true);
	}
	
	//파일에 저장하는 메소드
	public void saveToFile() {
		//JTextArea에 입력한 문자열 읽어오기
		String content = ta.getText();
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(openedFile);
			bw = new BufferedWriter(fw);
			
			bw.write(content);
			bw.flush();
			JOptionPane.showMessageDialog(this, "저장했습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) {bw.close();}
				if(fw != null) {fw.close();}
			}catch(Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {
		new MyFrame2("나의 프레임");
	}
}
