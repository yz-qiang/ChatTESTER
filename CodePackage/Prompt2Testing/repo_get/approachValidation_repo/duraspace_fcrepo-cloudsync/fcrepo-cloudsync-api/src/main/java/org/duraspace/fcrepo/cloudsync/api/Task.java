package org.duraspace.fcrepo.cloudsync.api;

import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="task")
public class Task {

    // IDLE tasks can transition to STARTING
    public static final String IDLE = "Idle";

    // STARTING tasks can transition to RUNNING, PAUSING, or CANCELING
    public static final String STARTING = "Starting";

    // RUNNING tasks can transition to PAUSING, CANCELING, or IDLE
    public static final String RUNNING = "Running";

    // PAUSING tasks can transition to CANCELING, PAUSED, or RESUMING
    public static final String PAUSING = "Pausing";

    // PAUSED tasks can transition to RESUMING or CANCELING
    public static final String PAUSED = "Paused";

    // RESUMING tasks can transition to PAUSING, CANCELING, or RUNNING
    public static final String RESUMING = "Resuming";

    // CANCELING tasks can transition to IDLE
    public static final String CANCELING = "Canceling";

    private String id;
    private URI uri;
    private String name;
    private String type;
    private String state;
    private String activeLogId;
    private URI activeLogUri;
    private String schedule;
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

    public String getActiveLogId() {
        return activeLogId;
    }

    public void setActiveLogId(String activeLogId) {
        this.activeLogId = activeLogId;
    }

    
    public URI getActiveLogUri() {
        return activeLogUri;
    }

    
    public void setActiveLogUri(URI activeLogUri) {
        this.activeLogUri = activeLogUri;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
