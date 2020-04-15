package com.company;

public class Chart {
    private String nameChart;
    /* cu ajutorul controllerului chart afisez informatiile din chart*/
    private ChartsController controller = new ChartsController();

    public Chart(String name) {
        this.nameChart = name;
    }

    public void showChart() {
        controller.showChart(this.nameChart);
    }
}
