package platformWeb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_02_Product {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @Test(groups = {"platformWeb", "product"})
    public void User_01_CreateNewProduct(){

    }
    @Test(groups = {"platformWeb", "product"})
    public void User_02_EditProduct(){

    }
    @Test(groups = {"platformWeb", "product"})
    public void User_03_ViewProduct(){

    }
}
