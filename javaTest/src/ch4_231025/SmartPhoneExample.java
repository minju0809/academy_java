package ch4_231025;

public class SmartPhoneExample {
	public static void main(String[] args) {
		Phone myPhone0 = new Phone(); 
			// ===> Phone 기본 생성자
		SmartPhone myPhone1 = new SmartPhone(); 
			// ===> Phone 기본 생성자
			// ===> SmartPhone 기본 생성자
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색"); 
			// ===> Phone 기본 생성자 <- super()
			// ===> Phone(String model, String color) 생성자 <- super(model, color)
			// ===> SmartPhone 매개변수 생성자 갤럭시, 은색

		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);		
		System.out.println("색상: " + myPhone.sno);

		System.out.println("와이파이 상태: " + myPhone.wifi);

		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		myPhone.sendVoice("아~ 네, 반갑습니다.");
		myPhone.hangUp();

		myPhone.setWifi(true);
		myPhone.internet();
	}
}
