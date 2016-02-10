package com.epam.javatraining.eps.parser;

import com.epam.javatraining.eps.input.ConsoleInputParamsReader;
import com.epam.javatraining.eps.input.CommandLineParamsReader;
import com.epam.javatraining.eps.input.ParamsReader;
import com.epam.javatraining.eps.input.Parameters;


public class Parser {
    
    Parameters params;
    
    public Parameters parse(String[] args) {
        if (args.length == 3) {
            try {
                ParamsReader paramsReaderFromCommand = new CommandLineParamsReader(args);
                params = paramsReaderFromCommand.read();
            } catch (IllegalArgumentException e) {
                System.out.println("Columns and rows must be > 0. Fill factor between 0.0 and 1.0 ");
                ParamsReader paramsReaderFromConsole = new ConsoleInputParamsReader();
                params = paramsReaderFromConsole.read();
            }
        } else {
            ParamsReader paramsReaderFromConsole = new ConsoleInputParamsReader();
            params = paramsReaderFromConsole.read();
        }
        return params;
    }
    
}
