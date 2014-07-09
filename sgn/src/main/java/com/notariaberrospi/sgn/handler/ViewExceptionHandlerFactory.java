package com.notariaberrospi.sgn.handler;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class ViewExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory base;
    
    public ViewExceptionHandlerFactory(ExceptionHandlerFactory base) {
        this.base = base;
    }
    
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new ViewExceptionHandler(base.getExceptionHandler());
    }
}
