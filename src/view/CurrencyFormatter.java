package view;

import java.text.DecimalFormat;
import java.text.ParseException;

import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

public class CurrencyFormatter extends TextFormatter<Double> {
    private static final double DEFAULT_VALUE = 0.00d;

    private static final DecimalFormat strictZeroDecimalFormat  
        = new DecimalFormat("###,##0.00");

    public CurrencyFormatter() {
        super(
                // string converter converts between a string and a value property.
                new StringConverter<Double>() {
                    @Override
                    public String toString(final Double value) {
                        return strictZeroDecimalFormat.format(value);
                    }

                    @Override
                    public Double fromString(final String string) {
                        try {
                            return strictZeroDecimalFormat.parse(string).doubleValue();
                        } catch (final ParseException e) {
                            return Double.NaN;
                        }
                    }
                },
                DEFAULT_VALUE,
                // change filter rejects text input if it cannot be parsed.
                change -> {
                    try {
                        strictZeroDecimalFormat.parse(change.getControlNewText());
                        return change;
                    } catch (final ParseException e) {
                        return null;
                    }
                }
        );
    }
}