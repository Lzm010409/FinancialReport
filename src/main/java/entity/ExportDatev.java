package entity;

import com.google.gson.annotations.Expose;

import java.sql.Timestamp;

public class ExportDatev {
    @Expose(serialize = true, deserialize = false)
    private boolean download;
    @Expose(serialize = true, deserialize = false)
    private long startDate;
    @Expose(serialize = true, deserialize = false)
    private long endDate;
    @Expose(serialize = true, deserialize = false)
    private String scope;
    @Expose(serialize = true, deserialize = false)
    private boolean enshrine;

    @Expose(serialize = false, deserialize = true)
    String filename;
    @Expose(serialize = false, deserialize = true)
    String mimetype;
    @Expose(serialize = false, deserialize = true)
    boolean base64Encoded;
    @Expose(serialize = false, deserialize = true)
    String content;



    public ExportDatev(long startDate, long endDate, String scope) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.scope = scope;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isEnshrine() {
        return enshrine;
    }

    public void setEnshrine(boolean enshrine) {
        this.enshrine = enshrine;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public boolean isBase64Encoded() {
        return base64Encoded;
    }

    public void setBase64Encoded(boolean base64Encoded) {
        this.base64Encoded = base64Encoded;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
