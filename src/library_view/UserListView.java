package library_view;

import java.util.ArrayList;
import library_controller.Controllers;
import library_domain.User;

public class UserListView {

	public void PrintUserListView(ArrayList<User> userList) {
		
		System.out.println("\n[나의 정보 목록 보기 모드]");
		System.out.println("바코드번호\t ID \t 이름 \t 주소 \t 전화번호 \t 성별");
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


	}

	

	
}
