package org.apache.fineract.models;

import java.util.HashMap;

public class GenericResponse {
	
	HashMap<String, Object> responseFields = new HashMap<String, Object>();

    public HashMap<String, Object> getResponseFields() {
        return responseFields;
    }

    public void setResponseFields(HashMap<String, Object> responseFields) {
        this.responseFields = responseFields;
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "responseFields=" + responseFields +
                '}';
    }

}
