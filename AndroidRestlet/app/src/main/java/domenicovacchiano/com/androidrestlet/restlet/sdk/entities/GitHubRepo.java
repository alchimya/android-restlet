package domenicovacchiano.com.androidrestlet.restlet.sdk.entities;

/**
 * Created by domenicovacchiano on 10/06/15.
 */
import com.google.gson.annotations.SerializedName;

//GitHubRepo class to map a JSON item of repositories user resource
//see an example of a JSON structure at
//https://api.github.com/users/alchimya/repos
//Each class property has an annotation to map the correspondif JSON field
//see this tutorial: http://www.javacodegeeks.com/2011/01/android-json-parsing-gson-tutorial.html
public class GitHubRepo {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
