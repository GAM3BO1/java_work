package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 *  파일 copy 연습
 */
public class MainClass09 {
	public static void main(String[] args) {
		//필요한 참조값을 담을 지역변수를 미리 만들기
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("C:\\Users\\repla\\Desktop\\에이콘\\acorn202304\\myFolder\\1.png");
			fos = new FileOutputStream("C:\\Users\\repla\\Desktop\\에이콘\\acorn202304\\myFolder\\copied2.png");
			//byte 알갱이를 읽어낼 배열 미리 생성
			byte[] buffer = new byte[1024];
			while(true) {
				//byte[] 배열을 전달해서 byte 알갱이를 한번에 1024개씩 읽어들이기
				int readedCount = fis.read(buffer);
				if(readedCount == -1) 
					break;
				
				//byte[] 배열에 저장된 byte 알갱이를 0번 인덱스부터 읽은 개수만큼만 출력
				fos.write(buffer, 0, readedCount);
				fos.flush();
			}
			System.out.println("파일 copy 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null) {fos.close();}
				if(fis != null) {fis.close();}
			}catch(Exception e) {
				
			}
		}
	}
}
