package documents;
public class Document {
    private Integer documentId;
    private static Integer counter = 0;
    private String documentTitle;
    private String documentLink;
    private Boolean isActive = true;
    public Document(String documentTitle, String documentLink){
        this.documentId = counter++;
        this.documentTitle = documentTitle;
        this.documentLink = documentLink;
        this.isActive = isActive;
    }
    public Integer getDocumentId() {
        return documentId;
    }
    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }
    public String getDocumentTitle() {
        return documentTitle;
    }
    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }
    public String getDocumentLink() {
        return documentLink;
    }
    public void setDocumentLink(String documentLink) {
        this.documentLink = documentLink;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentTitle='" + documentTitle + '\'' +
                ", documentLink='" + documentLink + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
