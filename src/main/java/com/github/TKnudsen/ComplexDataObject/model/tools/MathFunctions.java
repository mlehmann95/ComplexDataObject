package com.github.TKnudsen.ComplexDataObject.model.tools;

import java.util.List;

/**
 * <p>
 * Title: MathFunctions
 * </p>
 *
 * <p>
 * Description: little helpers when calculating trivial math stuff.
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 *
 * @author Juergen Bernard
 * @version 1.01
 */

public class MathFunctions {

	/**
	 * scales a value w.r.t. a given minimum and maximum value. The value can be
	 * outside the interval.
	 * 
	 * @param min
	 * @param max
	 * @param value
	 * @return
	 */
	public static double linearScale(double min, double max, double value) {
		if (!Double.isNaN(value))
			if (max != min)
				return (value - min) / (max - min);
			else if (max != 0)
				return (value - min) / (max);
			else
				return 1.0;
		else
			return Double.NaN;
	}

	/**
	 * scales a value w.r.t. a given minimum and maximum value. A boolean can be
	 * set to limit the return value between [0...1].
	 * 
	 * @param min
	 * @param max
	 * @param value
	 * @param limitToInterval
	 * @return
	 */
	public static double linearScale(double min, double max, double value, boolean limitToInterval) {
		if (Double.isNaN(value))
			return Double.NaN;

		double retValue = Double.NaN;

		if (max != min)
			retValue = (value - min) / (max - min);
		else if (max != 0)
			retValue = (value - min) / (max);
		else
			retValue = 1.0;

		if (limitToInterval) {
			retValue = Math.min(retValue, 1.0);
			retValue = Math.max(retValue, 0.0);
		}

		return retValue;
	}

	/**
	 * rounds a given value w.r.t a given number of decimals.
	 * 
	 * @param value
	 * @param decimals
	 * @return
	 */
	public static double round(double value, int decimals) {
		if (Double.isNaN(value))
			return value;

		double pow = Math.pow(10, decimals);
		double d = value * pow;
		d = Math.round(d);
		d /= pow;

		return d;
	}

	/**
	 * Calculates the mean value for a given series of values. Ignores
	 * Double.NAN
	 * 
	 * @param values
	 * @return mean value
	 */
	public static double getMean(double values[]) {
		if (values == null)
			return Double.NaN;

		double sum = 0;
		double count = 0;
		for (double d : values)
			if (!Double.isNaN(d)) {
				sum += d;
				count++;
			}

		return sum / count;
	}

	/**
	 * Calculates the mean value for a given series of values. Ignores
	 * Double.NAN
	 * 
	 * @param values
	 * @return
	 */
	public static double getMean(List<Double> values) {
		if (values == null)
			return Double.NaN;

		double sum = 0;
		double count = 0;
		for (double d : values)
			if (!Double.isNaN(d)) {
				sum += d;
				count++;
			}

		return sum / count;
	}
}