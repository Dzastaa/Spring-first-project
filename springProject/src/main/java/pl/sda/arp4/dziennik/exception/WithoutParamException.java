package pl.sda.arp4.dziennik.exception;

public class WithoutParamException extends RuntimeException{

    public WithoutParamException(String message) {
        super(message);
    }
}
