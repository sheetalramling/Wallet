package exceptions;

public class InvalidMoneyException extends Exception {
    public InvalidMoneyException(String errorMessage) {
        super(errorMessage);
    }
}
