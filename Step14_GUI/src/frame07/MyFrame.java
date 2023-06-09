package frame07;

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
		
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		
		JButton updateBtn = new JButton("수정");
		add(updateBtn);
		
		//전송, 삭제, 수정 버튼 모두 하나의 리스너 등록하기
		sendBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		
		//각각의 버튼에 action 명령을 설정할 수 있음
		sendBtn.setActionCommand("send");
		deleteBtn.setActionCommand("delete");
		updateBtn.setActionCommand("update");
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//MyFrame 객체 생성
		new MyFrame("나의 프레임");
		System.out.println("main 메소드 종료");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command 읽어오기
		String cmd = e.getActionCommand();
		/*
		 *  java에서 문자열의 참조값이 같은지 비교할 때는 비교 연산자(==)를 이용하여 비교
		 *  문자열의 참조값이 아닌 내용이 같은지 비교할 때는 String의 .equals() 메소드 이용하여 비교
		 *  
		 *  Why...
		 *  java에서는 문자열을 만드는 방법에 따라서 내용은 같지만 참조값이 다르게 나오는 경우 존재
		 *  따라서, 문자열의 내용이 같은지 정확히 비교할 때는 반드시 .equals() 메소드 사용
		 */
		if(cmd.equals("send")) {
			JOptionPane.showMessageDialog(this, "전송합니다");
		}else if(cmd.equals("delete")) {
			JOptionPane.showMessageDialog(this, "삭제합니다");
		}else if(cmd.equals("update")) {
			JOptionPane.showMessageDialog(this, "수정합니다");
		}
	}
}
