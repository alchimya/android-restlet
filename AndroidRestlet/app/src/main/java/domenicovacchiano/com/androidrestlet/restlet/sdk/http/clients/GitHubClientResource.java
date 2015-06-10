package domenicovacchiano.com.androidrestlet.restlet.sdk.http.clients;

/**
 * Created by domenicovacchiano on 10/06/15.
 */


import org.restlet.resource.ClientResource;
import domenicovacchiano.com.androidrestlet.restlet.sdk.interfaces.IClientResource;

/**
 * Created by domenicovacchiano on 10/06/15.
 */

//it defines a ClientResource singleton class  for GitHub repositories resource
public class GitHubClientResource implements IClientResource {

    private String baseUri="https://api.github.com";
    private ClientResource resource;
    private static GitHubClientResource _instance;
    public  static GitHubClientResource instance (){
        if (_instance==null){
            _instance=new GitHubClientResource();
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