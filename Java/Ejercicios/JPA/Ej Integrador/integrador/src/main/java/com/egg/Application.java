package com.egg;
import com.egg.Entity.Editorial;
import com.egg.Service.*;
public class Application {

    public static void main(String[] args) throws Exception{
        
       EditorialService eS = new EditorialService();
       Editorial e = new Editorial();
       System.out.println("\033\143");
       e.setNombre("Editorial UNO");
       
       eS.imprimirListaEditoriales();
    
       
        

    }
}
