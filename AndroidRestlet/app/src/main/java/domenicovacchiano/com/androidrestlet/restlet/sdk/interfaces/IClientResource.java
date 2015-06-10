package domenicovacchiano.com.androidrestlet.restlet.sdk.interfaces;

import org.restlet.resource.ClientResource;

/**
 * Created by domenicovacchiano on 10/06/15.
 */
public interface IClientResource {
    String getBaseUri();
    ClientResource getResource(String resourcePath);
}
