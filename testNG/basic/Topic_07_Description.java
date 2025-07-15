package basic;

import org.testng.annotations.Test;

public class Topic_07_Description {
    @Test(description = "Azure#9948 - Register new Account")
    public void register(){
        System.out.println("Register new account");
    }
    @Test(priority = 2)
    public void login(){
        System.out.println("Login to system");
    }
    @Test(priority = 3, enabled = false)
    public void order(){
        System.out.println("Oder product");
    }
    @Test(priority = 4)
    public void pay(){
        System.out.println("Pay product");
    }
    //@Test(priority = 5)
    public void ship(){
        System.out.println("ship product");
    }
}
