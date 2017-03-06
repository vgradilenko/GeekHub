package com.geekhub.gradilenko.grep;

import com.geekhub.gradilenko.grep.source.SourceLoadingException;
import org.apache.commons.cli.*;

public class Start {
    public static void main(String[] args) throws ParseException {
        CmdParser cmdParser = new CmdParser();
        try {
            cmdParser.parse(args);
        } catch (WrongArgumentException | SourceLoadingException e) {
            cmdParser.printHelp();
            System.exit(1);
        }
    }
}
