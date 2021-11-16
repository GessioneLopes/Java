package com.ordem.servico.util;

import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.SwingWrapper;

public class PieChart {

    public static void main(String[] args) {
        org.knowm.xchart.PieChart chart = getChartPie();
        new SwingWrapper<>(chart).displayChart();
    }

    public static org.knowm.xchart.PieChart getChartPie() {

        // Create Chart new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
        org.knowm.xchart.PieChart chart = new PieChartBuilder().width(800).height(600).build();

        // Customize Chart
        chart.getStyler().setLegendVisible(false);
        // chart.getStyler().setAnnotationType(AnnotationType.Label);
        // chart.getStyler().setAnnotationDistance(.82);
        chart.getStyler().setPlotContentSize(.9);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);
        // chart.getStyler().setCircular(false);

        // Series
        chart.addSeries("A", 22);
        chart.addSeries("B", 10);
        chart.addSeries("C", 34);
        chart.addSeries("D", 22);
        chart.addSeries("E", 29);
        chart.addSeries("F", 40);

        return chart;
    }
    
    
//     Thread plotThread = new Thread(() -> {
//            JPanel panel = new XChartPanel<>(BarChart.main());
//            JFrame frame = new JFrame("Gráfico de Vendas");
//            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            frame.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
//            frame.setAlwaysOnTop(true);
//            frame.add(panel);
//            frame.pack();
//            frame.setLocation(120, 60);
//            frame.setVisible(true);
//            frame.requestFocus();
//        });
//        plotThread.start();

}
