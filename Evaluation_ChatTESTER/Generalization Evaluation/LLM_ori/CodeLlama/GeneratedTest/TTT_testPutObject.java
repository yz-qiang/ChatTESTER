package org.duraspace.fcrepo.cloudsync.service.backend;
import com.github.cwilper.fcrepo.dto.core.ControlGroup;
import com.github.cwilper.fcrepo.dto.core.Datastream;
import com.github.cwilper.fcrepo.dto.core.DatastreamVersion;
import com.github.cwilper.fcrepo.dto.core.FedoraObject;
import com.github.cwilper.fcrepo.httpclient.MultiThreadedHttpClient;
import junit.framework.Assert;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.AutoCloseInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.Date;
import java.util.Random;
// original test path: duraspace_fcrepo-cloudsync###duraspace_fcrepo-cloudsync/fcrepo-cloudsync-service/src/test/java/org/duraspace/fcrepo/cloudsync/service/backend/DuraCloudConnectorTest###testPutObject
public class TTT_testPutObject {
@Test
public void testPutObject() throws Exception {
    FedoraObject object = PowerMockito.mock(FedoraObject.class);
    StoreConnector connector = PowerMockito.mock(StoreConnector.class);
    MultiThreadedHttpClient client = PowerMockito.mock(MultiThreadedHttpClient.class);
    HttpResponse response = PowerMockito.mock(HttpResponse.class);
    StatusLine statusLine = PowerMockito.mock(StatusLine.class);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    BufferedWriter writer = new BufferedWriter(outputStream);
    when(object.pid()).thenReturn("test:object");
    when(connector.hasObject(anyString())).thenReturn(false);
    when(client.execute(any(HttpPut.class))).thenReturn(response);
    when(statusLine.getStatusCode()).thenReturn(200);
    when(response.getStatusLine()).thenReturn(statusLine);
    when(writer.toString()).thenReturn("<foxml><object pid=\"test:object\"></object></foxml>");
    boolean result = connector.putObject(object, connector, true, true, true);
    assertTrue(result);
    verify(client).execute(any(HttpPut.class));
    verify(object).datastreams();
    verifyNoMoreInteractions(client);
}
}