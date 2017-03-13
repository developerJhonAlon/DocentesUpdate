/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.confirm.beans;

import ec.edu.espe.servidordocente.dto.FamiliarDTO;
import ec.edu.espe.servidordocente.servicio.FamiliarServicio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class ConfirmarFamiliarBean implements Serializable{

    @EJB
    private FamiliarServicio familiarServicio;
    
    @ManagedProperty(value = "#{docenteBean}")
    private DocenteBean docenteBean;
    
    private List<FamiliarDTO> familiares;
    private FamiliarDTO familiarModal;
    private StreamedContent file;
    
    
    /** Creates a new instance of ConfirmarFamiliarBean */
    public ConfirmarFamiliarBean() {
    }

    public DocenteBean getDocenteBean() {
        return docenteBean;
    }

    public void setDocenteBean(DocenteBean docenteBean) {
        this.docenteBean = docenteBean;
    }

    public List<FamiliarDTO> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<FamiliarDTO> familiares) {
        this.familiares = familiares;
    }

    public FamiliarDTO getFamiliarModal() {
        return familiarModal;
    }

    public void setFamiliarModal(FamiliarDTO familiarModal) {
        this.familiarModal = familiarModal;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    public void botonAceptar() {
        String mensaje = "";

        if (this.familiarModal.getFamIdFamiliar() != null) {
            this.familiarServicio.confirmarFamiliar(this.familiarModal);
            mensaje = "Información Confirmada";
        }

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide()");
        addMessage(mensaje);

    }

    @PostConstruct
    public void inicializar(){
        this.familiares = this.familiarServicio.encontrarFamiliarPorPersona(docenteBean.getDocenteSeleccionado().getPerIdPersona());
    }
    
    public StreamedContent descargarPDF() throws FileNotFoundException {

        InputStream stream = new FileInputStream("C:\\Users\\Jhonny\\AppData\\Roaming\\NetBeans\\8.0.1\\config\\GF_4.1\\domain1\\var\\webapp\\upload\\"+this.familiarModal.getFamPdf());
        this.file = new DefaultStreamedContent(stream, "application/pdf", "familiar.pdf");
        return this.file;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void botonCerrar() {
        System.out.println("Modal Cerrada");
    }
}
