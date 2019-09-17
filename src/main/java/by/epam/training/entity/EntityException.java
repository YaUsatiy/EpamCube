package by.epam.training.entity;

public class EntityException extends Exception {
    public EntityException() {}

    public EntityException(String message) {
        super(message);
    }

    public EntityException(Throwable cause) {
        super(cause);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }
}