package entity;

import com.google.gson.annotations.Expose;

public class SevQuery {

    @Expose
    private int limit;

    @Expose
    private String modelName;

    @Expose
    private String objectName = "SevQuery";

    @Expose
    private Filter filter;

    public SevQuery(String modelName) {
        this.modelName = modelName;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}
