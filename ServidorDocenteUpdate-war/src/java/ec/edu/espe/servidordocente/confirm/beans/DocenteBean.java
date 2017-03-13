/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.confirm.beans;

import ec.edu.espe.servidordocente.dto.PersonaDTO;
import ec.edu.espe.servidordocente.servicio.PersonaServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
/**
 *
 * @author Jhonny
 */
@ManagedBean
@SessionScoped
public class DocenteBean implements Serializable{

    @EJB
    private PersonaServicio personaServicio;
    
    private List<PersonaDTO> listaDocentes;
    private PersonaDTO docenteSeleccionado;
    
    /** Creates a new instance of DocentesBean */
    public DocenteBean() {
    }

    public PersonaDTO getDocenteSeleccionado() {
        return docenteSeleccionado;
    }

    public void setDocenteSeleccionado(PersonaDTO docenteSeleccionado) {
        this.docenteSeleccionado = docenteSeleccionado;
    }
    

    public List<PersonaDTO> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<PersonaDTO> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }
    
    @PostConstruct
    public void inicializar(){
        this.listaDocentes = this.personaServicio.listarPersonas();
    }
    
    
    public void onRowSelect(SelectEvent event) {
        System.out.println("Seleccion Row Edit");
        

    }

    public void onRowUnselect(UnselectEvent event) {
        System.out.println("Seleccion Row Not ");

    }
 
    
    
}
