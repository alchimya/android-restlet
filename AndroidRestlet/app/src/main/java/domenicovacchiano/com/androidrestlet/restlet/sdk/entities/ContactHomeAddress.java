package domenicovacchiano.com.androidrestlet.restlet.sdk.entities;

/**
 * Created by domenicovacchiano on 10/06/15.
 */
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContactHomeAddress implements Serializable {

    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("line1")
    private String line1;
    @SerializedName("line2")
    private String line2;
    @SerializedName("zipCode")
    private String zipCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
