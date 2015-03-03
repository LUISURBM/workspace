/*   1:    */package sia.bql.ftp;

/*   2:    */
/*   3:    */import common.Logger;
/*   4:    */
import java.io.File;
/*   5:    */
import java.io.FileInputStream;
/*   6:    */
import java.io.FileNotFoundException;
/*   7:    */
import java.io.FileOutputStream;
/*   8:    */
import java.io.IOException;
/*   9:    */
import java.io.InputStream;
/*  10:    */
import java.io.PrintStream;
/*  11:    */
import java.net.SocketException;
/*  12:    */
import org.apache.commons.net.ftp.FTPClient;
/*  13:    */
import sia.bql.bean.util.Archivo;
/*  14:    */
import sia.bql.hibernate.hidromet.HmstPath;
/*  15:    */
import sia.bql.i18n.NombresTitulosAplicacion;
/*  16:    */
import sun.net.ftp.FtpProtocolException;

/*  17:    */
/*  18:    */public class BartTransfer
/* 19: */extends FTPClient
/* 20: */{
	/* 21: */String remoteHost;
	/* 22: */String userName;
	/* 23: */String password;
	/* 24: 28 */private static Logger log = Logger
			.getLogger(BartTransfer.class);

	/* 25: */
	/* 26: */public BartTransfer(String remoteHost, String usuario,
			String password)
	/* 27: */throws IOException
	/* 28: */{
		/* 29: 33 */setRemoteHost(remoteHost);
		/* 30: 34 */setUserName(usuario);
		/* 31: 35 */setPassword(password);
		/* 32: */}

	/* 33: */
	/* 34: */public BartTransfer()
	/* 35: */{
		/* 36: 40 */HmstPath p =
		/* 37: 41 */HmstPath
				.obtenerDirectoriosFtp(NombresTitulosAplicacion.PATH_COMPONENTE.nombreTitulo);
		/* 38: 42 */setRemoteHost(p.getPathServer());
		/* 39: 43 */setUserName(p.getPathUserFtp());
		/* 40: 44 */setPassword(p.getPathPassword());
		/* 41: */}

	/* 42: */
	/* 43: */public boolean enviarImagen(Archivo a)
	/* 44: */throws FtpProtocolException, IOException
	/* 45: */{
		/* 46: 50 */InputStream in = null;
		/* 47: 51 */Boolean resultado = Boolean.valueOf(false);
		/* 48: */try
		/* 49: */{
			/* 50: 53 */if (a.getFileName().length() == 0) {
				/* 51: 54 */log.debug("No nombre para archivo");
				/* 52: */}
			/* 53: 57 */int size = (int) a.getFile().length();
			/* 54: 58 */log.debug("File " + a.getFileName() + ": " + size
					+ " bytes " +
					/* 55: 59 */a.getFile().getAbsolutePath());
			/* 56: */
			/* 57: 61 */in = new FileInputStream(a.getFile().getAbsolutePath()
			/* 58: 62 */.toUpperCase());
			/* 59: 63 */connect();
			/* 60: 64 */setFileType(2);
			/* 61: 65 */enterLocalPassiveMode();
			/* 62: 66 */resultado = Boolean.valueOf(storeFile(a.getFileName(),
					in));
			/* 63: 67 */log.debug("upload : " + resultado);
			/* 64: */}
		/* 65: */catch (Exception ex)
		/* 66: */{
			/* 67: 69 */ex.printStackTrace();
			/* 68: 70 */System.out.println("Error: " + ex.toString());
			/* 69: */}
		/* 70: */finally
		/* 71: */{
			/* 72: 72 */if (in != null) {
				/* 73: 73 */in.close();
				/* 74: */}
			/* 75: 75 */logout();
			/* 76: 76 */disconnect();
			/* 77: */}
		/* 78: 79 */return resultado.booleanValue();
		/* 79: */}

	/* 80: */
	/* 81: */public Archivo bajarImagen(String directorio, String archivo)
	/* 82: */throws FileNotFoundException, IOException
	/* 83: */{
		/* 84: 84 */Archivo bajar = new Archivo();
		/* 85: 85 */bajar.setFileName(directorio + archivo);
		/* 86: 86 */FileOutputStream fos = null;
		/* 87: */try
		/* 88: */{
			/* 89: 88 */connect();
			/* 90: 89 */setFileType(2, 2);
			/* 91: 90 */setFileTransferMode(2);
			/* 92: 91 */enterLocalPassiveMode();
			/* 93: 92 */for (String file : listNames()) {
				/* 94: 93 */if (file.equals(archivo))
				/* 95: */{
					/* 96: 94 */fos = new FileOutputStream(directorio + archivo);
					/* 97: 95 */boolean resultado = retrieveFile(archivo, fos);
					/* 98: 96 */log.debug("download? : " + resultado + " on "
							+ directorio + archivo);
					/* 99: 97 */bajar.setFile(new File(directorio + archivo));break;
					/* 100: */}
				/* 101: */}
			/* 102: */}
		/* 103: */finally
		/* 104: */{
			/* 105:102 */if (fos != null) {
				/* 106:103 */fos.close();
				/* 107: */}
			/* 108:105 */logout();
			/* 109:106 */disconnect();
			/* 110: */}
		/* 111:109 */return bajar;
		/* 112: */}

	/* 113: */
	/* 114: */public boolean eliminarImagen(String file)
	/* 115: */throws FtpProtocolException, IOException
	/* 116: */{
		/* 117:114 */Boolean resultado = Boolean.valueOf(false);
		/* 118: */try
		/* 119: */{
			/* 120:116 */if (file.length() == 0) {
				/* 121:117 */log.debug("No nombre para archivo");
				/* 122: */}
			/* 123:120 */connect();
			/* 124:121 */setFileType(2);
			/* 125:122 */enterLocalPassiveMode();
			/* 126:123 */resultado = Boolean.valueOf(deleteFile(file));
			/* 127:124 */log.debug("delete : " + resultado);
			/* 128: */}
		/* 129: */catch (Exception ex)
		/* 130: */{
			/* 131:126 */ex.printStackTrace();
			/* 132:127 */log.debug("Error: " + ex.toString());
			/* 133: */}
		/* 134: */finally
		/* 135: */{
			/* 136:129 */logout();
			/* 137:130 */disconnect();
			/* 138: */}
		/* 139:133 */return resultado.booleanValue();
		/* 140: */}

	/* 141: */
	/* 142: */private void connect()
	/* 143: */throws SocketException, IOException
	/* 144: */{
		/* 145:137 */connect(getRemoteHost());
		/* 146:138 */login(getUserName(), getPassword());
		/* 147: */}

	/* 148: */
	/* 149: */public String getRemoteHost()
	/* 150: */{
		/* 151:142 */return this.remoteHost;
		/* 152: */}

	/* 153: */
	/* 154: */public void setRemoteHost(String remoteHost)
	/* 155: */{
		/* 156:146 */this.remoteHost = remoteHost;
		/* 157: */}

	/* 158: */
	/* 159: */public String getUserName()
	/* 160: */{
		/* 161:150 */return this.userName;
		/* 162: */}

	/* 163: */
	/* 164: */public void setUserName(String userName)
	/* 165: */{
		/* 166:154 */this.userName = userName;
		/* 167: */}

	/* 168: */
	/* 169: */public String getPassword()
	/* 170: */{
		/* 171:158 */return this.password;
		/* 172: */}

	/* 173: */
	/* 174: */public void setPassword(String password)
	/* 175: */{
		/* 176:162 */this.password = password;
		/* 177: */}
	/* 178: */
}

/*
 * Location: C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * 
 * Qualified Name: sia.bql.ftp.BartTransfer
 * 
 * JD-Core Version: 0.7.0.1
 */