package org.apache.fineract.exception;
import org.apache.fineract.utils.ErrorCode;
@SuppressWarnings("serial")
public class ConnectException extends Exception {
	private ErrorCode errorCode;
	
	public ConnectException(final ErrorCode code) {
        super(code.getMessage());
        this.errorCode = code;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getCanonicalName());
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(this.errorCode.getCode());
        stringBuilder.append(": ");
        stringBuilder.append(this.errorCode.getMessage());
        return stringBuilder.toString();
    }
}
