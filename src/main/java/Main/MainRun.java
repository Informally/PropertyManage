package Main;

import Pages.BuildingManagerMenu;
import Pages.Login;

public class MainRun {

private static Login loginPage;
private static BuildingManagerMenu bmm;
	

    public static void main(String[] args) {
        initProgram();
    }
	private static void initProgram() {
		
		loginPage = new Login();
		loginPage.loginPage.setVisible(true);
		
		bmm = new BuildingManagerMenu();
		
		

    }
	
	
	public static Login getLoginPage() {
        return loginPage;
    }

}
