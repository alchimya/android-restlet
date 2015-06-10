package domenicovacchiano.com.androidrestlet.restlet.sdk.events;

/**
 * Created by domenicovacchiano on 10/06/15.
 */
import java.util.ArrayList;
import java.util.Iterator;

import domenicovacchiano.com.androidrestlet.restlet.sdk.interfaces.IClientResourceCallback;

//Event Manager to manage restlet http callbacks
public class ClientResourceCallbackEventsManager {

    private static ArrayList arrayListWithDelegate(Object delegate){
        ArrayList listeners=new ArrayList();
        listeners.add(delegate);
        return  listeners;
    }
    public static void onClientResourceCallback_Success (Object delegate,Object response){
       onClientResourceCallback_Success(arrayListWithDelegate(delegate),response);
    }
    public static void onClientResourceCallback_Error (Object delegate,Exception e){
        onClientResourceCallback_Error(arrayListWithDelegate(delegate), e);
    }

    public static void onClientResourceCallback_Success (ArrayList listeners,Object response){
        Iterator i = listeners.iterator();

        while(i.hasNext())  {
            ((IClientResourceCallback) i.next()).ClientResourceCallback_Success(response);
        }
    }
    public static void onClientResourceCallback_Error (ArrayList listeners,Exception e){
        Iterator i = listeners.iterator();

        while(i.hasNext())  {
            ((IClientResourceCallback) i.next()).ClientResourceCallback_Error(e);
        }
    }

}
