package domenicovacchiano.com.androidrestlet;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import domenicovacchiano.com.androidrestlet.restlet.sdk.entities.Contact;
import domenicovacchiano.com.androidrestlet.restlet.sdk.entities.GitHubRepo;
import domenicovacchiano.com.androidrestlet.restlet.sdk.entities.GitHubRepos;
import domenicovacchiano.com.androidrestlet.restlet.sdk.http.clients.GitHubClientResource;
import domenicovacchiano.com.androidrestlet.restlet.sdk.http.resources.ContactResource;
import domenicovacchiano.com.androidrestlet.restlet.sdk.http.resources.GitHubResource;
import domenicovacchiano.com.androidrestlet.restlet.sdk.interfaces.IClientResourceCallback;


public class MainActivity extends ActionBarActivity implements IClientResourceCallback {
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult=(TextView)findViewById(R.id.tvResult);
    }
    ////////////////////////////////////////////////////////////////////////////////
    //
    public void loadContact(View view) {
        //consumes Contact resource with a customer id
        ContactResource.getContact(this, "123");
    }
    public void loadGitHubRepos(View view) {
        //consumes GitHub resource for a user
        GitHubResource.getUserRepos(this, "alchimya");
    }
    ////////////////////////////////////////////////////////////////////////////////
    //ClientResourceCallback Events
    @Override
    public void ClientResourceCallback_Success(Object response) {

        final String message;
        //cast of response
        if (response instanceof Contact) {
            Contact contact=(Contact)response;
            message=String.format("Conatct %s has been loaded",contact.getFirstName());
        }else if (response instanceof GitHubRepos) {
            GitHubRepos repositories=(GitHubRepos)response;
            message=String.format("%d repositories loaded",repositories.items.size());
        }else {
            message=null;
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try{
                    tvResult.setText(message);
                }catch (Exception e){
                    tvResult.setText(e.getMessage());
                }
            }
        });

    }
    @Override
    public void ClientResourceCallback_Error(Exception e) {
        e.printStackTrace();
    }
    ////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
