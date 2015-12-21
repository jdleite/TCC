package br.com.mercado.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



public class MensageView {

	
 	public void info(String mensagem) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem,""));
	    }
	     
	   
    	public void warn(String mensagem) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem,""));
	    }
	  
    	public void error(String mensagem) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,  mensagem,""));
	    }
	     
	   
}
