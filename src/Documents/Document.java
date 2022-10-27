package documents;
public class Document {
    private Integer documentId;
    private Integer supervisorId;
    private Integer personId;
    private String documentTitle;
    private String documentLink;
    private String documentState;
    public Document(Integer documentId, Integer supervisorId, Integer personId, String documentTitle, String documentLink, String documentState){
        this.documentId = documentId;
        this.supervisorId = supervisorId;
        this.personId = personId;
        this.documentTitle = documentTitle;
        this.documentLink = documentLink;
        this.documentState = documentState;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", supervisorId=" + supervisorId +
                ", personId=" + personId +
                ", documentTitle='" + documentTitle + '\'' +
                ", documentLink='" + documentLink + '\'' +
                ", documentState='" + documentState + '\'' +
                '}';
    }
}
