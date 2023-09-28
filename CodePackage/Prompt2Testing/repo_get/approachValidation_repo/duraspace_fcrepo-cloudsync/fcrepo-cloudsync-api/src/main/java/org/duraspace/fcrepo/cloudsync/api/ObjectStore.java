package org.duraspace.fcrepo.cloudsync.api;

import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="objectStore")
public class ObjectStore {

    private String id;
    private URI uri;
    private String name;
    private String type;
    private String data;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
