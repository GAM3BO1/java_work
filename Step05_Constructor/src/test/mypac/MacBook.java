package test.mypac;

public class MacBook {
	//외부에서 접근불가 하도록 접근지정자를 private로 해서 필드 3개 선언하기
	private Cpu cpu;
	private Memory memory;
	private HardDisk hardDisk;

	//생성자
	public MacBook(Cpu cpu, Memory memory, HardDisk hardDisk) {
		this.cpu = cpu;
		this.memory = memory;
		this.hardDisk = hardDisk;
	}

	//메소드
	public void doGame() {
		if(this.cpu == null || memory == null || hardDisk == null) {
			System.out.println("부품이 부족해서 게임을 할수가 없어요!");
			return; //메소드를 여기서 종료하기
		}
		System.out.println("신나게 게임을 해요");
	}
}