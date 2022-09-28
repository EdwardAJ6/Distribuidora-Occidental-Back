package com.sena.disocc.exportarpdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sena.disocc.modelo.Venta;

@Component("/venta/listar")
public class ListarVentasPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Venta> ListaVentas = (List<Venta>) model.get("venta");
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 30, 20);
		document.open();
		
		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda =null;
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE VENTAS"));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablaVentas = new PdfPTable(6);
		
		ListaVentas.forEach(venta ->{
			tablaVentas.addCell(String.valueOf(venta.getIdVenta()));
			tablaVentas.addCell(venta.getFecha());
			tablaVentas.addCell(String.valueOf(venta.getTotal()));
			tablaVentas.addCell(venta.getPago_realizado());
			tablaVentas.addCell(String.valueOf(venta.getUsuario()));
			tablaVentas.addCell(String.valueOf(venta.getProducto()));
			
		});
		
		document.add(tablaTitulo);
		document.add(tablaVentas);
	}
	
}
