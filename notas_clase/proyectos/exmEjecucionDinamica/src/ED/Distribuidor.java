/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ED;

import java.lang.reflect.Method;

/**
 * Código visto en clase provisto por el profesor RGGH.
 * Adaptado a una sola clase.
 * @author LPENAF
 */
public class Distribuidor {
    public static void main(String args[]) {
//        System.out.println("Distribuidor, inciando con:");
//        if(args.length == 0){
//            System.out.println("Sin argumentos");
//        } else {
//            for(int i = 0; i < args.length; i++){
//                System.out.println("args[" + i + "]:" + args[i]);
//            }
//        }

        String[] argsPar = new String[0];
        
        if(args.length > 1) {
            argsPar = new String[args.length - 1];
            for(int i = 1; i < args.length; i++){
                argsPar[i - 1] = args[i];  
            }
        }
        
        if(args.length == 0) {
            System.out.println("Sin argumentos. No hay clase para ejecutar dinámicamente.");
        } else {
            Class[] cArg = new Class[1];
            cArg[0] = String[].class;
            System.out.println("Distribuidor redirigiendo a args[0]:" + args[0]);
            try {
                Class cl = Class.forName(args[0]);
                Method m = cl.getMethod("main", cArg);
                m.invoke(cl, (Object) argsPar);
                System.out.println("Distribuidor ha invocado, notar cuando aparece este mensaje...");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }  
    } 
}
