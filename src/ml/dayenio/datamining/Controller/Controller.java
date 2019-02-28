package ml.dayenio.datamining.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by @siemah on 27/02/2019.
 */
public class Controller {

    protected String filePath = "";
    protected BufferedReader bufferedReader;
    protected FileReader fileReader;
    protected ArrayList<String> fileLines = new ArrayList<String>();
    protected ArrayList<String> itemsListChain = new ArrayList<String>();

    /**
     * constructor of Controller
     * @param fileath the path of file of data
     */
    public Controller(String fileath) {
        this.filePath = fileath;
        this.init();
    }

    /**
     * initialize reading file variables
     */
    protected void init() {
        try {
            this.fileReader = new FileReader(filePath);
            this.bufferedReader = new BufferedReader(this.fileReader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get a all line of filePath file
     * @return ArrayList of lines
     */
    public ArrayList<String> getFileLines() {
        String line;
        try {
            while ( (line=this.bufferedReader.readLine()) != null ) {
                String[] splitLis = line.split(",");
                this.fileLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.fileLines;
    }

    /**
     * get list of items of each line in bdd file
     * @see Controller line 14 @var filePath
     * @return list of items of each line
     */
    public ArrayList<String> getItemsOfLine () {
        ArrayList<String> lines = this.getFileLines();
        lines.forEach(line -> {
            String[] lineStr;
            lineStr = line.split(",");
            this.itemsListChain.add(lineStr[2].trim());
        });
        return  this.itemsListChain;
    }

}
