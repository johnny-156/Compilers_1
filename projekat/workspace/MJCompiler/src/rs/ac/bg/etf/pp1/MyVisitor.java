package rs.ac.bg.etf.pp1;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class MyVisitor extends VisitorAdaptor {

// ovo sam ja dodao liniju
	
	protected Logger log = Logger.getLogger(getClass());
	protected AtomicBoolean error;
	
	public MyVisitor() {
		
	}
	
	public MyVisitor(AtomicBoolean error) {
		this.error = error;
	}
	
	public void setErrorOccurredObject(AtomicBoolean error) {
		this.error = error;
	}
	
	public void report_error(String message, SyntaxNode info) {
		error.set(true);
		StringBuilder msg = new StringBuilder();
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append ("Linija ").append(line).append(": ");
		msg.append(message);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append ("Linija ").append(line).append(": ");
		msg.append(message);
		log.info(msg.toString());
	}
}
