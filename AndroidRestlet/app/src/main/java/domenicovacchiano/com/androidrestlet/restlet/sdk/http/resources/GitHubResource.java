package domenicovacchiano.com.androidrestlet.restlet.sdk.http.resources;



import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Uniform;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ClientResource;

import domenicovacchiano.com.androidrestlet.restlet.sdk.entities.GitHubRepos;
import domenicovacchiano.com.androidrestlet.restlet.sdk.events.ClientResourceCallbackEventsManager;
import domenicovacchiano.com.androidrestlet.restlet.sdk.generics.JsonToObject;
import domenicovacchiano.com.androidrestlet.restlet.sdk.http.clients.GitHubClientResource;


/**
 * Created by domenicovacchiano on 10/06/15.
 */

//this helper class allow to consume a REST resource with one or more operations
public class GitHubResource {

    public static void getUserRepos (final Object delegate,final String user){

        new Thread() {
            public void run() {

                //defines a Restlet ClientResource
                ClientResource resource= GitHubClientResource.instance().getResource(String.format("/users/%s/repos", user));

                resource.setOnResponse(new Uniform() {
                    public void handle(Request request, Response response) {

                        try {
                            //creates a JsonRepresentation through a Representation (esponse.getEntity())
                            JsonRepresentation jsonRepresentation = new JsonRepresentation(response.getEntity());
                            //creates an instance of JsonToObject based on GitHubRepos class
                            JsonToObject<GitHubRepos> j2o=new JsonToObject<GitHubRepos>(GitHubRepos.class);
                            //deserialization of a JSON string
                            //NOTE:here wi will deserialize a JSON array into a GitHubRepos class
                            // that define an attribute named items, so we have to add the same attribute into
                            // the JSON string before the deserialization process
                            String jsonString=jsonRepresentation.getJsonArray().toString();
                            jsonString="{\"items\":"+jsonString+"}";
                            GitHubRepos repos= j2o.getObjectFromJSONString(jsonString);

                            //raise event on client
                            ClientResourceCallbackEventsManager.onClientResourceCallback_Success(delegate, repos);

                        } catch (Exception e) {
                            //raise event on client
                            ClientResourceCallbackEventsManager.onClientResourceCallback_Error(delegate,e);
                        }

                    }
                });
                resource.get();


            }
        }.start();


    }

}
