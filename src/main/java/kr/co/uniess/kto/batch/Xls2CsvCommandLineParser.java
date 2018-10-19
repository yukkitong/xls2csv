package kr.co.uniess.kto.batch;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Xls2CsvCommandLineParser {

  private Xls2CsvCommandLineParser() {
  }

  public static XlsMeta parse(String[] args) throws ParseException {
      XlsMeta meta = new XlsMeta();
      CommandLineParser parser = new DefaultParser();
      CommandLine cmd = parser.parse(buildOptions(), args);
      meta.filePath = cmd.getOptionValue("i");
      meta.startRow = Integer.valueOf(cmd.getOptionValues("s")[0]);
      meta.startColumn = Integer.valueOf(cmd.getOptionValues("s")[1]);
      return meta;
  }

  public static void showCommandLineHelp() {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp("xls2csv", buildOptions());
  }

  private final static Options buildOptions() {
      Options options = new Options();
      options.addOption(
          Option.builder("i")
              .hasArg(true)
              .argName("xls-file")
              .numberOfArgs(1)
              .required(true)
              .desc("xls file as a source")
              .build()                    
      );
      options.addOption(
          Option.builder("s")
              .hasArg(true)
              .numberOfArgs(2)
              .required(true)
              .argName("start cell position")
              .desc("start-row [space] start-col on Excel Sheet")
              .build()                    
      );
      options.addOption(
          Option.builder("o")
              .longOpt("offset")
              .hasArg(true)
              .numberOfArgs(4)
              .argName("offset")
              .desc("offset")
              .build()
      );
      return options;
  }
}