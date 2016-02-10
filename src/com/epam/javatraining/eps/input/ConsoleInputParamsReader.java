package com.epam.javatraining.eps.input;

import com.epam.javatraining.eps.utils.Size;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputParamsReader implements ParamsReader {

    @Override
    public Parameters read() {
        Parameters fieldParams = new Parameters();
        int numberOfColumns = scanPositiveInt("Enter number of columns of matrix: ");
        int numberOfRows = scanPositiveInt("Enter number of rows of matrix: ");
        fieldParams.setFieldSize(new Size(numberOfColumns, numberOfRows));
        double fillFactor = scanPositiveFillFactor("Enter value FILL_FACTOR: ");
        fieldParams.setFillFactor(fillFactor);
        return fieldParams;
    }

    private int scanPositiveInt(String mes) {
        int ret = -1;
        while (ret <= 0) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println(mes);
                ret = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong in size of field");
            }
        }
        return ret;

    }

    private double scanPositiveFillFactor(String mes) {
        double ret = -1;
        while (ret < 0 || ret > 1) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println(mes);
                ret = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Wrong in fill factor");
            }
        }
        return ret;

    }
}
