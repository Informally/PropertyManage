package Main;


import Pages.Login;

public class MainRun {

private static Login loginPage;

	

    public static void main(String[] args) {
        initProgram();
    }
	private static void initProgram() {
		
		loginPage = new Login();
		loginPage.loginPage.setVisible(true);
		
		
    }
	
	
	public static Login getLoginPage() {
        return loginPage;
    }

}
