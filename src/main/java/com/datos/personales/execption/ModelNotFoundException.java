package com.datos.personales.execption;

import java.io.Serial;
import java.io.Serializable;

public class ModelNotFoundException extends RuntimeException implements Serializable {

    @Serial
	private static final long serialVersionUID = 1L;

	public ModelNotFoundException(String message){
        super(message);
    }
}
