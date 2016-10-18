package library_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_controller.Controllers;
import library_domain.User;

public class UserListView {
	
	private Scanner keyboard;
	
	public UserListView()
	{
		keyboard = new Scanner(System.in);
	}

	public void PrintUserListView(ArrayList<User> userList) {
		
		System.out.println("\n[나의 정보 목록 보기 모드]");
		System.out.println("바코드번호\tID\t이름\t주소\t전화번호\t\t성별");
		if (userList.size() == 0) {
			System.out.println("나의 정보가 없습니다.");
		} else {

			for (int i = 0; i < userList.size(); i++) {
				System.out.print(userList.get(i).getUserBarcode() + "\t");
				System.out.print(userList.get(i).getUserId()+ "\t");
				System.out.print(userList.get(i).getUserName()+ "\t");
				System.out.print(userList.get(i).getUserAddr()+ "\t");
				System.out.print(userList.get(i).getUserTel()+ "\t");
				System.out.println(userList.get(i).getUserGender());
			}
		}
		
		this.menu();
	}

	private void menu() {
		System.out.println("회원정보 수정메뉴");
		System.out.println("1.이름수정, 2.주소수정, 3.전화번호 수정  4.메인페이지 ");
		int number = keyboard.nextInt();
		
		if(number == 1)
		{
			Controllers.getUserController().requestChangeName();
		}
		else if(number == 2)
		{
			Controllers.getUserController().requestChangeAddr();
		}
		else if(number == 3)
		{
			Controllers.getUserController().requestChangeTel();
		}
		else if(number == 4)
		{
			Controllers.getLoginControlles().requestMainLogin();
		}
		else
		{
			System.out.println("잘못입력하셨습니다.");
		}
		
	}

	

	
}
