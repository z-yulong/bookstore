import org.mindrot.jbcrypt.BCrypt;

/**
 * @author: zyl
 * @date 2023/3/11 8:38
 */
public class WebAppliction {
    public static void main(String[] args) throws Exception {

        long l = System.currentTimeMillis();
        String password = "123456";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // Print hashed password
        System.out.println("Hashed Password: " + hashedPassword);

        // Check if entered password matches with hashed password
        if (BCrypt.checkpw(password, "$2a$10$8LU2d6FXwIkj5C4yGq0oN.FH5FUjSVNmxmH7zZoxIxPTqhFogBNaK"))
            System.out.println("Password Matched!");
        else
            System.out.println("Invalid Password!");
        long e = System.currentTimeMillis();
        System.out.println(e-l);

    }
}
