package jena;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class InstrumentosSPRQL {
	private static QueryExecution consulta;
	private static ResultSet results;
	
	public static ResultSet sparql(InstrumentosBean instrumentos, int acao) throws IOException {
		InputStream input = new FileInputStream(new File("C:/Users/nilso/workspace/InstrumentosIA/instrumentos_novo.rdf"));
		Model model = ModelFactory.createDefaultModel();
		model.read(input, null, "RDF/XML");
		input.close();
		String queryStr = " PREFIX rdf: <http://www.semanticweb.org/renan/ontologies/2015/7/untitled-ontology-2#>"
						+ " SELECT ?rdf ?tipoInstrumento ?feitoDe ?numeroCordas ?temPes ?mediaPreco WHERE {"
						+ " ?rdf rdf:feitoDe ?feitoDe ."
						+ " ?rdf rdf:mediaPreco ?mediaPreco ."
						+ " ?rdf rdf:numeroCordas ?numeroCordas ."
						+ " ?rdf rdf:temPes ?temPes ."
						+ " ?rdf rdf:tipoInstrumento ?tipoInstrumento." ;
		
		if (Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15).contains(acao))
			queryStr += " FILTER regex(?tipoInstrumento,'" + instrumentos.getTipoInstrumento() + "')";
		if (Arrays.asList(2, 3, 6, 7, 10, 11, 14, 15).contains(acao))
			queryStr += " FILTER regex(?feitoDe,'" + instrumentos.getFeitoDe() + "')";
		if (Arrays.asList(4, 5, 6, 7, 12, 13, 14, 15).contains(acao))
			queryStr +=" FILTER (?numeroCordas = " + String.valueOf(instrumentos.getNumeroCordas()) + ")";
		if (Arrays.asList(8, 9, 10, 11, 12, 13, 14, 15).contains(acao)) {
			queryStr +=" FILTER (?mediaPreco <= " + String.valueOf(instrumentos.getMaxPreco()) + ")" 
					 + " FILTER (?mediaPreco >= " + String.valueOf(instrumentos.getMinPreco()) + ")";
		}
		
		queryStr = queryStr + " }";

		Query query = QueryFactory.create(queryStr);
		consulta = QueryExecutionFactory.create(query, model);
		results = consulta.execSelect();
		return results;
	}

	public static void close() {
		consulta.close();
	}
}
