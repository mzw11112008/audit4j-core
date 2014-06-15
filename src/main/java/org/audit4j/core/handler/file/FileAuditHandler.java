package org.audit4j.core.handler.file;

import org.audit4j.core.exception.InitializationException;
import org.audit4j.core.handler.Handler;

/**
 * The Class FileAuditHandler.
 * 
 * @author <a href="mailto:janith3000@gmail.com">Janith Bandara</a>
 */
public class FileAuditHandler extends Handler {

	/**
	 * asdas
	 */
	private static final long serialVersionUID = 1L;
	
	/** The writer. */
	ZeroCopyFileWriter writer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.audit4j.core.handler.Handler#init()
	 */
	@Override
	public void init() throws InitializationException {
		writer = new ZeroCopyFileWriter(getProperty("log.file.location"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.audit4j.core.handler.Handler#handle()
	 */
	@Override
	public void handle() {
		writer.write(getQuery());
	}
}