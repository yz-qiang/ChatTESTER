package org.duraspace.fcrepo.cloudsync.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="serviceInit")
public class ServiceInit {
    
    private String initialAdminUsername;
    private String initialAdminPassword;
    
    public String getInitialAdminUsername() {
        return initialAdminUsername;
    }
    
    public void setInitialAdminUsername(String initialAdminUsername) {
        this.initialAdminUsername = initialAdminUsername;
    }
    
    public String getInitialAdminPassword() {
        return initialAdminPassword;
    }
    
    public void setInitialAdminPassword(String initialAdminPassword) {
        this.initialAdminPassword = initialAdminPassword;
    }
    
}
