package domenicovacchiano.com.androidrestlet.restlet.sdk.entities;

/**
 * Created by domenicovacchiano on 10/06/15.
 */


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

//Contact class to map a JSON item of contacts resource
//see an example of a JSON structure at
//http://restlet-example-serialization.appspot.com/contacts/123
//Each class property has an annotation to map the correspondif JSON field
//see this tutorial: http://www.javacodegeeks.com/2011/01/android-json-parsing-gson-tutorial.html
public class Contact implements Serializable {

    @SerializedName("age")
    private int age;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("homeAddress")
    private ContactHomeAddress homeAddress;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ContactHomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(ContactHomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

