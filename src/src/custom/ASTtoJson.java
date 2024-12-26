package src.custom;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ASTtoJson {

    public static JSONObject convertToJson(ASTNode node)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",node.getName());
        jsonObject.put("action",node.getAction());
        jsonObject.put("shape",node.getShape());
        jsonObject.put("color",node.getColor());

        if(node.getNested()!=null && !node.getNested().isEmpty())
        {
            JSONArray childNode = new JSONArray();
            for(ASTNode child : node.getNested())
            {
                childNode.put(convertToJson(child));
            }
            jsonObject.put("nested",childNode);
        }
        return jsonObject;
    }
}

