package sia.cmmad.bean.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.Resource;
import javax.faces.context.FacesContext;

public class MyResource extends Resource implements java.io.Serializable {

	private String path = "";
	private HashMap<String, String> headers;
	private byte[] bytes;

	public MyResource(byte[] bytes) {
		this.bytes = bytes;
		this.headers = new HashMap<String, String>();
	}

	public InputStream getInputStream() {
		return new ByteArrayInputStream(this.bytes);
	}

	public String getRequestPath() {
		return path;
	}

	public void setRequestPath(String path) {
		this.path = path;
	}

	public Map<String, String> getResponseHeaders() {
		return headers;
	}

	public URL getURL() {
		return null;
	}

	@Override
	public boolean userAgentNeedsUpdate(FacesContext arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
