package restfulapi.requests.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.ExportDatev;
import entity.ExportVoucher;

import java.util.List;

public class JsonBuilder {

    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();



    public String build(ExportDatev exportDatev) {
        String input = gson.toJson(exportDatev);
        return input;
    }
    public String build(ExportVoucher exportVoucher) {
        String input = gson.toJson(exportVoucher);
        return input;
    }
    public Object deserializeExportDatev(String input){
        ExportDatev exportDatev =gson.fromJson(input, ExportDatev.class);
        return exportDatev;
    }




}
