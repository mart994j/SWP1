package app;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateServer {
	// The DateServer has not 100% code coverage, as it basically replaced immediately by the
	// mock date server for testing.


		/**
		 * Return the current date without the current time.
		 * @return the current date without the current time
		 */
		public Calendar getDate() {
			Calendar calendar = new GregorianCalendar();
			Calendar c = new GregorianCalendar(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
			return c;
		}
}
