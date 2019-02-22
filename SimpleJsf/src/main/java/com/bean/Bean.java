package com.bean;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputFile;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;

import org.primefaces.PrimeFaces;
import org.primefaces.behavior.ajax.AjaxBehaviorListenerImpl;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.event.TabCloseEvent;

@ManagedBean(name="bean")
@ViewScoped

public class Bean {

	public boolean render = false;
	
	private List<Tab> dynamicTab = new ArrayList<Tab>();
	
	private TabView tabView = new TabView();
	
	public TabView getTabView() {
		return tabView;
	}
	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}
	public List<Tab> getDynamicTab() {
		return dynamicTab;
	}
	public void setDynamicTab(List<Tab> dynamicTab) {
		this.dynamicTab = dynamicTab;
	}
	public boolean isRender() {
		return render;
	}
	public void setRender(boolean render) {
		this.render = render;
	}
	public Bean() {
		super();
		System.out.println("abd");
		
		HtmlInputFile file = new HtmlInputFile();
		file.setValueExpression("value", FacesContext.getCurrentInstance().
				getApplication().getExpressionFactory().createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{uploadBean.files}",  Object.class ));
//		AjaxBehavior valueChangeAction = (AjaxBehavior)FacesContext.getCurrentInstance().getApplication().createBehavior(AjaxBehavior.BEHAVIOR_ID);
//
//		valueChangeAction.addAjaxBehaviorListener(new AjaxBehaviorListener() {
//
//		  @Override
//		  public void processAjaxBehavior(AjaxBehaviorEvent event) throws AbortProcessingException {
//		    System.out.println("Ajax behavior called");     
//		  }
//		});
//		
//		file.addClientBehavior("change", valueChangeAction);
		
		AjaxBehavior ajaxBehavior = (AjaxBehavior)FacesContext.getCurrentInstance().getApplication().createBehavior(AjaxBehavior.BEHAVIOR_ID);
	
		MethodExpression methodExpressionForValueChange = FacesContext.getCurrentInstance().
				getApplication().getExpressionFactory()
				.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{uploadBean.upload()}", void.class,
						new Class[] { long.class });
		ajaxBehavior.addAjaxBehaviorListener(new AjaxBehaviorListenerImpl(
				methodExpressionForValueChange,
				methodExpressionForValueChange));
//		ajaxBehavior.setListener(methodExpressionForValueChange);
		file.addClientBehavior("change",
				ajaxBehavior);
		HtmlForm form = new HtmlForm();
		CommandButton btn = new CommandButton();
		form.getChildren().add(btn);
		HtmlOutputText txt = new HtmlOutputText();
		txt.setId("textid");
		txt.setValue("my name is saurabh");
		Tab tempTab = new Tab();
		tempTab.setId("abc");
		tempTab.setTitle("dynamic tab");
		form.getChildren().add(txt);
		tempTab.getChildren().add(form);
//		tempTab.getChildren().add(file);
		dynamicTab.add(tempTab);
	}
	public String buttonListener(){
		FacesContext context = FacesContext.getCurrentInstance();
		UIComponent comp = context.getViewRoot().findComponent("form:tabView");
//		comp.getChildren().remove(0);
//		render=true;
		HtmlOutputText txt = new HtmlOutputText();
		txt.setId("textidhscvjhsv" + UUID.randomUUID().toString());
		txt.setValue("my name is saurabh");
		Tab tempTab = new Tab();
		tempTab.setId("abhvdhc");
		tempTab.setTitle("dynamic tab");
		tempTab.setClosable(true);
		tempTab.getChildren().add(txt);
		dynamicTab.add(tempTab);
		return "index";
		
	}
	
	public void buttonListener(ActionEvent a){
		FacesContext context = FacesContext.getCurrentInstance();
//		UIComponent comp = context.getViewRoot().findComponent("form:tabView");
//		comp.getChildren().remove(0);
		HtmlOutputText txt = new HtmlOutputText();
		txt.setId("textidhvbjsd" + UUID.randomUUID().toString());
		txt.setValue("my name is saurabh");
		Tab tempTab = new Tab();
		tempTab.setId("abcbjhdbksbw" + UUID.randomUUID().toString());
		tempTab.setTitle("dynamic tab");
		tempTab.setClosable(true);
		tempTab.getChildren().add(txt);
		dynamicTab.add(tempTab);
		render=true;
		
	}
	
	public void onTabClose(TabCloseEvent event) {
		Tab tab = event.getTab();
		dynamicTab.remove(tab);

	}

}
