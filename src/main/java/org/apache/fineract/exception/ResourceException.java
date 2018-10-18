package org.apache.fineract.exception;

import org.apache.fineract.utils.ErrorCode;
@SuppressWarnings("serial")
public class ResourceException extends Exception{
	
	private ErrorCode errorCode;
    private String errorMessage;
    
    public ResourceException(final ErrorCode code) {
        super(code.getMessage());
        this.errorCode = code;
    }

    public ResourceException(final String message) {
        super(message);
        this.errorMessage = message;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        if (this.errorCode != null) {
            return this.errorCode.getMessage();
        }
        return this.errorMessage;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getCanonicalName());
        stringBuilder.append(System.getProperty("line.separator"));
        if (this.errorCode != null) {
            stringBuilder.append(this.errorCode.getCode());
            stringBuilder.append(": ");
            stringBuilder.append(this.errorCode.getMessage());
        } else {
            stringBuilder.append(this.errorMessage);
        }
        return stringBuilder.toString();
    }

}
