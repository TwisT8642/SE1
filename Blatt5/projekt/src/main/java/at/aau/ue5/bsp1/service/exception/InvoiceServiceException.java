package at.aau.ue5.bsp1.service.exception;

public class InvoiceServiceException extends Exception {
	private static final long serialVersionUID = 6830071372702994060L;

	public InvoiceServiceException() {
        super();
    }

    public InvoiceServiceException(String message) {
        super(message);
    }
}
