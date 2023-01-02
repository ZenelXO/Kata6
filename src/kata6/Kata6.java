package kata6;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import javax.xml.bind.*;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;

public class Kata6 {
    private static ArrayList<Comments> posts;
    
    public static void main(String[] args) throws Exception {
        
        URL url = new URL("https://jsonplaceholder.typicode.com/comments");
        //Establecemos la connexión
        HttpURLConnection cx = (HttpURLConnection) url.openConnection(); //Establece conexion
        cx.setRequestMethod("GET");//obtener datos

        InputStream strmContenido = cx.getInputStream();
        byte[] contStream = strmContenido.readAllBytes();

        String json = "";

        for (byte tmp : contStream) {
            //System.out.println((char)tmp);
            json += (char) tmp;
        }
        
        JSONArray jsonarr = new JSONArray(json);
        posts = new ArrayList<>();
        for (Object object : jsonarr) {
            posts.add(new Comments((Integer)((JSONObject)object).get("postId"), (Integer) ((JSONObject)object).get("id"),((JSONObject)object).get("name").toString() ,((JSONObject)object).get("email").toString(),((JSONObject)object).get("body").toString()));
        }
        //Visualizamos los resultados
        //for (Post post : posts) {
          //  System.out.println(post);
        //}
        //System.out.println(jsonarr);
        //Serealizamos 
        Serializarlo();
        
        //Serealizarmos a XML 
        XML();
        
    }
 
    public static void Serializarlo(){
        
        Gson gson = new Gson();
        String jsonS = "{'Postid':99,'id':99,'name':' Nombre','email':'Correo','body':'Body'}";
        Comments comments = gson.fromJson(jsonS, Comments.class);
        System.out.println("Objecto Serializado "+ comments);
    }
    
    public static void XML() throws JAXBException{
        Comments commentsXML = new Comments(888,888,"Name","commentsXML Title","commentsXML Body");
        
        /* init jaxb marshaler */
        JAXBContext jaxbContext = JAXBContext.newInstance( Comments.class );
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        
        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal(commentsXML, new File( "comments.xml" ) );
        jaxbMarshaller.marshal(commentsXML, System.out );
    }
    
    
}