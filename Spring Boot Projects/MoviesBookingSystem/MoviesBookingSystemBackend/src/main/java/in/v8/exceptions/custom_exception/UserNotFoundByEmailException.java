package in.v8.exceptions.custom_exception;

public class UserNotFoundByEmailException extends RuntimeException {
	/**
	 * What is serialVersionUID?
	 * 		serialVersionUID is a unique identifier used during the serialization and deserialization of objects to verify that the sender and receiver of the serialized object have compatible classes.
	 * 		If not explicitly declared, Java generates one at runtime, but defining it explicitly avoids potential issues (e.g., incompatibility after class changes).
	 * Why Add serialVersionUID?
	 * 		Avoids unexpected InvalidClassException during deserialization.
	 * 		Eliminates the warning in your IDE.
	 * 		Ensures compatibility for serialized objects, even if the class evolves.
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundByEmailException(String message) {
		super(message);
	}
}
