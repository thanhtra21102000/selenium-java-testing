package javaTester;

public class Topic_05_Path {
    public static void main(String[] args){
        String osName = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        String projectPath = System.getProperty("user.dir");
        String uploadFilePath = System.getProperty("user.dir") + "\\uploadFiles\\"; //mac // ngược lại
        String chandung = "chandung.jpg";
        String oto = "oto.jpg";
        String sutu = "sutu.jpg";

        System.out.println(osName);
        System.out.println(javaVersion);
        System.out.println(projectPath);
        System.out.println(uploadFilePath);
        System.out.println(uploadFilePath + chandung);
        System.out.println(uploadFilePath + oto);
        System.out.println(uploadFilePath + sutu);
    }
}
