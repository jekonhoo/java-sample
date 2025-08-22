package com.bossien.utils;

public class Check {

    public static Object notNull(
            Object obj
    ) {
        if (obj == null) {
            throw new IllegalArgumentException("obj can not be null");
        }

        return obj;
    }

    public static String notNull(
            String str
    ) {
        if (str == null) {
            throw new IllegalArgumentException("obj can not be null");
        }

        return str;
    }

    public static Object notNull(
            Object obj,
            String parameterName
    ) {
        try {
            notNull(obj);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    parameterName + "can not be null",
                    e
            );
        }

        return obj;
    }

    public static String notNull(
            String str,
            String parameterName
    ) {
        try {
            notNull(str);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    parameterName + "can not be null",
                    e
            );
        }

        return str;
    }

	public static String notNull(
			String value,
			String parameterName,
			int maxLength
	) {
		notNull(value, parameterName);

		if (value.length() > maxLength) {
			throw new IllegalArgumentException(
					parameterName + " length must be equal to or lower than " + maxLength + "!"
			);
		}

		return value;
	}

	public static String notNull(
			String value,
			String parameterName,
			int maxLength,
			int minLength
	) {
		notNull(
				value,
				parameterName,
				maxLength
		);

		if (minLength > 0 && value.length() < minLength) {
			throw new IllegalArgumentException(
					parameterName + " length must be equal to or bigger than " + minLength + "!"
			);
		}

		return value;
	}
}
