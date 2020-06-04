package Services;

import TestData.GebruikersData;
import TestData.WegData;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileService
{
    public List<String[]> GetTextFromCsvFile(File file) throws IOException, CsvException
    {
        // class with CSV file as a parameter.
        FileReader filereader = new FileReader(file);

        // file reader as a parameter
        CSVReader csvReader = new CSVReader(filereader);
        return csvReader.readAll();
    }

    public File GetExportedFile(String filename) throws Exception
    {
        for (int i = 0; i < 12; i++)
        {
            File[] files = new File(GebruikersData.DownloadFolder).listFiles();
            if (files.length != 0)
            {
                for (File file : files)
                {
                    if (file.getName().contains(filename))
                    {
                        return file;
                    }
                }
            }
            Thread.sleep(500);
        }

        throw new Exception(String.format("Geen tijdelijke wijzigingen export gemaakt"));
    }

    public boolean TextIsPresentInCsvFile(String text, File file) throws IOException, CsvException
    {
        List<String[]> csvText = GetTextFromCsvFile(file);

        int iterator = 0;
        for (String[] content: csvText)
        {
            for (String line : content)
            {
                if (line.contains(text))
                {
                    iterator++;
                }
            }
        }

        if (iterator > 0)
        {
            return true;
        }

        return false;
    }
}
