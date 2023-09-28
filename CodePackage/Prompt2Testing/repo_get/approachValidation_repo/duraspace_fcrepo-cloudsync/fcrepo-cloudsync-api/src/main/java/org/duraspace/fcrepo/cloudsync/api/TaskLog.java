package org.duraspace.fcrepo.cloudsync.api;

import javax.xml.bind.annotation.XmlRootElement;

import java.net.URI;
import java.util.Date;

@XmlRootElement(name="taskLog")
public class TaskLog {

    public static final String INCOMPLETE = "Incomplete";
    public static final String SUCCEEDED = "Succeeded";
    public static final String FAILED = "Failed";
    public static final String CANCELED = "Canceled";

    private String id;
    private URI uri;
    private String taskId;
    private URI taskUri;
    private String resultType;
    private Date startDate;
    private Date finishDate;
    private URI contentUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URI getUri() {
        return uri;
    }
    
    public void setUri(URI uri) {
        this.uri = uri;
    }
    
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    
    public URI getTaskUri() {
        return taskUri;
    }
    
    public void setTaskUri(URI taskUri) {
        this.taskUri = taskUri;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    
    public URI getContentUri() {
        return contentUri;
    }
    
    public void setContentUri(URI contentUri) {
        this.contentUri = contentUri;
    }
}
