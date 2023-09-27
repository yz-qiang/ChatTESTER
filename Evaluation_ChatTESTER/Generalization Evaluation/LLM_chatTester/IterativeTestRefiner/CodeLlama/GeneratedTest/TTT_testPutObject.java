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
    FedoraObject fedoraObject = PowerMockito.mock(FedoraObject.class);
    StoreConnector storeConnector = PowerMockito.mock(StoreConnector.class);
    MultiThreadedHttpClient httpClient = PowerMockito.mock(MultiThreadedHttpClient.class);
    when(fedoraObject.pid()).thenReturn("test:object");
    when(fedoraObject.datastreams()).thenReturn(Collections.emptyList());
    when(storeConnector.hasObject("test:object")).thenReturn(false);
    when(httpClient.execute(any(HttpPut.class))).thenReturn(null);
    File tempFile = File.createTempFile("cloudsync", ".xml");
    tempFile.deleteOnExit();
    DuraCloudConnector connector = new DuraCloudConnector(spaceURI, "test", "test", httpClient, 1024 * 1024);
    connector.putObject(fedoraObject, storeConnector, true, true, true);
    verify(httpClient, times(1)).execute(argThat(new ArgumentMatcher<HttpPut>() {
        @Override
        public boolean matches(HttpPut argument) {
            assertEquals("PUT", argument.getMethod());
            assertEquals("https:
            assertTrue(argument.getHeaders().containsKey("Content-Type"));
            assertEquals("application/octet-stream", argument.getFirstHeader("Content-Type").getValue());
            assertTrue(argument.getEntity().isRepeatable());
            assertNotNull(argument.getEntity().getContentLength());
            return true;
        }
    }));
    tempFile.delete();
}
}