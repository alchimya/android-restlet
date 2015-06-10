package domenicovacchiano.com.androidrestlet.restlet.sdk.generics;

import com.google.gson.Gson;

/**
 * Created by domenicovacchiano on 10/06/15.
 */

//Utility class that allow, with Gson, to convert a json string into a custom object
//see this tutorial: http://www.javacodegeeks.com/2011/01/android-json-parsing-gson-tutorial.html
public class JsonToObject <T> {

    private Class<T> type;
    public JsonToObject(Class<T> type) {
        this.type = type;
    }
    private Class<T> getType() {
        return type;
    }
    private T newInstance() throws IllegalAccessException, InstantiationException {
        return type.newInstance();
    }

    public T getObjectFromJSONString (String json){
        Gson gson = new Gson();
        return gson.fromJson(json, getType());
    }
}
