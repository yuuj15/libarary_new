package library_view;

import java.util.Scanner;

public class UserChangeNameView {

	private Scanner keyboard;

	public UserChangeNameView() {

		keyboard = new Scanner(System.in);
	}

	public String UserNewName() {

		System.out.println("수정할 이름: ");
		String newName = keyboard.next();

		return newName;

	}

}
