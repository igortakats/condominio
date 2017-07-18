package br.com.igita.condominio.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class ResourceLocator {
	
	public static final String FS = System.getProperty("file.separator");
	
	private ResourceLocator instance = null;
	
	private static Boolean lock = true;

	private static String VERSION;

	static {
		VERSION = "1.0";
	}

	private final static String resourcePath = "C:\\Users\\igt63\\OneDrive\\ws_laboratories_o2\\condominio\\src\\main\\resources";
	private final static String resourceExtension = ".properties";
	
//	public static PATH_TO_PROPERTIES_FILE=
	
	static Logger logger = Logger.getLogger(ResourceLocator.class);
	
	private ResourceLocator() {
		super();
	}
	
	public ResourceLocator getInstance() {
		
		synchronized (lock) {
			if (instance == null) {
				instance = new ResourceLocator();
			}
		}
		
		return instance;
		
	}
	
	public final static String getProperty(String resourceName, String propertyName) throws Exception {
		
		if (StringUtils.isEmpty(resourceName) || 
			StringUtils.isEmpty(propertyName)) {
			String m = "Resource Name or Property Name is empty.";
			logger.error(m);
			throw new Exception(m);
		}
		
		
		ResourceBundle bundle = null;
		
		StringBuffer sb = new StringBuffer();

//		sb.append(FS);
		sb.append(resourcePath);
		sb.append(FS);
		sb.append(resourceName.trim());
		sb.append(resourceExtension);
		
		try {
			bundle = getResourceBundle(sb.toString());
		} catch (IOException e) {
			throw e;
		}
		
		return bundle.getString(propertyName);
		
	}
	
	private static final PropertyResourceBundle getResourceBundle(String fileName) throws FileNotFoundException, IOException  {
		
		
		PropertyResourceBundle bundle = null;
		
		try {
			bundle = new PropertyResourceBundle(getInputStream(fileName));
		} catch (IOException e) {
			throw e;
		}
		
		return bundle;
		
	}
	
	
	private static final FileInputStream getInputStream(String fileName) throws FileNotFoundException {
			
		return new FileInputStream(fileName);	
		
	}
	
	public static final InputStream getResourcesFromClassPath(String name) throws FileNotFoundException {
		
		InputStream stream = ResourceLocator.class.getClassLoader().getResourceAsStream(name);
		
		if (stream == null ) {
			throw new FileNotFoundException("Resource + \"" + name + "\" not found.");
		}
		
		return stream;
	}
	
	public static final InputStream getPropertiesFile(String propertyFileName) throws IOException {

		InputStream out = null;
		
		try {
			
			out = getResourcesFromClassPath(propertyFileName);
			
		} catch (IOException e) {
			throw e;
		}
		
		return out;
	}
	
	public static final Object getPropertyFromBundle(String bundleName, String key) throws IOException {
		
		PropertyResourceBundle bundle = new PropertyResourceBundle(getPropertiesFile(bundleName));
		
		return bundle.getObject(key);
		
	}

}
