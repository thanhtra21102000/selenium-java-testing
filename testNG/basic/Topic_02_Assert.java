package basic;

import graphql.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {
    @Test
    public void login(){
        // Bắt buộc phải kiểu dữ liệu boolean
        // Selenium: tiền tố là isXXX: isDisplay/ isEnable/ isSelected/ isMultiple
        // Hàm tự define trả về boolean
        // True: Khi cần kiểm tra 1 dữ liệu trả về là đúng
        // False: Khi cần kiểm tra 1 dữ liệu trả về là sai
        Assert.assertTrue(5>3);

        boolean status = 5<3;
        System.out.println(status);
        Assert.assertFalse(status);
        // Equals: Kiểm tra dữ liệu mong đợi với thực tế giống nhau
        // 2 vế đều cùng 1 kiểu dữ liệu
        // Kiểm tra về giá trị của dữ liệu và kiểu dữ liệu
        String studentName = "Đặng Thùy Trâm";
    }
}
