package library_view;

import java.util.Scanner;

public class UserChangeAddrView {

	private Scanner keyboard;

	public UserChangeAddrView() {

		keyboard = new Scanner(System.in);
	}

	public String UserNewAddr() {

		System.out.println("수정할 주소: ");
		String newAddr = keyboard.next();

		return newAddr;

	}

}
