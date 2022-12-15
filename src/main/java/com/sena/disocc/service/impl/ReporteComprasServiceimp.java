package com.sena.disocc.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disocc.commons.JasperReportManager;
import com.sena.disocc.enums.TipoReporteEnum;
import com.sena.disocc.modelo.ReporteComprasDTO;
import com.sena.disocc.service.api.ReporteComprasServiceAPI;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteComprasServiceimp implements ReporteComprasServiceAPI {

	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;

	@Override
	public ReporteComprasDTO obtenerReporteCompras(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ReportesCompras";
		ReporteComprasDTO dto = new ReporteComprasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}

}
