package com.epam.javatraining.eps.input;

import com.epam.javatraining.eps.utils.Size;
import java.util.InputMismatchException;

public class CommandLineParamsReader implements ParamsReader {

    private final String[] args;

    public CommandLineParamsReader(String[] args) {
        this.args = args;
    }

    @Override
    public Parameters read() {
        Parameters fieldParams = new Parameters();
        fieldParams.setFieldSize(new Size(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        fieldParams.setFillFactor(Double.parseDouble(args[2]));
        checkCorrectParams(fieldParams);
        return fieldParams;
    }

    private void checkCorrectParams(Parameters params) {
        try {
            if (params.getFieldSize().getHeight() <= 0 || params.getFieldSize().getWidth() <= 0) {
                System.out.println("Wrong arguments in command line");
                throw (new IllegalArgumentException());
            }
            if (params.getFillFactor() < 0 || params.getFillFactor() > 1) {
                System.out.println("Wrong arguments in command line");
                throw (new IllegalArgumentException());
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Wrong in reading command line");
        }
    }
}
