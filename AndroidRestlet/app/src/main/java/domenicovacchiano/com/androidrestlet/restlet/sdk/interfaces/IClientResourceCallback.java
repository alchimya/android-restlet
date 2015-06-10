package domenicovacchiano.com.androidrestlet.restlet.sdk.interfaces;

/**
 * Created by domenicovacchiano on 10/06/15.
 */
public interface IClientResourceCallback {
    //methods of http Restlet callbacks
    void ClientResourceCallback_Success (Object response);
    void ClientResourceCallback_Error (Exception e);
}
