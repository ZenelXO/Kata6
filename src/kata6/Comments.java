package kata6;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"postId", "id", "name", "email", "body"})
@XmlRootElement(name = "Comments")

public class Comments {

    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;

    public Comments(Integer postId, Integer id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
    public Comments(){
        
    }

    public Integer getPostId() {
        return postId;
    }

    @XmlElement(name = "PostId", required=true)
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    @XmlElement(name = "Id")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    
    @XmlElement(name = "Name")
    public void setName(String name){
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    @XmlElement(name = "Email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    @XmlElement(name = "Body")
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "PostId: " + this.postId + " Id: " + this.id +" Name:" + this.name +" Email: " + this.email + " body: " + this.body + "\n";
    }
}