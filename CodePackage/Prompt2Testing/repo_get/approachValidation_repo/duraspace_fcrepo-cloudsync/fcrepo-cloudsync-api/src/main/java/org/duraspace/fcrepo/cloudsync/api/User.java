package org.duraspace.fcrepo.cloudsync.api;

import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class User {

    private String id;
    private URI uri;
    private String name;
    private String password;
    private Boolean isAdmin;
    private Boolean isEnabled;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Boolean isAdmin() {
        return isAdmin;
    }
    
    public void setAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

}
