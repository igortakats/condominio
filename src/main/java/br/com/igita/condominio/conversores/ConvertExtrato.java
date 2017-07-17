package br.com.igita.condominio.conversores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.igita.condominio.common.ResourceLocator;
import br.com.igita.condominio.conversores.DAO.DAO;
import br.com.igita.condominio.conversores.entities.TbMovimentacao;


public class ConvertExtrato extends DAO<TbMovimentacao> {
	
	private String drive = "h:\\Igor\\Onedrive\\_igor\\";
//	private String drive = "c:\\Users\\igt63\\OneDrive\\_igor\\";

//	private String fileToRead = drive + "Users\\igt63\\OneDrive\\_igor\\condo_jan_2013_mai_2017.txt";
//	private String fileExtension = ".txt";
//	private String fileName_prefix = drive + "Users\\igt63\\OneDrive\\_igor\\refugo_";
//	private String fileProperties = drive + "Users\\igt63\\OneDrive\\_igor\\condo.properties";
	
	private String fileToRead = drive + "condo_jan_2013_mai_2017.txt";
	private String fileExtension = ".txt";
	private String fileName_prefix = drive + "refugo_";
	private String fileProperties = drive + "condo.properties";
	
	private String newLine = "\n";
	
	Logger logger = Logger.getLogger(ConvertExtrato.class);
	
	public static void main(String[] args) {
		
		try {
			(new ConvertExtrato()).execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	private void execute() throws Exception {

		String line = null;
		
		String refugo = null;
		
		int count = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.load(ResourceLocator.getPropertiesFile("condo.properties"));
		} catch (Exception e) {
			logger.error(e);
			throw e;
		} 

		int numeroArquivoRefugo = Integer.parseInt(prop.getProperty("numero.arquivo.refugo"));
		
		numeroArquivoRefugo++;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(fileName_prefix);
		sb.append(numeroArquivoRefugo);
		sb.append(fileExtension);
		
		FileWriter outRefugo = new FileWriter(sb.toString());
		
		BufferedWriter writer = new BufferedWriter(outRefugo);

		FileReader fileReader = new FileReader(fileToRead);
		
		BufferedReader reader = new BufferedReader(fileReader);
		
		IConverterExtrato toTaxa = new ConvertExtratoToMovimentacao();
		
		while((line = reader.readLine()) != null) {
			
			count++;
			
			refugo = toTaxa.process(line);
			
			if (refugo != null) {
				writer.write(refugo.concat(newLine));
			}
			
		}
		
		logger.info("Total de registros processados ==> " + count);
		
		super.getConnection().close();
		
		reader.close();
		writer.close();
		
		FileOutputStream output = null;
		
		try {
			output = new FileOutputStream(fileProperties);
			Properties properties = new Properties();
			properties.setProperty("numero.arquivo.refugo", String.valueOf(numeroArquivoRefugo));
			properties.store(output, null);
			
		} catch (Exception e) {
			logger.error(e);
			System.exit(-1);
		} finally {
			output.close();
		}
		
	}
	
}
