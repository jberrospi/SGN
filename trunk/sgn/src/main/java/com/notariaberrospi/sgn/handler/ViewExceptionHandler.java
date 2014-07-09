package com.notariaberrospi.sgn.handler;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class ViewExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;

    public ViewExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        Iterable<ExceptionQueuedEvent> events = this.wrapped.getUnhandledExceptionQueuedEvents();
        for(Iterator<ExceptionQueuedEvent> it = events.iterator(); it.hasNext();) {
            ExceptionQueuedEvent event = it.next();
            ExceptionQueuedEventContext eqec = event.getContext();
            
            if(eqec.getException() instanceof ViewExpiredException) {
                FacesContext context = eqec.getContext();
                NavigationHandler navHandler = context.getApplication().getNavigationHandler();
 
                try {
                	checkViewRoot(context, "/paginas/modulos/principal/registrarKardex");
                    navHandler.handleNavigation(context, null, "/paginas/modulos/principal/registrarKardex?faces-redirect=true&expired=true");
                }
                finally {
                    it.remove();
                }
            }
        }
        this.wrapped.handle();
    }
    
    private void checkViewRoot(FacesContext ctx, String viewId) {
    	if (ctx.getViewRoot() == null) {
            UIViewRoot viewRoot = ctx.getApplication().getViewHandler().createView(ctx, viewId);
            if (viewRoot != null) {
                ctx.setViewRoot(viewRoot);
            }
        }
    }
}
