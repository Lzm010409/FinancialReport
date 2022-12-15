package entity;

import com.google.gson.annotations.Expose;

public class Filter {
    @Expose
    private String startDate;

    @Expose
    private String endDate;

    @Expose
    private String startPayDate;

    @Expose
    private String endPayDate;

    @Expose
    private int startAmount;

    @Expose
    private int endAmount;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartPayDate() {
        return startPayDate;
    }

    public void setStartPayDate(String startPayDate) {
        this.startPayDate = startPayDate;
    }

    public String getEndPayDate() {
        return endPayDate;
    }

    public void setEndPayDate(String endPayDate) {
        this.endPayDate = endPayDate;
    }

    public int getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(int startAmount) {
        this.startAmount = startAmount;
    }

    public int getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(int endAmount) {
        this.endAmount = endAmount;
    }
}
