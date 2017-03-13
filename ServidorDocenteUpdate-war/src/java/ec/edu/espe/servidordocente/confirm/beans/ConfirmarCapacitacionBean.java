/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.confirm.beans;

import ec.edu.espe.servidordocente.dto.CapacitacionDTO;
import ec.edu.espe.servidordocente.servicio.CapacitacionServicio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
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
public class ConfirmarCapacitacionBean implements Serializable {

    @EJB
    private CapacitacionServicio capacitacionServicio;

    @ManagedProperty(value = "#{docenteBean}")
    private DocenteBean docenteBean;

    private List<CapacitacionDTO> capacitaciones;
    private CapacitacionDTO capacitacionModal;
    private StreamedContent file;

    /** Creates a new instance of VerCapacitacionBean */
    public ConfirmarCapacitacionBean() {
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public DocenteBean getDocenteBean() {
        return docenteBean;
    }

    public void setDocenteBean(DocenteBean docenteBean) {
        this.docenteBean = docenteBean;
    }

    
    
    
    

    public List<CapacitacionDTO> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<CapacitacionDTO> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    public CapacitacionDTO getCapacitacionModal() {
        return capacitacionModal;
    }

    public void setCapacitacionModal(CapacitacionDTO capacitacionModal) {
        this.capacitacionModal = capacitacionModal;
    }

    @PostConstruct
    public void inicializar() {
        this.capacitaciones = this.capacitacionServicio.encontrarCapacitacionPorPersona(docenteBean.getDocenteSeleccionado().getPerIdPersona());
    }

    public void botonAceptar() {
        String mensaje = "";

        if (this.capacitacionModal.getCapIdCapacitacion() != null) {
            this.capacitacionServicio.confirmarCapacitacion(this.capacitacionModal);
            mensaje = "Información Confirmada";
        }

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide()");
        addMessage(mensaje);

    }

    public StreamedContent descargarPDF() throws FileNotFoundException {

        InputStream stream = new FileInputStream("C:\\Users\\Jhonny\\AppData\\Roaming\\NetBeans\\8.0.1\\config\\GF_4.1\\domain1\\var\\webapp\\upload\\"+this.capacitacionModal.getCapPdf());
        this.file = new DefaultStreamedContent(stream, "application/pdf", "capacitacion.pdf");
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
