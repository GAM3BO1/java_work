package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 *  파일 copy 연습
 */
public class MainClass08 {
	public static void main(String[] args) {
		//필요한 참조값을 담을 지역변수를 미리 만들기
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("C:\\Users\\repla\\Desktop\\에이콘\\acorn202304\\myFolder\\1.png");
			fos = new FileOutputStream("C:\\Users\\repla\\Desktop\\에이콘\\acorn202304\\myFolder\\copied1.png");
			
			while(true) {
				//1 byte씩 읽어들이기
				int readedByte = fis.read();
				System.out.println(readedByte);
				//만약 더이상 읽게 없다면 반복문 탈출
				if(readedByte == -1) 
					break;
				
				//읽은 1 byte 출력
				fos.write(readedByte);
				fos.flush();
			}
			System.out.println("파일 copy 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null) {fos.close();}
				if(fis != null) {fis.close();}
			}catch(Exception e) {}
		}
	}
}
