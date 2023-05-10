package frame06;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{
	//필드
	//동일한 type인 경우 1줄에 선언 가능
	JButton sendBtn, deleteBtn, updateBtn;
	
	//생성자
	public MyFrame(String title) {
		super(title);
		
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		//전송 버튼의 참조값을 필드에 저장(this.은 생략 가능)
		this.sendBtn = new JButton("전송");
		add(sendBtn);
		
		deleteBtn = new JButton("삭제");
		add(deleteBtn);
		
		updateBtn = new JButton("수정");
		add(updateBtn);
		
		//전송, 삭제, 수정 버튼 모두 하나의 리스너 등록하기
		sendBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
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
		//메소드의 매개변수로 전달되는 ActionEvent 객체에 이벤트에 대한 정보가 들어있음
		//이 객체를 활용하면 어떤 버튼이 눌러졌는지 구별 가능
		
		//눌러진 버튼의 참조값 얻어오기
		Object button = e.getSource();
		if(button == sendBtn) {
			JOptionPane.showMessageDialog(this, "전송합니다");
		}else if(button == deleteBtn) {
			JOptionPane.showMessageDialog(this, "삭제합니다");
		}else if(button == updateBtn) {
			JOptionPane.showMessageDialog(this, "수정합니다");
		}
	}
}
