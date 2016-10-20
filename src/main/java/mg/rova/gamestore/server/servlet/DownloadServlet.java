package mg.rova.gamestore.server.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("file");

		int BUFFER = 1024 * 100;
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition:", "attachment;filename=" + "\"" + filename + "\"");
		ServletOutputStream outputStream = response.getOutputStream();
		response.setContentLength(Long.valueOf(new File(filename).length()).intValue());
		response.setBufferSize(BUFFER);
		// Your IO code goes here to create a file and set to outputStream//
	}
}