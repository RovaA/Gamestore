package mg.rova.gamestore.server.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!ServletFileUpload.isMultipartContent(request)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not a multipart request");
			return;
		}

		ServletFileUpload upload = new ServletFileUpload(); // from Commons

		try {
			FileItemIterator iter = upload.getItemIterator(request);

			if (iter.hasNext()) {
				FileItemStream fileItem = iter.next();

				ServletOutputStream out = response.getOutputStream();
				response.setBufferSize(32768);

				InputStream in = fileItem.openStream();
				// The destination of your uploaded files.
				final File directory = new File("uploadedFiles");
				if (!directory.exists())
					directory.mkdirs();

				final File file = new File(fileItem.getName());
				OutputStream outputStream = new FileOutputStream(file);

				int length = 0;
				byte[] bytes = new byte[1024];

				while ((length = in.read(bytes)) != -1) {
					outputStream.write(bytes, 0, length);
				}

				response.setContentType("text/html");
				response.setContentLength((length > 0 && length <= Integer.MAX_VALUE) ? (int) length : 0);

				outputStream.close();
				in.close();
				out.flush();
				out.close();
			}
		} catch (Exception caught) {
			throw new RuntimeException(caught);
		}
	}
}