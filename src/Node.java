
import java.io.Serializable;

public class Node implements Serializable {
    private MenuItem data;
    private Node next;
    
    public Node (MenuItem item){
        data = item;
        next = null;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setData(MenuItem data){
       this.data = data;
    }
    
    public MenuItem getData(){
        return data;
    }
    
    public String toString(){
        return data.toString();
    }
}