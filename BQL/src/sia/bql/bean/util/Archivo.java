/*  1:   */package sia.bql.bean.util;

/*  2:   */
/*  3:   */import com.icesoft.faces.component.inputfile.FileInfo;
/*  4:   */
import java.io.File;

import org.icefaces.ace.component.fileentry.FileEntryResults;

/*  6:   */
/*  7:   */public class Archivo
/* 8: */{
	/* 9: */private String fileName;
	/* 10: */private String fileExtension;
	/* 11: */private File file;

	/* 12: */
	/* 13: */public Archivo(FileEntryResults.FileInfo fileInfo2)
	/* 14: */{
		/* 15:27 */this.fileName = fileInfo2.getFileName();
		/* 16:28 */this.file = fileInfo2.getFile();
		/* 17: */}

	/* 18: */
	/* 19: */public Archivo(FileInfo fileInfo)
	/* 20: */{
		/* 21:31 */this.fileName = fileInfo.getFileName();
		/* 22:32 */this.file = fileInfo.getFile();
		/* 23: */}

	/* 24: */
	/* 25: */public Archivo()
	/* 26: */{
		/* 27:36 */this.fileName = null;
		/* 28:37 */this.fileExtension = null;
		/* 29:38 */this.file = null;
		/* 30: */}

	/* 31: */
	/* 32: */public File getFile()
	/* 33: */{
		/* 34:44 */return this.file;
		/* 35: */}

	/* 36: */
	/* 37: */public void setFile(File file)
	/* 38: */{
		/* 39:48 */this.file = file;
		/* 40: */}

	/* 41: */
	/* 42: */public String getFileName()
	/* 43: */{
		/* 44:54 */return this.fileName;
		/* 45: */}

	/* 46: */
	/* 47: */public void setFileName(String fileName)
	/* 48: */{
		/* 49:57 */this.fileName = fileName;
		/* 50: */}

	/* 51: */
	/* 52: */public String getFileExtension()
	/* 53: */{
		/* 54:60 */return this.fileExtension;
		/* 55: */}

	/* 56: */
	/* 57: */public void setFileExtension(String fileExtension)
	/* 58: */{
		/* 59:63 */this.fileExtension = (fileExtension);
		/* 60: */}
	/* 61: */
}

/*
 * Location: C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * 
 * Qualified Name: sia.bql.bean.util.Archivo
 * 
 * JD-Core Version: 0.7.0.1
 */