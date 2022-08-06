package login;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "LoginDataProvider")
    public Object[][] getLoginData() {
        Object[][] loginData = {
                {"user1@test.com", "user1password" },
                {"user2@test.com", "user2password" },
                {"user3@test.com", "user3password" },
                {"tomsmith", "SuperSecretPassword!" }
        };
        return loginData;
    }
}
