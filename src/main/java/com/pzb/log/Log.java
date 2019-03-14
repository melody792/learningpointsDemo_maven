/* ****************************************************************** */
/*                                                                    */
/* IBM Confidential                                                   */
/*                                                                    */
/* OCO Source Materials                                               */
/* 5900-A1H                                                           */
/* © Copyright IBM Corp. 2017, 2018                                   */
/*                                                                    */
/* The source code for this program is not published or otherwise     */
/* divested of its trade secrets, irrespective of what has been       */
/* deposited with the U.S. Copyright Office.                          */
/*                                                                    */
/* ****************************************************************** */
package com.pzb.log;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	public static final Level AUDIT = new LevelExt("AUDIT", 850);


	/**
	 * Logs and returns a severe message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted
	 * without arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * SEVERE or lower.
	 * 
	 * @param logger the logger to use
	 * @param sourceMethod your method name
	 * @param msgKey the message key
	 * @param t an Exception generated for the problem
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String severe(Logger logger, String sourceMethod, Throwable t, String msgKey) {
		return severe( logger,  sourceMethod,  t, msgKey,  (Object[])null);
	}

	/**
	 * Logs and returns a severe message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted
	 * with arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * SEVERE or lower.
	 * 
	 * @param logger the logger to use
	 * @param sourceMethod the message key
	 * @param t an Exception generated for the problem
	 * @param msgKey - the key
	 * @param args - the args
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String severe(Logger logger, String sourceMethod, Throwable t, String msgKey, Object ... args) {
		return log(logger, Level.SEVERE, t, null, sourceMethod, msgKey, args);
	}

	/**
	 * Logs and returns a severe message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted
	 * without arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * SEVERE or lower.
	 * 
	 * @param logger the logger to use
	 * @param msgKey the message key
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String severe(Logger logger, String msgKey) {
		return severe(logger, msgKey, (Object[])null);
	}

	/**
	 * Logs and returns a severe message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted with
	 * arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * SEVERE or lower.
	 * 
	 * @param logger the logger to use
	 * @param msgKey the message key
	 * @param args the arguments
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String severe(Logger logger, String msgKey, Object ... args) {
		return log(logger, Level.SEVERE, msgKey, args);
	}

	/**
	 * Logs and returns a warning message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted
	 * without arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * WARNING or lower.
	 * 
	 * @param logger the logger to use
	 * @param sourceMethod your method name
	 * @param msgKey the message key
	 * @param t an Exception generated for the problem
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String warning(Logger logger, String sourceMethod, Throwable t, String msgKey) {
		return warning(logger,  sourceMethod, t, msgKey,  (Object[])null);
	}

	/**
	 * Logs and returns a warning message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted
	 * with arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * WARNING or lower.
	 * 
	 * @param logger the logger to use
	 * @param sourceMethod your method name
	 * @param msgKey the message key
	 * @param args the arguments
	 * @param t an Exception generated for the problem
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String warning(Logger logger, String sourceMethod, Throwable t, String msgKey, Object ... args) {
		return log(logger, Level.WARNING, t, null, sourceMethod, msgKey, args);
	}

	/**
	 * Logs and returns a warning message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted
	 * without arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * WARNING or lower.
	 * 
	 * @param logger the logger to use
	 * @param msgKey the message key
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String warning(Logger logger, String msgKey) {
		return warning(logger, msgKey, (Object[])null);
	}

	/**
	 * Logs and returns a warning message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted with
	 * arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * WARNING or lower.
	 * 
	 * @param logger the logger to use
	 * @param msgKey the message key
	 * @param args the arguments
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String warning(Logger logger, String msgKey, Object ... args) {
		return log(logger, Level.WARNING, msgKey, args);
	}
	
	/**
	 * Logs and returns an informational message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted
	 * without arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * INFO or lower.
	 * 
	 * @param logger the logger to use
	 * @param msgKey the message key
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String info(Logger logger, String msgKey) {
		if (logger.isLoggable(Level.INFO)) {
			return info(logger, msgKey, (Object[])null);
		}
		return null;
	}

	/**
	 * Logs and returns an informational message.  The message is identified by a key
	 * that is a base name in the resource bundle allocated to the logger used.
	 * The message text is localised to the current locale and formatted with
	 * arguments.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * INFO or lower.
	 *
	 * @param logger the logger to use
	 * @param msgKey the message key
	 * @param args the arguments
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */

	public static String info(Logger logger, String msgKey, Object ... args) {
		if (logger.isLoggable(Level.INFO)) {
			return log(logger, Level.INFO, null, msgKey, args);
		}
		return null;
	}

	/**
	 * Method entry trace.
	 *
	 * To enable messages logged with this method, set the logger level to
	 * FINER or lower.
	 *
	 * @param logger The logger to use
	 * @param sourceClass The referenced class
	 * @param sourceMethod The method being entered
	 */
	public static void entry(Logger logger, String sourceClass, String sourceMethod) {
		if (logger.isLoggable(Level.FINER)) {
			entry(logger, sourceClass, sourceMethod, (Object[])null);
		}
	}

	/**
	 * Method entry trace.
	 *
	 * To enable messages logged with this method, set the logger level to
	 * FINER or lower.
	 *
	 * @param logger The logger to use
	 * @param sourceClass The referenced class
	 * @param sourceMethod The method being entered
	 * @param args The arguments
	 */
	public static void entry(Logger logger, String sourceClass, String sourceMethod, Object ... args) {
		if (logger.isLoggable(Level.FINER)) {
			logger.entering(sourceClass, sourceMethod, args);
		}
	}

	/**
	 * Method exit trace.
	 *
	 * To enable messages logged with this method, set the logger level to
	 * FINER or lower.
	 *
	 * @param logger The logger to use
	 * @param sourceClass The referenced class
	 * @param sourceMethod The method being exited
	 */
	public static void exit(Logger logger, String sourceClass, String sourceMethod) {
		if (logger.isLoggable(Level.FINER)) {
			exit(logger, sourceClass, sourceMethod, (Object)null);
		}
	}

	/**
	 * Method exit trace.
	 *
	 * To enable messages logged with this method, set the logger level to
	 * FINER or lower.
	 *
	 * @param logger The logger to use
	 * @param sourceClass The referenced class
	 * @param sourceMethod The method being exited
	 * @param result The method result
	 */
	public static void exit(Logger logger, String sourceClass, String sourceMethod, Object result) {
		if (logger.isLoggable(Level.FINER)) {
			logger.exiting(sourceClass, sourceMethod, result);
		}
	}

	/**
	 * Logs a trace message.  The message text is formatted without arguments
	 * but not localised to the current locale.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * FINE or lower.
	 * <p>
	 * To represent a single quote in the message, use two single quotes.  For
	 * other formatting rules refer to API doc for the ICU class
	 * com.ibm.icu.text.MessageFormat.
	 *
	 * @param logger the logger to use
	 * @param message the message
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String fine(Logger logger, String message) {
		if (logger.isLoggable(Level.FINE)) {
			return fine(logger, message, (Object[])null);
		}
		return null;
	}

	/**
	 * Logs a trace message.  The message text is formatted with arguments
	 * but not localised to the current locale.
	 * <p>
	 * To enable messages logged with this method, set the logger level to
	 * FINE or lower.
	 * <p>
	 * To represent a single quote in the message, use two single quotes.  For
	 * other formatting rules refer to API doc for the ICU class
	 * com.ibm.icu.text.MessageFormat.
	 *
	 * @param logger the logger to use
	 * @param message the message
	 * @param args the arguments
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String fine(Logger logger, String message, Object ... args) {
		if (logger.isLoggable(Level.FINE)) {
			return log(logger, Level.FINE, message, args);
		}
		return null;
	}

	/**
	 * Test for logger level to determine if messages at the specified level will be logged.
	 * @param logger the logger to use
	 * @param level the logger level to be tested
	 * @return true if messages at this level will be logged, false otherwise
	 */
	public static boolean isLoggable(Logger logger, Level level) {
		if (logger.isLoggable(level)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a message.  The message is identified by a key that is a base
	 * name in the resource bundle allocated to the logger used.  The message
	 * text is formatted without arguments and localised to the current locale.
	 * <p>
	 * This method does not log the message.  Use it if you want to handle the
	 * message yourself without logging it.
	 * <p>
	 * To represent a single quote in the message, use two single quotes.  For
	 * other formatting rules refer to API doc for the ICU class
	 * com.ibm.icu.text.MessageFormat.
	 * 
	 * @param logger the logger to use
	 * @param msgKey the message key
	 * @return the localised and formatted message
	 */

	public static String format(Logger logger, String msgKey) {
		String msg = localiseAndFormatMessage(logger.getResourceBundle(), msgKey, (Object[])null);
		return msg;
	}

	/**
	 * Returns a message.  The message is identified by a key that is a base
	 * name in the resource bundle allocated to the logger used.  The message
	 * text is formatted with arguments and localised to the current locale.
	 * <p>
	 * This method does not log the message.  Use it if you want to handle the
	 * message yourself without logging it.
	 * <p>
	 * To represent a single quote in the message, use two single quotes.  For
	 * other formatting rules refer to API doc for the ICU class
	 * com.ibm.icu.text.MessageFormat.
	 * 
	 * @param logger the logger to use
	 * @param msgKey the message key
	 * @param args the arguments
	 * @return the localised and formatted message
	 */

	public static String format(Logger logger, String msgKey, Object ... args) {
		return localiseAndFormatMessage(logger.getResourceBundle(), msgKey, args);
	}

	/**
	 * Localises and formats a message.  The message is identified by a key that
	 * is a base name in the given resource bundle.  The message text is
	 * localised to the current locale and formatted with arguments.
	 * <p>
	 * If the key is not found in the resource bundle, the key itself is
	 * returned.
	 * 
	 * @param bundle the resource bundle to use
	 * @param key the message key
	 * @param args the arguments (may be null)
	 * @return the localised and formatted message
	 */

	public static String localiseAndFormatMessage(ResourceBundle bundle, String key, Object ... args) {
		String message = key;
		if (null != bundle && bundle.containsKey(key)) {
			message = bundle.getString(key);
		}
		return formatMessage(message, args);
	}

	/**
	 * Formats a message with arguments.
	 * 
	 * @param message the message
	 * @param args the arguments (may be null)
	 * @return the formatted message
	 */

	private static String formatMessage(String message, Object ... args) {
		String formattedMessage = message;
		try {
			formattedMessage = MessageFormat.format(message, args);
		} catch (IllegalArgumentException e) {
		}
		return formattedMessage;
	}
	
	/**
	 * 
	 * @param logger the logger to use
	 * @param level the specified logging level
	 * @param t Throwable (Exception)
	 * @param message the message
	 * @param args the arguments
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String log(Logger logger, Level level, Throwable t, String message, Object ... args) {
		if (logger.isLoggable(level)) {
			return log(logger, level, t, null, null, message, args);
		}
		return null;
	}
	
	/**
	 * Logs a message.  The message text is formatted without arguments
	 * but not localised to the current locale.
	 * <p>
	 * The default logger level for trace is FINE. To log messages with FINER or FINEST
	 * level, use the level parameter and set the logger level appropriately.
	 * <p>
	 * To represent a single quote in the message, use two single quotes.  For
	 * other formatting rules refer to API doc for the ICU class
	 * com.ibm.icu.text.MessageFormat.
	 * 
	 * @param logger the logger to use
	 * @param level the specified logging level
	 * @param message the message
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String log(Logger logger, Level level,String tid, String message) {
		return log(logger, level, (Throwable)null, null, message, (Object[])null);
	}

	/**
	 * Logs a message.  The message text is formatted with arguments but
	 * not localised to the current locale.
	 * <p>
	 * The default logger level for trace is FINE. To log messages with FINER or FINEST
	 * level, use the level parameter and set the logger level appropriately.
	 * <p>
	 * To represent a single quote in the message, use two single quotes.  For
	 * other formatting rules refer to API doc for the ICU class
	 * com.ibm.icu.text.MessageFormat.
	 * 
	 * @param logger the logger to use
	 * @param level the specified logging level
	 * @param message the message
	 * @param args the arguments
	 * @return the localised and formatted message - ignore it if you don't
	 *          need it - or null if the logging did not complete
	 */
	public static String log(Logger logger, Level level, String message, Object ... args) {
		return log(logger, level, (Throwable)null, null, message, args);
	}
	
	public static String log(Logger logger, Level level, Throwable t, String sourceMethod, String msgKey, Object ... args) {
		if (logger.isLoggable(level)) {
			return log(logger, level, t, null, sourceMethod, msgKey, args);
		}
		return null;
	}
	
	public static String log(Logger logger, Level level, String tid, String sourceClass, String sourceMethod, String message, Object ... args) {
		return log(logger, level,tid, null, sourceClass, sourceMethod, message, args);
	}
	
	public static String log(Logger logger, Level level,String tid, Throwable t, String sourceClass, String sourceMethod, String message, Object ... args) {
		if (logger.isLoggable(level)) {
			String msg = format(logger, message, args);
			doLog(logger, level,tid, t, sourceClass, sourceMethod, msg);
			return msg;
		}
		return null;
	}
	
	private static void doLog(Logger logger, Level level, String handleTid, Throwable t, String sourceClass, String sourceMethod, String message) {
		String sourceClassLocVal = (sourceClass == null) || (sourceClass.isEmpty()) ? logger.getName() : sourceClass;

		String tenantId = null;
		try {
			tenantId = LoggedTenantId.get();
		} catch(Exception ignored) { }

		if (t == null) {
			if(tenantId != null) {
				if (handleTid != null) {
					logger.logp(level, sourceClassLocVal, sourceMethod, "[tid=" + tenantId + "] " + "[handleTid=" + handleTid + "] " + message);
				} else {
					logger.logp(level, sourceClassLocVal, sourceMethod, "[tid=" + tenantId + "] " + message);
				}
			} else {
				logger.logp(level, sourceClassLocVal, sourceMethod, message);
			}
		} else {
			if(tenantId != null) {
				logger.logp(level, sourceClassLocVal, sourceMethod, "[tid=" + tenantId + "] " + "[handleTid=" + handleTid + "] " + message, t);
			} else {
				logger.logp(level, sourceClassLocVal, sourceMethod, message, t);
			}
		}
	}
	
	private static class LevelExt extends Level {
		
		private static final long serialVersionUID = 1L;

		public LevelExt(Level _level) {
			super(_level.getName(), _level.intValue());
		}
		
		protected LevelExt(String name, int value) {
			super(name, value);
		}
	}


	/**
	 * This class should only be used for logging -- to get a tenant id anywhere
	 * else in the application use <code>@Inject Provider&lt;AtUser&gt; user</code>
	 */
	public static class LoggedTenantId {

	    private static final Logger logger = Logger.getLogger(LoggedTenantId.class.getName());
		private final static ThreadLocal<String> contexts = new ThreadLocal<String>();

		private static String defaultId;

		/**
		 * Set the tenantId on the ThreadLocal.
		 * Caution:
		 * (1) to avoid memory leak, be sure to call reset()
		 *     eg. try { LoggedTenantId.set(id); ... } finally { LoggedTenantId.reset(); }
		 * (2) do not call this method outside of ApplicationFilter unless you are sure
		 *     it is not going to intercept an existing request.
		 *
		 * @param tenantId - the tenant id
		 */

		public static void set(String tenantId) {
			if(isLoggable(logger, Level.FINEST)) {
				log(logger, Level.FINEST, "set tenant id ''{0}'' called by {1}", tenantId, new Throwable().getStackTrace()[1]);
			}
			contexts.set(tenantId);
		}


		public static String get() throws Exception {
			String tenantId = contexts.get();
			if (tenantId == null) {
				if (defaultId != null) {
					tenantId = defaultId;
				}
				else {
					// TODO: must have tenant id, otherwise, to throw exception
					tenantId = "defaultTid";
	//				throw new TenantException("No tenant id available.  Unauthorized.");
				}
			}
			return tenantId;
		}


		public static String getUnchecked() {
			try {
				return get();
			}
			catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		public static void reset() {
			if(isLoggable(logger, Level.FINEST)) {
			    log(logger, Level.FINEST, "reset tenant id ''{0}'' called by {1}", contexts.get(), new Throwable().getStackTrace()[1]);
			}
			contexts.remove();
		}

		public static void initForTest(String tenantId) {
			defaultId = tenantId;
		}
	}
}
