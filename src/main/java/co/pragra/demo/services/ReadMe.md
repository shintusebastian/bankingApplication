###API
there are 3 layers in an application. 
the service layer is denoted by the annotation @Service. 
<br>
The @Controller and @ResponseBody annotations can be replaced
with a single annotation named @RestController. 

The data that is required to create a user should come from 
the request made by the user which is sent in a body. 
So, the data will be available in the request body. 
so, we annotate that the method createAccount() will get 
the data from the RequestBody using the @RequestBody 
annotation.

We will test the API using postman. we can test the GET, POST,
PUT methods using postman.
<br>
We have added two dependencies named swagger in the pom.xml 
to include documentation in this APIs. To access the 
documentation, the path we need is 
localhost:8080/swagger-ui.html
<br>for now, we are not doing the documentation as the 
swagger is not working. So, later we will try documentation using 
open api. 

Now, we will not use entities, instead we are going to use
request and response. 

Now on , we are not returning an account, instead we are 
returning a response entity.
Now we have a better way of dealing it by having a controller advice. 
Later, we will come up with some extra things so that we 
can deal with exceptions as well. 

Now to list all the saving account from the account list, 
we can create an API by just making little changes in the 
getAll API.