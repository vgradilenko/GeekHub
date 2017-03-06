package com.geekhub.gradilenko.grep;

import org.apache.commons.cli.Options;

public class InitOptions {

    public Options getOptions() {
        Options options = new Options();
        options.addOption("w", "word", true, "enter the search phrase");
        options.addOption("r", "regex", true, "set regular expression");
        options.addOption("f", "file", true, "set path to file");
        options.addOption("u", "url", true, "set url");
        options.addOption("h", "help", false, "print help");

        return options;
    }
}
