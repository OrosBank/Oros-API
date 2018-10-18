package org.apache.fineract.models.noncore;

import java.util.ArrayList;
import java.util.List;

public class IdentifierTemplate {

    List<IdentifierType> allowedDocumentTypes = new ArrayList<>();

    public List<IdentifierType> getAllowedDocumentTypes() {
        return allowedDocumentTypes;
    }

    public void setAllowedDocumentTypes(List<IdentifierType> allowedDocumentTypes) {
        this.allowedDocumentTypes = allowedDocumentTypes;
    }

    public IdentifierTemplate() {
    }
}
