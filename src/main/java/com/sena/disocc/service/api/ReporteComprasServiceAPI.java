package com.sena.disocc.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.sena.disocc.modelo.ReporteComprasDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteComprasServiceAPI {
	
	
	ReporteComprasDTO obtenerReporteCompras(Map<String, Object> params) throws JRException, IOException, SQLException;; 

}
