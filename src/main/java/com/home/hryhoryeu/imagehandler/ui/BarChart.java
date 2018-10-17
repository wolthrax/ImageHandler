package com.home.hryhoryeu.imagehandler.ui;

import com.home.hryhoryeu.imagehandler.config.ConfigParams;
import com.home.hryhoryeu.imagehandler.config.Names;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Map;

public class BarChart {

    public void showBarChart(Map<Integer, Number> barChartMap, String title) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(Names.BarChart.X_LABEL_TEXT);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(Names.BarChart.Y_LABEL_TEXT);

        javafx.scene.chart.BarChart<String, Number> barChart = new javafx.scene.chart.BarChart<>(xAxis,yAxis);
        barChart.setTitle(title);

        XYChart.Series series = new XYChart.Series();
        series.setName(Names.BarChart.SERIES_NAME);

        for(Map.Entry e : barChartMap.entrySet()){
            series.getData().add(new XYChart.Data(String.valueOf(e.getKey()), e.getValue()));
        }

        barChart.getData().addAll(series);

        Scene scene = new Scene(barChart, ConfigParams.Size.BAR_CHART_WIDTH, ConfigParams.Size.BAR_CHART_HEIGHT);

        Stage stage = new Stage();
        stage.setTitle(Names.BarChart.STAGE_TITLE);
        stage.setScene(scene);
        stage.show();
    }
}
