package retry.exception;

public class CustomException extends RuntimeException {

    private Long errorId;


    public CustomException(Long errorId, String message) {
        super(message);
        this.errorId = errorId;
    }

    public Long getLoadGroupId() {
        return errorId;
    }

}
