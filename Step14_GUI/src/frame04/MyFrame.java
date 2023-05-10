package frame04;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	//생성자
	public MyFrame(String title) {
		super(title);
		
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//BorderLayout 매니저 사용
		setLayout(new BorderLayout());
		
		JButton btn1 = new JButton("버튼1");
		add(btn1, BorderLayout.NORTH);	//프레임에 버튼 추가
		
		JButton btn2 = new JButton("버튼2");
		add(btn2, BorderLayout.EAST);	//프레임에 버튼 추가
		
		JButton btn3 = new JButton("버튼3");
		add(btn3, BorderLayout.SOUTH);	//프레임에 버튼 추가
		
		JButton btn4 = new JButton("버튼4");
		add(btn4, BorderLayout.WEST);	//프레임에 버튼 추가
		
		//프레임을 화면상에 실제 보이게 하기(false 하면 화면에 보이지 않음)
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//MyFrame 객체 생성
		new MyFrame("나의 프레임");
		System.out.println("main 메소드 종료");
	}
}
