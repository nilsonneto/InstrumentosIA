package jena;

import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/busca/instrumentos")
public class InstrumentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InstrumentosBean model = new InstrumentosBean();
		String tipo = request.getParameter("txtTipo");
		String material = request.getParameter("txtMaterial");
		String cordas = request.getParameter("txtCordas");
		String minPreco = request.getParameter("txtMinPreco");
		String maxPreco = request.getParameter("txtMaxPreco");
		int acao = 0;
		
		/* 
		 * Ação:
		 * 0 = Todos
		 * 1 = Tipo
		 * 2 = Material
		 * 3 = Tipo + Material
		 * 4 = Cordas
		 * 5 = Tipo + Cordas 
		 * 6 = Material + Cordas
		 * 7 = Tipo + Material + Cordas
		 * 8 = Preço
		 * 9 = Tipo + Preço
		 * 10 = Material + Preço
		 * 11 = Tipo + Material + Preço
		 * 12 = Cordas + Preço
		 * 13 = Tipo + Cordas + Preço
		 * 14 = Material + Cordas + Preço
		 * 15 = Tipo + Material + Cordas + Preço
		 */
		
		if (!tipo.isEmpty())
			acao += 1;
		if (!material.isEmpty())
			acao += 2;
		if (!cordas.isEmpty())
			acao += 4;		
		if (!minPreco.isEmpty() || !maxPreco.isEmpty())
			acao += 8;
		
		if (cordas.isEmpty())
			cordas = "0";
		if (minPreco.isEmpty())
			minPreco = "0";
		if (maxPreco.isEmpty())
			maxPreco = "999999999";
		
		model.setTipoInstrumento(tipo);
		model.setFeitoDe(material);
		model.setNumeroCordas(Integer.valueOf(cordas));
		model.setMinPreco(Float.valueOf(minPreco));
		model.setMaxPreco(Float.valueOf(maxPreco));
		
		System.out.println("Ação " + String.valueOf(acao) + " Parametros: \'" 
				+ tipo + "\' || \'" 
				+ material + "\' || \'" 
				+ cordas + "\' || \'" 
				+ minPreco + "\' || \'" 
				+ maxPreco + "\' || \'"
		);

		ResultSet result = jena.InstrumentosSPRQL.sparql(model, acao);
		String resultStr = ResultSetFormatter.asXMLString(result);
		resultStr = resultStr.replaceAll("http://www.semanticweb.org/renan/ontologies/2015/7/untitled-ontology-2", "");
		resultStr = resultStr.replaceAll("<.*?>", "");
		resultStr = resultStr.replaceAll(" ", "");
		resultStr = resultStr.replaceAll("(\\n)+", " ");
		if (resultStr.isEmpty() || resultStr.equals(" "))
			resultStr = "Não foram encontrados resultados :( :(";
		else
			resultStr = resultStr.substring(2);
		List<String> resultList = Arrays.asList(resultStr.split(" #"));
		
		jena.InstrumentosSPRQL.close();
		request.getSession().setAttribute("resultList", resultList);
        response.sendRedirect("results.jsp");
	}
}
