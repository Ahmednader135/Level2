package reader;

import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataDrivenFromJson {

    String successfulLogin = "SuccessfulLogin";
    private String[] readJson(String testStatus) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("data/dataDriven.json");
        JSONObject jsonObject = (JSONObject)jsonParser.parse(fileReader);
        //JSONObject jsonObject = (JSONObject)object;
        JSONArray jsonArray = (JSONArray)jsonObject.get(testStatus);
        String arr[] = new String[jsonArray.size()];
        for (int i=0; i<jsonArray.size(); i++ )
        {
            JSONObject Users = (JSONObject)jsonArray.get(i);
            String email = (String)Users.get("Email");
            String pass = (String)Users.get("Password");
            arr[i] = email+","+pass;

        }
        return arr;
    }

    public String[] readDataForSuccessfulLogin() throws IOException, ParseException {
        return readJson(successfulLogin);
    }
}
