package domenicovacchiano.com.androidrestlet.restlet.sdk.http.resources;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Uniform;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ClientResource;

import domenicovacchiano.com.androidrestlet.restlet.sdk.entities.Contact;
import domenicovacchiano.com.androidrestlet.restlet.sdk.events.ClientResourceCallbackEventsManager;
import domenicovacchiano.com.androidrestlet.restlet.sdk.generics.JsonToObject;
import domenicovacchiano.com.androidrestlet.restlet.sdk.http.clients.ContactClientResource;

/**
 * Created by domenicovacchiano on 10/06/15.
 */

//this helper class allow to consume a REST resource with one or more operations
public class ContactResource {

    public static void getContact (final Object delegate,final String contactId){



        new Thread() {
            public void run() {

                //defines a Restlet ClientResource
                ClientResource resource= ContactClientResource.instance().getResource(String.format("/contacts/%s", contactId));

                resource.setOnResponse(new Uniform() {
                    public void handle(Request request, Response response) {

                        try {
                            //creates a JsonRepresentation through a Representation (esponse.getEntity())
                            JsonRepresentation jsonRepresentation = new JsonRepresentation(response.getEntity());
                            //creates an instance of JsonToObject based on Contact class
                            JsonToObject<Contact> j2o=new JsonToObject<Contact>(Contact.class);
                            //deserialization of a JSON string
                            Contact contact= j2o.getObjectFromJSONString(jsonRepresentation.getJsonObject().toString());
                            //raise event on client
                            ClientResourceCallbackEventsManager.onClientResourceCallback_Success(delegate,contact);

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
