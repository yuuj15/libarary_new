package library_controller;

public class Controllers {

	private static LoginController loginControlles;
	private static UserController userController;
	private static BookController bookController;
	private static ProgramController programController;
	private static UserPageController userpageController;
	
	public Controllers() {

		loginControlles = new LoginController();
		userController = new UserController();
		bookController = new BookController();
		programController = new ProgramController();
		userpageController = new UserPageController();
		
	}

	public static LoginController getLoginControlles() {
		return loginControlles;
	}

	public static UserController getUserController() {

		return userController;

	}

	public static BookController getBookController() {

		return bookController;

	}

	public static ProgramController getProgramController() {

		return programController;
	}

	public static UserPageController getUserpageController() {

		return userpageController;

	}

	
}
