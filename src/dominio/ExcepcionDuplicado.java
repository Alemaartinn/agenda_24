package dominio;

public class ExcepcionDuplicado extends Exception{

 private Contacto cerror;  
 public  ExcepcionDuplicado(Contacto c){
    cerror=c;
 }
 public ExcepcionDuplicado(){

 }
 public Contacto getContacto(){
    return cerror;

 }

}

    
