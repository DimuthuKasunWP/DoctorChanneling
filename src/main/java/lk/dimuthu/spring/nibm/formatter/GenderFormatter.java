package lk.dimuthu.spring.nibm.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import lk.dimuthu.spring.nibm.domain.Gender;

/**
 * {@link Gender} formatter for web application, this allow us to use Gender
 * enumeration as a property in our model.
 *
 * @see Gender
 * @author Toan Quach
 * @version $Id: $Id
 */
public class GenderFormatter implements Formatter<Gender> {

	/** {@inheritDoc} */
	@Override
	public String print(Gender gender, Locale locale) {
		return gender.name();
	}

	/** {@inheritDoc} */
	@Override
	public Gender parse(String text, Locale locale) throws ParseException {
		return Gender.valueOf(text);
	}
}
