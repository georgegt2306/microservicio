package com.datos.personales.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.datos.personales.util.RespuestaGenerica;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/validate")
@RequiredArgsConstructor
public class ServicioDisponibilidad {
	
	private final RespuestaGenerica respuestaGenerica;
	
	@ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/sd.disponibilidad", produces = "application/json")
    public ResponseEntity<RespuestaGenerica> emisionComprobanteXmlPlus(HttpServletRequest request) {
        return new ResponseEntity<>(respuestaGenerica.respuestaExitosa(null, "OK " + request.getRequestURL() + " --> " + request.getRemoteAddr()), HttpStatus.OK);
    }
    
}
