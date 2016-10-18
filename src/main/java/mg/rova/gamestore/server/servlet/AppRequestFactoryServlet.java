package mg.rova.gamestore.server.servlet;

import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

@SuppressWarnings("serial")
public class AppRequestFactoryServlet extends RequestFactoryServlet {

	public AppRequestFactoryServlet() {
		super(getNewExceptionHandler());
	}
	
	public static ExceptionHandler getNewExceptionHandler() {
		
		return new ExceptionHandler() {
			
			@Override
			public ServerFailure createServerFailure(Throwable throwable) {
				String message = "Server Error: " + (throwable == null ? null : throwable.getMessage());
				String exceptionType = throwable.getClass().getSimpleName();
				String stackTraceString = String.valueOf(throwable.getStackTrace());
				return new ServerFailure(message, exceptionType, stackTraceString, true);
			}
		};
	}
}
