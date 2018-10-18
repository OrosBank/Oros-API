package org.apache.fineract.utils;

public enum ErrorCode {
	
	 UNKNOWN(999, "An unknown error has occured."),

	    // for ConnectException
	    NOT_CONNECTED(100, "Could not establish a connection!"),
	    NOT_LOGGED_IN(101, "Not logged in. A valid authentication key is required to carry on API requests."),
	    UNAUTHENTICATED(102, "Invalid authentication details were passed in the API request."),
	    INVALID_AUTHENTICATION_TOKEN(103, "Invalid authentication token was passed."),

	    // for ResourceException
	    OFFICE_NOT_FOUND(200, "Office not found."),
	    STAFF_NOT_FOUND(201, "Staff not found."),
	    INVALID_STATUS(202, "Invalid staff status passed. Should only be active, inactive or all."),
	    CLIENT_NOT_FOUND(203, "Client not found."),
	    CLIENT_OR_IDENTIFIER_NOT_FOUND(204, "Client or identifier not found."),
	    CLIENT_IMAGE_NOT_FOUND(205, "Image for the given client ID does not exist."),
	    GROUP_NOT_FOUND(206, "Group not found."),
	    USER_NOT_FOUND(207,"User not found")
	    ;

	    private int code;
	    private String message;

	    ErrorCode(final int errorCode, final String errorMessage) {
	        this.code = errorCode;
	        this.message = errorMessage;
	    }

	    public int getCode() {
	        return this.code;
	    }

	    public String getMessage() {
	        return this.message;
	    }


}
