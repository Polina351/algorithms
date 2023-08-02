package home_work_3_exc;

public class WrongLoginException extends Exception{
    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
