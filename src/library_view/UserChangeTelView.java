package library_view;

import java.util.Scanner;

public class UserChangeTelView {

	private Scanner keyboard;

	public UserChangeTelView() {

		keyboard = new Scanner(System.in);
	}

	public String UserNewTel() {

		System.out.println("수정할 전화번호: ");
		String newTel = keyboard.nextLine();

		return newTel;

	}

}
