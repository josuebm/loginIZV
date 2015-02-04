/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validar;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author 2dam
 */
@Named(value = "usuario")
@RequestScoped
public class Usuario implements Serializable {

    private ArrayList<String[]> passwords = new ArrayList();
    private String name="", cont;
    private String mensajeErrorNombre="resources/images/blanco.PNG";
    private ArrayList usuarios = new ArrayList();
    private String imagen;
    
    
    public Usuario() {
        listaUsuarios();
        nombresUsados();
    }
    
    public String comprobarPassword(){
        for(int i=0; i<passwords.size(); i++)
            if(passwords.get(i)[0].compareToIgnoreCase(name) == 0 && passwords.get(i)[1].compareToIgnoreCase(cont) == 0)
                return "bien";
        return "error";
    }
    
    public void nombresUsados(){
        usuarios.add("josue");
        usuarios.add("aitor");
    }
    
    public void listaUsuarios(){
        passwords.add(new String[]{"josue", "bernal"});
        passwords.add(new String[]{"aitor", "lopez"});
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public ArrayList<String[]> getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList<String[]> passwords) {
        this.passwords = passwords;
    }

    public String getMensajeErrorNombre() {
        return mensajeErrorNombre;
    }

    public void setMensajeErrorNombre(String mensajeErrorNombre) {
        this.mensajeErrorNombre = mensajeErrorNombre;
    }
    
    
    
    public void validarNombre(AjaxBehaviorEvent evento) {
        if(name.compareTo("")==0 || name.length()==0){
             mensajeErrorNombre = "resources/images/blanco.PNG";
        }else if (usuarios.contains(name)) {
            mensajeErrorNombre = "resources/images/delete.png";
        }else{
            mensajeErrorNombre = "resources/images/ok.png";
        }
    }
    
   /* public void cargarImagen(AjaxBehaviorEvent evento) {
        if (usuarios.contains(name)) {
            mensajeErrorNombre = "El nombre ya está siendo usado";
        }else{
            mensajeErrorNombre = "El nombre está disponible";
        }
    }*/
    
    
    
}
