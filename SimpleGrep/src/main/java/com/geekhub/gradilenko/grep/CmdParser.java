package com.geekhub.gradilenko.grep;

import com.geekhub.gradilenko.grep.parser.ContentParser;
import com.geekhub.gradilenko.grep.parser.TextContentParser;
import com.geekhub.gradilenko.grep.source.SourceLoader;
import com.geekhub.gradilenko.grep.source.SourceLoadingException;
import org.apache.commons.cli.*;

public class CmdParser {

    private InitOptions initOptions = new InitOptions();
    private ContentParser contentParser = new TextContentParser();
    private SourceLoader loader = new SourceLoader();

    public void parse(final String[] cmdArgs) throws WrongArgumentException, SourceLoadingException {
        CommandLineParser parser = new DefaultParser();
        Options options = initOptions.getOptions();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, cmdArgs);

            if (cmd.hasOption("h")) {
                printHelp();
            } else {
                if (cmd.hasOption("w") && cmd.hasOption("f")) {
                    System.out.println(contentParser.parseContent(loader.loadSource(cmd.getOptionValue("f")),
                            cmd.getOptionValue("w")));

                } else if (cmd.hasOption("r") && cmd.hasOption("f")) {
                    System.out.println(contentParser.parseContent(loader.loadSource(cmd.getOptionValue("f")),
                            cmd.getOptionValue("w")));

                } else if (cmd.hasOption("w") && cmd.hasOption("u")) {
                    System.out.println(contentParser.parseContent(loader.loadSource(cmd.getOptionValue("u")),
                            cmd.getOptionValue("w")));

                } else if (cmd.hasOption("r") && cmd.hasOption("u")) {
                    System.out.println(contentParser.parseContent(loader.loadSource(cmd.getOptionValue("u")),
                            cmd.getOptionValue("w")));
                }
            }
        } catch (ParseException e) {
            throw new WrongArgumentException(e);
        }
    }

    public void printHelp() {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("h", initOptions.getOptions());
    }
}

