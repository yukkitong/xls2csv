package kr.co.uniess.kto.batch;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.uniess.kto.batch.model.csv.Image;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) {

        logger.info("App start with " + Arrays.toString(args));
        
        XlsMeta meta = null;
        List<Image> list = null;

        try {
            meta = Xls2CsvCommandLineParser.parse(args);
            list = XlsReader.loadExcelFile(meta);
        } catch (ParseException e) {
            e.printStackTrace();
            Xls2CsvCommandLineParser.showCommandLineHelp();
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        assert meta != null;
        assert list != null;

        try {
            CsvWriter.write(list, getOutputFile(meta.filePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static final String getOutputFile(String input) {
        int extPoint = input.lastIndexOf(".xls");
        return input.substring(0, extPoint) + ".csv";
    }
}
