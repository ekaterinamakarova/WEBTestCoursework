/**
 *Класс для чтения данных из текстового файла "credentials".
 *Все данные для входа и различных действий на самом сайте берутся из текстового файла построчно.
 *Делает код универсальным, посольку при изменении данных они меняются не в самом коде, а в файле.
 */
package Pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FileReaderClass {

    /** Путь к текстовому файлу */

    private String credentialsDirectory = "./src/credentials";

    public String readFromFile(int k) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(credentialsDirectory)); /**  BufferReader увеличивает производительность чтения данных из потока */
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return (lines.get(k));

    }

}