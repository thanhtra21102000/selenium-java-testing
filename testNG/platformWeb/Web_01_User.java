package platformWeb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_01_User {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @Test(groups = {"platformWeb", "user"})
    public void User_01_CreateNewUser(){

    }
    @Test(groups = {"platformWeb", "user"})
    public void User_02_EditUser(){

    }
    @Test(groups = {"platformWeb", "user"})
    public void User_03_ViewUser(){

    }
}
