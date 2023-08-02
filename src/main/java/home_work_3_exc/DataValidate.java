package home_work_3_exc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DataValidate {
    static String pattern = "[A-Za-z0-9]*_?[A-Za-z0-9]*";
    public static BoolVariable dataValidate(String login, String password, String confirmPassword) {
        BoolVariable bv = new BoolVariable();
        bv.setBool(true);
        bv.setS("");
        Pattern myPattern = Pattern.compile(pattern);
        Matcher loginMatcher = myPattern.matcher(login);
        Matcher passwordMatcher = myPattern.matcher(password);
        try {
            if (!loginMatcher.matches()) {
                throw new WrongLoginException("Invalid symbols in Login folder!");
            }
            if (login.length() > 19) {
                throw new WrongLoginException("        Login is too long!");
            }
            if (!passwordMatcher.matches()) {
                throw new WrongPasswordException("Invalid symbols in Password folder!");
            }
            if (password.length() > 19) {
                throw new WrongPasswordException("     Password is too long!");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException(" Password confirm failed!");
            }
        } catch (WrongPasswordException | WrongLoginException exception) {
            bv.setBool(false);
            bv.setS(exception.getMessage());
        }
        return bv;
    }
}
