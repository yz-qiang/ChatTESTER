package org.duraspace.fcrepo.cloudsync.api;

import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="service")
public class ServiceInfo {

    private boolean isInitialized;
    private String version;
    private String buildDate;
    private URI currentUserUri;
    private URI objectSetsUri;
    private URI objectStoresUri;
    private URI providerAccountsUri;
    private URI spacesUri;
    private URI taskLogsUri;
    private URI tasksUri;
    private URI usersUri;

    public boolean isInitialized() {
        return isInitialized;
    }
    
    public void setInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }
    
    public URI getCurrentUserUri() {
        return currentUserUri;
    }
    
    public void setCurrentUserUri(URI currentUserUri) {
        this.currentUserUri = currentUserUri;
    }

    public URI getObjectSetsUri() {
        return objectSetsUri;
    }
    
    public void setObjectSetsUri(URI objectSetsUri) {
        this.objectSetsUri = objectSetsUri;
    }
    
    public URI getObjectStoresUri() {
        return objectStoresUri;
    }
    
    public void setObjectStoresUri(URI objectStoresUri) {
        this.objectStoresUri = objectStoresUri;
    }
    
    public URI getProviderAccountsUri() {
        return providerAccountsUri;
    }
    
    public void setProviderAccountsUri(URI providerAccountsUri) {
        this.providerAccountsUri = providerAccountsUri;
    }

    public URI getSpacesUri() {
        return spacesUri;
    }
    
    public void setSpacesUri(URI spacesUri) {
        this.spacesUri = spacesUri;
    }

    public URI getTaskLogsUri() {
        return taskLogsUri;
    }
    
    public void setTaskLogsUri(URI taskLogsUri) {
        this.taskLogsUri = taskLogsUri;
    }
    
    public URI getTasksUri() {
        return tasksUri;
    }
    
    public void setTasksUri(URI tasksUri) {
        this.tasksUri = tasksUri;
    }
    
    public URI getUsersUri() {
        return usersUri;
    }
    
    public void setUsersUri(URI usersUri) {
        this.usersUri = usersUri;
    }

}
