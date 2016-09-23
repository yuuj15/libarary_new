package library_main;

import library_controller.Controllers;
import library_controller.LoginController;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();
		LoginController loginController = Controllers.getLoginControlles();
		loginController.requestMainLogin();

	}

}
