package com.bean;


import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;



public class PerformancePhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	public void beforePhase(PhaseEvent phaseEvent) {
		// FacesContext.getCurrentInstance().getApplication().getStateManager().getViewState(FacesContext.getCurrentInstance());
		String phaseName = phaseEvent.getPhaseId().toString();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest httpServletRequest = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		String projectName = httpServletRequest.getSession()
				.getServletContext().getServletContextName();

	}

	public void afterPhase(PhaseEvent phaseEvent) {
		String phaseName = phaseEvent.getPhaseId().toString();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest httpServletRequest = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();

	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}