package test3;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;
import javax.xml.crypto.Data;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		byte[] body=readBody(request,response);
		String textBody=new String(body,"ISO-8859-1");
		String filename=getFilename(textBody);
		Position p=getFilePosition(request, response, textBody);
		writeTo(filename,body,p);
		
	}
	class Position{
		int begin;
		int end;
		public Position(int begin,int end) {
			// TODO Auto-generated constructor stub
			this.begin=begin;
			this.end=end;
			
		}
		
	}
	private byte[] readBody(HttpServletRequest request,HttpServletResponse response)throws IOException{
		int formDataLength=request.getContentLength();
		DataInputStream dataStream=new DataInputStream(request.getInputStream());
		byte body[]=new byte[formDataLength];
		int totalBytes=0;
		while(totalBytes<formDataLength){
			int bytes=dataStream.read(body,totalBytes,formDataLength);
			totalBytes+=bytes;
		}
		return body;
	}
	
	private Position getFilePosition(HttpServletRequest request,HttpServletResponse response,String textBody)throws IOException{
		String contentType=request.getContentType();
		String boundaryText=contentType.substring(contentType.lastIndexOf("=")+1,contentType.length());
		int pos=textBody.indexOf("filename=\"");
		pos=textBody.indexOf("\n",pos)+1;
		pos=textBody.indexOf("\n",pos)+1;
		pos=textBody.indexOf("\n",pos)+1;
		int boundaryLoc=textBody.indexOf(boundaryText,pos)-4;
		int begin=((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
		int end=((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;
		return new Position(begin, end);
	}
	
	private String getFilename(String reqBody){
		String filename=reqBody.substring(reqBody.indexOf("filename=\"")+10);
		filename=filename.substring(0,filename.indexOf("\n"));
		filename=filename.substring(filename.lastIndexOf("\\")+1,filename.indexOf("\""));
		return filename;
	}
	private void writeTo(String filename,byte[] body,Position p)throws FileNotFoundException,IOException{
		FileOutputStream fileOutputStream=new FileOutputStream("c:/workspace/"+filename);
		fileOutputStream.write(body,p.begin,(p.end-p.begin));
		fileOutputStream.flush();
		fileOutputStream.close();
		
	}

}
