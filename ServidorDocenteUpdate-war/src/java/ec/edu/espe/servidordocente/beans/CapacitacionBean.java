/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.beans;

import ec.edu.espe.servidordocente.dto.CapacitacionDTO;
import ec.edu.espe.servidordocente.servicio.CapacitacionServicio;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class CapacitacionBean implements Serializable {

    @EJB
    private CapacitacionServicio capacitacionServicio;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;

    private List<CapacitacionDTO> capacitaciones;
    private CapacitacionDTO capacitacionModal;
    private UploadedFile file;
    //  private String destino = ".\\resources\\images\\";
    private String destino = "C:\\Users\\Jhonny\\AppData\\Roaming\\NetBeans\\8.0.1\\config\\GF_4.1\\domain1\\var\\webapp\\upload\\";

    public CapacitacionBean() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
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
        this.capacitaciones = this.capacitacionServicio.encontrarCapacitacionPorPersona(loginBean.getPersonaDTO().getPerIdPersona());
    }

    public void botonAceptar() {
        String mensaje = "";
        if (this.capacitacionModal.getCapIdCapacitacion() != null) {
            this.capacitacionModal.setCapPdf(this.file.getFileName());
            this.capacitacionServicio.modificarCapacitacion(this.capacitacionModal);
            
            mensaje = "Información Editada";
        } else {
            this.capacitacionModal.setPerIdPersona(this.loginBean.getPersonaDTO());
            this.capacitacionModal.setCapPdf(this.file.getFileName());
            this.capacitacionServicio.registrarCapacitacion(this.capacitacionModal);
            //Renderizar la vista
            this.capacitaciones = this.capacitacionServicio.encontrarCapacitacionPorPersona(loginBean.getPersonaDTO().getPerIdPersona());

            mensaje = "Información Guardada";

        }

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide()");
        addMessage(mensaje);

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void botonAgregar() {

        this.capacitacionModal = new CapacitacionDTO();
        System.out.println("Seleccion Row Edit");
    }

    public void upload() {
//      FacesContext facesContext = FacesContext.getCurrentInstance();
//      ExternalContext externalContext = facesContext.getExternalContext();
//        
//      System.out.println("path :"+externalContext.getRealPath("/"));
//         

//        ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
//        String archivo = scontext.getRealPath("/"+getFile().getFileName()); 
//        
        //System.out.println("RUTA: 1:"+getFilename());
        String extValidate;
        if (getFile() != null) {
            String ext = getFile().getFileName();

            System.out.println("RUTA: " + ext);
            if (ext != null) {
                extValidate = ext.substring(ext.indexOf(".") + 1);
            } else {
                extValidate = "null";
            }

            if (extValidate.equals("pdf")) {
                try {
//                    String archivo = scontext.getRealPath("Servidor/resources/images/" + getFile().getFileName());
//              
//                    
//                    System.out.println("RUTA BASICA: "+ruta);
                    TransferFile(getFile().getFileName(), getFile().getInputstream());

                } catch (IOException e) {
                    addMessage("Error al Subir Archivo");
                }
                addMessage("Archivo subido");
            } else {
                addMessage("Error solo PDF");
            }

        } else {
            addMessage("Seleccione Archivo");
        }

    }

    public void TransferFile(String archivo, InputStream in) {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        ExternalContext externalContext = facesContext.getExternalContext();
//       
//    
        try {
            OutputStream out = new FileOutputStream(new File(this.destino + archivo));
            int reader = 0;
            byte[] bytes = new byte[(int) getFile().getSize()];
            while ((reader = in.read(bytes)) != -1) {
                out.write(bytes, 0, reader);
            }
            in.close();
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void botonCerrar() {

        System.out.println("Modal Cerrada");
    }

}
