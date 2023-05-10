package frame05;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{
	//생성자
	public MyFrame(String title) {
		super(title);
		
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		
		//ActionListener 인터페이스 type의 참조값
		ActionListener listener1 = new ActionListener() {
			//이 리스너를 등록한 UI에 어떤 액션이 발생하면 호출되는 메소드
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("전송 버튼 클릭");
				//JOptionPane.showMessageDialog(프레임의 참조값, 띄울 메시지); - 알림창
				//클래스명.this 하면 바깥에 있는 클래스로 생성한 객체의 참조값을 가리킬 수 있음
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다");	
			}
		};
		
		//전송 버튼에 등록
		sendBtn.addActionListener(listener1);
		
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		
//		deleteBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("삭제 버튼 클릭");
//			}
//		});
		
		//ActionListener 인터페이스 type의 참조값을 함수 형태로 전달 가능
		deleteBtn.addActionListener((e)->{
			System.out.println("삭제 버튼 클릭");
			//함수 형태의 메소드에서 this는 바깥 클래스로 생성한 객체의 참조값을 가리킬 수 있음
			JOptionPane.showMessageDialog(this, "삭제합니다");
		});
		
		JButton updateBtn = new JButton("수정");
		add(updateBtn);
		
		//MyFrame을 ActionListener 인터페이스 type으로 만들기
		updateBtn.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//MyFrame 객체 생성
		new MyFrame("나의 프레임");
		System.out.println("main 메소드 종료");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "수정합니다");		
	}
}
