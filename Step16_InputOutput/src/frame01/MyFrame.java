package frame01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	public MyFrame(String title) {
		super(title);

		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//BorderLayout으로 설정
		setLayout(new BorderLayout());

		//UI를 감쌀 Panel
		JPanel p1 = new JPanel();

		JTextField inputText = new JTextField(20);
		JButton saveBtn = new JButton("저장");

		//패널에 UI를 추가
		p1.add(inputText);
		p1.add(saveBtn);

		//패널을 프레임의 북쪽에 배치
		add(p1, BorderLayout.NORTH);
		//패널의 배경색
		p1.setBackground(Color.PINK);
		/*
		 *  읽어오기 버튼을 누르면 diary.txt에 있는 모든 문자열을 읽어와서
		 *  JTextArea에 출력
		 *  
		 *  FileReader 객체를 활용하면 파일에서 문자열을 읽을 수 있음
		 */

		JTextArea ta = new JTextArea();
		add(ta, BorderLayout.CENTER);

		JButton readBtn = new JButton("읽어오기");
		p1.add(readBtn);

		setVisible(true);

		//File 객체
		File f = new File("C:\\Users\\repla\\Desktop\\에이콘\\acorn202304\\myFolder\\diary.txt");
		//저장 버튼에 리스너 등록
		saveBtn.addActionListener((e2)->{
			//입력한 문자열 읽어오기
			String msg = inputText.getText();	//바깥 영역에 정의된 지역변수 참조 가능

			try {
				if(!f.exists()) {
					f.createNewFile();
				}
				//파일에 문자열을 출력할 객체
				FileWriter fw = new FileWriter(f, true);
				fw.write(msg);
				fw.write("\r\n");	//개행 기호
				fw.flush();
				fw.close();

				JOptionPane.showMessageDialog(this, "저장했습니다");
			}catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		//읽어오기 버튼에 리스너 등록
		readBtn.addActionListener((e2)->{
			//try 블럭 안에서 사용할 변수를 미리 만들어놓기
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				//반복문
				while(true) {
					//문자열을 한줄씩 읽어내기
					String line = br.readLine();
					
					//만약 더이상 읽을 문자열이 없다면 반복문 탈출
					if(line == null) {break;}
					
					//읽어낸 문자열을 JTextArea에 출력하기
					ta.append(line);	//개행기호는 제외된 상태로 읽어옴
					ta.append("\r\n");	//개행기호 추가
				}
			} catch (IOException e) {	//파일이 존재하지 않을 경우 에러 발생
				e.printStackTrace();
			} finally {
				//사용했던 스트림은 열렸던 순서의 역순으로 닫아주는 것이 좋음
				try {
					//close()를 호출할 때도 null에 주의하여 호출
					if(br != null) {br.close();}
					if(fr != null) {fr.close();}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}
