# android-restlet
A very simple ptoject/tutorial to show how to use Restlet and Gson libs under Android

# What is this?
It's a project tutorial that will help you to understand how to use <b>Restlet</b> framework (http://restlet.com/) 
and how to implement a JSON deserialization by using <b>Gson Google</b> framework (https://code.google.com/p/google-gson/).
<br/>
You can use this project as template to develop your custom resource consumer.
<br/>
With this class set you can consume at the same time resources from different uri service.
<br/>
In this example we will consume in the same project resources from RestLet Demo service and from GitHub API service.

# Packages
I developed this project wih Android Studio, however you can setup this code on your favourite IDE.
<br/>
——><b>restlet.sdk</b>
<br/>
———> <b>entities</b>
<br/>
———> <b>http</b>
<br/>
—————> <b>clients</b>
<br/>
—————> <b>resources</b>
<br/>
———> <b>interfaces</b>
<br/>
———> <b>events</b>
<br/>
———> <b>generics</b>
<br/>

- <b>restlet.sdk.entities</b>
<br/>
contains all classes to map JSON items of REST resources

- <b>restlet.sdk.http.clients</b>
<br/>
contains Restlet ClientResource singleton classes of REST resources

- <b>restlet.sdk.http.resources</b>
<br/>
contains helper classes that allow to consume REST resources with one or more operations for different REST path

- <b>restlet.sdk.interfaces</b>
<br/>
IClientResourceCallback: defines event method signatures for Restlet http callbacks

- <b>restlet.sdk.events</b>
<br/>
ClientResourceCallbackEventsManager: implements and dispatches Restlet http callbacks

- <b>restlet.sdk.generics</b>
<br/>
JsonToObject: is a generic T class tha allow to deserialize a JSON string into a custom class

# How to use
To test this class set, I developed two REST service
<br/>
- Restlet Contacts API demo service: http://restlet-example-serialization.appspot.com/contacts/123
- GitHup User repositories API:https://api.github.com/users/GIT_HUB_USER_HERE/repos

<br/>
Inside ContactResource class you will find a static method (getContact) that allow to consume the Contact.
<br/>
See loadContact nethod inside MainActivity class.

<br/>
Instead to consume GitRepos resource you have to refer to GitHubResource class and call ths static method getUserRepos.
<br/>
See loadGitHubRepos nethod inside MainActivity class.


# How to develop your custom resources
- <b>add your entities classes and map these classes with the corresponding JSON structure.</b>
<br/>
If the JSON response is an array you have to develop a class with a List<BaseEntity> attribute (see Contacts) 

- <b>add your EntityClientResource.</b> 
<br/>
For further details see ContactClientResource and GitHubClientResource classes.
<br/>
However you create these classe by copying from ContactClientResource ord GitHubClientResource and by changing:
baseUri value, _instance type and if you need to add custom settings you have to add them to getResource method.

- <b>add your EntityResource classes to define methods for REST operations</b>
<br/>
For further details see ContactResource and GitHubResource classes.
