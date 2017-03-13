/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.beans;

import ec.edu.espe.servidordocente.dto.FamiliarDTO;
import ec.edu.espe.servidordocente.servicio.FamiliarServicio;
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
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;
/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class FamiliarBean implements Serializable{

    @EJB
    private FamiliarServicio familiarServicio;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    
    private List<FamiliarDTO> familiares;
    private FamiliarDTO familiarModal;
    
    
    private UploadedFile file;
    private String destino = "C:\\Users\\Jhonny\\AppData\\Roaming\\NetBeans\\8.0.1\\config\\GF_4.1\\domain1\\var\\webapp\\upload\\";


    /** Creates a new instance of FamiliarBean */
    public FamiliarBean() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    
    
    public FamiliarDTO getFamiliarModal() {
        return familiarModal;
    }

    public void setFamiliarModal(FamiliarDTO familiarModal) {
        this.familiarModal = familiarModal;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    @PostConstruct
    public void inicializar() {
        this.familiares = this.familiarServicio.encontrarFamiliarPorPersona(loginBean.getPersonaDTO().getPerIdPersona());
    }

    public List<FamiliarDTO> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<FamiliarDTO> familiares) {
        this.familiares = familiares;
    }

    public void botonAceptar() {
        String mensaje = "";
        if (this.familiarModal.getFamIdFamiliar() != null) {
            this.familiarModal.setFamPdf(this.file.getFileName());
            this.familiarServicio.modificarFamiliar(this.familiarModal);
            mensaje = "Información Editada";
        } else {
            this.familiarModal.setPerIdPersona(this.loginBean.getPersonaDTO());
            this.familiarModal.setFamPdf(this.file.getFileName());
            this.familiarServicio.registrarFamiliar(this.familiarModal);
            //Obtener todos los familiares para renderizar la vista
            this.familiares = this.familiarServicio.encontrarFamiliarPorPersona(loginBean.getPersonaDTO().getPerIdPersona());

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
       
        this.familiarModal = new FamiliarDTO();
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
