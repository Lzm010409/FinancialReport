package entity;

import com.google.gson.annotations.Expose;

public class ExportVoucher {

    @Expose
    private boolean download;

    @Expose
    private SevQuery sevQuery;

    public boolean isDownload() {
        return download;
    }

    public ExportVoucher(SevQuery sevQuery) {
        this.sevQuery = sevQuery;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public SevQuery getSevQuery() {
        return sevQuery;
    }

    public void setSevQuery(SevQuery sevQuery) {
        this.sevQuery = sevQuery;
    }
}
