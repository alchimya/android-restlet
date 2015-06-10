package domenicovacchiano.com.androidrestlet.restlet.sdk.http.clients;

import org.restlet.resource.ClientResource;

import domenicovacchiano.com.androidrestlet.restlet.sdk.interfaces.IClientResource;

/**
 * Created by domenicovacchiano on 10/06/15.
 */
//it defines a ClientResource singleton class  for contact resource
public class ContactClientResource implements IClientResource {

    private String baseUri="http://restlet-example-serialization.appspot.com";
    private ClientResource resource;
    private static ContactClientResource _instance;
    public  static ContactClientResource instance (){
        if (_instance==null){
            _instance=new ContactClientResource();
        }
        return _instance;
    }

    @Override
    public String getBaseUri() {
        return baseUri;
    }

    @Override
    public ClientResource getResource(String resourcePath) {
        resource=new ClientResource(String.format("%s%s",baseUri,resourcePath));
        /////////////////////////////////////////////////////////////////////////////////
        //you can perform here your custom settings on client resource object
        //for example you can set here basi authentication
        //resource.setChallengeResponse(ChallengeScheme.HTTP_BASIC,"your_id","your_pwd");
        /////////////////////////////////////////////////////////////////////////////////
        return resource;
    }
}

